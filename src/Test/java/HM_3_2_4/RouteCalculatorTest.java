package HM_3_2_4;

import part3.HM_3_2_4.RouteCalculator;
import part3.HM_3_2_4.StationIndex;
import part3.HM_3_2_4.core.Line;
import part3.HM_3_2_4.core.Station;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class RouteCalculatorTest {

    private static String dataFile = "src/main/resources/part3/spbmetro/map.json";
    private static StationIndex stationIndex;
    private static RouteCalculator calculator;

    @BeforeEach
    void setUp() {
        createStationIndex();
        calculator = new RouteCalculator(stationIndex);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getShortestRouteOneLine() {
        List<Station> testList = new ArrayList<>();
        testList.add(stationIndex.getStation("Комендантский проспект"));
        testList.add(stationIndex.getStation("Старая Деревня"));
        testList.add(stationIndex.getStation("Крестовский остров"));
        testList.add(stationIndex.getStation("Чкаловская"));
        testList.add(stationIndex.getStation("Спортивная"));
        testList.add(stationIndex.getStation("Адмиралтейская"));
        testList.add(stationIndex.getStation("Садовая"));
        assertEquals(testList, calculator.getShortestRoute(stationIndex.getStation("Комендантский проспект"), stationIndex.getStation("Садовая")));

    }

    @Test
    void getShortestRouteOneConnection() {
        List<Station> testList = new ArrayList<>();
        testList.add(stationIndex.getStation("Адмиралтейская"));
        testList.add(stationIndex.getStation("Садовая"));
        testList.add(stationIndex.getStation("Спасская"));
        testList.add(stationIndex.getStation("Достоевская"));
        assertEquals(testList, calculator.getShortestRoute(stationIndex.getStation("Адмиралтейская"), stationIndex.getStation("Достоевская")));
    }

    @Test
    void getShortestRouteTwoConnection() {
        List<Station> testList = new ArrayList<>();
        testList.add(stationIndex.getStation("Горьковская"));
        testList.add(stationIndex.getStation("Невский проспект"));
        testList.add(stationIndex.getStation("Гостиный двор"));
        testList.add(stationIndex.getStation("Маяковская"));
        testList.add(stationIndex.getStation("Площадь Восстания"));
        testList.add(stationIndex.getStation("Чернышевская"));
        testList.add(stationIndex.getStation("Площадь Ленина"));
        assertEquals(testList, calculator.getShortestRoute(stationIndex.getStation("Горьковская"), stationIndex.getStation("Площадь Ленина")));
    }


    @Test
    void getShortestRouteWrong() {
        List<Station> testList = new ArrayList<>();
        testList.add(stationIndex.getStation("Горьковская"));
        testList.add(stationIndex.getStation("Невский проспект"));
        testList.add(stationIndex.getStation("Гостиный двор"));
        testList.add(stationIndex.getStation("Маяковская"));
        testList.add(stationIndex.getStation("Площадь Восстания"));
        testList.add(stationIndex.getStation("Чернышевская"));
        testList.add(stationIndex.getStation("Площадь Ленина"));
        assertThrows(NullPointerException.class, () -> {
            calculator.getShortestRoute(stationIndex.getStation("Горьковская"), stationIndex.getStation("Площадь Горьковская"));
        });
    }
    @Test
    void calculateDurationOneLine() {
        List<Station> testList = new ArrayList<>();
        testList.add(stationIndex.getStation("Комендантский проспект"));
        testList.add(stationIndex.getStation("Старая Деревня"));
        testList.add(stationIndex.getStation("Крестовский остров"));
        testList.add(stationIndex.getStation("Чкаловская"));
        testList.add(stationIndex.getStation("Спортивная"));
        testList.add(stationIndex.getStation("Адмиралтейская"));
        testList.add(stationIndex.getStation("Садовая"));
        testList.add(stationIndex.getStation("Звенигородская"));
        testList.add(stationIndex.getStation("Обводный канал"));
        testList.add(stationIndex.getStation("Волковская"));
        testList.add(stationIndex.getStation("Бухарестская"));
        testList.add(stationIndex.getStation("Международная"));
        assertEquals(27.5, calculator.calculateDuration(testList));
    }

    @Test
    void calculateDurationOneConnection() {
        List<Station> testList = new ArrayList<>();
        testList.add(stationIndex.getStation("Адмиралтейская"));
        testList.add(stationIndex.getStation("Садовая"));
        testList.add(stationIndex.getStation("Спасская"));
        testList.add(stationIndex.getStation("Достоевская"));
        assertEquals(8.5, calculator.calculateDuration(testList));
    }

    @Test
    void calculateDurationTwoConnection() {
        List<Station> testList = new ArrayList<>();
        testList.add(stationIndex.getStation("Горьковская"));
        testList.add(stationIndex.getStation("Невский проспект"));
        testList.add(stationIndex.getStation("Гостиный двор"));
        testList.add(stationIndex.getStation("Маяковская"));
        testList.add(stationIndex.getStation("Площадь Восстания"));
        testList.add(stationIndex.getStation("Чернышевская"));
        testList.add(stationIndex.getStation("Площадь Ленина"));
        assertEquals(17.0, calculator.calculateDuration(testList));
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