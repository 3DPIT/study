package builder._1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DefaultTourBuilder implements TourPlanBuilder{
    private String title;
    private int night;
    private int days;
    private LocalDate startDate;
    private String whereToStay;
    private List<DetailPlan> plans;

    @Override
    public TourPlanBuilder title(String title) {
        this.title= title;
        return this;
    }

    @Override
    public TourPlanBuilder nightAndDays(int night, int days) {

        return null;
    }

    @Override
    public TourPlanBuilder startDate(LocalDate localDate) {
        return null;
    }

    @Override
    public TourPlanBuilder whereToStay(String whereToStay) {
        this.whereToStay = whereToStay;
        return this;
    }

    @Override
    public TourPlanBuilder addPlan(int day, String plan) {
        if(this.plans == null){
            this.plans = new ArrayList<>();
        }

        this.plans.add(new DetailPlan(day, plan));
        return this;
    }

    @Override
    public TourPlan getPlan() {
        return new TourPlan(title, night,days,startDate, whereToStay,plans);
    }
}
