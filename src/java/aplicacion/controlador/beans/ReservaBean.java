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
/**
 * clase ReservaBean
 */
public class ReservaBean implements Serializable{

    private Reserva reserva;
    
    public ReservaBean() {
        this.reserva = new Reserva();        
    }
    /**
     * constructor de Usuario con su get
     * @return 
     */
    public Reserva getReserva() {
        return reserva;
    }
    /**
     * constructor de Usuario con su set
     * @param reserva 
     */
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    /**
     * borrado de Reserva
     * @param re 
     */
    public void borrarReserva(Reserva re) {
        ReservaDAOImp reservaDAOImp = new ReservaDAOImp();
        reservaDAOImp.delete(re);
    }
    /**
     * modificacion de Reserva
     * @param re 
     */
    public void modificarReserva(Reserva re) {
        ReservaDAOImp reservaDAOImp = new ReservaDAOImp();
        reservaDAOImp.update(re);
    }
    /**
     * agregado de Reserva
     * @param re 
     */
    public void agregarReserva(Reserva re) {
        ReservaDAOImp reservaDAOImp = new ReservaDAOImp();
        reservaDAOImp.add(re);
    }
     /**
      * listado de Reserva
      * @return 
      */       
    public List<Reserva> listarReservas() {
        ReservaDAOImp reservaDAOImp = new ReservaDAOImp();
        return reservaDAOImp.devolverReservas();
    }
    /**
     * obtencion de la ultima Reserva
     * @return 
     */
    public Reserva obtenerUltimaReserva() {
        ReservaDAOImp reservaDAOImp = new ReservaDAOImp();
        return reservaDAOImp.obtenerUltimaReserva();
    }    
}