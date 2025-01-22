package HilosDavid.EjercicioPintores;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
public class Pintores {
    

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3*4);
        for (int i = 0; i < 4; i++) {
            Runnable naranja = new color("Rojo", "Amarillo", "Naranja",latch);
            Runnable turquesa = new color("Azul", "Cian", "Turquesa",latch);
            Runnable lima = new color("Verde", "Amarillo", "Lima",latch);

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
    private CountDownLatch latch;


    public color(String color1, String color2, String colorFinal, CountDownLatch latch) {
        this.color1 = color1;
        this.color2 = color2;
        this.colorFinal = colorFinal;
        this.latch = latch;
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

        
    }
}

