package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Reserva;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rojas, Guido G.
 */
public interface IReservaDAO{

    public void add(Reserva re);
    public void update(Reserva re);
    public void delete(Reserva re);
    public List<Reserva> devolverReservas();
    public Reserva obtenerUltimaReserva();
    public Date obtenerFechaReserva(int Codigobuscar);
    public int obtenerCodigoPerfil(int Codigobuscar);
}
