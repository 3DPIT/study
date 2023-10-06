package design.pattern.builder.builder1;

import java.time.LocalDate;

public interface TourPlanBuilder {
    TourPlanBuilder title(String title);
    TourPlanBuilder nightAndDays(int  night, int days);
    TourPlanBuilder startDate(LocalDate localDate);
    TourPlanBuilder whereToStay(String whereToStay);
    TourPlanBuilder addPlan(int day, String plan);
    TourPlan getPlan();
}
