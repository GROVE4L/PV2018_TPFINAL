package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.EditorialBean;
import aplicacion.controlador.beans.PublicacionAutorBean;
import aplicacion.controlador.beans.PublicacionBean;
import aplicacion.controlador.converters.HeaderFooterPageEvent;
import aplicacion.controlador.converters.Texto;
import aplicacion.modelo.dominio.Autor;
import aplicacion.modelo.dominio.Clasificacion;
import aplicacion.modelo.dominio.Publicacion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rojas, Guido G.
 */
@ManagedBean
@ViewScoped
/**
 * clase AgregarPublicacionFormBean
 */
public class AgregarPublicacionFormBean implements Serializable{

    @ManagedProperty(value = "#{publicacionBean}")
    private PublicacionBean publicacionBean;
    
    private Publicacion publicacion;
    private List<Publicacion> listaFiltrada;
    
    public AgregarPublicacionFormBean() {
        this.publicacion = new Publicacion();
        this.publicacion.setPubTipo("Libro");
        List<Publicacion> listaFiltrada = new ArrayList<Publicacion>();
    }

    public List<Publicacion> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(List<Publicacion> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }
    
    
    
    /**
     * constructor de PublicacionBean con su get
     * @return 
     */
    public PublicacionBean getPublicacionBean() {
        return publicacionBean;
    }
    /**
     * constructor de PublicacionBean con su set
     * @param publicacionBean 
     */
    public void setPublicacionBean(PublicacionBean publicacionBean) {
        this.publicacionBean = publicacionBean;
    }
    /**
     * constructor de Publicacion con su get
     * @return 
     */
    public Publicacion getPublicacion() {
        return publicacion;
    }
    /**
     * constructor de Publicacion con su set
     * @param publicacion 
     */
    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
    /**
     * devuelve publicacion
     * @param codPub
     * @return 
     */
    public Publicacion devolverPublicacion(String codPub){
        Publicacion aux = new Publicacion();
        aux.setPubCodigo(codPub);
        return publicacionBean.buscarPublicacion(aux);
    }
    /**
     * busqueda de publicacion
     * @return 
     */   
    public Publicacion buscarPublicacion() {        
        return publicacionBean.buscarPublicacion(this.publicacion);
    }
    /**
     * listado de publicaciones
     * @return 
     */
    public List<Publicacion> listadoPublicaciones() {        
        return publicacionBean.listarPublicaciones();
    }
    /**
     * listado de publicaciones con stock
     * @return 
     */
    public List<Publicacion> listadoPublicacionesConStock() {
        return publicacionBean.listarPublicacionesConStock();
    }
    /**
     * agregado de publicacion
     */
    public void agregarPublicacion() {
        if(this.buscarPublicacion() == null) { //No existe la publicacion
            Texto t = new Texto();
            this.publicacion.setPubNombre(t.primeraLetraMayus(this.publicacion.getPubNombre())); //Primer letra del Nombre en Mayusculas
            this.publicacion.setPubTipo(t.primeraLetraMayus(this.publicacion.getPubTipo())); //Primer letra del Apellido en Mayusculas
            this.publicacion.setPubEstado(true);
            publicacionBean.agregarPublicacion(this.publicacion);
            
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Publicación Agregada Exitosamente",
                            ""));
            this.publicacion = new Publicacion();
        }
        else { //La publicacion ya existe..
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Este codigo de publicación ya existe!",
                            ""));
        }
    }
    public void verPdf(){
        if(this.listadoPublicaciones() == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Esta tabla esta Vacía.",
                ""));
        }
        else {
            List<Publicacion> listadoAImprimir = new ArrayList<Publicacion>();
            if(listaFiltrada != null)
                listadoAImprimir = listaFiltrada;
            else
                listadoAImprimir = this.listadoPublicacionesConStock();            
            Document document = new Document(PageSize.A4.rotate(), 1, 1, 50, 50); //Tamaño A4            
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                PdfWriter writer = PdfWriter.getInstance(document, baos);
                writer.setInitialLeading(20);                  
                document.open();

                HeaderFooterPageEvent event = new HeaderFooterPageEvent();
                writer.setPageEvent(event);          
                PdfPTable table = new PdfPTable(6); //3 columnas
                table.setWidths(new float[] { 20,20,60,20,30,10}); //Ancho columnas                   

                PdfPCell cell = new PdfPCell(new Paragraph("Lista de Publicaciones", new Font(Font.FontFamily.COURIER, 16, Font.NORMAL)));
                cell.setColspan(6);
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER); 
                cell.setFixedHeight(50);
                table.addCell(cell);                       

                cell = new PdfPCell();
                cell.setPhrase(new Phrase("Publicación", new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
                cell.setBackgroundColor(new BaseColor(0, 255, 255));
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setFixedHeight(18);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell();
                cell.setPhrase(new Phrase("Editorial", new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
                cell.setBackgroundColor(new BaseColor(0, 255, 255));
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setFixedHeight(18);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell();
                cell.setPhrase(new Phrase("Resumen", new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
                cell.setBackgroundColor(new BaseColor(0, 255, 255));
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setFixedHeight(18);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell();
                cell.setPhrase(new Phrase("Tipo", new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
                cell.setBackgroundColor(new BaseColor(0, 255, 255));
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setFixedHeight(18);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell();
                cell.setPhrase(new Phrase("Autores", new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
                cell.setBackgroundColor(new BaseColor(0, 255, 255));
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setFixedHeight(18);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell();
                cell.setPhrase(new Phrase("Cant.", new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
                cell.setBackgroundColor(new BaseColor(0, 255, 255));
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setFixedHeight(18);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                boolean color=true;
                BaseColor fondoCelda;
                
                EditorialBean eBean = new EditorialBean();
                PublicacionAutorFormBean pb = new PublicacionAutorFormBean();
                List<Autor> listaAutores = new ArrayList<Autor>();
                String AutoresLista="";
                int tamanoLetra=10;
                for(Publicacion i: listadoAImprimir) {
                    if(!color) {
                        fondoCelda = new BaseColor(170, 229, 255);
                        
                        cell = new PdfPCell();
                        cell.setBorder(PdfPCell.NO_BORDER);
                        cell.setFixedHeight(18);
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPhrase(new Phrase(String.valueOf(i.getPubNombre()), new Font(Font.FontFamily.COURIER, tamanoLetra, Font.NORMAL)));
                        cell.setBackgroundColor(fondoCelda);
                        table.addCell(cell);
                        
                        cell = new PdfPCell();
                        cell.setBorder(PdfPCell.NO_BORDER);
                        cell.setFixedHeight(18);
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPhrase(new Phrase(eBean.devolverNombreEditorial(i.getPubEditorial()), new Font(Font.FontFamily.COURIER, tamanoLetra, Font.NORMAL)));
                        cell.setBackgroundColor(fondoCelda);
                        table.addCell(cell);
                        
                        cell = new PdfPCell();
                        cell.setBorder(PdfPCell.NO_BORDER);
                        cell.setFixedHeight(18);
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPhrase(new Phrase(String.valueOf(i.getPubResumen()), new Font(Font.FontFamily.COURIER, tamanoLetra, Font.NORMAL)));
                        cell.setBackgroundColor(fondoCelda);
                        table.addCell(cell);

                        cell = new PdfPCell();
                        cell.setBorder(PdfPCell.NO_BORDER);
                        cell.setFixedHeight(18);
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPhrase(new Phrase(i.getPubTipo(), new Font(Font.FontFamily.COURIER, tamanoLetra, Font.NORMAL)));
                        cell.setBackgroundColor(fondoCelda);
                        table.addCell(cell);
                        
                        AutoresLista="";
                        listaAutores = pb.listarAutoresDePublicacion(i.getPubCodigo());
                        if(listaAutores.isEmpty())                             
                            AutoresLista="N/A";
                        else {
                            for(Autor j: listaAutores) {
                                AutoresLista = AutoresLista +" "+j.getAutNombres() + " "+j.getAutApellidos()+"\n";
                            }
                        }
                        
                        cell = new PdfPCell();
                        cell.setBorder(PdfPCell.NO_BORDER);
                        cell.setFixedHeight(40);
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPhrase(new Phrase(AutoresLista, new Font(Font.FontFamily.COURIER, tamanoLetra, Font.NORMAL)));
                        cell.setBackgroundColor(fondoCelda);
                        table.addCell(cell);
                        
                        cell = new PdfPCell();
                        cell.setBorder(PdfPCell.NO_BORDER);
                        cell.setFixedHeight(18);
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPhrase(new Phrase(String.valueOf(i.getPubStock()), new Font(Font.FontFamily.COURIER, tamanoLetra, Font.NORMAL)));
                        cell.setBackgroundColor(fondoCelda);
                        table.addCell(cell);
                        
                        color=true;
                    }
                    else {
                        fondoCelda = new BaseColor(153, 204, 255);
                        
                        cell = new PdfPCell();
                        cell.setBorder(PdfPCell.NO_BORDER);
                        cell.setFixedHeight(18);
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPhrase(new Phrase(String.valueOf(i.getPubNombre()), new Font(Font.FontFamily.COURIER, tamanoLetra, Font.NORMAL)));
                        cell.setBackgroundColor(fondoCelda);
                        table.addCell(cell);
                        
                        cell = new PdfPCell();
                        cell.setBorder(PdfPCell.NO_BORDER);
                        cell.setFixedHeight(18);
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPhrase(new Phrase(eBean.devolverNombreEditorial(i.getPubEditorial()), new Font(Font.FontFamily.COURIER, tamanoLetra, Font.NORMAL)));
                        cell.setBackgroundColor(fondoCelda);
                        table.addCell(cell);
                        
                        cell = new PdfPCell();
                        cell.setBorder(PdfPCell.NO_BORDER);
                        cell.setFixedHeight(18);
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPhrase(new Phrase(String.valueOf(i.getPubResumen()), new Font(Font.FontFamily.COURIER, tamanoLetra, Font.NORMAL)));
                        cell.setBackgroundColor(fondoCelda);
                        table.addCell(cell);

                        cell = new PdfPCell();
                        cell.setBorder(PdfPCell.NO_BORDER);
                        cell.setFixedHeight(18);
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPhrase(new Phrase(i.getPubTipo(), new Font(Font.FontFamily.COURIER, tamanoLetra, Font.NORMAL)));
                        cell.setBackgroundColor(fondoCelda);
                        table.addCell(cell);
                        
                        listaAutores = pb.listarAutoresDePublicacion(i.getPubCodigo());
                        AutoresLista="";
                        if(listaAutores.isEmpty())
                            AutoresLista="N/A";
                        else {
                            for(Autor j: listaAutores) {
                                AutoresLista = AutoresLista +" "+j.getAutNombres() + " "+j.getAutApellidos()+"\n";
                            }
                        }
                        
                        cell = new PdfPCell();
                        cell.setBorder(PdfPCell.NO_BORDER);
                        cell.setFixedHeight(40);
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPhrase(new Phrase(AutoresLista, new Font(Font.FontFamily.COURIER, tamanoLetra, Font.NORMAL)));
                        cell.setBackgroundColor(fondoCelda);
                        table.addCell(cell);
                        
                        cell = new PdfPCell();
                        cell.setBorder(PdfPCell.NO_BORDER);
                        cell.setFixedHeight(18);
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPhrase(new Phrase(String.valueOf(i.getPubStock()), new Font(Font.FontFamily.COURIER, tamanoLetra, Font.NORMAL)));
                        cell.setBackgroundColor(fondoCelda);
                        table.addCell(cell);
                        
                        color =false;
                    }
                }
                document.add(table); 

            } 
            catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
            document.close();

            FacesContext context = FacesContext.getCurrentInstance();
            Object response = context.getExternalContext().getResponse();
            if (response instanceof HttpServletResponse) {
                HttpServletResponse hsr = (HttpServletResponse) response;
                hsr.setContentType("application/pdf");
                String pdfFileName = "ListadoDePublicaciones.pdf";
                hsr.setHeader("Content-disposition", "attachment; filename=" + pdfFileName);
                hsr.setContentLength(baos.size());
                try {
                    ServletOutputStream out = hsr.getOutputStream();
                    baos.writeTo(out);
                    out.flush();
                } 
                catch (IOException ex) {
                    System.out.println("Error:  " + ex.getMessage());
               }
               context.responseComplete();
            }
        }                    
    }
}
