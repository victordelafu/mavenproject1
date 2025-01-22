/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexiónDeRedes.sockets;

import java.net.Socket;

/**
 *
 * @author Alumno
 */
public class socketEjemplo {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost",80);
            System.out.println("Conexión establecida");
            socket.close();
        }catch(Exception e){
            System.out.println("ERROR AL ESTABLECER LA CONEXION " + e.getMessage());
            e.printStackTrace();
        }
    }
}
