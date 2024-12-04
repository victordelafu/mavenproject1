/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaniProcesos.Hilost2;

/**
 *
 * @author Alumno
 */
public class Ejemplo3 extends Thread {
    @Override
    public void run(){
        System.out.println("Informacion del hilo: "+ Thread.currentThread().toString());
        for (int i = 0; i < 1000; i++) {
            i++;
        }
    }
}
