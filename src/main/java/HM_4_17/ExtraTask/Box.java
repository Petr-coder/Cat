package HM_4_17.ExtraTask;

class Box {
    int number;
    static int count = 0;

    public Box() {
        count++;
        this.number = count;
    }

    @Override
    public String toString() {
        return "\t" + "Ящик " +
                 number + "\n";
    }
}
