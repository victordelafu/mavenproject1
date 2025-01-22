/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexiónDeRedes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.*;

/**
 *
 * @author Alumno
 */
public class URLPostExample {

    public static void main(String[] args) throws IOException {
        try {
            URI uri = new URI("https://httpbin.org/post");
            URL url = uri.toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form");
            String params = URLEncoder.encode("nombre", "UTF-8") + "=" + URLEncoder.encode("Juan", "UTF-8")
                    + //El encode envia los archivos a html para que la pagina pueda recibirlos bien
                    " and " + URLEncoder.encode("edad", "UTF-8") + "=" + URLEncoder.encode("27", "UTF-8");
            try {
                OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
                writer.write(params);
                writer.flush();
                
                int responseCode= connection.getResponseCode();
                if(responseCode == HttpURLConnection.HTTP_OK){
                    System.out.println("Solicitud exitosa");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while((line = reader.readLine())!= null){
                        System.out.println(line);
                    }
                }

            } catch (Exception ex) {
                System.out.println("ERROR AL ESTABLECER LA CONEXION " + ex.getMessage());
                ex.printStackTrace();
            }
        } catch (URISyntaxException | MalformedURLException e) {
            System.out.println("ERROR AL ESTABLECER LA CONEXION " + e.getMessage());
            e.printStackTrace();
        }
    }
}
