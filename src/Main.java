import model.ATM;
import model.Request;
import model.Teller;
import service.Banks;
import service.Operaciones;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        init();
        menu();
        //ToDO

        /*
         * Implementa un menú que perimta crear cuenta, buscar una cuenta por indice o por número de cuenta
         * y permita hacer depositos o retiros de la cuenta seleccionada.
         *
         * */
    }

    static void init() {
        Teller teller = new Teller(Banks.SUCURSAL);
        ATM atm1 = new ATM(Banks.A);
        atm1.setNext(teller);
        ATM atm2 = new ATM(Banks.B);
        atm2.setNext(teller);
        ATM atm3 = new ATM(Banks.C);
        atm3.setNext(teller);
    }

    static void menu(){

    }
}
