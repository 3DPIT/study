package dateType;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class App {
    public static void main(String[] args) {
        //이름이 잘 작명되어 있지 않고,
        Date date = new Date();//타임 스탬프 없고,
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat();

        //기계적 시간 api
        Instant instant = Instant.now();
        System.out.println(instant); // UTC GMT
        System.out.println(instant.atZone(ZoneId.systemDefault()));

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone   );
        System.out.println(zonedDateTime);

        // 휴먼용 , 해당 서버의 시간이 나옴
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime birthDay=
                LocalDateTime.of(1992, Month.AUGUST, 17,0,0,0);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);


        //기간 표현
        //period Human용 기간 비교
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2020,Month.AUGUST, 17);

        Period period  = Period.between(today,thisYearBirthday);
        System.out.println(period.getDays());

        Period until =  today.until(thisYearBirthday);
        System.out.println(until.get(ChronoUnit.DAYS));

        //Duration - 인스턴트 가지고 비교
        // Machine용 시간을 비교

        Instant now2= Instant.now();
        Instant plus = now2.plus(10,ChronoUnit.SECONDS);
        Duration between = Duration.between(now2, plus);
        System.out.println(between.getSeconds());

        //파싱 또는 포매팅

        //포매팅
        LocalDateTime now3= LocalDateTime.now();
        System.out.println(now3);
        DateTimeFormatter MMddyyyy= DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now3.format(MMddyyyy));

        //파싱
        LocalDate parse = LocalDate.parse("07/15/1982", MMddyyyy);
        System.out.println(parse);

        //레거시api 호환
        Date date3= new Date();
        Instant instant1 = date.toInstant();
        Date newDate = Date.from(instant1);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        ZonedDateTime dateTime1 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar.from( dateTime1);

        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);

        // INMUTABLE하고 새로운 인스턴스 생성함

    }
}
