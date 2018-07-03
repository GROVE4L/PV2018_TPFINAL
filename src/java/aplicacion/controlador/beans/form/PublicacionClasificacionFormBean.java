package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.AutorBean;
import aplicacion.controlador.beans.ClasificacionBean;
import aplicacion.controlador.beans.PublicacionAutorBean;
import aplicacion.controlador.beans.PublicacionBean;
import aplicacion.controlador.beans.PublicacionClasificacionBean;
import aplicacion.modelo.dominio.Autor;
import aplicacion.modelo.dominio.Clasificacion;
import aplicacion.modelo.dominio.Publicacion;
import aplicacion.modelo.dominio.PublicacionAutor;
import aplicacion.modelo.dominio.PublicacionClasificacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rojas, Guido G.
 */
@ManagedBean
@ViewScoped
/**
 * clase llamada PublicacionClasificacionFormBean
 */
public class PublicacionClasificacionFormBean implements Serializable{

    private String codigoPublicacion;
    private int codigoClasificacion;
    
    //@ManagedProperty(value = "#{publicacionAutorBean}")
    private PublicacionClasificacionBean publicacionClasificacionBean;    
    
       public PublicacionClasificacionFormBean() {
        this.publicacionClasificacionBean = new PublicacionClasificacionBean();        
    }
    /**
     * constructor de PublicacionClasificacionBean con su get
     * @return 
     */
    public PublicacionClasificacionBean getPublicacionClasificacionBean() {
        return publicacionClasificacionBean;
    }
    /**
     * constructor de PublicacionClasificacionBean con su set
     * @param publicacionClasificacionBean 
     */
    public void setPublicacionClasificacionBean(PublicacionClasificacionBean publicacionClasificacionBean) {
        this.publicacionClasificacionBean = publicacionClasificacionBean;
    }
    /**
     * constructor de CodigoPublicacion con su get
     * @return 
     */  
    public String getCodigoPublicacion() {
        return codigoPublicacion;
    }
    /**
     * constructor de CodigoPublicacion con su set
     * @param codigoPublicacion 
     */
    public void setCodigoPublicacion(String codigoPublicacion) {
        this.codigoPublicacion = codigoPublicacion;
    }
    /**
     * constructor de CodigoClasificacion con su get
     * @return 
     */
    public int getCodigoClasificacion() {
        return codigoClasificacion;
    }
    /**
     * constructor de CodigoClasificacion con su set
     * @param codigoClasificacion 
     */
    public void setCodigoClasificacion(int codigoClasificacion) {
        this.codigoClasificacion = codigoClasificacion;
    }   
    /**
     * pregunta si pertenece a clasificacion a lista
     * @param codigoClasificacionBuscado
     * @param listaDondeBuscarlo
     * @return 
     */
    private boolean perteneClasificacionALista(int codigoClasificacionBuscado, List<Clasificacion> listaDondeBuscarlo) {
        for(Clasificacion i: listaDondeBuscarlo) {
            if(i.getClaCodigo() == codigoClasificacionBuscado)
                return true;
        }
        return false;
    }
    /**
     * procedimiento vincularLibro
     */
    public void vincularLibro(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Publicacion Vinculada Exitosamente",
                            ""));
            
        PublicacionClasificacion objetoCargado = new PublicacionClasificacion();
        objetoCargado.setPcEstado(true);
        objetoCargado.setPcClasificacion(this.codigoClasificacion);
        objetoCargado.setPcPublicacion(this.codigoPublicacion);        
        publicacionClasificacionBean.agregarPublicacionClasificacion(objetoCargado);
    }
    /**
     * lista de clasificaciones de publicacion
     * @param codigoPublicacionBuscado
     * @return 
     */
    public List<Clasificacion> listarClasificacionesDePublicacion(String codigoPublicacionBuscado) {        
        List<PublicacionClasificacion> listaCodigosClasificaciones = publicacionClasificacionBean.listarPublicacionClasificacion(codigoPublicacionBuscado);
        
        List<Clasificacion> listaClasificaciones = new ArrayList<Clasificacion>();
        ClasificacionBean clasificacionBean = new ClasificacionBean();
        for(PublicacionClasificacion i: listaCodigosClasificaciones) {
            listaClasificaciones.add(clasificacionBean.buscarPorCodigo(i.getPcClasificacion()));           
        }        
        return listaClasificaciones;
    }
    /**
     * lista de clasificaciones disponibles
     * @return 
     */
    public List<Clasificacion> listaClasificacionesDisponibles() {
        ClasificacionBean clasificacionBean = new ClasificacionBean();
        PublicacionBean publicacionBean = new PublicacionBean();
        if(codigoPublicacion == null)
            codigoPublicacion = ((Publicacion)publicacionBean.listarPublicaciones().get(0)).getPubCodigo();
                
        List<Clasificacion> listaClasificacionesDeLaPublicacion = new ArrayList<Clasificacion>();
        List<Clasificacion> listaFinal = new ArrayList<Clasificacion>();        
        listaClasificacionesDeLaPublicacion = this.listarClasificacionesDePublicacion(this.codigoPublicacion);
        for(Clasificacion i: clasificacionBean.listarClasificaciones()) {
            if(!this.perteneClasificacionALista(i.getClaCodigo(), listaClasificacionesDeLaPublicacion))
                listaFinal.add(i);
        }  
        return listaFinal;
    }
    
}
