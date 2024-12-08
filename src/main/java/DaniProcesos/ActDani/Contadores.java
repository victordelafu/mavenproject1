/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaniProcesos.ActDani;

import java.util.Scanner;

/**
 *
 * @author Víctor de la Fuente
 */
public class Contadores {
    private static int contador2=0;
    static long inicio;
    static long fin;
    static Scanner entrada = new Scanner(System.in);

    public static void main(String args[]) {
        int eleccion;
        do {
            System.out.println("1->1ªforma\n2->2ªforma\n3->3ªforma\n4->Salir");
            eleccion = entrada.nextInt();
            switch (eleccion) {
                case 1:
                    inicio = System.currentTimeMillis();
                    //lógica hacer un contador de 1 a 5000 que pinte los numero con un for (forma sencilla)
                    int contador = 0;
                    for (int i = 0; i < 5000; i++) {
                        contador++;
                        System.out.println(contador);
                    }

                    fin = System.currentTimeMillis();
                    System.out.println("El proceso ha tardado " + (fin - inicio) + " milisegundos en ejecutarse");
                    break;
                case 2:
                    inicio = System.currentTimeMillis();
                    //lógica -> Hacer un contador de 1 a 5000 que pinte los numeros con hilos
                    Thread hilo1 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0; i < 2500; i++) {
                                System.out.println(i);
                            }
                        }
                    });
                    Thread hilo2 = new Thread(() -> {
                        for (int i = 2500; i < 5000; i++) {
                            System.out.println(i);
                        }
                    });
                    hilo1.start();
                    hilo2.start();
                    try {
                        hilo1.join();
                        hilo2.join();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    fin = System.currentTimeMillis();
                    System.out.println("El proceso ha tardado " + (fin - inicio) + " milisegundos en ejecutarse");
                    break;
                case 3:
                    System.out.println("FFFFF");
                    inicio = System.currentTimeMillis();
                    //Lógica:
                    
                    Runnable tarea = new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("AAAAAAAAAAA");
                            while(contador2 <= 5000){
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
                    fin = System.currentTimeMillis();
                    System.out.println("El proceso ha tardado " + (fin - inicio) + " milisegundos en ejecutarse");
                    break;
                default:
                    System.out.println("Introduce una opción válida");
            }
        } while (eleccion != 4);

    }

}
