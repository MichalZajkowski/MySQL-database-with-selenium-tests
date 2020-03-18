package shared;

public enum QueryEnum {
    SELECT(" SELECT "),
    FROM(" FROM "),
    WHERE(" WHERE "),
    AND(" AND "),
    INSERT(" INSERT "),
    UPDATE(" UPDATE "),
    DELETE(" DELETE "),
    LIKE(" LIKE "),
    BETWEEN(" BETWEEN "),
    ESCAPE(" IS NULL "),
    IN(" IN "),
    OR(" OR "),
    INTO(" INTO "),
    SET(" SET "),
    VALUES (" VALUES  ");

    private String query;

    QueryEnum(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
