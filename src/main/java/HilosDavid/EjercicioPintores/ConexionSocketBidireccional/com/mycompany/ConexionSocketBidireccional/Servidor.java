package HilosDavid.EjercicioPintores.ConexionSocketBidireccional.com.mycompany.ConexionSocketBidireccional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @author Alumno: Victor de la Fuente
 */
public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Servidor esperando conexiones...");
        int contador=1;
        
        while (true) {

            Socket clienteSocket = serverSocket.accept();
            System.out.println("Cliente conectado");

            new Thread(() -> manejarCliente(clienteSocket),"Usuario: '"+contador+"'").start();
            contador++;
        }
    }

    private static void manejarCliente(Socket clienteSocket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
            String mensaje;


            while ((mensaje = in.readLine()) != null) {
                System.out.println("Mensaje recibido de " +Thread.currentThread().getName()+ ": "+ mensaje);

                String mensajeConRotulo = "[Mensaje del servidor a todos los clientes]: " + mensaje;
                out.println(mensajeConRotulo);
                retransmitirMensaje(clienteSocket, mensaje);
            }
            clienteSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void retransmitirMensaje(Socket clienteSocket, String mensaje) {
        try {
            PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
            out.println(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






