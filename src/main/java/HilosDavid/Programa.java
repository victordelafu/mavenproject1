/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid;

/**
 *
 * @author Alumno
 */
public class Programa {
    public static void main(String[] args){
        EjemploRunnable_2 tarea = new EjemploRunnable_2();
        Thread hilo = new Thread(tarea);
        hilo.start();
        System.out.println("Fin del hilo principal");
    }
}
