import model.Request;
import service.Banks;
import service.Operaciones;

import java.util.Scanner;

public class Menu {

    public static void start(){
        Request req = new Request();
        String nombre;
        int numeroCuenta;
        int indexCuenta;
        Banks bankId;
        Operaciones operacion;
        double cantidad;

        int opc;

        inicio:
        while (true){
            req = askLocation(req);
            req = askOperation(req);
        }
    }

    private static Request askLocation(Request req){
        int opc;
        Scanner scanner = new Scanner(System.in);

        System.out.println("******* SELECCIONE UNA UBICACIÓN *******");
        System.out.println("1. ATM Banco A");
        System.out.println("2. ATM Banco B");
        System.out.println("3. ATM Banco C");
        System.out.println("4. Sucursal bancaria");

        opc = scanner.nextInt();
        switch (opc){
            case 1:
                req.setBankId(Banks.A);
                break;
            case 2:
                req.setBankId(Banks.B);
                break;
            case 3:
                req.setBankId(Banks.C);
                break;
            case 4:
                req.setBankId(Banks.SUCURSAL);
            default:
                System.out.println("Ingresa una opción válida");
                break;
        }
        return req;
    }

    private static Request askOperation(Request req){
        System.out.println("***** QUÉ OPERACIÓN VA A REALIZAR? ******");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Depositar");
        System.out.println("3. Retirar");
        System.out.println("4. Eliminar cuenta");
        return req;
    }
}
