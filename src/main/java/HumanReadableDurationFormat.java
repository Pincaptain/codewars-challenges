import java.util.List;

public class HumanReadableDurationFormat {

    enum Duration {
        SECONDS,
        MINUTES,
        HOURS,
        DAYS,
        YEARS,
    }

    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }

        return parseDuration(seconds, Duration.YEARS, new StringBuilder());
    }

    public static String parseDuration(int seconds, Duration duration, StringBuilder builder) {
        if (duration == null) {
            return builder.toString();
        }

        int secondsInDuration = getAmountOfSecondsInDuration(duration);
        int amount = seconds / secondsInDuration;
        int reminder = seconds % getAmountOfSecondsInDuration(duration);

        Duration nextDuration = getNextDuration(duration);

        if (amount == 0) {
            return parseDuration(seconds, nextDuration, builder);
        }

        List<String> durationSingularAndPlural = getDurationSingularAndPlural(duration);

        builder.append(amount)
                .append(" ")
                .append(amount == 1 ? durationSingularAndPlural.get(0) : durationSingularAndPlural.get(1));

        if (reminder == 0) {
            return builder.toString();
        }

        if (nextDuration != null) {
            int secondsInNextDuration = getAmountOfSecondsInDuration(nextDuration);
            int nextReminder = reminder % secondsInNextDuration;

            if (nextReminder == 0) {
                builder.append(" and ");
            } else {
                builder.append(", ");
            }
        }

        return parseDuration(reminder, nextDuration, builder);
    }

    public static Duration getNextDuration(Duration duration) {
        return switch (duration) {
            case YEARS -> Duration.DAYS;
            case DAYS -> Duration.HOURS;
            case HOURS -> Duration.MINUTES;
            case MINUTES -> Duration.SECONDS;
            default -> null;
        };
    }

    public static int getAmountOfSecondsInDuration(Duration duration) {
        return switch (duration) {
            case YEARS -> 31536000;
            case DAYS -> 86400;
            case HOURS -> 3600;
            case MINUTES -> 60;
            default -> 1;
        };
    }

    public static List<String> getDurationSingularAndPlural(Duration duration) {
        return switch (duration) {
            case YEARS -> List.of("year", "years");
            case DAYS -> List.of("day", "days");
            case HOURS -> List.of("hour", "hours");
            case MINUTES -> List.of("minute", "minutes");
            default -> List.of("second", "seconds");
        };
    }

    public static void main(String[] args) {
        System.out.println(formatDuration(3660));
    }
}
