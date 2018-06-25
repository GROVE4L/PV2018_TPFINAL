package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.DetalleReserva;
import java.util.List;

/**
 *
 * @author Rojas, Guido G.
 */
public interface IDetalleReservaDAO{

    public void add(DetalleReserva dr);
    public void delete(DetalleReserva dr);
    public void update(DetalleReserva dr);    
    public List<DetalleReserva> devolverDetalleReservas();
}
