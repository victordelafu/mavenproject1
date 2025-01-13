/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid.clase2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Alumno
 */
public class ExecutorServiceEjemplo {
    public static void main(String[] args){
        Contador contadorCompartido = new Contador();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        executor.submit(new HiloIncrementador(contadorCompartido,"Hilo-1")); //.submit hace que se ejecute el hilo, es como el .start() pero en una sola linea
        executor.submit(new HiloIncrementador(contadorCompartido,"Hilo-2"));
        
        executor.shutdown(); //Para cerrar los hilos
        
        
        
    }
}
