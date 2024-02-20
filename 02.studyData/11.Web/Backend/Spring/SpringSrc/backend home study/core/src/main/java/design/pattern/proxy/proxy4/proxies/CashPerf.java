package design.pattern.proxy.proxy4.proxies;

import design.pattern.proxy.proxy4.Payment;
import org.springframework.util.StopWatch;

public class CashPerf implements Payment {

    Payment cash = new Cash();
    @Override
    public void pay(int amount) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        cash.pay(amount);

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
