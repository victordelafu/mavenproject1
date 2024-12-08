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
        System.out.println(Thread.currentThread().getName() + " Finalizando el programa");
    }

    public static void main(String[] args){
        Thread.currentThread().setName("Principal");
        Thread.currentThread().getName();
        Thread.currentThread().toString();
        ThreadGroup grupo = new ThreadGroup("Grupo hilos");
        Ejemplo3 h = new Ejemplo3();

        Thread h1 = new Thread(grupo,h,"Hilo 1");
        Thread h2 = new Thread(grupo,h,"Hilo 2");
        Thread h3 = new Thread(grupo,h,"Hilo 3");

        h1.start();
        h2.start();
        h3.start();

        System.out.println("3 HILOS CREADOS");
        System.out.println("HILOS ACTIVOS: "+ Thread.activeCount());

    }
}
