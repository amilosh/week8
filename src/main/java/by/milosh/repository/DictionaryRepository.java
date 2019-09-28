package by.milosh.repository;

import by.milosh.model.DictionaryRow;
import by.milosh.model.DictionaryRowField;
import by.milosh.util.DataBaseConnectionHelper;
import by.milosh.util.DataBaseConnector;
import by.milosh.util.DataBaseQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DictionaryRepository {

    public List<DictionaryRow> getDictionaryRowsSQL() {
        List<DictionaryRow> rows = new ArrayList<>();
        try (Connection connection = DataBaseConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(DataBaseQuery.QUERY_FULL_1.getQuery())) {
            rows = getRowsFromDB(resultSet);
        } catch (SQLException e) {
            System.out.println("DB connection error: " + e);
        }
        return rows;
    }

    public List<DictionaryRow> getDictionaryRowsMapJava() {
        List<DictionaryRow> rowsList = new ArrayList<>();
        Map<String, Integer> rows = new TreeMap<>();
        try (ResultSet resultSetDictionary1 = new DataBaseConnectionHelper().getResultSet(DataBaseQuery.QUERY_DICTIONARY_1.getQuery());
             ResultSet resultSetDictionary2 = new DataBaseConnectionHelper().getResultSet(DataBaseQuery.QUERY_DICTIONARY_2.getQuery());) {
            rows = resultSetToMap(resultSetDictionary1);
            Map<String, Integer> dict2 = resultSetToMap(resultSetDictionary2);
            Map<String, Integer> tmp = new HashMap<>(dict2);
            tmp.keySet().removeAll(rows.keySet());
            rows.putAll(tmp);
            rowsList = rows.entrySet().stream().map(d -> new DictionaryRow(d.getKey(), d.getValue())).collect(Collectors.toList());
        } catch (SQLException e) {
            System.out.println("DB connection error: " + e);
        }
        return rowsList;
    }

    public List<DictionaryRow> getDictionaryRowsListJava() {
        List<DictionaryRow> rowsList = new ArrayList<>();
        try (Connection connection = DataBaseConnector.getConnection();
             Statement statementDictionary1 = connection.createStatement();
             Statement statementDictionary2 = connection.createStatement();
             ResultSet resultSetDictionary1 = statementDictionary1.executeQuery(DataBaseQuery.QUERY_DICTIONARY_1.getQuery());
             ResultSet resultSetDictionary2 = statementDictionary2.executeQuery(DataBaseQuery.QUERY_DICTIONARY_2.getQuery());) {
            rowsList = getRowsFromDB(resultSetDictionary1);
            List<DictionaryRow> dict2 = getRowsFromDB(resultSetDictionary2);
            List<String> words = rowsList.stream().map(DictionaryRow::getWord).collect(Collectors.toList());
            List<DictionaryRow> dict2After = dict2.stream().filter(d -> words.stream().noneMatch(str -> str.trim().equals(d.getWord()))).collect(Collectors.toList());
            rowsList.addAll(dict2After);
            Collections.sort(rowsList, DictionaryRow.compareByWord());
        } catch (SQLException e) {
            System.out.println("DB connection error: " + e);
        }
        return rowsList;
    }

    private List<DictionaryRow> getRowsFromDB(ResultSet resultSet) throws SQLException {
        List<DictionaryRow> rows = new ArrayList<>();
        while (resultSet.next()) {
            String word = resultSet.getString(DictionaryRowField.WORD.getFieldNme());
            Integer id = resultSet.getInt(DictionaryRowField.REFERENCE_ID.getFieldNme());
            rows.add(new DictionaryRow(word, id));
        }
        return rows;
    }

    private Map<String, Integer> resultSetToMap(ResultSet resultSet) throws SQLException {
        Map<String, Integer> map = new TreeMap<>();
        while (resultSet.next()) {
            String word = resultSet.getString(DictionaryRowField.WORD.getFieldNme());
            Integer id = resultSet.getInt(DictionaryRowField.REFERENCE_ID.getFieldNme());
            map.put(word, id);
        }
        return map;
    }
}
