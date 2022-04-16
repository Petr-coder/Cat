package HM_3_1_5_enums_and_interfaces;

public class Skirt extends Clothes implements FemaleClothes {

    public Skirt(Size size, int price, Color color) {
        super(size, price, color);
        setName("Женская юбка");
    }

    @Override
    public void dressWoman(Clothes[] clothes) {

    }
}
