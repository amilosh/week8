package by.milosh.util;

public enum DataBaseParameter {

    DATABASE("database"),
    URL("db.url"),
    LOGIN("db.login"),
    PASSWORD("db.password");

    private String parameter;

    DataBaseParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}
