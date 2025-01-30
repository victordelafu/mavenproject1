/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexiónDeRedes.ConexionesSSLTCP;

/**
 *
 * @author Alumno
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class ServidorSSLTCP {
    public static void main(String[] args) {
        try {
            System.setProperty("javax.net.ssl.keyStore","servidor.jks");
            System.setProperty("javax.net.ssl.keyStorePassword","21121998a");
            
            SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(1222);

            System.out.println("Servidor SSL esperando conexiones...");

            
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                new Thread(() -> manejarCliente(clientSocket)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();  
        }
    }

    private static void manejarCliente(SSLSocket clientSocket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String mensaje;
            while ((mensaje = in.readLine()) != null) {
                System.out.println("Cliente: " + mensaje);
                out.println(mensaje.toUpperCase()); 
            }
        } catch (Exception e) {
            e.printStackTrace();  
        } finally {
            try {
                clientSocket.close();  
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
