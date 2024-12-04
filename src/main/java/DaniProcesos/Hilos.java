/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaniProcesos;

/**
 *
 * @author Alumno
 */
public class Hilos extends Thread{
    private int x;
    Hilos(int x){
        this.x =x;  
    }
    @Override
    public void run(){
        for(int i = 0; i<x;i++){
            System.out.println("En el hilo...."+i);
        }
    }
    public static void main(String[] args){
        Hilos p = new Hilos(8); //así llamamos al constructor por lo que cambia la x a lo que pongas en parentesis aquí
        p.start(); //Hace que comience el hilo //hace que se ejecute la clase run()
    }
}
