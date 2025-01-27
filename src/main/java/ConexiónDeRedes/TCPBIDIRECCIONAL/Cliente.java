/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexiónDeRedes.TCPBIDIRECCIONAL;
import java.io.*;
import java.net.*;
/**
 *
 * @author Alumno
 */
public class Cliente {
    public static void main(String[] args) throws IOException{
         Socket socket = new Socket("localhost",1234);
        
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
          BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
          
          String userInput;
          while((userInput = teclado.readLine())!=null){
              out.println(userInput);
              System.out.println("Servidor: "+in.readLine());
          }
          socket.close();
    }
}
