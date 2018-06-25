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
public class DetalleReservaBean implements Serializable{

    private DetalleReserva dr;
    
    public DetalleReservaBean() {
        this.dr = new DetalleReserva();        
    }

    public DetalleReserva getDr() {
        return dr;
    }

    public void setDr(DetalleReserva dr) {
        this.dr = dr;
    }
    
    public void agregarDetalleReserva(DetalleReserva dr) {
        DetalleReservaDAOImp drDAOImp = new DetalleReservaDAOImp();
        drDAOImp.add(dr);
    }
    public void borrarDetalleReserva(DetalleReserva dr) {
        DetalleReservaDAOImp drDAOImp = new DetalleReservaDAOImp();
        drDAOImp.delete(dr);
    }
    public void modificarDetalleReserva(DetalleReserva dr) {
        DetalleReservaDAOImp drDAOImp = new DetalleReservaDAOImp();
        drDAOImp.update(dr);
    }
    
    public List<DetalleReserva> devolverDetalleReserva(DetalleReserva dr) {
        DetalleReservaDAOImp drDAOImp = new DetalleReservaDAOImp();
        return drDAOImp.devolverDetalleReservas();
    }
}