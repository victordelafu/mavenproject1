/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid.MetodosHilos;

import java.util.concurrent.*;


/**
 *
 * @author Alumno
 */
public class BlockingQueueEjemplo {//2 hilos donde uno produce y otro consume (Para manejar sin necesidad de poner bloqueos manualmente) ".INTERRUPT
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        
        Runnable productor=()->{
            for (int i = 0; i < 10; i++) {
                try{
                    System.out.println("Productor esta produciendo el valor: "+i);
                    queue.put(i);//Según vayamos formando los números se incorporan a la cola
                    System.out.println("Productor ha colocado el valor: "+i+" en la cola.");
                    Thread.sleep(2500);
                    
                }catch(InterruptedException ex){
                    System.out.println("El productor fue interrumpido: "+ex.getMessage());
                    ex.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                
            }
            System.out.println("Productor ha terminado de producir todos los valores");
        };
        Runnable consumidor=()->{
            while(true){
                try{
                    Integer valor = queue.take();
                    System.out.println("Consumidor ha tomado el valor: "+valor+" de la cola");
                    Thread.sleep(2500);
                }catch(InterruptedException ex){
                    System.out.println("El consumidor fue interrumpido: "+ex.getMessage());
                    ex.printStackTrace();
                    break;
                }
                
            }
            System.out.println("Consumidor ha terminado de consumir");
        };
        Thread hiloProductor = new Thread(productor);
        Thread hiloConsumidor = new Thread(consumidor);
        
        hiloProductor.start();
        hiloConsumidor.start();
    }
    
}
