package HM_4_17;

public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {

        if (radius < 0) {
            radius = Math.abs(radius);
        }


        return Math.PI * Math.pow(radius, 2);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        if (radius < 0) {
            radius = Math.abs(radius);
        }

        return (double) 4 / 3 * Math.PI * Math.pow(radius, 3);
    }

    public static boolean isTriangleRightAngled(double a, double b, double c) {
        if (a + b > c && b + c > a && a + c > b) {
            return true;
        } else {
            return false;
        }
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (!isTriangleRightAngled(a, b, c)) {
            return -1.0;
        } else {
            double semiperimeter = (a + b + c) / 2;
            return Math.sqrt(semiperimeter * (semiperimeter - a) * (semiperimeter - b) * (semiperimeter - c));
        }
    }
}
