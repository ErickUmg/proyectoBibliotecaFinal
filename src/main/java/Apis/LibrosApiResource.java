/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apis;

import Dao.LibroDao;
import Entidad.Autor;
import Entidad.Categoria;
import Entidad.Libro;
import Entidad.ListadoLibro;
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
@Path("LibrosApi")
public class LibrosApiResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LibrosApiResource
     */
    public LibrosApiResource() {
    }

    /**
     * Retrieves representation of an instance of Apis.LibrosApiResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {

        JSONArray json = new JSONArray();
        JSONObject objeto;
        LibroDao ad = new LibroDao();
        List<Object[]> registros = ad.listarLibro();
        ListadoLibro listado;

        for (Object[] datos : registros) {
            Libro l = (Libro) datos[0];
            Categoria c = (Categoria) datos[1];
            Autor aut = (Autor) datos[2];
            Tipo tip = (Tipo) datos[3];
            String tit = l.getTitulo();
            objeto = new JSONObject();

            listado = new ListadoLibro();
            listado.setAutor(aut.getNombreAutor());
            listado.setIdAutor(aut.getIdAutor());
            listado.setCategoria(c.getCategoria());
            listado.setIdCategoria(c.getIdCategoria());
            listado.setIdTipo(tip.getIdTipo());

            listado.setEstado(l.getEstado());
            listado.setIdLibro(l.getIdLibro());
            listado.setIsbn(l.getIsbn());
            listado.setTipo(tip.getTipo());
            listado.setTitulo(tit);
            //pasar a data al jsonobjet
            objeto.put("id_autor", listado.getIdAutor());
            objeto.put("autor", listado.getAutor());
            objeto.put("id_categoria", listado.getIdCategoria());
            objeto.put("categoria", listado.getCategoria());
            objeto.put("id_tipo", listado.getIdTipo());
            objeto.put("tipo", listado.getTipo());
            objeto.put("estado", listado.getEstado());
            objeto.put("id_libro", listado.getIdLibro());
            objeto.put("isbn", listado.getIsbn());
            objeto.put("titulo", listado.getTitulo());
            json.add(objeto);

        }
        return json.toJSONString();
    }

    /**
     * PUT method for updating or creating an instance of LibrosApiResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
