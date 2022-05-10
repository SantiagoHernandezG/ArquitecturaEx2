package model;
import service.Banks;
import service.Operaciones;

public class Request {
    private String nombre;
    private int numeroCuenta;
    private int indexCuenta;
    private Banks bankId;
    private Operaciones operacion;
    private double cantidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getIndexCuenta() {
        return indexCuenta;
    }

    public void setIndexCuenta(int indexCuenta) {
        this.indexCuenta = indexCuenta;
    }

    public Banks getBankId() {
        return bankId;
    }

    public void setBankId(Banks bankId) {
        this.bankId = bankId;
    }

    public Operaciones getOperacion() {
        return operacion;
    }

    public void setOperacion(Operaciones operacion) {
        this.operacion = operacion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
