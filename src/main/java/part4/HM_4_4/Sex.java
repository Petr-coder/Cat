package part4.HM_4_4;

public enum Sex {
    MALE("Мужчина"), FEMALE("Женщина");

    Sex(String gender) {
        this.gender = gender;
    }

    private String gender;

    public String getGender() {
        return gender;
    }

}
