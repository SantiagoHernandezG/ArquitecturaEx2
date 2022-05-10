package interfaces;
import model.Request;

/* Chain of Responsability - Patrón de comportamiento
* Para la implementación de este patrón se considera el escenario en que existen dos interfaces: ATM y Banquero.
 * El ATM solo puede procesar peticiones de retiros, depósitos y consultas.
 * Mientras que el banquero puede procesar altas, bajas y consultas de cuentas.
 * El orden jerárquico es banquero > ATM
* */
public interface Handler {
    void setNext(Handler h);
    void handle(Request request);
    void atenderCliente(Request request);
}
