package repository;
import model.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class CuentaRepository {

    /*  Implementación de Singleton
     *  Dado que Repository es nuestra conexión a DB o manejo de memoria. Solo necesitamos uno activo
     */

    private static CuentaRepository instance = new CuentaRepository();
    private List<Cuenta> cuentas;

    CuentaRepository(){
        cuentas = new ArrayList<>();
    }

    public static CuentaRepository getInstance(){
        return  instance;
    }

    public Cuenta obtenerCuentaPorIndice(int index){
        return cuentas.get(index);
    }

    public void agregarCuenta(Cuenta c){
        cuentas.add(c);
    }

    public Cuenta obtenerCuentaPorNumeroCuenta(int numeroCuenta){
        for (Cuenta c: cuentas){
            if(c.getNumeroDeCuenta() == numeroCuenta){
                return c;
            }
        }
        return null;
    }

    public void actualizarMontoDeCuenta(int index, double monto){
        Cuenta cuenta = obtenerCuentaPorIndice(index);
        if (cuenta != null){
            cuenta.setMonto(monto);
        }
    }

    public void eliminarCuenta(int index){
        cuentas.remove(index);
    }
}
