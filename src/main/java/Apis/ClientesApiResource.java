/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apis;

import Dao.ClienteDao;
import Entidad.Cliente;
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
@Path("ClientesApi")
public class ClientesApiResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClientesApiResource
     */
    public ClientesApiResource() {
    }

    /**
     * Retrieves representation of an instance of Apis.ClientesApiResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
           //TODO return proper representation object
        JSONArray json = new JSONArray();
        JSONObject objeto;
        ClienteDao ad = new ClienteDao();
        List<Cliente> registros = ad.listarCliente();
        
        Cliente categ;
        for(Cliente cliente:registros){
            categ = new Cliente();
            objeto = new JSONObject();
            objeto.put("id_cliente", cliente.getIdCliente());
            objeto.put("nombre_cliente", cliente.getNombre());
            objeto.put("apellido_cliente", cliente.getApellido());
            objeto.put("dpi_cliente", cliente.getDpi());
            objeto.put("telefono_cliente", cliente.getTelefono());
            objeto.put("estado_cliente", cliente.getEstado());
            json.add(objeto);
        }

        return json.toJSONString();
    }

    /**
     * PUT method for updating or creating an instance of ClientesApiResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
