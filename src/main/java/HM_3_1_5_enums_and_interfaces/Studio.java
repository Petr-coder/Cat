package HM_3_1_5_enums_and_interfaces;

public class Studio implements MaleClothes, FemaleClothes {

    @Override
    public void dressWoman(Clothes[] clothes) {

        for (Clothes item : clothes) {
            if (item instanceof Pants) {
                item.setName("Женские брюки");
            } else if (item instanceof Skirt) {
                item.setName("Женская футболка");
            }
        }

        printClothes(clothes);
    }

    @Override
    public void dressMan(Clothes[] clothes) {
        for (Clothes item : clothes) {
            if (item instanceof Pants) {
                item.setName("Мужские брюки");
            } else if (item instanceof Tshirt) {
                item.setName("Мужская футболка");
            }
        }

        printClothes(clothes);
    }

    static void printClothes(Clothes[] clothes) {
        for (Clothes unit : clothes) {
            System.out.println(unit);
        }
    }
}
