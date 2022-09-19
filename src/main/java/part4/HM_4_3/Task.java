package part4.HM_4_3;

/*
Подключите в проект библиотеку  airport.jar (лежит в ресурсах) и распечатайте время вылета и модели самолетов,
вылетающих в ближайшие два часа.
 */

import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static com.skillbox.airport.Airport.getInstance;

public class Task {
    public static void main(String[] args) {
        Airport airport = getInstance();
        LocalDateTime currentDateAndTime = LocalDateTime.now();

        airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .filter(flight -> modifiedDate(flight)
                        .isAfter(currentDateAndTime) && modifiedDate(flight)
                        .isBefore(currentDateAndTime.plusHours(2)))
                .forEach(s -> System.out.println(modifiedDate(s) + ", " + s.getAircraft()));
    }

    public static LocalDateTime modifiedDate(Flight dateAndTime) {
        return LocalDateTime
                .ofInstant(dateAndTime.getDate().toInstant(), ZoneId.systemDefault());
    }

}
