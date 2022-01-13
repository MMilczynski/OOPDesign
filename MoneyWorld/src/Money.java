enum Currency {
    USD, EURO;

    /* ... just make it work, no logic here */
    public double convertRateTo(Currency target) {
        return 1.0;
    }
}

public class Money {
    private double value;

    // need to add this
    private Currency currency;

    // need to modify constructor, could have used overloading as well
    public Money(double value, Currency currency) {
        this.value = value;
        // need to add this line
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Test.test();
    }
}

class Test {

    private static void dispenseFunds(Money amount) {
        /* ... */
        System.out.println("Funds dispensed");
    }

    public static void test() {
        /*
         * previous code
         * 
         * Money balance = new Money(1.0);
         * Money request = new Money(3.0);
         * 
         * now I need to modify those two calls and add conversion operation.
         * Error-prone code and hard to maintain
         */
        Money balance = new Money(1.0, Currency.EURO);
        Money request = new Money(3.0, Currency.USD);

        double normalizedBalance = balance.getValue() * balance.getCurrency().convertRateTo(Currency.USD);

        double normalizedRequest = request.getValue() * request.getCurrency().convertRateTo(Currency.USD);

        if (normalizedBalance > normalizedRequest)
            dispenseFunds(request);
    }
}
