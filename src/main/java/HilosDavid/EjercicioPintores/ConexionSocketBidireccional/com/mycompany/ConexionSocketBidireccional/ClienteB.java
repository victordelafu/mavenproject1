
package HilosDavid.EjercicioPintores.ConexionSocketBidireccional.com.mycompany.ConexionSocketBidireccional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Alumno: Victor de la Fuente
 */
public class ClienteB {
    public static void main (String[] args) throws IOException{
        Socket socket = new Socket("localhost",1234);
        
        
        
            try{
                BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                System.out.println("Conectado al servidor. Escribe un mensaje");
                BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
                String userInput;
                while((userInput = entrada.readLine()) != null){
                    System.out.println("");
                    out.println(userInput);
                    System.out.println(in.readLine());

                }
                
                socket.close();

            }catch(IOException e){
                e.printStackTrace();
            }   
    }  
}