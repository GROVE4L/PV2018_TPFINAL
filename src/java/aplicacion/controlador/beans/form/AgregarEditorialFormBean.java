package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.EditorialBean;
import aplicacion.controlador.converters.HeaderFooterPageEvent;
import aplicacion.controlador.converters.Texto;
import aplicacion.modelo.dominio.Clasificacion;
import aplicacion.modelo.dominio.Editorial;
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
 * clase AgregarEditorialFormBean
 */
public class AgregarEditorialFormBean implements Serializable{

    @ManagedProperty(value = "#{editorialBean}")
    private EditorialBean editorialBean;
    
    private Editorial editorial;
    private Editorial editorialSeleccionada;
    private List<Editorial> listaFiltrada;
    /**
     * 
     */
    public AgregarEditorialFormBean() {
        this.editorial = new Editorial();
        this.editorialSeleccionada = new Editorial();
        List<Editorial> listaFiltrada = new ArrayList<Editorial>();
    }

    public List<Editorial> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(List<Editorial> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }
    
    
    /**
     * constructor de Editorial seleccionada con su get
     * @return 
     */
    public Editorial getEditorialSeleccionada() {
        return editorialSeleccionada;
    }
    /**
     * constructor de Editorial seleccionada con su set
     * @param editorialSeleccionada 
     */
    public void setEditorialSeleccionada(Editorial editorialSeleccionada) {
        this.editorialSeleccionada = editorialSeleccionada;
    }
    /**
     * constructor de EditorialBean con su get
     * @return 
     */
    public EditorialBean getEditorialBean() {
        return editorialBean;
    }
    /**
     * constructor de EditorialBean con su set
     * @param editorialBean 
     */
    public void setEditorialBean(EditorialBean editorialBean) {
        this.editorialBean = editorialBean;
    }
    /**
     * constructor de Editorial con su get
     * @return 
     */
    public Editorial getEditorial() {
        return editorial;
    }
    /**
     * constructor de Editorial con su set
     * @param editorial 
     */
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    /**
     * procedimiento llamado modificarEditorial
     * modificacin de Editorial
     */
    public void modificarEditorial() {
        editorialBean.modificarEditorial(editorialSeleccionada);
    }
    /**
     * procedimiento recuperarEditorial
     * recuperacion de Editorial
     * @param e 
     */
    public void recuperarEditorial(Editorial e) {
        e.setEditEstado(true);
        editorialBean.recuperarEditorial(e);
    }
    /**
     * procedimiento borrarEditorial
     * borrado de Editorial
     * @param e 
     */
    public void borrarEditorial(Editorial e) {
        e.setEditEstado(false);
        editorialBean.borrarEditorial(e);
    }
    /**
     * busqueda de Editorail
     * @return 
     */
    public Editorial buscarEditorial() {        
        return editorialBean.buscarEditorial(this.editorial);
    }
    /**
     * devuelve el nombre de Editorial
     * @param codigobuscado
     * @return 
     */
    public String devolverNombreEditorial(int codigobuscado) {
        return editorialBean.devolverNombreEditorial(codigobuscado);
    }
    /**
     * lista de Editoriales
     * @return 
     */
    public List<Editorial> listadoEditoriales() {        
        return editorialBean.listarEditoriales();
    }
    /**
     * listado Editoriales Activas
     * @return 
     */
    public List<Editorial> listadoEditorialesActivas() {        
        return editorialBean.listarEditorialesActivas();
    }
    /**
     * agregado de Editorial
     */   
    public void agregarEditorial() {      
        if(this.buscarEditorial() == null) { //No existe la editorial..            
            this.editorial.setEditEstado(true);
            Texto t = new Texto();
            this.editorial.setEditNombre(t.primeraLetraMayus(this.editorial.getEditNombre()));
            editorialBean.agregarEditorial(editorial);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Editorial Agregada Exitosamente",
                            ""));
            this.editorial= new Editorial();
        }
        else { //La editorial ya existe..
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Esta editoral ya existe!",
                            ""));
        }
    }
    public void verPdf(){
        if(this.listadoEditorialesActivas()== null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Esta tabla esta Vacía.",
                ""));
        }
        else {
            List<Editorial> listadoAImprimir = new ArrayList<Editorial>();
            if(listaFiltrada != null)
                listadoAImprimir = listaFiltrada;
            else
                listadoAImprimir = this.listadoEditorialesActivas();            
            Document document = new Document(PageSize.LETTER);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                PdfWriter writer = PdfWriter.getInstance(document, baos);
                writer.setInitialLeading(20);                  
                document.open();

                HeaderFooterPageEvent event = new HeaderFooterPageEvent();
                writer.setPageEvent(event);          
                PdfPTable table = new PdfPTable(1); //3 columnas
                table.setWidths(new float[] {50}); //Ancho columnas                   

                PdfPCell cell = new PdfPCell(new Paragraph("Lista de Editoriales", new Font(Font.FontFamily.COURIER, 16, Font.NORMAL)));
                cell.setColspan(1);
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER); 
                cell.setFixedHeight(50);
                table.addCell(cell);                       

                cell = new PdfPCell();
                cell.setPhrase(new Phrase("Nombre de Editorial", new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
                cell.setBackgroundColor(new BaseColor(0, 255, 255));
                cell.setBorder(PdfPCell.NO_BORDER);
                cell.setFixedHeight(18);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                boolean color=true;
                BaseColor fondoCelda;

                for(Editorial i: listadoAImprimir) {
                    if(!color) {
                        fondoCelda = new BaseColor(170, 229, 255);
                        cell = new PdfPCell();
                        cell.setBorder(PdfPCell.NO_BORDER);
                        cell.setFixedHeight(18);
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setPhrase(new Phrase(String.valueOf(i.getEditNombre()), new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
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
                        cell.setPhrase(new Phrase(String.valueOf(i.getEditNombre()), new Font(Font.FontFamily.COURIER, 12, Font.NORMAL)));
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
                String pdfFileName = "ListadoDeEditoriales.pdf";
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
