package HM_3_1_5_enums_and_interfaces;

public class Tshirt extends Clothes implements MaleClothes, FemaleClothes {

    public Tshirt(Size size, int price, Color color) {
        super(size, price, color);
    }

    @Override
    public void dressWoman() {
        setName("Женская футболка");
        System.out.println(this);
    }

    @Override
    public void dressMan() {
        setName("Мужская футболка");
        System.out.println(this);
    }
}
