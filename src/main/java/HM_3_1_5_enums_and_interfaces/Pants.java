package HM_3_1_5_enums_and_interfaces;

public class Pants extends Clothes implements MaleClothes, FemaleClothes {


    public Pants(Size size, int price, Color color) {
        super(size, price, color);
    }

    @Override
    public void dressWoman() {
        setName("Женские брюки");
        System.out.println(this);
    }

    @Override
    public void dressMan() {
        setName("Мужские брюки");
        System.out.println(this);
    }
}
