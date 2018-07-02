package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.imp.ReservaDAOImp;
import aplicacion.modelo.dominio.Reserva;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Rojas, Guido G.
 */
@ManagedBean
@ViewScoped
public class ReservaBean implements Serializable{

    private Reserva reserva;
    
    public ReservaBean() {
        this.reserva = new Reserva();        
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
 
    public void borrarReserva(Reserva re) {
        ReservaDAOImp reservaDAOImp = new ReservaDAOImp();
        reservaDAOImp.delete(re);
    }
    
    public void modificarReserva(Reserva re) {
        ReservaDAOImp reservaDAOImp = new ReservaDAOImp();
        reservaDAOImp.update(re);
    }
    public void agregarReserva(Reserva re) {
        ReservaDAOImp reservaDAOImp = new ReservaDAOImp();
        reservaDAOImp.add(re);
    }
            
    public List<Reserva> listarReservas() {
        ReservaDAOImp reservaDAOImp = new ReservaDAOImp();
        return reservaDAOImp.devolverReservas();
    }
    public Reserva obtenerUltimaReserva() {
        ReservaDAOImp reservaDAOImp = new ReservaDAOImp();
        return reservaDAOImp.obtenerUltimaReserva();
    }    
}