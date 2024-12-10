package DaniProcesos.ActDani;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Examen {
    private static final Semaphore cubos = new Semaphore(2);
    // Semáforo para los dos cubos, permite que solo dos cubos sean usados al mismo tiempo.

    private static final Lock mezclador = new ReentrantLock();
    // Bloqueo para garantizar que solo una mezcla pueda realizarse a la vez.

    private static final Semaphore turnoMezclador = new Semaphore(0);
    // Semáforo que indica cuándo la mezcladora está lista para mezclar.
    private static final Semaphore turnoPersona = new Semaphore(1);
    // Semáforo para controlar el acceso por turno a las personas que preparan los colores.
    private static final Semaphore mezclaTerminada = new Semaphore(0);
    // Semáforo para notificar a las personas cuando la mezcla ha terminado.
    private static int personaActual = 0;
    // Variable que indica la persona que tiene el turno.
    private static final int TOTAL_PERSONAS = 3;
    // Número total de personas que están preparando colores.(NºHilos)

    public static void main(String[] args) {
        // Crear y nombrar los hilos para cada persona.
        Thread persona1 = new Thread(new Persona("Rojo", "Amarillo", "Magenta", 0), "Persona 1");
        Thread persona2 = new Thread(new Persona("Azul", "Cian", "Magenta", 1), "Persona 2");
        Thread persona3 = new Thread(new Persona("Verde", "Amarillo", "Cian", 2), "Persona 3");
        // Iniciar los hilos de las personas.
        persona1.start();
        persona2 .start();
        persona3.start();
        // Iniciar el hilo para la mezcladora.
        new Thread(new Mezclador()).start();
    }

    // Clase que representa a una persona que prepara un color secundario.
    static class Persona implements Runnable {
        private final String colorSecundario;
        private final String colorPrimario1;
        private final String colorPrimario2;
        private final int id;

        public Persona(String colorSecundario, String colorPrimario1, String colorPrimario2, int id) {
            this.colorSecundario = colorSecundario;
            this.colorPrimario1 = colorPrimario1;
            this.colorPrimario2 = colorPrimario2;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    turnoPersona.acquire();
                    // Espera su turno para preparar el color.
                    if (personaActual != id) {
                        // Si no es el turno de esta persona, libera el semáforo y espera.
                        turnoPersona.release();
                        continue;
                    }
                    System.out.println(Thread.currentThread().getName() + " esperando los cubos para preparar: " + colorSecundario);
                    cubos.acquire(2);
                    // Intenta adquirir los dos cubos necesarios para cargar los colores.
                    System.out.println(Thread.currentThread().getName() + " coge los cubos para " + colorSecundario);
                    cargarCubos();
                    // Simula el tiempo que tarda en cargar los colores en los cubos.
                    System.out.println(Thread.currentThread().getName() + " cargó " + colorPrimario1 + " y " + colorPrimario2);
                    mezclador.lock();
                    // Bloquea el acceso a la mezcladora para echar los colores.
                    try {
                        System.out.println(Thread.currentThread().getName() + " echando " + colorPrimario1 + " y " + colorPrimario2 + " en la mezcladora");
                        cubos.release(2);
                        // Libera los cubos después de echar los colores en la mezcladora.
                        System.out.println(Thread.currentThread().getName() + " terminó con los cubos");
                        turnoMezclador.release();
                        // Notifica a la mezcladora que puede iniciar la mezcla.
                    } finally {
                        mezclador.unlock();
                        // Libera el bloqueo de la mezcladora.
                    }
                    personaActual = (personaActual + 1) % TOTAL_PERSONAS;
                    // Actualiza la persona actual al siguiente turno.
                    turnoPersona.release();
                    // Libera el turno para la siguiente persona.
                    mezclaTerminada.acquire();
                    // Espera a que la mezcla termine antes de continuar.
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void cargarCubos() throws InterruptedException {
            Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1001));
            // Simula el tiempo que tarda en cargar los colores en los cubos (entre 500 ms y 1 s).
        }
        }

    // Clase que representa la mezcladora.
    static class Mezclador implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    turnoMezclador.acquire();
                    // Espera a que alguien eche colores en la mezcladora.
                    mezclador.lock();
                    // Bloquea el acceso a la mezcladora para iniciar la mezcla.
                    try {
                        System.out.println("Mezcladora iniciando mezcla");
                        mezclarColores();
                        // Simula el tiempo que tarda la mezcladora en mezclar los colores.
                        System.out.println("Mezcladora terminó de mezclar");
                    } finally {
                        mezclador.unlock();
                        // Libera el bloqueo de la mezcladora.
                        mezclaTerminada.release();
                        // Notifica que la mezcla ha terminado.
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void mezclarColores() throws InterruptedException {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2001));
            // Simula el tiempo de mezcla (entre 1 s y 2 s).
        }
    }
}
