package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.PerfilBean;
import aplicacion.controlador.beans.ReservaBean;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Rojas, Guido G.
 */
@ManagedBean
@ViewScoped
/**
 * clase ReservaFormBean
 */
public class PerfilFormBean implements Serializable{

    @ManagedProperty(value = "#{perfilBean}")
    private PerfilBean perfilBean;
    
    @ManagedProperty(value = "#{reservaBean}")
    private ReservaBean reservaBean;
    
    public PerfilFormBean() {
       
    }

    public PerfilBean getPerfilBean() {
        return perfilBean;
    }

    public void setPerfilBean(PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
    }

    public ReservaBean getReservaBean() {
        return reservaBean;
    }

    public void setReservaBean(ReservaBean reservaBean) {
        this.reservaBean = reservaBean;
    }
    
    
    public String obtenerNyAPerfil(int CodigoBuscar){
        return perfilBean.obtenerNyAPerfil(reservaBean.obtenerCodigoPerfil(CodigoBuscar));
                
    }
    
    public String obtenerDNIPerfil(int CodigoBuscar){
        return perfilBean.obtenerDNIPerfil(reservaBean.obtenerCodigoPerfil(CodigoBuscar));
                
    }
}
