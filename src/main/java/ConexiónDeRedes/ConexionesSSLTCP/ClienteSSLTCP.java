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

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class ClienteSSLTCP {
    public static void main(String[] args) {
        try {
            System.setProperty("javax.net.ssl.trustStore","servidor.jks");
            System.setProperty("javax.net.ssl.trustStorePassword","21121998a");
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket("localhost", 1222);

            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader stdln = new BufferedReader(new InputStreamReader(System.in));
                
                
                String userInput;
                while ((userInput = stdln.readLine()) != null) {
                    out.println(userInput);
                    System.out.println("Servidor: " + in.readLine());                    
                }
    
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                socket.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
