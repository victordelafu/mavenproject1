/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid.MetodosHilos;

import java.util.concurrent.*;

/**
 *
 * @author Alumno tareas que se ejecuten despues de un tiempo
 */
public class ScheduleExecutor {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1); //ThreadPool es para manejar la cantidad de hilos que quieras poner en los parentesis

        Runnable tarea = () -> System.out.println("Tarea ejecutada en: " + System.currentTimeMillis());

        scheduler.scheduleAtFixedRate(tarea, 0, 2, TimeUnit.SECONDS);//hilo que queremos formar + tiempo de ejecucion(timesleep) + periodo(cuanto tiempo que queremos que se ejecute + unidad de tiempo
        
        //Función que inicia el scheduler:
        scheduler.schedule(()->{
            System.out.println("Finalizar el schedule...");
            scheduler.shutdown();
            
        },10,TimeUnit.SECONDS); //Significa que el scheduler se apague tras 10 segundos
    }

}
