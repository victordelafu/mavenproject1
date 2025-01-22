/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexiónDeRedes.sockets;

import java.io.IOException;
import java.net.*;

/**
 *
 * @author Alumno
 */
public class ServidorUDP {
    public static void main(String[] args) {
        try{
            DatagramSocket socket = new DatagramSocket(1234);
            byte[] buffer = new byte[1234];
            
            System.out.println("Servidor UDP esperando mensajes...");
            
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
            
            socket.receive(packet);
            
            String mensaje = new String(packet.getData(),0, packet.getLength());
            
            System.out.println("Mensaje recibido: "+mensaje);
            
            socket.close();
        }catch(IOException e){
            System.out.println("ERROR AL ESTABLECER LA CONEXION " + e.getMessage());
            e.printStackTrace();
        }
    }
}
