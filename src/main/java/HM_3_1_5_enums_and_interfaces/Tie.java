package HM_3_1_5_enums_and_interfaces;

public class Tie extends Clothes implements MaleClothes {


    public Tie(Size size, int price, Color color) {
        super(size, price, color);
        setName("Мужской галстук");
    }

    @Override
    public void dressMan() {
        System.out.println(this);
    }
}
