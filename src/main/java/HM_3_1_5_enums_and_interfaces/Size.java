package HM_3_1_5_enums_and_interfaces;

public enum Size {
    XXS (32){
        @Override
        String getDescription() {
            return "Детский размер";
        }
    }, XS(34), S(36), M(38), L(40);

    int euroSize;

    String getDescription() {
        return "Взрослый размер";
    }

    Size(int euroSize) {
        this.euroSize = euroSize;
    }
}
