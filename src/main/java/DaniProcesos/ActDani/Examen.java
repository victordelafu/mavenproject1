package DaniProcesos.ActDani;
import java.util.concurrent.Semaphore;

public class Examen {

    // Semáforo para los dos cubos
    private static final Semaphore cubos = new Semaphore(2);

    // Bloqueo para garantizar que solo se haga una mezcla a la vez
    private static final Object mezclador = new Object();

    public static void main(String[] args) {
        // Crear y ejecutar los hilos para las tres personas con nombres personalizados
        Thread persona1 = new Thread(new Persona("Rojo", "Amarillo", "Magenta"), "Persona 1");
        Thread persona2 = new Thread(new Persona("Azul", "Cian", "Magenta"), "Persona 2");
        Thread persona3 = new Thread(new Persona("Verde", "Amarillo", "Cian"), "Persona 3");

        persona1.start();
        persona2.start();
        persona3.start();
    }

    static class Persona implements Runnable {
        private final String colorSecundario;
        private final String colorPrimario1;
        private final String colorPrimario2;

        public Persona(String colorSecundario, String colorPrimario1, String colorPrimario2) {
            this.colorSecundario = colorSecundario;
            this.colorPrimario1 = colorPrimario1;
            this.colorPrimario2 = colorPrimario2;
        }

        @Override
        public void run() {
            try {
                // Intentar obtener ambos cubos
                System.out.println(Thread.currentThread().getName() + " esperando por cubos para preparar " + colorSecundario + ".");

                synchronized (cubos) { // Sincronizar acceso a los dos cubos
                    cubos.acquire(2); // Intentar adquirir los dos cubos
                    System.out.println(Thread.currentThread().getName() + " está cargando " + colorPrimario1 + " y " + colorPrimario2 + " para " + colorSecundario + ".");
                    Thread.sleep(500 + (int) (Math.random() * 500)); // Simular tiempo de carga
                    System.out.println(Thread.currentThread().getName() + " terminó de cargar los colores.");
                    cubos.release(2); // Liberar los cubos
                }

                // Sincronizar para mezclar
                synchronized (mezclador) {
                    System.out.println(Thread.currentThread().getName() + " está mezclando para preparar " + colorSecundario + ".");
                    Thread.sleep(1000 + (int) (Math.random() * 1000)); // Simular tiempo de mezcla
                    System.out.println(Thread.currentThread().getName() + " terminó de preparar " + colorSecundario + ".");
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " fue interrumpido.");
            }
        }
    }
}
