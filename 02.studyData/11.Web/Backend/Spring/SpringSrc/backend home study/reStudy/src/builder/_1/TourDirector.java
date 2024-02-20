package builder._1;

import java.time.LocalDate;

public class TourDirector {

    private TourPlanBuilder tourPlanBuilder;

    public TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan plan(){
        return tourPlanBuilder.title("나트랑")
                .startDate(LocalDate.of(2023,10,17))
                .whereToStay("호텔")
                .addPlan(0,"야외 수영")
                .getPlan();
    }
    public TourPlan plan1(){
        return tourPlanBuilder.title("나트랑1")
                .startDate(LocalDate.of(2023,11,17))
                .addPlan(0,"야외 수영1")
                .getPlan();
    }

}
