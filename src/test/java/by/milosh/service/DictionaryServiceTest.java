package by.milosh.service;


import by.milosh.model.DictionaryRow;
import by.milosh.util.ExpectedValueUtil;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class DictionaryServiceTest {

    private DictionaryService ds = new DictionaryService();

    @Test
    public void testGetDictionaryRowsSQL() {
        List<DictionaryRow> expectedRows = ExpectedValueUtil.buildList();
        List<DictionaryRow> actualRows = ds.getDictionaryRowsSQL();
        assertThat(expectedRows, containsInAnyOrder(actualRows.toArray()));
    }

    @Test
    public void testGetDictionaryRowsMapJava() {
        List<DictionaryRow> expectedRows = ExpectedValueUtil.buildList();
        List<DictionaryRow> actualRows = ds.getDictionaryRowsMapJava();
        assertThat(expectedRows, containsInAnyOrder(actualRows.toArray()));
    }

    @Test
    public void testGetDictionaryRowsListJava() {
        List<DictionaryRow> expectedRows = ExpectedValueUtil.buildList();
        List<DictionaryRow> actualRows = ds.getDictionaryRowsLisJava();
        assertThat(expectedRows, containsInAnyOrder(actualRows.toArray()));
    }
}
