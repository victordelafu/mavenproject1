/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexiónDeRedes.TareaConexioneseHilos;

/**
 *
 * @author Alumno
 */
import java.io.*;
import java.net.*;

public class Cliente1 {

    public static void main(String[] args) {
       
        

        try (Socket socket = new Socket("localhost", 1234);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {

            
            new Thread(() -> {
                String mensaje;
                try {
                    while ((mensaje = entrada.readLine()) != null) {
                        System.out.println("Mensaje del servidor: " + mensaje);
                    }
                } catch (IOException e) {
                    System.out.println("Error al recibir mensaje: " + e.getMessage());
                }
            }).start();

            
            String mensajeUsuario;
            while ((mensajeUsuario = teclado.readLine()) != null) {
                salida.println(mensajeUsuario);
            }

        } catch (IOException e) {
            System.out.println("Error al conectarse al servidor: " + e.getMessage());
        }
    }
}

