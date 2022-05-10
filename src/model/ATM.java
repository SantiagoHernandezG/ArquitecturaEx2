package model;
import interfaces.Handler;
import service.Banks;
import service.CuentaService;
import service.Operaciones;

public class ATM implements Handler {
    private Banks bancoId;
    private Handler nextHandler;

    public ATM(Banks bancoId) {
        setBancoId(bancoId);
    }

    public Banks getBancoId() {
        return bancoId;
    }

    public void setBancoId(Banks bancoId) {
        this.bancoId = bancoId;
    }

    @Override
    public void setNext(Handler h) {
        nextHandler = h;
    }

    @Override
    public void handle(Request request) {
        if(request.getOperacion() == Operaciones.CREAR || request.getOperacion() ==  Operaciones.ELIMINAR){
            System.out.println("Esta petición no puede ser procesada por el ATM. Redirigiendo con banquero...");
            nextHandler.handle(request);
        }else{
            request.setBankId(this.bancoId);
            atenderCliente(request);
        }
    }

    @Override
    public void atenderCliente(Request request) {
        CuentaService service = new CuentaService();
        switch (request.getOperacion()){
            case CONSULTAR:
                if(request.getNumeroCuenta() == 0){
                    service.consultarCuentaIndex(request.getIndexCuenta());
                }else{
                    service.consultarCuentaNumero(request.getNumeroCuenta());
                }
                break;

            case DEPOSITAR:
                service.depositar(request.getIndexCuenta(), request.getCantidad());
                break;

            case RETIRAR:
                service.retirar(request.getIndexCuenta(), request.getCantidad(), request.getBankId());
                break;
        }
    }
}
