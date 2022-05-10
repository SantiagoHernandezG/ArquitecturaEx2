package service;

import jdk.swing.interop.SwingInterOpUtils;
import model.Cuenta;
import repository.CuentaRepository;
import java.util.Random;

public class CuentaService {

    private CuentaRepository cuentaRepository = CuentaRepository.getInstance();
    Random random = new Random();

    public void crearCuenta(String nombre){
        Cuenta cuenta = new Cuenta();
        cuenta.setNombre(nombre);
        cuenta.setNumeroDeCuenta(random.nextInt(10000));
        cuenta.setMonto(0.0);
        cuentaRepository.agregarCuenta(cuenta);
        System.out.println("Cuenta agregada exitosamente:");
        consultarCuentaNumero(cuenta.getNumeroDeCuenta());
    }

    public void consultarCuentaNumero(int numeroCuenta){
        Cuenta cuenta = cuentaRepository.obtenerCuentaPorNumeroCuenta(numeroCuenta);
        System.out.println("***** CUENTA ******");
        System.out.println("Numero de cuenta: "+cuenta.getNumeroDeCuenta());
        System.out.println("Nombre: "+cuenta.getNombre());
        System.out.println("Saldo: "+cuenta.getMonto());
    }

    public void consultarCuentaIndex(int index){
        Cuenta cuenta = cuentaRepository.obtenerCuentaPorIndice(index);
        System.out.println("***** CUENTA ******");
        System.out.println("Numero de cuenta: "+cuenta.getNumeroDeCuenta());
        System.out.println("Nombre: "+cuenta.getNombre());
        System.out.println("Saldo: "+cuenta.getMonto());
    }

    public void depositar(int index, double monto){
        Cuenta cuenta = cuentaRepository.obtenerCuentaPorIndice(index);
        Double saldo = cuenta.getMonto() + monto;
        cuenta.setMonto(saldo);
        consultarCuentaIndex(index);
        cuentaRepository.actualizarMontoDeCuenta(index,saldo);
        System.out.println("DEPOSITO EXITOSO");
    }

    public void retirar(int index, double monto,Banks banco){
        Cuenta cuenta = cuentaRepository.obtenerCuentaPorIndice(index);
        double comision =0;
        double saldo= 0;
        double retiroTotal=0;
        switch (banco){
            case A:
                comision = 30;
                break;
            case B:
                comision = 15;
                break;
            case C:
                comision = 10;
                break;
            case SUCURSAL:
                comision = 0;
                break;
        }
        System.out.println("Se está aplicando una comisión de: " + comision);
        retiroTotal = monto + comision;
        if(cuenta.getMonto() > retiroTotal){
            saldo = cuenta.getMonto();
            cuenta.setMonto(saldo);
            consultarCuentaIndex(index);
            cuentaRepository.actualizarMontoDeCuenta(index,saldo);
            System.out.println("RETIRO EXITOSO");
        }else {
            System.out.println("SALDO INSUFICIENTE");
            consultarCuentaIndex(index);
        }
    }

    public void eliminarCuenta(int index){
        cuentaRepository.eliminarCuenta(index);
        System.out.println("CUENTA ELIMINADA");
    }
}
