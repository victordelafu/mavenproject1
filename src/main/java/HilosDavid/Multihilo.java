/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid;

public class Multihilo {
    static class tarea extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " Ejecutando iteración " +i);
                try{
                    Thread.sleep(500); //Hace una espera de 500millisegundos entre cada proyeccion de cada hilo          
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args){
            Thread hilo1 = new Thread(new tarea());
            Thread hilo2 = new Thread(new tarea());
            
            hilo1.start();
            hilo2.start();
            
            try {
                hilo1.join(); 
//.join se utiliza para esperar a que un hilo termine su ejecución antes de continuar con el código siguiente en el 
//programa principal o en el hilo actual.
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            try {
                hilo2.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Fin del hilo principal");
            System.out.println("Fin del hilo principal");
        }
}
