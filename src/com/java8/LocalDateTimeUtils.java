package com.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.zone.ZoneOffsetTransitionRule;
import java.util.Arrays;
import java.util.TimeZone;

/**
 * @author 212331901
 * @date 2019/3/11
 */
public class LocalDateTimeUtils {

    private void commonLocalDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek().toString());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.isLeapYear());
        System.out.println(localDate.plusDays(2).toString());
    }

    private void commonLocalTime() {
        LocalTime localTimeNow = LocalTime.now();
        System.out.println(localTimeNow);
        System.out.println(localTimeNow.getSecond());
        System.out.println(localTimeNow.getNano());

        LocalTime localTime = LocalTime.of(10, 30);
        System.out.println(localTime);
        System.out.println(localTime.getHour());
        System.out.println(localTime.minusMinutes(15));
        System.out.println(localTime.isAfter(localTimeNow));
        System.out.println(LocalTime.MIDNIGHT);
        System.out.println(LocalTime.NOON);
    }

    private void commonLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getNano());
        System.out.println(localDateTime.plusWeeks(3));
    }

    private void commonInstantAndDuration() {
        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(Duration.ofMillis(5000));
        System.out.println(instant.plusMillis(200));
        System.out.println(instant.plus(Duration.ofMillis(200)));
        System.out.println(Duration.between(instant, instant.minusMillis(300)));

        // Period : handle bigger durations
        System.out.println(Period.ofYears(3));

    }

    private void utilityOfEnums() {
        //DayOfWeek
        System.out.println(DayOfWeek.of(3));
        System.out.println(LocalDate.now().with(DayOfWeek.THURSDAY));

        System.out.println(Month.of(6));
        System.out.println(MonthDay.now());
        System.out.println(MonthDay.of(9, 23));
    }

    private void timeAdujstAndBuild() {
        LocalDate localDate = LocalDate.of(2019, 3, 11);
        System.out.println(localDate);
        System.out.println(localDate.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println(localDate.with(TemporalAdjusters.next(DayOfWeek.of(3))));

        OffsetDateTime offsetDateTime = Year.of(2018)
                                            .atMonth(3)
                                            .atDay(2)
                                            .atTime(10, 10)
                                            .atOffset(ZoneOffset.UTC);
        OffsetDateTime offsetDateTime1 = OffsetDateTime.of(2018, 3, 2, 0, 0, 0, 0, ZoneOffset.of("+09:00"));
        System.out.println(offsetDateTime);
        System.out.println(offsetDateTime1);

        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.getZone());
        Clock clock_3 = Clock.system(ZoneOffset.of("+03:00"));
        System.out.println(clock_3.getZone());
        System.out.println(clock_3.instant());
        Clock clock_eura = Clock.system(ZoneId.of("Europe/Tiraspol"));
        System.out.println(clock_eura.getZone());
        System.out.println(Clock.tick(clock_eura, Duration.ofSeconds(400)));
    }

    private void fromStringAndFormat(String input) {
        String strDate = (input == null || input.isEmpty()) ? "2019-03-11" : input;
        LocalDate localDate = LocalDate.parse(strDate);
        System.out.println(localDate);

        String armisticeDateTime = "2016-04-04T11:50";

        LocalDateTime aLDT = LocalDateTime.parse(armisticeDateTime);
        System.out.println("Date/Time: " + aLDT);

        String formater = "dd MM yyyy";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formater);
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDate1 = LocalDate.parse("04 07 2018", dateTimeFormatter);
        System.out.println(localDate1);
        System.out.println(dateTimeFormatter2.format(localDate1));
    }

    public static boolean laterThanToday(String date) {
        String formate = "yyyy-MM-dd";
        LocalDate input = LocalDate.parse(date, DateTimeFormatter.ofPattern(formate));
        return LocalDate.now().isBefore(input);
    }

    public static boolean withIn90Days(String date) {
        String formate = "yyyy-MM-dd";
        LocalDate input = LocalDate.parse(date, DateTimeFormatter.ofPattern(formate));
        return input.isBefore(LocalDate.now().plusDays(90));
    }

    public static void timezone() {
        System.out.println(Arrays.toString(TimeZone.getAvailableIDs()));
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("Asia/Shanghai")));
        System.out.println("system timezone: " + ZoneId.systemDefault());
        System.out.println(ZonedDateTime.now());
        System.out.println(Instant.now());
    }

    public static void main(String[] args) {
        LocalDateTimeUtils utils = new LocalDateTimeUtils();
//        utils.commonLocalDate();
//        utils.commonLocalTime();
//        utils.commonLocalDateTime();
//        utils.commonInstantAndDuration();
//        utils.utilityOfEnums();
//        utils.timeAdujstAndBuild();
//        utils.fromStringAndFormat(null);
        timezone();
    }
}
