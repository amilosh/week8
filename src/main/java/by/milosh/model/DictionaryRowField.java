package by.milosh.model;

public enum DictionaryRowField {

    WORD("word"),
    REFERENCE_ID("reference_id");

    private String fieldNme;

    DictionaryRowField(String fieldNme) {
        this.fieldNme = fieldNme;
    }

    public String getFieldNme() {
        return fieldNme;
    }
}
