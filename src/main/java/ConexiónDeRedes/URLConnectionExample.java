/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexiónDeRedes;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 *
 * @author Alumno
 */
public class URLConnectionExample {
    public static void main(String[] args) throws IOException{
        try{
            URI uri = new URI("https://es.wikipedia.org/wiki/Wikipedia:Portada");
            
            URL url = uri.toURL();
            
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while((line = reader.readLine())!= null) {
                System.out.println(line);
            }
            reader.close();
            
        }catch(URISyntaxException | MalformedURLException e){
            System.out.println("ERROR AL ESTABLECER LA CONEXION "+e.getMessage());
            e.printStackTrace();
        }
            }
}
