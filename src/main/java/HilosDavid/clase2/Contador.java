/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid.clase2;

/**
 *Metodo sincronize
 */
public class Contador {
    private int valor = 0;
    public synchronized void incrementar(String hiloNombre){
        valor++;
        System.out.println(hiloNombre + " incrementa el contador a: " +valor);
        try{
            Thread.sleep(500);
            
        }catch(InterruptedException e){
            System.out.println("Hilo interrumpido:\n");
            e.printStackTrace();
        }
    }
    
}
