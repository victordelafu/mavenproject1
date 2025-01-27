/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexiónDeRedes.TCPBIDIRECCIONAL;



/**
 *
 * @author Alumno
 */
import java.io.*;
import java.net.*;

public class Servidor {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Servidor esperando conexiones...");

            while (true) {
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Cliente conectado");

                // Crear un nuevo hilo para manejar la comunicación con el cliente
                new Thread(() -> {
                    try {
                        // Crear los flujos de entrada y salida
                        BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
                        String mensaje;

                        // Leer mensajes del cliente y responder
                        while ((mensaje = in.readLine()) != null) {
                            System.out.println("Cliente: " + mensaje);
                            out.println("Servidor: " + mensaje.toUpperCase());
                        }
                    } catch (IOException ex) {
                        System.out.println("Error al manejar la conexión con el cliente: " + ex.getMessage());
                        ex.printStackTrace();
                    } finally {
                        try {
                            // Cerrar la conexión con el cliente
                            clienteSocket.close();
                        } catch (IOException ex) {
                            System.out.println("Error al cerrar la conexión con el cliente: " + ex.getMessage());
                        }
                    }
                }).start();
            }

        } catch (IOException e) {
            System.out.println("ERROR AL ESTABLECER LA CONEXION: " + e.getMessage());
            e.printStackTrace();
        }
    }
}