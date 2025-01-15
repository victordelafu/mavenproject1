/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid.MetodosHilos;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Alumno
 */
public class ReentraLockEjemplo {

    private static ReentrantLock lock = new ReentrantLock();
    private static int contador = 6;

    public static void main(String[] args) {
        Runnable tarea = () -> {
            for (int i = 0; i < 5; i++) {
                lock.lock();//Bloquea los resultados hasta que no entre el hilo no va a sumarlo
                try {
                    contador++;
                    System.out.println(Thread.currentThread().getName() + " ha incrementado el contador a " + contador);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();

                    }
                
                } finally{
                    lock.unlock();
                }
            }
           
        };
        Thread hilo1 = new Thread(tarea,"Hilo-1");
        
        
        Thread hilo2 = new Thread(tarea,"Hilo-2");
        
        hilo1.start();
        
        hilo2.start();
        
            
    }

}

