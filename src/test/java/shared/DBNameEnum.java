package shared;

public enum DBNameEnum {
    CATEGORY(" help_category "),
    KEYWORD(" help_keyword "),
    RELATION(" help_relation ");

    private String name;

    DBNameEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
