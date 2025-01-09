/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid;

/**
 *
 * @author Alumno
 */
public class HiloSimple {
     static class Tarea extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                System.out.println("Soy un Hilo");
            }
        }
    }
    public static void main(String[] args){
        Tarea tarea = new Tarea();
        Thread hilo = new Thread(tarea);
        hilo.start();
        System.out.println("Fin del hilo principal");
    }
}
