/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apis;

import Dao.TipoDao;
import Entidad.Tipo;
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
@Path("TipoApi")
public class TipoApiResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TipoApiResource
     */
    public TipoApiResource() {
    }

    /**
     * Retrieves representation of an instance of Apis.TipoApiResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
               //TODO return proper representation object
        JSONArray json = new JSONArray();
        JSONObject objeto;
        TipoDao ad = new TipoDao();
        List<Tipo> registros = ad.listarTipo();
        
        Tipo tipo;
        for(Tipo tip:registros){
            tipo = new Tipo();
            objeto = new JSONObject();
            objeto.put("id_tipo", tip.getIdTipo());
            objeto.put("nombre_tipo", tip.getTipo());
            objeto.put("estado_tipo", tip.getEstado());
            json.add(objeto);
        }

        return json.toJSONString();
    }

    /**
     * PUT method for updating or creating an instance of TipoApiResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
