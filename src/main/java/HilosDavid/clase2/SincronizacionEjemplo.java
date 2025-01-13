/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid.clase2;

/**
 *
 * @author Alumno
 */
public class SincronizacionEjemplo {
    public static void main(String[] args){
        Contador contadorCompartido = new Contador();
        Thread hilo1 = new Thread(new HiloIncrementador(contadorCompartido,"hilo-1"));
        Thread hilo2 = new Thread(new HiloIncrementador(contadorCompartido,"hilo-2"));
        
        hilo1.start();
        hilo2.start();
    }
}
