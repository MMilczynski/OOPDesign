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

    private double normalize() {
        return this.currency == Currency.USD
                ? this.value
                : this.value * this.currency.convertRateTo(Currency.USD);
    }

    public boolean isGreaterThan(Money op) {
        return this.normalize() > op.normalize();
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
        Money balance = new Money(1.0, Currency.EURO);
        Money request = new Money(3.0, Currency.USD);

        if (balance.isGreaterThan(request))
            dispenseFunds(request);
    }
}
