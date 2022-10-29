/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Entidad.Autor;
import Entidad.Categoria;
import Entidad.Cliente;
import Entidad.ListadoDevolucion;
import Entidad.ListadoLibro;
import Entidad.ListadoPrestamo;
import Entidad.Tipo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author FERNANDO
 */
public class ConsumidorApi {
 
    public List<Autor> listarAutor(String url){
        List<Autor> lista = new ArrayList<Autor>();
        Autor autor;
        PeticionWS ws = new PeticionWS();
        //invocar apiconsumer
        String data = ws.consumirWs(url);

        try {
            JSONParser parser = new JSONParser();

            JSONArray arreglo = new JSONArray(data);
            JSONObject json;
            for(int i=0; i<arreglo.length(); i++){
                json = arreglo.getJSONObject(i);
                System.out.println("autor -> "+json.getString("nombre_autor"));
                System.out.println("autor -> "+json.getInt("id_autor"));
                autor = new Autor();
                autor.setEstado(json.getInt("estado_autor"));
                autor.setIdAutor(json.getInt("id_autor"));
                autor.setNombreAutor(json.getString("nombre_autor"));
                lista.add(autor);
            }
        } catch (Exception e) {
            System.out.println("error casting json -> " + e);
        }
        
        return lista;
    }
    
    public List<Categoria> listarCategoria(String url){
        List<Categoria> lista = new ArrayList<Categoria>();
        Categoria categ;
        PeticionWS ws = new PeticionWS();
        //invocar apiconsumer
        String data = ws.consumirWs(url);

        try {
            JSONParser parser = new JSONParser();

            JSONArray arreglo = new JSONArray(data);
            JSONObject json;
            for(int i=0; i<arreglo.length(); i++){
                json = arreglo.getJSONObject(i);
                
                categ = new Categoria();
                categ.setEstado(json.getInt("estado_categoria"));
                categ.setIdCategoria(json.getInt("id_categoria"));
                categ.setCategoria(json.getString("nombre_categoria"));
                lista.add(categ);
            }
        } catch (Exception e) {
            System.out.println("error casting json -> " + e);
        }
        
        return lista;
    }
    
    public List<Tipo> listarTipo(String url){
        List<Tipo> lista = new ArrayList<Tipo>();
        Tipo tipo;
        PeticionWS ws = new PeticionWS();
        //invocar apiconsumer
        String data = ws.consumirWs(url);

        try {
            JSONParser parser = new JSONParser();

            JSONArray arreglo = new JSONArray(data);
            JSONObject json;
            for(int i=0; i<arreglo.length(); i++){
                json = arreglo.getJSONObject(i);
                
                tipo = new Tipo();
                tipo.setEstado(json.getInt("estado_tipo"));
                tipo.setIdTipo(json.getInt("id_tipo"));
                tipo.setTipo(json.getString("nombre_tipo"));
                lista.add(tipo);
            }
        } catch (Exception e) {
            System.out.println("error casting json -> " + e);
        }
        
        return lista;
    }
    
    public List<Cliente> listarCliente(String url){
        List<Cliente> lista = new ArrayList<Cliente>();
        Cliente cliente;
        PeticionWS ws = new PeticionWS();
        //invocar apiconsumer
        String data = ws.consumirWs(url);

        try {
            JSONParser parser = new JSONParser();
            JSONArray arreglo = new JSONArray(data);
            JSONObject json;
            for(int i=0; i<arreglo.length(); i++){
                json = arreglo.getJSONObject(i);
                
                cliente = new Cliente();
                cliente.setApellido(json.getString("apellido_cliente"));
                cliente.setDpi(json.getString("dpi_cliente"));
                cliente.setEstado(json.getInt("estado_cliente"));
                cliente.setIdCliente(json.getInt("id_cliente"));
                cliente.setNombre(json.getString("nombre_cliente"));
                cliente.setTelefono(json.getInt("telefono_cliente"));
                
                lista.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("error casting json -> " + e);
        }
        
        return lista;
    }
    
    public List<ListadoDevolucion> listarDevoluciones(String url){
        List<ListadoDevolucion> lista = new ArrayList<ListadoDevolucion>();
        ListadoDevolucion devolucion;
        PeticionWS ws = new PeticionWS();
        //invocar apiconsumer
        String data = ws.consumirWs(url);

        try {
            JSONParser parser = new JSONParser();
            JSONArray arreglo = new JSONArray(data);
            JSONObject json;
            
            for(int i=0; i<arreglo.length(); i++){
                json = arreglo.getJSONObject(i);
                
                devolucion = new ListadoDevolucion();
                devolucion.setApellidoCliente(json.getString("apellido_cliente"));
                devolucion.setDevComentario(json.getString("comentario_dev"));
                devolucion.setDpiCliente(json.getString("dpi_cliente"));
       //         devolucion.setEstadoDev(json.getInt("estado_devolucion"));
                devolucion.setIdCliente(json.getInt("id_cliente"));
                devolucion.setIdDevolucion(json.getInt("id_devolucion"));
                devolucion.setIdLibro(json.getInt("id_libro"));
                devolucion.setIsbnLibro(json.getString("isbn_libro"));
                devolucion.setNombreCliente(json.getString("nombre_cliente"));
                devolucion.setTelefonoCliente(json.getInt("telefono_cliente"));
                devolucion.setTituloLibro(json.getString("titulo_libro"));
                
                lista.add(devolucion);
            }
        } catch (Exception e) {
            System.out.println("error casting json -> " + e);
        }
        
        return lista;
    }
    
    public List<ListadoLibro> listarLibros(String url){
        List<ListadoLibro> lista = new ArrayList<ListadoLibro>();
        ListadoLibro libros;
        PeticionWS ws = new PeticionWS();
        //invocar apiconsumer
        String data = ws.consumirWs(url);

        try {
            JSONParser parser = new JSONParser();
            JSONArray arreglo = new JSONArray(data);
            JSONObject json;
            
            for(int i=0; i<arreglo.length(); i++){
                json = arreglo.getJSONObject(i);
                
                libros = new ListadoLibro();
                libros.setAutor(json.getString("autor"));
                libros.setCategoria(json.getString("categoria"));
                libros.setEstado(json.getInt("estado"));
                libros.setIdAutor(json.getInt("id_autor"));
                libros.setIdCategoria(json.getInt("id_categoria"));
                libros.setIdLibro(json.getInt("id_libro"));
                libros.setIdTipo(json.getInt("id_tipo"));
                libros.setIsbn(json.getString("isbn"));
                libros.setTipo(json.getString("tipo"));
                libros.setTitulo(json.getString("titulo"));
                lista.add(libros);
            }
        } catch (Exception e) {
            System.out.println("error casting json -> " + e);
        }
        
        return lista;
    }
    
    public List<ListadoPrestamo> listarPrestamo(String url){
        List<ListadoPrestamo> lista = new ArrayList<ListadoPrestamo>();
        ListadoPrestamo prestamo;
        PeticionWS ws = new PeticionWS();
        //invocar apiconsumer
        String data = ws.consumirWs(url);

        try {
            JSONParser parser = new JSONParser();
            JSONArray arreglo = new JSONArray(data);
            JSONObject json;
            
            for(int i=0; i<arreglo.length(); i++){
                json = arreglo.getJSONObject(i);
                
                prestamo = new ListadoPrestamo();
                prestamo.setApellidoCliente(json.getString("apellido_cliente"));
                prestamo.setDpiCliente(json.getString("dpi_cliente"));
                prestamo.setEstadoPrestamo(json.getInt("estado_prestamo"));
                prestamo.setFechaDevolucion(json.getString("fecha_devolucion"));
                prestamo.setFechaPrestado(json.getString("fecha_prestado"));
                prestamo.setIdCliente(json.getInt("id_cliente"));
                prestamo.setIdLibro(json.getInt("id_libro"));
                prestamo.setIdPrestamo(json.getInt("id_prestamo"));
                prestamo.setIsbnLibro(json.getString("isbn_libro"));
                prestamo.setNombreCliente(json.getString("nombre_cliente"));
                prestamo.setTelefonoCliente(json.getInt("telefono_cliente"));
                prestamo.setTituloLibro(json.getString("titulo_libro"));
                
                lista.add(prestamo);
            }
        } catch (Exception e) {
            System.out.println("error casting json -> " + e);
        }
        
        return lista;
    }
    
    
}
