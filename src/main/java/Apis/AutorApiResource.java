/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apis;

import Dao.AutorDao;
import Entidad.Autor;
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
@Path("AutorApi")
public class AutorApiResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AutorApiResource
     */
    public AutorApiResource() {
    }

    /**
     * Retrieves representation of an instance of Apis.AutorApiResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        JSONArray json = new JSONArray();
        JSONObject objeto;
        AutorDao ad = new AutorDao();
        List<Autor> registros = ad.listarAutor();
        
        Autor autor;
        for(Autor persona:registros){
            autor = new Autor();
            objeto = new JSONObject();
            objeto.put("id_autor", persona.getIdAutor());
            objeto.put("nombre_autor", persona.getNombreAutor());
            objeto.put("estado_autor", persona.getEstado());
            json.add(objeto);
        }

        return json.toJSONString();
    }

    /**
     * PUT method for updating or creating an instance of AutorApiResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
