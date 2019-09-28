package by.milosh.util;

import by.milosh.model.DictionaryRow;

import java.util.ArrayList;
import java.util.List;

public class ExpectedValueUtil {

    public static List<DictionaryRow> buildList() {
        List<DictionaryRow> expectedRows = new ArrayList<>();
        expectedRows.add(new DictionaryRow("абажур", 1));
        expectedRows.add(new DictionaryRow("кинотеатр", 2));
        expectedRows.add(new DictionaryRow("музыка", 16));
        expectedRows.add(new DictionaryRow("самолет", 3));
        expectedRows.add(new DictionaryRow("человек", 4));
        return expectedRows;
    }
}
