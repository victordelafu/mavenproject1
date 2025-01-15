/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid.MetodosHilos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Alumno
 */
public class SemaphoreEjemplo {
    private static Semaphore semaphore = new Semaphore(1);
    
    public static void main(String[] args) {
        Runnable tarea = ()->{
            try{
                System.out.println(Thread.currentThread().getName()+" Esperando el acceso...");
                semaphore.acquire();
                
                System.out.println(Thread.currentThread().getName()+" Obtuvo el acceso.");
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                System.out.println(".:Hilo interrumpido:.");
                ex.printStackTrace();
            }finally{
                semaphore.release();
                System.out.println(Thread.currentThread().getName()+" Liberó el acceso.");
            }
        };
        Thread[] hilos = new Thread[5];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i]= new Thread(tarea,"Hilo-"+i);
            hilos[i].start();
            try{
                hilos[i].join();
            }catch(InterruptedException e){
                System.out.println("Hilo interrumpido");
                e.printStackTrace();
            }
        }
    }
}
