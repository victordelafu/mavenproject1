/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid.MetodosHilos;

import java.util.concurrent.*;

/**
 *
 * @author Alumno
 */
public class CountDownLatchEjemplo {
    public static void main(String[] args) {
        Thread[] hilos = new Thread[10];
        CountDownLatch latch = new CountDownLatch(10);
        Semaphore semaphore = new Semaphore(1);
        
        Runnable tarea = ()->{
          try{
              semaphore.acquire(); //DA AL HILO ACCESO (SEMAFORO EN VERDE) EN ESTE CASO SOLO A 1 HILO
              System.out.println(Thread.currentThread().getName()+" Ejecutando la tarea");
              Thread.sleep(1000);
              System.out.println(Thread.currentThread().getName()+" Completó la tarea");
              Thread.sleep(500);
          }catch(InterruptedException ex){
              System.out.println("El hilo se ha interrumpido "+ex.getMessage());
              ex.printStackTrace();
          }finally{
              semaphore.release();
              latch.countDown();//BAJA UNO AL CONTADOR
          }
        };
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(tarea,"Hilo-"+(i+1));
            hilos[i].start();
            try{
               Thread.sleep(500);
            }catch(InterruptedException ex){
              System.out.println("El hilo se ha interrumpido "+ex.getMessage());
              ex.printStackTrace();
            }   
        }
        try{
            latch.await();
            System.out.println("Todas las tareas completadas. Continuando...");
            System.out.println("Hilo principal ejecutando tarea adicionales...");
            Thread.sleep(1000);
            System.out.println("Hilo principal completó las tareas adicionales.");
        }catch(InterruptedException ex){
              System.out.println("El hilo se ha interrumpido "+ex.getMessage());
              ex.printStackTrace();
            }   
    }
}
