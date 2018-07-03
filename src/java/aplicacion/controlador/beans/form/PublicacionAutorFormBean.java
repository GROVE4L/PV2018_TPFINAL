package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.AutorBean;
import aplicacion.controlador.beans.PublicacionAutorBean;
import aplicacion.controlador.beans.PublicacionBean;
import aplicacion.modelo.dominio.Autor;
import aplicacion.modelo.dominio.Publicacion;
import aplicacion.modelo.dominio.PublicacionAutor;
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
 * clase  PublicacionAutorFormBean
 */
public class PublicacionAutorFormBean implements Serializable{

    private String codigoPublicacion;
    private int codigoAutor;
    
    //@ManagedProperty(value = "#{publicacionAutorBean}")
    private PublicacionAutorBean publicacionAutorBean;    
    
       public PublicacionAutorFormBean() {
        this.publicacionAutorBean = new PublicacionAutorBean();        
    }
     /**
      * constructor de PublicacionAutorBean con su get
      * @return 
      */  
    public PublicacionAutorBean getPublicacionAutorBean() {
        return publicacionAutorBean;
    }
    /**
     * constructor de PublicacionAutorBean con su set
     * @param publicacionAutorBean 
     */
    public void setPublicacionAutorBean(PublicacionAutorBean publicacionAutorBean) {
        this.publicacionAutorBean = publicacionAutorBean;
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
     * constructor de CodigoAutor con su get
     * @return 
     */
    public int getCodigoAutor() {
        return codigoAutor;
    }
    /**
     * constructor de CodigoAutor con su set
     * @param codigoAutor 
     */
    public void setCodigoAutor(int codigoAutor) {
        this.codigoAutor = codigoAutor;
    }  
    /**
     * pregunta si pertenece autor a lista
     * @param codigoAutor
     * @param listaDondeBuscarlo
     * @return 
     */
    private boolean perteneAutorALista(int codigoAutor, List<Autor> listaDondeBuscarlo) {
        for(Autor i: listaDondeBuscarlo) {
            if(i.getAutCodigo() == codigoAutor)
                return true;
        }
        return false; //returna falso
    }
    /**
     * lista de autores disponibles
     * @return 
     */
    public List<Autor> listaAutoresDisponibles() {
        AutorBean autorBean = new AutorBean();
        PublicacionBean publicacionBean = new PublicacionBean();
        if(codigoPublicacion == null)
            codigoPublicacion = ((Publicacion)publicacionBean.listarPublicaciones().get(0)).getPubCodigo();
                
        List<Autor> listaAutoresDeLaPublicacion = new ArrayList<Autor>();
        List<Autor> listaFinal = new ArrayList<Autor>();        
        listaAutoresDeLaPublicacion = this.listarAutoresDePublicacion(this.codigoPublicacion);
        for(Autor i: autorBean.listarAutores()) {
            if(!this.perteneAutorALista(i.getAutCodigo(), listaAutoresDeLaPublicacion))
                listaFinal.add(i);
        }  
        return listaFinal;
    }
    /**
     * lista de autores de publicacion
     * @param codigoPublicacionBuscado
     * @return 
     */
    public List<Autor> listarAutoresDePublicacion(String codigoPublicacionBuscado) {        
        List<PublicacionAutor> listaCodigosAutores = publicacionAutorBean.listarPublicacionAutor(codigoPublicacionBuscado);        
        List<Autor> listaAutores = new ArrayList<Autor>();
        AutorBean autorBean = new AutorBean();
        for(PublicacionAutor i: listaCodigosAutores) {
            listaAutores.add(autorBean.buscarPorCodigo(i.getPaAutor()));           
        }        
        return listaAutores;
    }
    /**
     * procedimiento llamado vincularLibro
     */
    public void vincularLibro(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Publicacion Vinculada Exitosamente",
                            ""));        
        PublicacionAutor objetoCargado = new PublicacionAutor();
        objetoCargado.setPaAutor(codigoAutor);
        objetoCargado.setPaEstado(true);
        objetoCargado.setPaUblicacion(codigoPublicacion);
        
        publicacionAutorBean.agregarPublicacionAutor(objetoCargado);
    }
}
