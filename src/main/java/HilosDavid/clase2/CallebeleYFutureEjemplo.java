/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid.clase2;

/**
 *
 * @author Alumno
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallebeleYFutureEjemplo {
    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        
        Callable<Integer> SumaParte1 = ()->{ //El Callable nos permite recoger datos y con el Future los enseñamos (Generar y recuperar)
            int suma= 0;
            for (int i = 0; i < 50; i++) {
                suma +=1;
            }
            return suma;
            
        };
        Callable<Integer> SumaParte2 = ()->{//Los parentesis sirven para crear una clase dentro del nombre, lo que va dentro de {} es lo que deberia ir en los `parentesis
            int suma= 0;
            for (int i = 51; i < 100; i++) {
                suma +=1;
            }
            return suma;
            
        };
        try{
            Future<Integer> resultado1 = executor.submit(SumaParte1);
            Future<Integer> resultado2 = executor.submit(SumaParte2);
            int sumaTotal= resultado1.get() + resultado2.get();
            System.out.println("Suma total del 1 al 100: "+sumaTotal);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
        executor.shutdown();
    
    }
    }
}
