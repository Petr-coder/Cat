package part1.integerExperiments;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        //забыл, что Integer инициализируется null
        container.count += 7843;

        System.out.println("sumDigits(12345) result is " + sumDigits(12345));
        System.out.println("sumDigits(10) result is " + sumDigits(10));
        System.out.println("sumDigits(5059191) result is " + sumDigits(5059191));

        System.out.println("\n" + "sumDigitsWithCharactersMethods(12345) result is "
                + sumDigitsWithCharactersMethods(12345));
        System.out.println("sumDigitsWithCharactersMethods(10) result is "
                + sumDigitsWithCharactersMethods(10));
        System.out.println("sumDigitsWithCharactersMethods(5059191) result is "
                + sumDigitsWithCharactersMethods(5059191));


    }

    /*
    Реализуйте статический метод sumDigits, чтобы он считал сумму цифр в числе и возвращал сумму в результате своей работы.
    Для реализации метода можете использовать методы:
     */
    public static Integer sumDigits(Integer number) {
        //@TODO: write code here
        String temporary = Integer.toString(number);
        int result = 0;

        for (int i = 0; i < temporary.length(); i++) {
            result += Integer.parseInt(String.valueOf(temporary.charAt(i)));
        }

        return result;
    }

    public static Integer sumDigitsWithCharactersMethods(Integer number) {
        String temporary = Integer.toString(number);
        int result = 0;

        for (int i = 0; i < temporary.length(); i++) {
            result += Character.getNumericValue(temporary.charAt(i));
        }

        return result;
    }

}
