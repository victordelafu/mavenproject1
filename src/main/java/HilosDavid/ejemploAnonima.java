/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid;

/**
 *
 * @author Alumno
 */
public class ejemploAnonima {

    public static void main(String[] args) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Soy un hilo");
                }
            }
        });
        hilo.start();
        System.out.println("Fin del hilo principal");
    }
}
