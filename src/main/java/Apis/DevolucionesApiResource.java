/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apis;

import Dao.DevolucionesDao;
import Entidad.Cliente;
import Entidad.Devoluciones;
import Entidad.Libro;
import Entidad.ListadoDevolucion;
import java.util.List;
import javax.json.Json;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
@Path("DevolucionesApi")
public class DevolucionesApiResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DevolucionesApiResource
     */
    public DevolucionesApiResource() {
    }

    /**
     * Retrieves representation of an instance of Apis.DevolucionesApiResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        JSONArray json = new JSONArray();
        JSONObject objeto;
        DevolucionesDao ad = new DevolucionesDao();
        List<Object[]> registros = ad.listarDevoluciones();
        ListadoDevolucion listado;

        for (Object[] datos : registros) {
                Devoluciones dev = (Devoluciones) datos[0];
                Cliente cli = (Cliente) datos[1];
                Libro lib = (Libro) datos[2];
                String tit = lib.getTitulo();

                objeto = new JSONObject();

               listado = new ListadoDevolucion();
               listado.setApellidoCliente(cli.getApellido());
               listado.setDevComentario(dev.getComentario());
               listado.setDpiCliente(cli.getDpi());
               listado.setIdCliente(cli.getIdCliente());
               listado.setIdDevolucion(dev.getIdDevolucion());
               listado.setIdLibro(lib.getIdLibro());
               listado.setIsbnLibro(lib.getIsbn());
               listado.setNombreCliente(cli.getNombre());
               listado.setTelefonoCliente(cli.getTelefono());
               listado.setTituloLibro(lib.getTitulo());
                //pasar a data al jsonobjet
                objeto.put("apellido_cliente", listado.getApellidoCliente());
                objeto.put("dpi_cliente", listado.getDpiCliente());
                objeto.put("id_cliente", listado.getIdCliente());
                objeto.put("id_libro", listado.getIdLibro());
                objeto.put("id_devolucion", listado.getIdDevolucion());
                objeto.put("comentario_dev", listado.getDevComentario());
                objeto.put("isbn_libro", listado.getIsbnLibro());
                objeto.put("nombre_cliente", listado.getNombreCliente());
                objeto.put("telefono_cliente", listado.getTelefonoCliente());
                objeto.put("titulo_libro", listado.getTituloLibro());
                json.add(objeto);
                
            }
            return json.toJSONString();
    }

    /**
     * PUT method for updating or creating an instance of DevolucionesApiResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        System.out.println("resultado de la peticion del lado del api -> "+content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(String content){
        System.out.println("meotod post api incvocado");
    }
}
