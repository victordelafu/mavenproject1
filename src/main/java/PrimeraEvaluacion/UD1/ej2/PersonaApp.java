/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PrimeraEvaluacion.UD1.ej2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class PersonaApp {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Persona> personas = new ArrayList();

    public static void main(String[] args) {
        personas.add(new Persona("victor", 25, "05961264D", 'H', 115, 188));
        personas.add(new Persona("carmen", 21, "05966624F", 'M', 70, 160));
        personas.add(new Persona("jesus", 54, "05961264D", 'H', 87, 165));
        System.out.println("---BIENVENIDO AL BANCO MAS FIABLE DEL MUNDO---");
        boolean continuar = true;
        while (continuar) {
            System.out.println("""
            \nSeleccione una opcion:
                1. Dar de alta
                2. Listado Personas
                3. Calcular mayor o menor
                4. Calcular paso ideal
                5. Comprobar sexo      
                6. Generar DNI aleatorio
                7. Salir del programa              
             """);
            int eleccionMenu = entrada.nextInt();
            switch (eleccionMenu) {
                case 1:
                    darDeAlta();
                    break;
                case 2:
                    mostrarPersonas();
                    break;
                case 3:
                    mayoroMenor();
                    break;
                case 4:
                    calcularPesoIdeal();
                    break;
                case 5:
                    comprobarSexo();
                    break;
                case 6:
                    generarDNI();
                    break;
                case 7:
                    continuar = false;
                default:
                    System.out.println("Introduce una opcion valida");
                    break;
            }
        }

    }

    private static void darDeAlta() {
        do {
            System.out.println("Introduce nombre");
            String nombre = entrada.next();
            System.out.println("Introduce edad");
            int edad = entrada.nextInt();
            if (edad < 0) {
                System.out.println("Introduce una cantidad válida");
                break;
            }
            System.out.println("Introduce DNI");
            String dni = entrada.next();
            System.out.println("Introduce sexo");
            char sexo = (char) entrada.nextByte();
            System.out.println("Introduce peso");
            double peso = entrada.nextDouble();
            System.out.println("Introduce altura en cm");
            int altura = entrada.nextInt();
            personas.add(new Persona(nombre, edad, dni, sexo, peso, altura));
            System.out.println("Quieres introducir mas personas?----'Si o no'");
            String eleccion = entrada.next();
            if (eleccion.equalsIgnoreCase("no")) {
                break;
            }
        } while (true);
    }

    private static void mostrarPersonas() {
        System.out.println("Las cuentas creadas hasta el momento son: ");
        for (Persona p : personas) {
            System.out.println(p);
        }
    }

    private static void mayoroMenor() {
        System.out.println("Introduce una persona para saber si es mayor o menor de edad");
        boolean encontrado = false;
        do {
            String nombre = entrada.next();
            for (Persona p : personas) {
                if (p.getNombre().equals(nombre)) {
                    encontrado = true;
                    p.calcularEdad(p.getEdad());
                    break;
                } else {
                    System.out.println("Esa persona no existe en la base de datos");
                }
            }
        }while(!encontrado);
    }

    private static void calcularPesoIdeal() {

    }

    private static void comprobarSexo() {

    }

    private static void generarDNI() {

    }
}
