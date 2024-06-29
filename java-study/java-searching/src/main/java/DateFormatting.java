import java.util.*;
import java.time.*;
import java.time.format.*;

public class DateFormatting {
    public static void main(String[] args) {
        List<String> inputs = List.of("2010/02/20", "2011 03 21", "04 22 2012", "2013-05-23", "2 014p 06p 24");
        System.out.println("Dates formatted: " + dateFormat(inputs));
    }

    private static List<String> dateFormat(List<String> inputs) {
        List<String> results = new ArrayList<>();
        DateTimeFormatter targetFormater = DateTimeFormatter.ofPattern("yyyy/dd/MM");
        List<DateTimeFormatter> formatters = List.of(
                DateTimeFormatter.ofPattern("yyyy/MM/dd"),
                DateTimeFormatter.ofPattern("yyyy MM dd"),
                DateTimeFormatter.ofPattern("MM dd yyyy"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"),
                DateTimeFormatter.ofPattern("yyyyMMdd")
        );

        for (var input : inputs) {
            String inputCleaned = (input.contains("p")) ? input.replace(" ", "").replace("p", "") : input;
            for (var format : formatters) {
                try {
                    LocalDate date = LocalDate.parse(inputCleaned, format);
                    results.add(date.format(targetFormater));
                } catch (Exception ignored) {}
            }
        }

        return results;
    }
}
