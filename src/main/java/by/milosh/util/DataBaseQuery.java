package by.milosh.util;

public enum DataBaseQuery {

    QUERY_DICTIONARY_1("SELECT word, reference_id FROM dictionary_1"),
    QUERY_DICTIONARY_2("SELECT word, reference_id FROM dictionary_2"),
    QUERY_FULL_1("select sub.word as word, sub.reference_id as reference_id from "
            + "(SELECT d1.word as word, d1.reference_id as reference_id \n"
            + "    FROM dictionary_1 as d1 LEFT JOIN dictionary_2 as d2\n"
            + "    ON d1.word = d2.word\n"
            + "union all\n"
            + "SELECT d2.word as word, d2.reference_id as reference_id \n"
            + "    FROM dictionary_2 as d2 LEFT JOIN dictionary_1 as d1\n"
            + "    ON d2.word = d1.word where d1.word IS NULL) as sub "
            + "order by word;"),
    QUERY_FULL_2("select sub.word as word, sub.id as reference_id from (\n"
            + "select word, reference_id as id from dictionary_1\n"
            + "union all\n"
            + "select word, reference_id as id from dictionary_2) as sub\n"
            + "group by word");

    private String query;

    DataBaseQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
