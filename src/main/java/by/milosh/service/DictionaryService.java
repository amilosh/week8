package by.milosh.service;

import by.milosh.model.DictionaryRow;
import by.milosh.repository.DictionaryRepository;

import java.util.List;

public class DictionaryService {

    public List<DictionaryRow> getDictionaryRowsSQL() {
        return new DictionaryRepository().getDictionaryRowsSQL();
    }

    public List<DictionaryRow> getDictionaryRowsMapJava() {
        return new DictionaryRepository().getDictionaryRowsMapJava();
    }

    public List<DictionaryRow> getDictionaryRowsLisJava() {
        return new DictionaryRepository().getDictionaryRowsListJava();
    }
}
