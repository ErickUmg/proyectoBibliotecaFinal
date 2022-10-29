/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import Dao.AutorDao;
import Dao.CategoriaDao;
import Entidad.Autor;
import Entidad.Categoria;
import WS.ConsumidorApi;
import WS.PeticionWS;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.JSONObject;
import org.json.JSONArray;


/**
 *
 * @author FERNANDO
 */
@ManagedBean
@ViewScoped
public class AutorControl {

    /**
     * Creates a new instance of AutorControl
     */
    private List<Autor> listaAutor;
    private Autor autor;
    public List<SelectItem> selectAutor;

    ConsumidorApi consumidor = new ConsumidorApi();
    public AutorControl() {
        autor = new Autor();
    }

    
    

    public List<SelectItem> getSelectAutor() {
        this.selectAutor = new ArrayList<SelectItem>();
        AutorDao cated = new AutorDao();
        List<Autor> ls = cated.listarAutorActivos();
        selectAutor.clear();
        for (Autor opcion : ls) {
            SelectItem Item = new SelectItem(opcion.getIdAutor(),
                    opcion.getNombreAutor());
            this.selectAutor.add(Item);

        }
        return selectAutor;
    }
    
    public List<Autor> getListaAutor() {
        AutorDao ad = new AutorDao();
        //consumo desde hibernate
        //listaAutor = ad.listarAutor();
        //consumir desde api
        String url ="http://localhost:8080/proyectoBiblioteca/webresources/AutorApi/";
        listaAutor = consumidor.listarAutor(url);
        return listaAutor;
        //comenrario
    }

    public void setListaAutor(List<Autor> listaAutor) {
        this.listaAutor = listaAutor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void limpiarAutor() {
        autor = new Autor();
    }

    public void agregarAutor() {
        AutorDao ad = new AutorDao();
        ad.agregar(autor);
    }

    public void modificarAutor() {
        AutorDao ad = new AutorDao();
        ad.modificar(autor);
        limpiarAutor();
    }

    public void eliminarAutor() {
        AutorDao ad = new AutorDao();
        ad.eliminar(autor);
        limpiarAutor();
    }
}
