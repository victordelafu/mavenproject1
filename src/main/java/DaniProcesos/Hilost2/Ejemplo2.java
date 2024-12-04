/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaniProcesos.Hilost2;

/**
 *
 * @author Alumno
 */
public class Ejemplo2 extends Thread{
    @Override
    public void run(){
        System.out.println(
                "Dentro del Hilo: "+Thread.currentThread().getName()
                +",Prioridad: " + Thread.currentThread().getPriority()
                +",ID: "+ Thread.currentThread().getId()
                +", Hilos activos: "+ Thread.currentThread().activeCount());
        
    }
    public static void main(String[] args){
        Thread.currentThread().setName("Principal");
        System.out.println("current thread: "+Thread.currentThread().getName());
        System.out.println("toString de current Thread: "+Thread.currentThread().toString());
        Ejemplo2 h;
        for(int i = 0; i<3; i++){
            h =new Ejemplo2();
            h.setName("Hilo_"+i);
            h.setPriority(i+1);
            h.start();
            System.out.println("Información del "+h.getName()+": "+ h.toString());
        }
        System.out.println("3 hilos creados...");
        System.out.println("Hilos activos: "+Thread.activeCount());
    }
}
