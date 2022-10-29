/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apis;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author FERNANDO
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Apis.AutorApiResource.class);
        resources.add(Apis.CategoriasApiResource.class);
        resources.add(Apis.ClientesApiResource.class);
        resources.add(Apis.DevolucionesApiResource.class);
        resources.add(Apis.LibrosApiResource.class);
        resources.add(Apis.PrestamosApiResource.class);
        resources.add(Apis.TipoApiResource.class);
    }
    
}
