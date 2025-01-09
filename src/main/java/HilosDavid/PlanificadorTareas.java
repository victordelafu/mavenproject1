/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid;

import java.util.*;

/**
 *
 * @author Alumno
 */
class Tarea {

    String nombre;
    int tiempoEjecucion;
    int tiempoInicio;
    int tiempoFin;
    int tiempoRestante;

    public Tarea(String nombre, int tiempoEjecucion) {
        this.nombre = nombre;
        this.tiempoEjecucion = tiempoEjecucion;
        this.tiempoRestante= tiempoEjecucion;
    }

}

public class PlanificadorTareas {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        List<Tarea> tareas = new ArrayList<>(Arrays.asList(
                new Tarea("Tarea 1", 5),
                new Tarea("Tarea 2", 8),
                new Tarea("Tarea 3", 3),
                new Tarea("Tarea 4", 9),
                new Tarea("Tarea 5", 6)
        ));
        do {
            System.out.println("Selecciona el algoritmo de planificación:");
            System.out.println("1->FCFS (First-Come, First-Served\n2->RR(Round Robin)\n3->SRT(Shortest Remaining Time)\n4->Salir");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    ejecutarFCFS(tareas);
                    break;
                case 2:
                    ejecutarRR(tareas, 2);
                    break;
                case 3:
                    ejecutarSRT(tareas);
                    break;
                case 4:

                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Introduce una opción válida");
                    break;
            }
        } while (opcion != 4);
    }

    private static void ejecutarFCFS(List<Tarea> tareas) {
        int tiempoActual = 0;
        for (Tarea tarea : tareas) {
            tarea.tiempoInicio = tiempoActual;
            tarea.tiempoFin = tiempoActual + tarea.tiempoEjecucion;
            tiempoActual = tarea.tiempoFin;
        }
        for (Tarea tarea : tareas) {
            System.out.println(tarea.nombre + " Se inicio a los: " + tarea.tiempoInicio + " y termino a los: " + tarea.tiempoFin);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void ejecutarRR(List<Tarea> tareas, int quantum) {
        int tiempoActual = 0;
        while (!tareas.isEmpty()) {
            Iterator<Tarea> iterator = tareas.iterator();
            while (iterator.hasNext()) {
                Tarea tarea = iterator.next();
                if (tarea.tiempoRestante > quantum) {
                    System.out.println(tarea.nombre + " Se ejecuta desde " + tiempoActual + " hasta " + (tiempoActual + quantum));
                    tarea.tiempoRestante -= quantum;
                    tiempoActual += quantum;
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                } else {
                    System.out.println(tarea.nombre + " Se ejecuta desde " + tiempoActual + " hasta " + (tiempoActual + tarea.tiempoRestante));
                    tiempoActual += tarea.tiempoRestante;
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    iterator.remove();
                }
            }
        }

    }

    private static void ejecutarSRT(List<Tarea> tareas) {
        int tiempoActual=0;
        PriorityQueue<Tarea> colaTareas = new PriorityQueue<>(Comparator.comparing(t -> t.tiempoRestante));
        colaTareas.addAll(tareas);
        while(!colaTareas.isEmpty()){
            Tarea tarea = colaTareas.poll(); //Si está vacio devuelve un Null;
            if(tarea.tiempoRestante > 0){
                System.out.println(tarea.nombre + " Se ejecuta desde " + tiempoActual + " hasta " + (tiempoActual + tarea.tiempoRestante));
                tiempoActual += tarea.tiempoRestante;
                tarea.tiempoRestante=0;
                try {
                        Thread.sleep(1000);

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
            }
        }
        
    }

}
