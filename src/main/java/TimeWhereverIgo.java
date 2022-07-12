import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeWhereverIgo {

    public static String getFriendDateAndTime(String myTime, String myZone, String friendZone) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        ZonedDateTime friendDateTime = ZonedDateTime.from(formatter
                .withZone(ZoneId.of(myZone))
                .parse(myTime));

        return formatter.format(friendDateTime.withZoneSameInstant(ZoneId.of(friendZone)));
    }

    public static void main(String[] args) {
        System.out.println(getFriendDateAndTime("27-03-2021 19:41", "Europe/Warsaw", "Australia/Sydney"));
    }
}
