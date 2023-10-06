package design.pattern.builder.builder1;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        TourPlanBuilder builder = new DefaultTourBuilder();
        
        TourPlan plan= builder.title("나트랑여행")
                .nightAndDays(2,3)
                .startDate(  LocalDate.of(2023,10,6))
                .whereToStay("호텔")
                .addPlan(0,"야외 수영")
                .getPlan();

        TourPlan shortTrip = builder.title("제주도")
                .startDate(LocalDate.of(2023,10,6))
                .getPlan();
    }
}
