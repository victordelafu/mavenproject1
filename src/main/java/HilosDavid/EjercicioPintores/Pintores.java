package HilosDavid.EjercicioPintores;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Pintores {

    public static void main(String[] args) {
        
        for (int i = 0; i < 4; i++) {
            Runnable naranja = new color("Rojo", "Amarillo", "Naranja");
            Runnable turquesa = new color("Azul", "Cian", "Turquesa");
            Runnable lima = new color("Verde", "Amarillo", "Lima");

            Thread vitin = new Thread(naranja, "Vitín");
            Thread pauloncio = new Thread(turquesa, "Pauloncio");
            Thread jaime = new Thread(lima, "Jaime");
            
            vitin.start();
            espera();
            pauloncio.start();
            espera();
            jaime.start();
            espera();
        }
    }

    private static void espera() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println("El hilo se ha interrumpido " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

class color implements Runnable {

    private String color1;
    private String color2;
    private String colorFinal;
    private static Semaphore semaphore = new Semaphore(1);
    private static CountDownLatch latch = new CountDownLatch(12);

    public color(String color1, String color2, String colorFinal) {
        this.color1 = color1;
        this.color2 = color2;
        this.colorFinal = colorFinal;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " está cargando los colores: " + color1 + " y " + color2 + ".");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " terminó de mezclar y produjo: " + colorFinal + ".");
            System.out.println(Thread.currentThread().getName() + " Liberó la mezcladora.");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("El hilo fue interrumpido: " + ex.getMessage());
        } finally {
            semaphore.release();
            latch.countDown();
        }

        try {
            latch.await();
            System.out.println("Todos los colores se han gastado");
            Thread.sleep(2000);
            System.out.println("La casa se ha terminado de pintar");
        } catch (InterruptedException ex) {
            System.out.println("El hilo se ha interrumpido " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

