package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.imp.DetalleReservaDAOImp;
import aplicacion.modelo.dominio.DetalleReserva;
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
 * clase llamada DetalleReservaBean 
 */
public class DetalleReservaBean implements Serializable{

    private DetalleReserva dr;
    
    public DetalleReservaBean() {
        this.dr = new DetalleReserva();        
    }
    /**
     * constructor de DetalleReserva con su get y set
     * @return 
     */
    public DetalleReserva getDr() {
        return dr;
    }

    public void setDr(DetalleReserva dr) {
        this.dr = dr;
    }
    /**
     * procedimiento llamado agregarDetalleReserva 
     * @param dr 
     */
    public void agregarDetalleReserva(DetalleReserva dr) {
        DetalleReservaDAOImp drDAOImp = new DetalleReservaDAOImp();
        drDAOImp.add(dr);
    }
    /**
     * procedimiento llamado borrarDetalleReserva 
     * @param dr 
     */
    public void borrarDetalleReserva(DetalleReserva dr) {
        DetalleReservaDAOImp drDAOImp = new DetalleReservaDAOImp();
        drDAOImp.delete(dr);
    }
    /**
     * procedimiento llamado modificarDetalleReserva
     * @param dr 
     */
    public void modificarDetalleReserva(DetalleReserva dr) {
        DetalleReservaDAOImp drDAOImp = new DetalleReservaDAOImp();
        drDAOImp.update(dr);
    }
    /**
     * lista de DetalleReserva
     * @param dr
     * @return 
     */
    public List<DetalleReserva> devolverDetalleReserva() {
        DetalleReservaDAOImp drDAOImp = new DetalleReservaDAOImp();
        return drDAOImp.devolverDetalleReservas();
    }
}