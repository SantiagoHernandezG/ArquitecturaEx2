import model.ATM;
import model.Request;
import model.Teller;
import service.Banks;
import service.Operaciones;

import java.util.Scanner;

public class Menu {

    public static void start(){
        while (true){
            Request req = new Request();
            req = askLocation(req);
            req = askOperation(req);
            processRequest(req);
        }
    }

    private static Request askLocation(Request req){
        int opc;
        Scanner scanner = new Scanner(System.in);

        System.out.println("******* SELECCIONE UNA UBICACIÓN *******");
        System.out.println("A ");
        System.out.println("B");
        System.out.println("C");
        System.out.println("SUCURSAL");

        /* Código refactorizado:
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
                break;
            default:
                System.out.println("Ingresa una opción válida");
                break;
        }
        */

        /*Nuevo código después de la refactorización
        *  Mayor optimización y claridad al leer el código
        * */
        req.setBankId(Banks.valueOf(scanner.next()));

        return req;
    }

    private static Request askOperation(Request req){
        int opc;
        double cantidad;
        String nombre;
        Scanner scanner = new Scanner(System.in);

        System.out.println("***** QUÉ OPERACIÓN VA A REALIZAR? ******");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Depositar");
        System.out.println("3. Retirar");
        System.out.println("4. Eliminar cuenta");
        System.out.println("5. Consultar saldo");
        opc = scanner.nextInt();
        switch (opc){
            case 1:
                req.setOperacion(Operaciones.CREAR);
                System.out.println("Ingrese su nombre:");
                nombre = scanner.next();
                req.setNombre(nombre);
                break;
            case 2:
                req.setOperacion(Operaciones.DEPOSITAR);
                req = auth(req);
                System.out.println("Ingrese la cantidad que va a depositar:");
                cantidad = scanner.nextDouble();
                req.setCantidad(cantidad);
                break;
            case 3:
                req.setOperacion(Operaciones.RETIRAR);
                req = auth(req);
                System.out.println("Ingrese la cantidad que va a retirar:");
                cantidad = scanner.nextDouble();
                req.setCantidad(cantidad);
                break;
            case 4:
                req.setOperacion(Operaciones.ELIMINAR);
                break;
            case 5:
                req.setOperacion(Operaciones.CONSULTAR);
                req = auth(req);
                break;
            default:
                System.out.println("Ingresa una opción válida");
                break;
        }
        return req;
    }

    private static Request auth(Request req){
        int opc;
        int identifier;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cómo buscamos su cuenta");
        System.out.println("1. Número de cuenta");
        System.out.println("2. Index");
        opc = scanner.nextInt();
        switch (opc){
            case 1:
                System.out.println("Ingrese su número de cuenta");
                identifier = scanner.nextInt();
                req.setNumeroCuenta(identifier);
                break;
            case 2:
                System.out.println("Ingrese su index");
                identifier = scanner.nextInt();
                req.setIndexCuenta(identifier);
                break;
            default:
                System.out.println("Ingrse una opción válida");
                break;
        }
        return req;
    }

    private static void processRequest(Request req){
        Teller teller = new Teller(Banks.SUCURSAL);
        ATM atm1 = new ATM(Banks.A);
        atm1.setNext(teller);
        ATM atm2 = new ATM(Banks.B);
        atm2.setNext(teller);
        ATM atm3 = new ATM(Banks.C);
        atm3.setNext(teller);

        switch (req.getBankId()){
            case A:
                atm1.handle(req);
                break;
            case B:
                atm2.handle(req);
                break;
            case C:
                atm3.handle(req);
                break;
            case SUCURSAL:
                teller.handle(req);
                break;
        }
    }
}
