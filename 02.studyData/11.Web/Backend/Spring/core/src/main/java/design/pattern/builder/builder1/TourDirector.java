package design.pattern.builder.builder1;

import java.time.LocalDate;

public class TourDirector {
    private TourPlanBuilder tourPlanBuilder;

    public TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan plan(){
        return tourPlanBuilder.title("나트랑")
//                .nightAndDays(2,3)
                .startDate(LocalDate.of(2023,10,1))
                .whereToStay("호텔")
                .addPlan(0,"야외 수영")
                .getPlan();
    }

    public TourPlan shortTrip(){
        return tourPlanBuilder.title("제주도")
//                .nightAndDays(2,3)
                .startDate(LocalDate.of(2023,10,1))
                .getPlan();
    }
}
