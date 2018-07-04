package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.AutorBean;
import aplicacion.controlador.converters.Texto;
import aplicacion.modelo.dominio.Autor;
import aplicacion.controlador.converters.HeaderFooterPageEvent;
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
 * clase AgregarAutorFormBean
 */
public class AgregarAutorFormBean implements Serializable{

    @ManagedProperty(value = "#{autorBean}")
    private AutorBean autorBean;
    
    private List<Autor> listaFiltrada;
    private Autor autor;
    private Autor autorSeleccionado;
    /**
     * 
     */
    public AgregarAutorFormBean() {
        this.autor = new Autor();
        this.autorSeleccionado = new Autor();
        List<Autor> listaFiltrada = new ArrayList<Autor>();
        
    }

    public List<Autor> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(List<Autor> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }
    
    /**
     * constructor de AutorSeleccionado con su get
     * @return 
     */
    public Autor getAutorSeleccionado() {
        return autorSeleccionado;
    }
    /**
     * constructor de AutorSeleccionado con su set
     * @param autorSeleccionado 
     */
    public void setAutorSeleccionado(Autor autorSeleccionado) {
        this.autorSeleccionado = autorSeleccionado;
    }
    
    /**
     * constructor de AutorBean con su get
     * @return 
     */
    
    public AutorBean getAutorBean() {
        return autorBean;
    }
    /**
     * constructor de AutorBean con su set
     * @param autorBean 
     */
    public void setAutorBean(AutorBean autorBean) {
        this.autorBean = autorBean;
    }
    /**
     * constructor de Autor con su get
     * @return 
     */
    public Autor getAutor() {
        return autor;
    }
    /**
     * constructor de Autor con su set
     * @param autor 
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }  
    /**
     * busqueda de Autor
     * @return 
     */
    public Autor buscarAutor() {        
        return autorBean.buscarAutor(this.autor);
    }
    /**
     * listado de autores
     * @return 
     */
    public List<Autor> listadoAutores() {        
        return autorBean.listarAutores();
    }
    /**
     * modificacion de autor
     */
    public void modificarAutor() {
        autorBean.modificarAutor(autorSeleccionado);
    }
    /**
     * borrado de autor
     * @param a 
     */
    public void borrarAutor(Autor a) {
        autorBean.borrarAutor(a);
    }
     /**
      * agregado de autor
      */      
    public void agregarAutor() {
        if(this.buscarAutor() == null) { //No existe el autor             
            Texto t = new Texto();
            this.autor.setAutNombres(t.primeraLetraMayus(this.autor.getAutNombres())); //Primer letra del Nombre en Mayusculas
            this.autor.setAutApellidos(t.primeraLetraMayus(this.autor.getAutApellidos())); //Primer letra del Apellido en Mayusculas
            autorBean.agregarAutor(autor);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Autor Agregada Exitosamente",
                            ""));
            this.autor=new Autor();
        }
        else { //La editorial ya existe..
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Este Autor ya existe!",
                            ""));
        }
    }
    
        public void verPdf(){
            if(this.listadoAutores() == null) {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Esta tabla esta Vacía.",
                            ""));
            }
            else {
                if(listaFiltrada != null) {
                
            Document document = new Document(PageSize.LETTER);
             ByteArrayOutputStream baos = new ByteArrayOutputStream();
             try {
                  PdfWriter writer = PdfWriter.getInstance(document, baos);
                  writer.setInitialLeading(20);                  
                  document.open();
                 
                HeaderFooterPageEvent event = new HeaderFooterPageEvent();
                writer.setPageEvent(event);          
                                
                PdfPTable table = new PdfPTable(1); //3 columnas
                table.setWidths(new float[] { 6}); //Ancho columnas                   
          
                PdfPCell cell = new PdfPCell(new Paragraph("Lista de Autores", new Font(Font.FontFamily.COURIER, 16, Font.NORMAL)));
                cell.setColspan(1);
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER); 
                cell.setFixedHeight(50);
                table.addCell(cell);                       
                  
                cell = new PdfPCell();
                cell.setPhrase(new Phrase("Nombre y Apellido", new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
                cell.setBackgroundColor(new BaseColor(0, 255, 255));
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setFixedHeight(18);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                boolean color=true;
                BaseColor fondoCelda;
                
                for(Autor i: this.listaFiltrada) {
                      if(!color) {
                            fondoCelda = new BaseColor(170, 229, 255);
                            cell = new PdfPCell();
                            cell.setBorder(PdfPCell.NO_BORDER);
                            cell.setFixedHeight(18);
                            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                            cell.setPhrase(new Phrase(i.getAutNombres()+" "+i.getAutApellidos(), new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
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
                            cell.setPhrase(new Phrase(i.getAutNombres()+" "+i.getAutApellidos(), new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
                            cell.setBackgroundColor(fondoCelda);
                            table.addCell(cell);
                            color =false;
                      }
                }
                document.add(table); 
                  
            } catch (Exception ex) {
                  System.out.println("Error " + ex.getMessage());
            }
            document.close();
            
            FacesContext context = FacesContext.getCurrentInstance();
            Object response = context.getExternalContext().getResponse();
            if (response instanceof HttpServletResponse) {
                  HttpServletResponse hsr = (HttpServletResponse) response;
                  hsr.setContentType("application/pdf");
                  String pdfFileName = "ListadoDeAutores.pdf";
                  hsr.setHeader("Content-disposition", "attachment; filename=" + pdfFileName);
                  hsr.setContentLength(baos.size());
                  try {
                        ServletOutputStream out = hsr.getOutputStream();
                        baos.writeTo(out);
                        out.flush();
                  } catch (IOException ex) {
                        System.out.println("Error:  " + ex.getMessage());
                  }
                  context.responseComplete();
            }
            }
            else {
                Document document = new Document(PageSize.LETTER);
             ByteArrayOutputStream baos = new ByteArrayOutputStream();
             try {
                  PdfWriter writer = PdfWriter.getInstance(document, baos);
                  writer.setInitialLeading(20);                  
                  document.open();
                 
                HeaderFooterPageEvent event = new HeaderFooterPageEvent();
                writer.setPageEvent(event);          
                                
                PdfPTable table = new PdfPTable(1); //3 columnas
                table.setWidths(new float[] { 6}); //Ancho columnas                   
          
                PdfPCell cell = new PdfPCell(new Paragraph("Lista de Autores", new Font(Font.FontFamily.COURIER, 16, Font.NORMAL)));
                cell.setColspan(1);
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER); 
                cell.setFixedHeight(50);
                table.addCell(cell);                       
                  
                cell = new PdfPCell();
                cell.setPhrase(new Phrase("Nombre y Apellido", new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
                cell.setBackgroundColor(new BaseColor(0, 255, 255));
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setFixedHeight(18);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                boolean color=true;
                BaseColor fondoCelda;
                
                for(Autor i: this.listadoAutores()) {
                      if(!color) {
                            fondoCelda = new BaseColor(170, 229, 255);
                            cell = new PdfPCell();
                            cell.setBorder(PdfPCell.NO_BORDER);
                            cell.setFixedHeight(18);
                            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                            cell.setPhrase(new Phrase(i.getAutNombres()+" "+i.getAutApellidos(), new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
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
                            cell.setPhrase(new Phrase(i.getAutNombres()+" "+i.getAutApellidos(), new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
                            cell.setBackgroundColor(fondoCelda);
                            table.addCell(cell);
                            color =false;
                      }
                }
                document.add(table); 
                  
            } catch (Exception ex) {
                  System.out.println("Error " + ex.getMessage());
            }
            document.close();
            
            FacesContext context = FacesContext.getCurrentInstance();
            Object response = context.getExternalContext().getResponse();
            if (response instanceof HttpServletResponse) {
                  HttpServletResponse hsr = (HttpServletResponse) response;
                  hsr.setContentType("application/pdf");   
                  String pdfFileName = "ListadoDeAutores.pdf";
                  hsr.setHeader("Content-disposition", "attachment; filename=" + pdfFileName);                  
                  hsr.setContentLength(baos.size());
                  try {
                        ServletOutputStream out = hsr.getOutputStream();
                        baos.writeTo(out);
                        out.flush();
                  } catch (IOException ex) {
                        System.out.println("Error:  " + ex.getMessage());
                  }
                  context.responseComplete();
            }
           }
            
            }
            
    }    
}
