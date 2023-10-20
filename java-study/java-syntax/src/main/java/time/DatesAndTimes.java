package time;

import java.time.*;
import java.time.format.*;

public class DatesAndTimes {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        
        System.out.println("Instant: " + instant);
        System.out.println("Local date: " + date);
        System.out.println("Local time: " + time);
        System.out.println("Local date time: " + dateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");

        System.out.println("Local date time formatted: " + dateTime.format(formatter));
    }
}
