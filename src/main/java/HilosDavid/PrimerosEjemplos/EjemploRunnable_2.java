/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid.PrimerosEjemplos;

/**
 *
 * @author Alumno
 */
public class EjemploRunnable_2 extends otraClase implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Soy un hilo");
        }
        imprimirMensaje();
    }
}
