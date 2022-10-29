/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apis;

import Dao.PrestamoDao;
import Entidad.Cliente;
import Entidad.Libro;
import Entidad.ListadoPrestamo;
import Entidad.Prestamo;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * REST Web Service
 *
 * @author FERNANDO
 */
@Path("PrestamosApi")
public class PrestamosApiResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PrestamosApiResource
     */
    public PrestamosApiResource() {
    }

    /**
     * Retrieves representation of an instance of Apis.PrestamosApiResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {   
        JSONArray json = new JSONArray();
        JSONObject objeto;
        PrestamoDao ad = new PrestamoDao();
        List<Object[]> registros = ad.listarPrestamo();
        ListadoPrestamo listado;

        for (Object[] datos : registros) {
                Prestamo prst = (Prestamo) datos[0];
                Cliente cli = (Cliente) datos[1];
                Libro lib = (Libro) datos[2];
                String tit = lib.getTitulo();
                objeto = new JSONObject();

                listado = new ListadoPrestamo();
                listado.setApellidoCliente(cli.getApellido());
                listado.setDpiCliente(cli.getDpi());
                listado.setEstadoPrestamo(prst.getEstado());
                listado.setFechaDevolucion(prst.getFechaDevolucion());
                listado.setFechaPrestado(prst.getFechaPrestado());
                listado.setIdCliente(cli.getIdCliente());
                listado.setIdLibro(lib.getIdLibro());
                listado.setIdPrestamo(prst.getIdPrestamo());
                listado.setIsbnLibro(lib.getIsbn());
                listado.setNombreCliente(cli.getNombre());
                listado.setTelefonoCliente(cli.getTelefono());
                listado.setTituloLibro(tit);
                //pasar a data al jsonobjet
                objeto.put("apellido_cliente", listado.getApellidoCliente());
                objeto.put("dpi_cliente", listado.getDpiCliente());
                objeto.put("estado_prestamo", listado.getEstadoPrestamo());
                objeto.put("fecha_devolucion", listado.getFechaDevolucion());
                objeto.put("fecha_prestado", listado.getFechaPrestado());
                objeto.put("id_cliente", listado.getIdCliente());
                objeto.put("id_libro", listado.getIdLibro());
                objeto.put("id_prestamo", listado.getIdPrestamo());
                objeto.put("isbn_libro", listado.getIsbnLibro());
                objeto.put("nombre_cliente", listado.getNombreCliente());
                objeto.put("telefono_cliente", listado.getTelefonoCliente());
                objeto.put("titulo_libro", listado.getTituloLibro());
                json.add(objeto);
                
            }
            return json.toJSONString();
    }

    /**
     * PUT method for updating or creating an instance of PrestamosApiResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
