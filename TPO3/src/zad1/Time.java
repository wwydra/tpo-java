package zad1;

import java.time.*;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Time {

    public static String passed(String from, String to){
        try {
            LocalDateTime fromDate;
            LocalDateTime toDate;
            try {
                fromDate = LocalDateTime.parse(from);
            } catch (DateTimeParseException e) {
                fromDate = LocalDate.parse(from).atStartOfDay();
            }
            try {
                toDate = LocalDateTime.parse(to);
            } catch (DateTimeParseException e) {
                toDate = LocalDate.parse(to).atStartOfDay();
            }

            Duration duration = Duration.between(fromDate, toDate);
            long d = duration.toDays();
            long t = d / 7;
            double tDecimalPart = (double) (d % 7) / 7;

            String godz = fromDate.toLocalTime().toString();
            StringBuilder result = new StringBuilder();
            result.append("Od ").append(formatDate(fromDate));
            if (!godz.equals("00:00")) {
                result.append(" godz. ").append(godz).append(" do ").append(formatDate(toDate))
                        .append(" godz. ").append(toDate.toLocalTime().toString());
            }else{
                result.append(" do ").append(formatDate(toDate));
            }

            long days = ChronoUnit.DAYS.between(fromDate.toLocalDate(), toDate.toLocalDate());
            long weeks = days / 7;
            double weeksFraction = (double) (days % 7) / 7;
            String daysWord = adjust(days, "dzień", "dni", "dni");
            String weeksWord = adjust(weeks, "tydzień", "tygodnie", "tygodni");

            result.append("\n - mija: ")
                    .append(days).append(" ").append(daysWord)
                    .append(", ").append(weeksWord).append(" ")
                    .append(String.format("%.2f", weeks + weeksFraction).replace(',', '.'));

            long g = duration.toHours();
            long m = duration.toMinutes();

            ZoneId zoneId = ZoneId.of("Europe/Warsaw");
            ZonedDateTime fromZonedDateTime = fromDate.atZone(zoneId);
            ZonedDateTime toZonedDateTime = toDate.atZone(zoneId);

            if (!fromZonedDateTime.getOffset().equals(toZonedDateTime.getOffset())) {
                long offsetHoursDifference = (fromZonedDateTime.getOffset().getTotalSeconds()
                        - toZonedDateTime.getOffset().getTotalSeconds()) / 3600;
                g += offsetHoursDifference;
                m += offsetHoursDifference * 60;
            }

            if (!godz.equals("00:00")) {
                result.append("\n").append(" - godzin: ").append(g)
                        .append(", minut: ").append(m);
            }

            if (d > 0) {
                Period period = Period.between(fromDate.toLocalDate(), toDate.toLocalDate());
                long r = period.getYears();
                long m2 = period.getMonths();
                long d2 = period.getDays();

                int n = 0;
                result.append("\n");
                result.append(" - kalendarzowo:");
                if (r > 0) {
                    result.append(" ");
                    result.append(r).append(" ").append(adjust(r, "rok", "lata", "lat"));
                    n++;
                }
                if (m2 > 0) {
                    if (n == 0){
                        result.append(" ");
                    }else{
                        result.append(", ");
                    }
                    result.append(m2).append(" ")
                            .append(adjust(m2, "miesiąc", "miesiące", "miesięcy"));
                    n++;
                }
                if (d2 > 0) {
                    if (n == 0){
                        result.append(" ");
                    }else{
                        result.append(", ");
                    }
                    result.append(d2).append(" ").append(adjust(d2, "dzień", "dni", "dni"));
                }
            }

            return result.toString();
        } catch (DateTimeParseException e) {
            return "*** java.time.format.DateTimeParseException: " + e.getMessage();
        }
    }

    private static String formatDate(LocalDateTime dateTime) {
        String[] plMonths = {"stycznia", "lutego", "marca", "kwietnia", "maja", "czerwca", "lipca", "sierpnia",
                "września", "października", "listopada", "grudnia"};
        String[] plDays = {"poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota", "niedziela"};

        String res = dateTime.getDayOfMonth() + " " + plMonths[dateTime.getMonthValue() - 1];

        if (dateTime.getYear() != LocalDate.now().getYear()) {
            res += " " + dateTime.getYear();
        }

        res += " (" + plDays[dateTime.getDayOfWeek().getValue() - 1] + ")";

        return res;
    }

    private static String adjust(long number, String singular, String plural, String plural2) {
        if (number == 1) {
            return singular;
        } else if (number % 10 >= 2 && number % 10 <= 4 && (number % 100 < 10 || number % 100 >= 20)) {
            return plural;
        } else {
            return plural2;
        }
    }
}
