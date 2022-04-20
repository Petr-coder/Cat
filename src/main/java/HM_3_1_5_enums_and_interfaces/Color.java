package HM_3_1_5_enums_and_interfaces;

public enum Color {
    BLACK("Чёрный"),
    RED("Красный"),
    BLUE("Синий"),
    GREEN("Зелёный"),
    WHITE("Белый"),
    YELLOW("Жёлтый");

    private String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}