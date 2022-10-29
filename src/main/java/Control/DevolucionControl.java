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
import Dao.DevolucionesDao;
import Entidad.Cliente;
import Entidad.Devoluciones;
import Entidad.Libro;
import Entidad.ListadoDevolucion;
import WS.ConsumidorApi;
import java.util.ArrayList;


/**
 *
 * @author FERNANDO
 */
@ManagedBean
@ViewScoped
public class DevolucionControl {

    /**
     * Creates a new instance of DevolucionesControl
     */
    private List<ListadoDevolucion> listaDevoluciones;
    private Devoluciones devolucion;
    public ListadoDevolucion devolucionNueva;
    ConsumidorApi consumidor = new ConsumidorApi();

    public DevolucionControl() {
        devolucion = new Devoluciones();
        devolucionNueva = new ListadoDevolucion();
    }
/**
    public List<ListadoDevolucion> getListaDevoluciones() {
   
        DevolucionesDao ad = new DevolucionesDao();
         List<Object[]> registros = ad.listarDevoluciones();
        ListadoDevolucion listado;
        listaDevoluciones = new ArrayList<ListadoDevolucion>();
        for (Object[] datos : registros) {
            
                Devoluciones dev = (Devoluciones) datos[0];
                Cliente cli = (Cliente) datos[1];
                Libro lib = (Libro) datos[2];
                String tit = lib.getTitulo();

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
              
                listaDevoluciones.add(listado);   
            }
        return listaDevoluciones;
    }
   **/ 
    public List<ListadoDevolucion> getListaDevoluciones(){
        //listaDevoluciones = new ArrayList<ListadoDevolucion>();
        String url ="http://localhost:8080/proyectoBiblioteca/webresources/DevolucionesApi/";
        listaDevoluciones = consumidor.listarDevoluciones(url);
        return listaDevoluciones;
    }

    public void setListaDevoluciones(List<ListadoDevolucion> listaDevoluciones) {
        this.listaDevoluciones = listaDevoluciones;
    }

    public Devoluciones getDevoluciones() {
        return devolucion;
    }

    public void setDevoluciones(Devoluciones devolucion) {
        this.devolucion = devolucion;
    }

    public void limpiarDevoluciones() {
        devolucion = new Devoluciones();
    }

    public void agregarDevoluciones() {
        DevolucionesDao ad = new DevolucionesDao();
        Libro libro = new Libro();
        Cliente cliente = new Cliente();
        libro.setIdLibro(devolucionNueva.getIdLibro());
        cliente.setIdCliente(devolucionNueva.getIdCliente());
        devolucion.setCliente(cliente);
        devolucion.setLibro(libro);
        System.out.println("cliente -> "+cliente.getIdCliente());
        System.out.println("libro -> "+libro.getIdLibro());
        ad.agregar(devolucion);
    }

    public void modificarDevoluciones() {
        DevolucionesDao ad = new DevolucionesDao();
        ad.modificar(devolucion);
        limpiarDevoluciones();
    }

    public void eliminarDevoluciones() {
        DevolucionesDao ad = new DevolucionesDao();
        ad.eliminar(devolucion);
        limpiarDevoluciones();
    }

    public ListadoDevolucion getDevolucionNueva() {
        return devolucionNueva;
    }

    public void setDevolucionNueva(ListadoDevolucion devolucionNueva) {
        this.devolucionNueva = devolucionNueva;
    }

    public Devoluciones getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Devoluciones devolucion) {
        this.devolucion = devolucion;
    }
}
