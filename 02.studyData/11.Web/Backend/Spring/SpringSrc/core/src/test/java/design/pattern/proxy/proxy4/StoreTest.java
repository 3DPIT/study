package design.pattern.proxy.proxy4;

import design.pattern.proxy.proxy4.proxies.Cash;
import design.pattern.proxy.proxy4.proxies.CashPerf;
import design.pattern.proxy.proxy4.proxies.CreditCard;
import org.junit.jupiter.api.Test;

class StoreTest {
    @Test
    public void testCashPay(){
        Cash cash = new Cash();
        Store store = new Store(cash);
        store.buySomething(100);
    }
    @Test
    public void testCreditCardPay(){
        CreditCard creditCard = new CreditCard();
        Store store = new Store(creditCard);
        store.buySomething(100);
    }
    @Test
    public void testCashPerfPay(){
        CashPerf cashPerf = new CashPerf();
        Store store = new Store(cashPerf);
        store.buySomething(100);
    }
}