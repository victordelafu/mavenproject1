package DaniProcesos.EjerciciosTutoriales.Ejercicio1;

public class main {
    public static void main(String[] args){
        HiloEjemplo hiloEjemplo = new HiloEjemplo();
        hiloEjemplo.start();

        Ejercicio1 ejercicio1 = new Ejercicio1();
        Thread thread = new Thread(ejercicio1);
        thread.start();
    }
}
