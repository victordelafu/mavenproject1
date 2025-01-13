/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HilosDavid.clase2;

/**
 *
 * @author Alumno
 */
public class HiloIncrementador implements Runnable{
    private Contador contador;
    private String nombreHilo;

    public HiloIncrementador(Contador contador, String nombreHilo) {
        this.contador = contador;
        this.nombreHilo = nombreHilo;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            contador.incrementar(nombreHilo);
        }
    }
}
