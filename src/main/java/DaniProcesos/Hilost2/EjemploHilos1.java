/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaniProcesos.Hilost2;

/**
 *
 * @author Alumno
 */
public class EjemploHilos1 extends Thread {  //El extends Thread es obligatorio
    public EjemploHilos1(String nombre){
        super(nombre);
        System.out.println("CREANDO HILO: "+getName()); //Devuelve el nombre del hilo
    }
    public void run(){
        for(int i = 0; i<5;i++){
            System.out.println("Hilo: "+getName()+" C="+i);
        }
    }
    //Primero entra a EjemploHilos1 y de ahí accede a la clase run()
    public static void main(String[] args){
        EjemploHilos1 h1 = new EjemploHilos1("Hilo 1"); //ASí se crean los hilos y luego son llamados
        EjemploHilos1 h2 = new EjemploHilos1("Hilo 2"); //El nombre del hilo tiene que ser igual al del constructor y a la clase
        EjemploHilos1 h3 = new EjemploHilos1("Hilo 3");
        
        h1.start();
        h2.start();
        h3.start();
        
        System.out.println("3 HILOS INICIADOS...");
        
    }
}
