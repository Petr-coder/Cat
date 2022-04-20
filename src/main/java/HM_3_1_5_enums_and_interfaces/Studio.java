package HM_3_1_5_enums_and_interfaces;

public class Studio {


    public void dressWoman(Clothes[] clothes) {
        for (Clothes unit : clothes) {
            if (unit instanceof FemaleClothes) {
                FemaleClothes femaleClothes = (FemaleClothes) unit;
                femaleClothes.dressWoman();
            }
        }
    }


    public void dressMan(Clothes[] clothes) {
        for (Clothes unit : clothes) {
            if (unit instanceof MaleClothes) {
                MaleClothes maleClothes = (MaleClothes) unit;
                maleClothes.dressMan();
            }
        }
    }

}
