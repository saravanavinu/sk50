public interface Phone {

    String getDescription();

    double getCost();

}

public class AndroidPhone implements Phone {

    @Override
    public String getDescription() {
        return "Android Phone";
    }

    @Override
    public double getCost() {
        return 15000.0;
    }
}

public class Iphone implements Phone {

    @Override
    public String getDescription() {
        return "iPhone";
    }

    @Override
    public double getCost() {
        return 60000.0;
    }
}

public abstract class PhoneDecorator implements Phone {

    protected Phone phone;

    public PhoneDecorator(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String getDescription() {
        return phone.getDescription();
    }

    @Override
    public double getCost() {
        return phone.getCost();
    }
}

public class ScreenGuard extends PhoneDecorator {

    public ScreenGuard(Phone phone) {
        super(phone);
    }

    @Override
    public String getDescription() {
        return phone.getDescription() + ", Screen Guard";
    }

    @Override
    public double getCost() {
        return phone.getCost() + 500.0;
    }
}

public class PhoneCase extends PhoneDecorator {

    public PhoneCase(Phone phone) {
        super(phone);
    }

    @Override
    public String getDescription() {
        return phone.getDescription() + ", Phone Case";
    }

    @Override
    public double getCost() {
        return phone.getCost() + 800.0;
    }
}

public class WirelessCharger extends PhoneDecorator {

    public WirelessCharger(Phone phone) {
        super(phone);
    }

    @Override
    public String getDescription() {
        return phone.getDescription() + ", Wireless Charger";
    }

    @Override
    public double getCost() {
        return phone.getCost() + 2500.0;
    }
}
public class Earbuds extends PhoneDecorator {

    public Earbuds(Phone phone) {
        super(phone);
    }

    @Override
    public String getDescription() {
        return phone.getDescription() + ", Earbuds";
    }

    @Override
    public double getCost() {
        return phone.getCost() + 2000.0;
    }
}
public class MobileShop {

    public static void main(String[] args) {

        Phone phone1 = new AndroidPhone();

        Phone phone2 = new ScreenGuard(new AndroidPhone());

        Phone phone3 = new PhoneCase(
                new ScreenGuard(
                        new AndroidPhone()));

        Phone phone4 = new Earbuds(
                new WirelessCharger(
                        new PhoneCase(
                                new Iphone())));

        display(phone1);
        display(phone2);
        display(phone3);
        display(phone4);
    }

    public static void display(Phone phone) {

        System.out.println("Description : " + phone.getDescription());
        System.out.println("Cost        : " + phone.getCost());
        System.out.println();
    }
}