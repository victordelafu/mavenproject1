/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PrimeraEvaluacion.UD1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class CuentaApp {
    static ArrayList<Cuenta> cuentas = new ArrayList();
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("---BIENVENIDO AL BANCO MAS FIABLE DEL MUNDO---");
        boolean continuar = true;
        while (continuar) {
            System.out.println("""
            \nSeleccione una opcion:
                1. Dar de alta cuenta
                2. Listado Cuentas disponibles
                3. Salir del programa                                         
             """);
            int eleccionMenu = entrada.nextInt();
            switch (eleccionMenu) {
                case 1:
                    darDeAlta();
                    break;
                case 2:
                    mostrarCuentas();
                    break;
                case 3:
                    continuar = false;
            }
        }
        
        
    }

    private static void darDeAlta() {
        do{
            System.out.println("Introduce al titular de la cuenta");
            String nombre = entrada.next();
            System.out.println("Introduce el saldo de la cuenta de este titular");
            double cantidad = entrada.nextDouble();
            cuentas.add(new Cuenta(nombre, cantidad));
            System.out.println("Quieres introducir mas usuarios?----'Si o no'");
            String eleccion = entrada.next();
            if(eleccion.equalsIgnoreCase("no")){
                break;
            }
        }while(true);
    }

    private static void mostrarCuentas() {
        System.out.println("Las cuentas creadas hasta el momento son: ");
        for(Cuenta c : cuentas){
            System.out.println(c);
        }
    }
    
}
