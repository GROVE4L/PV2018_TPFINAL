package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.ClasificacionBean;
import aplicacion.controlador.converters.HeaderFooterPageEvent;
import aplicacion.controlador.converters.Texto;
import aplicacion.modelo.dominio.Autor;
import aplicacion.modelo.dominio.Clasificacion;
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
 * clase AgregarClasificacionFormBean
 */
public class AgregarClasificacionFormBean implements Serializable{

    @ManagedProperty(value = "#{clasificacionBean}")
    private ClasificacionBean clasificacionBean;
    
    private Clasificacion clasificacion;
    private Clasificacion clasificacionSeleccionada;
    private List<Clasificacion> listaFiltrada;
    
    public AgregarClasificacionFormBean() {
        this.clasificacion = new Clasificacion();
        this.clasificacionSeleccionada = new Clasificacion();
        List<Clasificacion> listaFiltrada = new ArrayList<Clasificacion>();
    }

    public List<Clasificacion> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(List<Clasificacion> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }
    
    
    /**
     * constructor de ClasificacionBean con su get
     * @return 
     */
    public ClasificacionBean getClasificacionBean() {
        return clasificacionBean;
    }
    /**
     * constructor de ClasificacionBean con su set
     * @param clasificacionBean 
     */
    public void setClasificacionBean(ClasificacionBean clasificacionBean) {
        this.clasificacionBean = clasificacionBean;
    }
    /**
     * constructor de Clasificacion con su get
     * @return 
     */
    public Clasificacion getClasificacion() {
        return clasificacion;
    }
    /**
     * constructor de Clasificaion con su set
     * @param clasificacion 
     */
    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }
    /**
     * constructor de ClasificacionSeleccionada con su get
     * @return 
     */
    public Clasificacion getClasificacionSeleccionada() {
        return clasificacionSeleccionada;
    }
    /**
     * constructor de ClasificacionSeleccionada con su get
     * @param clasificacionSeleccionada 
     */
    public void setClasificacionSeleccionada(Clasificacion clasificacionSeleccionada) {
        this.clasificacionSeleccionada = clasificacionSeleccionada;
    }
    /**
     * busqueda de Clasificacion
     * @return 
     */
    public Clasificacion buscarClasificacion() {        
        return clasificacionBean.buscarClasificacion(this.clasificacion);
    }
    /**
     * listado de Clasificaciones
     * @return 
     */
    public List<Clasificacion> listadoClasificaciones() {        
        return clasificacionBean.listarClasificaciones();
    }
    /**
     * procedimiento modificarClasificacion 
     * modificacion de clasificacion
     */
    public void modificarClasificacion() {
        clasificacionBean.modificarClasificacion(clasificacionSeleccionada);
    }
    /**
     * procedimiento llamado borrarClasificacion
     * borrado clasificacion
     * @param c 
     */
    public void borrarClasificacion(Clasificacion c) {
        clasificacionBean.borrarClasificacion(c);
    } 
    /**
     * procedimiento llamado agregarClasificacio
     * agregado de clasificacion
     */
    public void agregarClasificacion() {
        if(this.buscarClasificacion() == null) { //No existe la clasificacion
            Texto t = new Texto();
            this.clasificacion.setClaDescripcion(t.primeraLetraMayus(this.clasificacion.getClaDescripcion()));
            
            clasificacionBean.agregarClasificacion(this.clasificacion);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Clasificacion Agregada Exitosamente",
                            ""));
            this.clasificacion = new Clasificacion();
        }
        else { //La clasificacion ya existe..
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Esta Clasificacion ya existe!",
                            ""));
        }
    }
    public void verPdf(){
        if(this.listadoClasificaciones() == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Esta tabla esta Vacía.",
                ""));
        }
        else {
            List<Clasificacion> listadoAImprimir = new ArrayList<Clasificacion>();
            if(listaFiltrada != null)
                listadoAImprimir = listaFiltrada;
            else
                listadoAImprimir = this.listadoClasificaciones();            
            Document document = new Document(PageSize.LETTER);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                PdfWriter writer = PdfWriter.getInstance(document, baos);
                writer.setInitialLeading(20);                  
                document.open();

                HeaderFooterPageEvent event = new HeaderFooterPageEvent();
                writer.setPageEvent(event);          
                PdfPTable table = new PdfPTable(2); //3 columnas
                table.setWidths(new float[] { 25, 50}); //Ancho columnas                   

                PdfPCell cell = new PdfPCell(new Paragraph("Lista de Clasificaciones", new Font(Font.FontFamily.COURIER, 16, Font.NORMAL)));
                cell.setColspan(2);
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER); 
                cell.setFixedHeight(50);
                table.addCell(cell);                       

                cell = new PdfPCell();
                cell.setPhrase(new Phrase("Identificador", new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
                cell.setBackgroundColor(new BaseColor(0, 255, 255));
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setFixedHeight(18);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell();
                cell.setPhrase(new Phrase("Descripción", new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
                cell.setBackgroundColor(new BaseColor(0, 255, 255));
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setFixedHeight(18);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                boolean color=true;
                BaseColor fondoCelda;

                for(Clasificacion i: listadoAImprimir) {
                    if(!color) {
                        fondoCelda = new BaseColor(170, 229, 255);
                        cell = new PdfPCell();
                        cell.setBorder(PdfPCell.NO_BORDER);
                        cell.setFixedHeight(18);
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPhrase(new Phrase(String.valueOf(i.getClaIdentificador()), new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
                        cell.setBackgroundColor(fondoCelda);
                        table.addCell(cell);
                        
                        cell = new PdfPCell();
                        cell.setBorder(PdfPCell.NO_BORDER);
                        cell.setFixedHeight(18);
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPhrase(new Phrase(i.getClaDescripcion(), new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
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
                        cell.setPhrase(new Phrase(String.valueOf(i.getClaIdentificador()), new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
                        cell.setBackgroundColor(fondoCelda);
                        table.addCell(cell);

                        cell = new PdfPCell();
                        cell.setBorder(PdfPCell.NO_BORDER);
                        cell.setFixedHeight(18);
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPhrase(new Phrase(i.getClaDescripcion(), new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
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
                String pdfFileName = "ListadoDeClasificaciones.pdf";
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
