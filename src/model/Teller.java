package model;
import interfaces.Handler;
import service.Banks;
import service.CuentaService;

public class Teller implements Handler {
    private  Banks bancoId;
    private Handler nextHandler = null;

    public Teller(Banks bancoId){
        setBancoId(bancoId);
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
        request.setBankId(this.bancoId);
        atenderCliente(request);
    }

    @Override
    public void atenderCliente(Request request) {
        System.out.println("Banquero: Será un placer atenderle...");
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

            case CREAR:
                service.crearCuenta(request.getNombre());
                break;

            case ELIMINAR:
                service.eliminarCuenta(request.getIndexCuenta());
                break;
        }
    }
}
