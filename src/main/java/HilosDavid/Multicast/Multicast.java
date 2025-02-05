/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid.Multicast;

import java.io.IOException;
import java.net.*;
/**
 *
 * @author Alumno
 */
public class Multicast {
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        String multicastAddress = "239.25.255.250";
        int port= 1234;
        
        InetAddress group = InetAddress.getByName(multicastAddress);
        MulticastSocket socket = new MulticastSocket(port);
        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
        
        socket.joinGroup(new InetSocketAddress(group,port), networkInterface);
        
        new Thread(()->{
            try{
                byte[] buffer = new byte[1024];
           while(true){
               DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
               socket.receive(packet);
               String mensaje= new String(packet.getData(),0,packet.getLength());
               System.out.println("MENSAJE RECIBIDO: "+mensaje);
           }
            }catch(Exception e){
                e.printStackTrace();
            }
           
        }).start();
        DatagramSocket sendSocket= new DatagramSocket();
        int count = 1;
        while(true){
            String mensaje = "Mensaje "+ count + " Del nodo multicast";
            byte[] buffer = mensaje.getBytes();
            
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length,group,port);
            sendSocket.send(packet);
            count++;
            Thread.sleep(5000);
        }
        
    }
}
