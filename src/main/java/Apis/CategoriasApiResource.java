/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apis;

import Dao.CategoriaDao;
import Entidad.Categoria;
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
@Path("CategoriasApi")
public class CategoriasApiResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CategoriasApiResource
     */
    public CategoriasApiResource() {
    }

    /**
     * Retrieves representation of an instance of Apis.CategoriasApiResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
           //TODO return proper representation object
        JSONArray json = new JSONArray();
        JSONObject objeto;
        CategoriaDao ad = new CategoriaDao();
        List<Categoria> registros = ad.listarCategoria();
        
        Categoria categ;
        for(Categoria categoria:registros){
            categ = new Categoria();
            objeto = new JSONObject();
            objeto.put("id_categoria", categoria.getIdCategoria());
            objeto.put("nombre_categoria", categoria.getCategoria());
            objeto.put("estado_categoria", categoria.getEstado());
            json.add(objeto);
        }

        return json.toJSONString();
    }

    /**
     * PUT method for updating or creating an instance of CategoriasApiResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
