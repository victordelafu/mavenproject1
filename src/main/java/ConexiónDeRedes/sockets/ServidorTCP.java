/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexiónDeRedes.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Alumno
 */
public class ServidorTCP {
    public static void main(String[] args) {
        try{
            ServerSocket serversocket = new ServerSocket(1234);
            System.out.println("Servidor TCP esperando conexiones...");
            Socket clienteSocket = serversocket.accept();
            System.out.println("Cliente conectado");
            
            PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            
            out.println("Bienvenido al servidor TCP");
            System.out.println("Mensaje recibido del cliente: "+ in.readLine());
            
            clienteSocket.close(); //LOS SOCKETS SIEMPRE HAY QUE CERRARLO
            serversocket.close();
        }catch(IOException e){
            System.out.println("ERROR AL ESTABLECER LA CONEXION " + e.getMessage());
            e.printStackTrace();
        }
       
    }
}
