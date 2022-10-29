/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.entity.*;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author FERNANDO
 */
public class PeticionWS {
    
    public String consumirWs(String url){
        String resultado="";
        JSONArray arreglo;// = new JSONArray();
        JSONObject objeto = null;
        String datos ="";
        int k = 0;
        try{
            RequestConfig.Builder requestBuilder = RequestConfig.custom();
            requestBuilder = requestBuilder.setConnectTimeout(10000);
            requestBuilder = requestBuilder.setConnectionRequestTimeout(5000);
            
            HttpClientBuilder builder = HttpClientBuilder.create();
            builder.setDefaultRequestConfig(requestBuilder.build());
            
            HttpClient cliente = builder.build();
            
            HttpGet requestHttp = new HttpGet(url);
            requestHttp.setHeader("content-type","application/json");
            HttpResponse respuesta = cliente.execute(requestHttp);
            k = respuesta.getStatusLine().getStatusCode();
            resultado = EntityUtils.toString(respuesta.getEntity(),"UTF-8");
            if(!resultado.isEmpty()){
                System.out.println("resultado de la peticion");
                System.out.println(resultado);
                datos = resultado;
            }else{
                datos="";
                System.out.println("NO HAY RESPUESTA DEL SERVIDOR -> "+k);
            }
            
        }catch(Exception e){
            System.out.println("Error al realizar petición -> "+e);
        }
        return datos;
    }    
    
    public String invocarWs(String url,String data){
        String resultado="";
        JSONArray arreglo = new JSONArray();
        JSONObject objeto;
        String datos ="";
        int k = 0;
        try{
            RequestConfig.Builder requestBuilder = RequestConfig.custom();
            requestBuilder = requestBuilder.setConnectTimeout(10000);
            requestBuilder = requestBuilder.setConnectionRequestTimeout(5000);
            
            HttpClientBuilder builder = HttpClientBuilder.create();
            builder.setDefaultRequestConfig(requestBuilder.build());
            
            HttpClient cliente = builder.build();
            
            //HttpGet requestHttp = new HttpGet(url);
            HttpPut requestHttp = new HttpPut(); 
            requestHttp.setHeader("content-type","application/json");
            HttpResponse respuesta = cliente.execute(requestHttp);
            k = respuesta.getStatusLine().getStatusCode();
            resultado = EntityUtils.toString(respuesta.getEntity(),"UTF-8");
            if(!resultado.isEmpty()){
                System.out.println("resultado de la peticion");
                System.out.println(resultado);
                datos = resultado;
               
            }else{
                datos="";
                System.out.println("NO HAY RESPUESTA DEL SERVIDOR -> "+k);
            }
            
        }catch(Exception e){
            System.out.println("Error al realizar petición -> "+e);
        }
        return datos;
    }    
    
    public String post(String URL, String function, String values) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(URL);

        //parameter for the web service
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("P_FUNCTION", function));
        parameters.add(new BasicNameValuePair("P_PARAMETERS", values));

        try {

            //send parameter to URL from main
            httpPost.setEntity(new UrlEncodedFormEntity(parameters));
           
            HttpResponse httpRespose = httpClient.execute(httpPost);

            //get response from URL Web Service
            HttpEntity httpEntity = httpRespose.getEntity();
            String response = EntityUtils.toString(httpEntity);
            return response;
        } catch (Exception exception) {
            return "ERROR: " + URL + " NO DISPONIBLE" + exception.toString();
        }
    }

    
   
}
