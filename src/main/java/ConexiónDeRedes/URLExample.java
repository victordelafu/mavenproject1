/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexiónDeRedes;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author Alumno
 */
public class URLExample {
    /**
     * PUERTOS;
     * HTTPS: 443
     * SSH:   
     * FTP: 
     * HTTP:
     */
    public static void main(String[] args) {
        try{
            URI uri = new URI("https://www.google.com:443/search?=java"); //FTP SSH HTTP  //EL "?" separa la ruta de la consulta, a la derecha es la consulta
            
            URL url = uri.toURL();
            
            //COMPONENTES DEL URL:
            System.out.println("PROTOCOLO: "+url.getProtocol()); //HTTPS
            System.out.println("HOST: "+url.getHost());//www.google.com
            System.out.println("PUERTO: "+url.getPort());//443+
            System.out.println("RUTA: "+url.getPath()); // /search
            System.out.println("CONSULTA: "+ url.getQuery()); // q=java
            
        }catch(MalformedURLException | URISyntaxException e){
            System.out.println("Error al realizar la conexion "+e.getMessage());
            e.printStackTrace();
        }
        
    }
}
