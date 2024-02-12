package builder._1;

import java.time.LocalDate;
import java.util.List;

public class TourPlan {
    private String title;
    private int nigths;
    private int days;
    private LocalDate startDate;
    private String whereToStay;
    private List<DetailPlan> plans;

    public TourPlan() {
    }

    public TourPlan(String title, int nigths, int days, LocalDate startDate, String whereToStay, List<DetailPlan> plans) {
        this.title = title;
        this.nigths = nigths;
        this.days = days;
        this.startDate = startDate;
        this.whereToStay = whereToStay;
        this.plans = plans;
    }

    @Override
    public String toString() {
        return "TourPlan{" +
                "title='" + title + '\'' +
                ", nigths=" + nigths +
                ", days=" + days +
                ", startDate=" + startDate +
                ", whereToStay='" + whereToStay + '\'' +
                ", plans=" + plans +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNigths() {
        return nigths;
    }

    public void setNigths(int nigths) {
        this.nigths = nigths;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getWhereToStay() {
        return whereToStay;
    }

    public void setWhereToStay(String whereToStay) {
        this.whereToStay = whereToStay;
    }

    public List<DetailPlan> getPlans() {
        return plans;
    }

    public void setPlans(List<DetailPlan> plans) {
        this.plans = plans;
    }
}
