/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaniProcesos;

/**
 *
 * @author Alumno
 */
public class ContadorNuevo {

    private static int contador2 = 0;

    public static void main(String args[]) {
        System.out.println("FFFFF");

        long inicio = System.currentTimeMillis();
        //Lógica:

        Runnable tarea = new Runnable() {
            @Override
            public void run() {
                System.out.println("AAAAAAAAAAA");
                while (contador2 <= 5000) {
                    contador2++;
                    System.out.println(contador2);
                }
            }
        };
        Thread hilo3 = new Thread(tarea);
        Thread hilo4 = new Thread(tarea);
        hilo3.start();
        hilo4.start();
        try {
            hilo3.join();
            hilo4.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long fin = System.currentTimeMillis();
        System.out.println("El proceso ha tardado " + (fin - inicio) + " milisegundos en ejecutarse");
    }
}
