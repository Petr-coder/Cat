package part3.HM_3_1_6_advancedOop;

/*
Практическое задание
1. Продолжаем работать с участниками и выполнением действий. Создайте три класса Человек,
Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и
прыгать, все также с выводом информации о действии в консоль.

2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
печатаем в консоль (успешно пробежал, не смог пробежать и т.д.). У препятствий есть длина
(для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.

3. Создайте два массив: с участниками и препятствиями, и заставьте всех участников пройти
этот набор препятствий. Если участник не смог пройти одно из препятствий, то дальше по
списку он препятствий не идет
 */
public class Task {
    public static void main(String[] args) {

        Activity[] activities = new Activity[12];

        activities[0] = new Human(3, 4000);
        activities[1] = new Human(2, 3000);
        activities[2] = new Human(1, 500);
        activities[3] = new Human(2, 1200);

        activities[4] = new Robot(5, 10000);
        activities[5] = new Robot(10, 10000);
        activities[6] = new Robot(15, 10000);
        activities[7] = new Robot(12, 10000);

        activities[8] = new Cat(4, 100);
        activities[9] = new Cat(5, 300);
        activities[10] = new Cat(3, 200);
        activities[11] = new Cat(4, 50);

        OvercomeObstacle[] overcomeObstacles = new OvercomeObstacle[10];

        overcomeObstacles[0] = new Treadmill(4);
        overcomeObstacles[1] = new Wall(2);
        overcomeObstacles[2] = new Treadmill(100);
        overcomeObstacles[3] = new Wall(4);

        overcomeObstacles[4] = new Treadmill(5000);
        overcomeObstacles[5] = new Wall(1);
        overcomeObstacles[6] = new Wall(3);
        overcomeObstacles[7] = new Wall(2);
        overcomeObstacles[8] = new Treadmill(1000);
        overcomeObstacles[9] = new Treadmill(30);


        runBigRace(activities, overcomeObstacles);
    }

    static void runBigRace(Activity[] activities, OvercomeObstacle[] overcomeObstacles) {

        for (int i = 0; i < activities.length; i++) {

            for (int j = 0; j < overcomeObstacles.length; j++) {

                if (!overcomeObstacles[j].interact(activities[i])) {
                    System.out.println("Участник " + activities[i].toString() + " не смог осилить гонку");
                    break;
                }

                if (j == overcomeObstacles.length - 1) {
                    System.out.println("Участник " + activities[i].toString() + " завершил гонку успешно");
                }

            }

        }
    }

}
