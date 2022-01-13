
public class Money {
    private double value;

    public Money(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
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
        Money balance = new Money(6.0);
        Money request = new Money(3.0);

        if (balance.getValue() > request.getValue())
            dispenseFunds(request);
    }
}
