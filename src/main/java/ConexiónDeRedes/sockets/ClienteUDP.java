/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexiónDeRedes.sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Alumno
 */
public class ClienteUDP {
    public static void main(String[] args) {
        try{
            DatagramSocket socket = new DatagramSocket();
            String mensaje = "Hola desde el cliente";
            
            InetAddress dicAddress = InetAddress.getByName("localhost");
            
            DatagramPacket packet = new DatagramPacket(mensaje.getBytes(),mensaje.length(),dicAddress,1234);
            
            socket.send(packet);
            socket.close();
        }catch(IOException e){
            System.out.println("ERROR AL ESTABLECER LA CONEXION " + e.getMessage());
            e.printStackTrace();
        }
        
    }
}
