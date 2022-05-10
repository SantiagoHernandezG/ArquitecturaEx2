package service;

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
        cuenta.setMonto(cuenta.getMonto() + monto);
        consultarCuentaIndex(index);
    }

    public void retirar(int index, double monto,Banks banco){
        Cuenta cuenta = cuentaRepository.obtenerCuentaPorIndice(index);
        double comision =0;
        switch (banco){
            case A:
                comision = 30;
            case B:
                comision = 15;
            case C:
                comision = 10;
            case SUCURSAL:
                comision = 0;
        }
        cuenta.setMonto(cuenta.getMonto() - monto - comision);
        consultarCuentaIndex(index);
    }
}
