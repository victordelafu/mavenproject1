/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexiónDeRedes.TareaConexioneseHilos;

import java.io.*;
import java.net.*;

/**
 *
 * @author Alumno
 */
public class Servidor {

    static boolean turno = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Servidor esperando conexiones...");
            new Thread(() -> {
                try {
                    Socket clienteSocket = serverSocket.accept();
                    System.out.println("Cliente conectado");

                    
                    BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
                    String mensaje;
                    int contador = 0;

                    
                    while (contador < 5) {
                        synchronized (lock) {

                            if (turno) {
                                System.out.println(Thread.currentThread().getName() + " Está escribiendo un mensaje...");
                                mensaje = in.readLine();
                                System.out.println(Thread.currentThread().getName() + " ha escrito: " + mensaje);
                                out.println(Thread.currentThread().getName() + " " + mensaje.toUpperCase());
                                contador++;
                                turno = false;
                                lock.notify();
                            } else {
                                lock.wait();
                            }
                        }
                    }

                } catch (IOException | InterruptedException ex) {
                    System.out.println("Error al manejar la conexión con el cliente: " + ex.getMessage());
                    ex.printStackTrace();
                }

            }, "Pauloncio").start();
            new Thread(() -> {
                try {
                    Socket clienteSocket = serverSocket.accept();
                    System.out.println("Cliente conectado");

                    
                    BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
                    String mensaje;
                    int contador = 0;

                    
                    while (contador < 5) {
                        synchronized (lock) {

                            if (!turno) {
                                System.out.println(Thread.currentThread().getName() + " Está escribiendo un mensaje...");
                                mensaje = in.readLine();
                                System.out.println(Thread.currentThread().getName() + " ha escrito: " + mensaje);
                                out.println(Thread.currentThread().getName() + " " + mensaje.toUpperCase());
                                contador++;
                                turno = true;

                                lock.notify();
                            } else {
                                lock.wait();

                            }
                        }
                    }
                } catch (IOException ex) {
                    System.out.println("Error al manejar la conexión con el cliente: " + ex.getMessage());
                    ex.printStackTrace();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }, "Vitín").start();
        } catch (IOException e) {
            System.out.println("ERROR AL ESTABLECER LA CONEXION: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
