package HM_3_1_5_enums_and_interfaces;

abstract class Clothes {
    private String name;
    private Size size;
    private int price;
    private Color color;


    public Clothes(Size size, int price, Color color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return getName() + ": " + size.getDescription() + ", цена " + getPrice() + ", цвет " + getColor().getName();
    }
}
