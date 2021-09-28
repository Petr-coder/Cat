package StringExperiments;

public class task2 {
    /*
    Напишите код в проекте StringExperiments, который считает сумму заработка всех друзей (Васи, Пети и Маши).
    Используйте методы indexOf(), lastIndexOf(), substring() и trim().
     */
    static final int DIGITS_TILL_AMOUNT = 7;

    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        int index1 = text.indexOf(" ", 8);
        int index2 = text.indexOf("рублей");
        String vasyaMoney = text.substring(index1, index2).trim();
        int moneyOfVasya = Integer.parseInt(vasyaMoney);

        int indexOfPetrName = text.indexOf("Петя");
        int index4 = text.indexOf("рубля");
        String petyaMoney = text.substring(indexOfPetrName + DIGITS_TILL_AMOUNT, index4).trim();
        int moneyOfPetya = Integer.parseInt(petyaMoney);

        int indexOfMashaName = text.indexOf("Маша");
        int index6 = text.lastIndexOf("рублей");
        String mashaMoney = text.substring(indexOfMashaName + DIGITS_TILL_AMOUNT, index6).trim();
        int moneyOfMasha = Integer.parseInt(mashaMoney);


        System.out.println("vasyaMoney =" + vasyaMoney + "!");
        System.out.println("petyaMoney =" + petyaMoney + "!");
        System.out.println("mashaMoney =" + mashaMoney + "!");

        System.out.println("Общая сумма заработка всех друзей (Васи, Пети и Маши) составила " +
                (moneyOfVasya + moneyOfPetya + moneyOfMasha) + " рублей");
    }
}
