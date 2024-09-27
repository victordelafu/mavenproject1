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
    static double cantidad;
    static ArrayList<Cuenta> cuentas = new ArrayList();
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args){
        //Datos de prueba:
        cuentas.add(new Cuenta("victor", 28000));
        cuentas.add(new Cuenta("carmen", 100));
        cuentas.add(new Cuenta("ivan", 350));
        System.out.println("---BIENVENIDO AL BANCO MAS FIABLE DEL MUNDO---");
        boolean continuar = true;
        while (continuar) {
            System.out.println("""
            \nSeleccione una opcion:
                1. Dar de alta cuenta
                2. Listado Cuentas disponibles
                3. Retirar fondos
                4. Ingresar fondos
                5. Salir del programa                             
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
                    retirarFondos();
                    break;
                case 4:
                    ingresar();
                    break;
                case 5:
                    continuar = false;
                default:
                    System.out.println("Introduce una opcion valida");
                    break;
            }
        }
        
        
    }

    private static void darDeAlta() {
        do{
            System.out.println("Introduce al titular de la cuenta");
            String nombre = entrada.next();
            System.out.println("Introduce el saldo de la cuenta de este titular");
            cantidad = entrada.nextDouble();
            if(cantidad < 0){
                System.out.println("Introduce una cantidad válida");
                break;
            }
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

    private static void retirarFondos() {
        boolean encontrado = false;
        do{
        System.out.println("Identificate para retirar fondos de la cuenta");
        String titular1 = entrada.next();
        
        for(Cuenta c : cuentas){
            if(c.getTitular().equals(titular1)){
                encontrado = true;
                System.out.println("Cuanto deseas retirar de la cuenta de "+c.getTitular());
                double retiro = entrada.nextDouble();
                if(retiro > c.getCantidad()){
                    System.out.println("Este retiro es imposible ya que supera " +c.getCantidad() + " del titular "+ c.getTitular());
                }
            else {
                    
                    c.ingresar(retiro);
                    System.out.println("Retiro de " + retiro + " realizado con exito. Nuevo saldo: " + c.getCantidad());
                }
                    break;
                }
        }if (!encontrado) {
            System.out.println("Introduce un nombre válido");}
        }while(!encontrado);
    }

    private static void ingresar() {
        
        
        boolean encontrado = false;
        do{
        System.out.println("¿A que cliente quieres ingresar dinero?");
        String titular1 = entrada.next();
        
        for(Cuenta c : cuentas){
            if(c.getTitular().equals(titular1)){
                encontrado = true;
                System.out.println("Cuanto deseas ingresar en la cuenta de "+c.getTitular());
                double ingreso = entrada.nextDouble();
                if(ingreso < 50){
                    System.out.println("No es posible ingresar cantidades menores a 50euros");
                }
            else {
                    
                    c.ingresar(ingreso);
                    System.out.println("Ingreso de " + ingreso + " realizado con exito. Nuevo saldo: " + c.getCantidad());
                }
                    break;
                }
        }if (!encontrado) {
            System.out.println("Introduce un nombre válido");}
        }while(!encontrado);
    }
    }
    

