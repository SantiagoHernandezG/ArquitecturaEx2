import model.Teller;
import model.ATM;
import service.Banks;

public class SetUp {
    public static void init() {
        Teller teller = new Teller(Banks.SUCURSAL);
        ATM atm1 = new ATM(Banks.A);
        atm1.setNext(teller);
        ATM atm2 = new ATM(Banks.B);
        atm2.setNext(teller);
        ATM atm3 = new ATM(Banks.C);
        atm3.setNext(teller);
    }

    public static void menu(){

    }
}
