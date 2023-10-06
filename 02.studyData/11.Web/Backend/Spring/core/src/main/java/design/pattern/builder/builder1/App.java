package design.pattern.builder.builder1;

public class App {
    public static void main(String[] args) {
        TourDirector director = new TourDirector(new DefaultTourBuilder());
        TourPlan tourPlan = director.plan();
        TourPlan tourPlan1 = director.shortTrip();
    }
}
