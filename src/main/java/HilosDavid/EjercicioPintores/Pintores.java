package HilosDavid.EjercicioPintores;

import java.util.concurrent.*;

public class Pintores {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(12);

        Thread naranja = new Thread(new color("Rojo", "Amarillo", "Naranja"),"Vitín");
        Thread turquesa = new Thread(new color("Azul", "Cian", "Turquesa"), "Pauloncio");
        Thread lima = new Thread(new color("Verde", "Amarillo", "Lima"), "Jaime");
        for (int i = 0; i < 4; i++) {


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
    private CountDownLatch latch;

    public color(String color1, String color2, String colorFinal) {
        this.color1 = color1;
        this.color2 = color2;
        this.colorFinal = colorFinal;
        this.latch = latch;

    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getColorFinal() {
        return colorFinal;
    }

    public void setColorFinal(String colorFinal) {
        this.colorFinal = colorFinal;


    }

    @Override
    public void run() {
        Semaphore semaphore = new Semaphore(1);
        CountDownLatch latch = new CountDownLatch(12);

        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " está cargando los colores: " + color1 + " y " + color2 + ".");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " terminó de mezclar y produjo: " + colorFinal + ".");
            System.out.println(Thread.currentThread().getName() + " Liberó la mezcladora");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("El hilo fue interrumpido: " + ex.getMessage());
        } finally {
            semaphore.release();
            latch.countDown();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("El hilo se ha interrumpido " + ex.getMessage());
            ex.printStackTrace();
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
/**
 *import java.util.concurrent.*;
 *
 * public class Pintores {
 *
 *     public static void main(String[] args) {
 *         Semaphore semaphore = new Semaphore(1);
 *         CountDownLatch latch = new CountDownLatch(12);
 *
 *         Runnable tarea = () -> {
 *             try {
 *                 semaphore.acquire();
 *                 System.out.println(Thread.currentThread().getName() + " Está cargando los colores en la mezcladora");
 *                 Thread.sleep(3000);
 *                 System.out.println(Thread.currentThread().getName() + " Terminó de mezclar e hizo el color:");
 *                 Thread.sleep(500);
 *             } catch (InterruptedException ex) {
 *                 System.out.println("Se ha jodido la mezcladora " + ex.getMessage());
 *                 ex.printStackTrace();
 *             } finally {
 *                 semaphore.release();
 *                 latch.countDown();
 *
 *             }
 *         };
 *
 *         for (int i = 0; i < 4; i++) {
 *
 *         Thread naranja = new Thread(new color("Rojo", "Amarillo", "Naranja"),"Vitín");
 *         Thread turquesa = new Thread(new color("Azul", "Cian", "Turquesa"),"Pauloncio");
 *         Thread lima = new Thread(new color("Verde", "Amarillo", "Lima"),"Jaime");
 *
 *
 *         Thread vitin = new Thread(tarea, "Vitín");
 *         Thread pauloncio = new Thread(tarea, "Pauloncio");
 *         Thread jaime = new Thread(tarea, "Jaime");
 *
 *
 *             vitin.start();
 *             pauloncio.start();
 *             jaime.start();
 *
 *             naranja.start();
 *             turquesa.start();
 *             lima.start();
 *         }
 *
 *
 *         try {
 *             Thread.sleep(500);
 *         } catch (InterruptedException ex) {
 *             System.out.println("El hilo se ha interrumpido " + ex.getMessage());
 *             ex.printStackTrace();
 *         }
 *
 *         try {
 *             latch.await();
 *             System.out.println("Todos los colores se han gastado");
 *             Thread.sleep(2000);
 *             System.out.println("La casa se ha terminado de pintar");
 *         } catch (InterruptedException ex) {
 *             System.out.println("El hilo se ha interrumpido " + ex.getMessage());
 *             ex.printStackTrace();
 *         }
 *     }
 *
 * }
 *
 * class color implements Runnable{
 *     private String color1;
 *     private String color2;
 *     private String colorFinal;
 *
 *     public color(String color1, String color2, String colorFinal) {
 *         this.color1 = color1;
 *         this.color2 = color2;
 *         this.colorFinal = colorFinal;
 *     }
 *
 *     public String getColor1() {
 *         return color1;
 *     }
 *
 *     public void setColor1(String color1) {
 *         this.color1 = color1;
 *     }
 *
 *     public String getColor2() {
 *         return color2;
 *     }
 *
 *     public void setColor2(String color2) {
 *         this.color2 = color2;
 *     }
 *
 *     public String getColorFinal() {
 *         return colorFinal;
 *     }
 *
 *     public void setColorFinal(String colorFinal) {
 *         this.colorFinal = colorFinal;
 *
 *
 *     }
 *     @Override
 *     public void run() {
 *         Semaphore semaphore = new Semaphore(1);
 *         CountDownLatch latch = new CountDownLatch(12);
 *
 *         try {
 *             semaphore.acquire();
 *             System.out.println(Thread.currentThread().getName() + " está cargando los colores: " + color1 + " y " + color2 + ".");
 *             Thread.sleep(3000); // Simula tiempo de mezcla
 *             System.out.println(Thread.currentThread().getName() + " terminó de mezclar y produjo: " + colorFinal + ".");
 *             System.out.println(Thread.currentThread().getName()+" Liberó la mezcladora");
 *             Thread.sleep(1000);
 *         } catch (InterruptedException ex) {
 *             System.out.println("El hilo fue interrumpido: " + ex.getMessage());
 *         }finally {
 *             semaphore.release();
 *             latch.countDown();
 *         }
 *     }
 * }
 */
