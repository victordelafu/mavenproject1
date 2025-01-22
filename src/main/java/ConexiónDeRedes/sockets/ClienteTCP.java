/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexiónDeRedes.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Alumno
 */
public class ClienteTCP {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost",1234);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            System.out.println("Mensaje del servidor: "+ in.readLine());
            out.println("Hola Servidor");
            socket.close();
            
        }catch(IOException e){
            System.out.println("ERROR AL ESTABLECER LA CONEXION " + e.getMessage());
            e.printStackTrace();
        }
        
    }
}
