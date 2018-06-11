package aplicacion.controlador.converters;

import java.util.StringTokenizer;

/**
 *
 * @author Rojas, Guido G.
 */
public class Texto {
    public String primeraLetraMayus(String cadena) {
        if (cadena == null)
            return null;        
        StringBuilder builder = new StringBuilder();
        StringTokenizer st = new StringTokenizer(cadena," ");
        while (st.hasMoreElements()) {
            String ne = (String)st.nextElement();
            if (ne.length()>0) {
                builder.append(ne.substring(0, 1).toUpperCase());
                builder.append(ne.substring(1).toLowerCase()); //agregado
                builder.append(' ');
            }
        }
        //Fix Borrar ultimo Espacio        
        String textoFormateado = builder.toString();
        textoFormateado = textoFormateado.substring(0, textoFormateado.length()-1);//borrar el ultimo espacio               
        return textoFormateado;
    }
}
