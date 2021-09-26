package StringExperiments;

public class task2 {
    /*
    Напишите код в проекте StringExperiments, который считает сумму заработка всех друзей (Васи, Пети и Маши).
    Используйте методы indexOf(), lastIndexOf(), substring() и trim().
     */
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        int index1 = text.indexOf("5000");
        int index2 = text.indexOf("рублей");
        String vasyaMoney = text.substring(index1, index2).trim();
        int moneyOfVasya = Integer.parseInt(vasyaMoney);


        int index3 = text.indexOf("7563");
        int index4 = text.indexOf("рубля");
        String petyaMoney = text.substring(index3, index4).trim();
        int moneyOfPetya = Integer.parseInt(petyaMoney);

        int index5 = text.indexOf("30000");
        int index6 = text.lastIndexOf("рублей");

        String mashaMoney = text.substring(index5, index6).trim();
        int moneyOfMasha = Integer.parseInt(mashaMoney);


        System.out.println("vasyaMoney =" + vasyaMoney + "!");
        System.out.println("petyaMoney =" + petyaMoney + "!");
        System.out.println("mashaMoney =" + mashaMoney + "!");

        System.out.println("Общая сумма заработка всех друзей (Васи, Пети и Маши) составила " +
                (moneyOfVasya + moneyOfPetya + moneyOfMasha) + " рублей");
    }
}
