package part3.HM_3_2_4;

import part3.HM_3_2_4.core.Line;
import part3.HM_3_2_4.core.Station;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
О чем проект
Это приложение для расчета маршрута и времени поездки между станциями метрополитена в г.
Санкт- Петербург. Запустите и через консоль введите любые две станции. Во многих сценариях
(сочетаниях станций) расчет будет производиться некорректно, потому что в коде намеренно
допущена ошибка, которую необходимо найти.

Что нужно сделать
1. Напишите тесты на все методы класса RouteCalculator в SPBMetro
2. С помощью тестов и отладки исправьте ошибку, которую вы найдёте в SPBMetro в классе
RouteCalculator.

Рекомендации
● Список станций хранится в формате json, при каждом запуске приложения этот файл
считывается и формируется мапа со всеми линиями, станциями, пересечениями.
Познакомитесь самостоятельно с форматом json.
● Сформируйте схему метро (StationIndex) в тестовом классе, в которой можно построить хотя
бы один маршрут с двумя пересадками. Делайте небольшую схему, чтобы легче
ориентироваться в ней.
● Чтобы протестировать приватные методы класса RouteCalculator, используйте различные
аргументы метода getShortestRoute() для вызова методов без пересадок, с одной и двумя
пересадками.
● Code Coverage — инструмент в IDEA, определяющий уровень покрытия тестами классов,
методов и строк. Чтобы запустить тесты с проверкой покрытия, надо нажать правой кнопкой
мыши по классу директории с тестами и выбрать Run All tests with Coverage. Желательно
добиться 100%-ного покрытия методов класса RouteCalculator.
 */
public class Main {
    private static String dataFile = "src/main/resources/part3/spbmetro/map.json";
    private static Scanner scanner;

    private static StationIndex stationIndex;

    public static void main(String[] args) {
        RouteCalculator calculator = getRouteCalculator();

        System.out.println("Программа расчёта маршрутов метрополитена Санкт-Петербурга\n");
        scanner = new Scanner(System.in);
        for (; ; ) {
            Station from = takeStation("Введите станцию отправления:");
            Station to = takeStation("Введите станцию назначения:");

            List<Station> route = calculator.getShortestRoute(from, to);
            System.out.println("Маршрут:");
            printRoute(route);

            System.out.println("Длительность: " +
                    RouteCalculator.calculateDuration(route) + " минут");
        }
    }

    private static RouteCalculator getRouteCalculator() {
        createStationIndex();
        return new RouteCalculator(stationIndex);
    }

    private static void printRoute(List<Station> route) {
        Station previousStation = null;
        for (Station station : route) {
            if (previousStation != null) {
                Line prevLine = previousStation.getLine();
                Line nextLine = station.getLine();
                if (!prevLine.equals(nextLine)) {
                    System.out.println("\tПереход на станцию " +
                            station.getName() + " (" + nextLine.getName() + " линия)");
                }
            }
            System.out.println("\t" + station.getName());
            previousStation = station;
        }
    }

    private static Station takeStation(String message) {
        for (; ; ) {
            System.out.println(message);
            String line = scanner.nextLine().trim();
            Station station = stationIndex.getStation(line);
            if (station != null) {
                return station;
            }
            System.out.println("Станция не найдена :(");
        }
    }

    private static void createStationIndex() {
        stationIndex = new StationIndex();
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

            JSONArray linesArray = (JSONArray) jsonData.get("lines");
            parseLines(linesArray);

            JSONObject stationsObject = (JSONObject) jsonData.get("stations");
            parseStations(stationsObject);

            JSONArray connectionsArray = (JSONArray) jsonData.get("connections");
            parseConnections(connectionsArray);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void parseConnections(JSONArray connectionsArray) {
        connectionsArray.forEach(connectionObject ->
        {
            JSONArray connection = (JSONArray) connectionObject;
            List<Station> connectionStations = new ArrayList<>();
            connection.forEach(item ->
            {
                JSONObject itemObject = (JSONObject) item;
                int lineNumber = ((Long) itemObject.get("line")).intValue();
                String stationName = (String) itemObject.get("station");

                Station station = stationIndex.getStation(stationName, lineNumber);
                if (station == null) {
                    throw new IllegalArgumentException("core.Station " +
                            stationName + " on line " + lineNumber + " not found");
                }
                connectionStations.add(station);
            });
            stationIndex.addConnection(connectionStations);
        });
    }

    private static void parseStations(JSONObject stationsObject) {
        stationsObject.keySet().forEach(lineNumberObject ->
        {
            int lineNumber = Integer.parseInt((String) lineNumberObject);
            Line line = stationIndex.getLine(lineNumber);
            JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);
            stationsArray.forEach(stationObject ->
            {
                Station station = new Station((String) stationObject, line);
                stationIndex.addStation(station);
                line.addStation(station);
            });
        });
    }

    private static void parseLines(JSONArray linesArray) {
        linesArray.forEach(lineObject -> {
            JSONObject lineJsonObject = (JSONObject) lineObject;
            Line line = new Line(
                    ((Long) lineJsonObject.get("number")).intValue(),
                    (String) lineJsonObject.get("name")
            );
            stationIndex.addLine(line);
        });
    }

    private static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(dataFile));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}