package model;
import interfaces.Handler;
import service.Banks;
import service.Operaciones;

public class Teller implements Handler {
    private  Banks bancoId;
    private Handler nextHandler = null;

    public Teller(Banks bancoId){
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

    }

    @Override
    public void atenderCliente(Request request) {

    }
}
