/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PrimeraEvaluacion.UD1.ej3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class PasswordApp {

    static Random random = new Random();
    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Password> contraseña = new ArrayList();
    static ArrayList<Password> contraseñaFuerte = new ArrayList();

    public static void main(String[] args) {
        contraseña.add(new Password(1, 5, "01234"));
        contraseña.add(new Password(2, 5, "98765"));
        contraseña.add(new Password(3, 3, "567"));
        int eleccion;
        do {

            System.out.println("---BIENVENIDO AL SISTEMA DE GESTIÓN DE CONTRASEÑAS---");
            System.out.println("Escoge una opción:\n1->Generar Contraseña\n2->Ver fuerza de la contraseña");
            eleccion = entrada.nextInt();
            switch (eleccion) {
                case 1:
                    generarContraseña();
                    break;
                case 2:
                    listarContraseñas();
                    break;
            }
        }while(eleccion!=3);
        }
    public static void generarContraseña() {
        boolean generado = false;
        do {
            System.out.println("Introduce la longitud de la contraseña que vamos a generar por ti");
            int longitud = entrada.nextInt();
            if (longitud > 0 && longitud < 15) {
                generado = true;
                String contraseña = generarContra(longitud);
                System.out.println("Contraseña generada: " + contraseña);
                break;
            } else {
                System.out.println("La contraseña tiene que tener entre 1 y 15 dígitos");
            }
        } while (!generado);

    }

    private static String generarContra(int longitud) {
        String caracteresPermitidos = "ABCDEabcde0123456789";
        StringBuilder contraseña = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteresPermitidos.length());
            contraseña.append(caracteresPermitidos.charAt(index));
        }
        return contraseña.toString();
    }

    public boolean esFuerte(String contraseña) {
        int numeros = 0;
        int mayusculas = 0;
        int minusculas = 0;
        for (char c : contraseña.toCharArray()) {
            if (Character.isDigit(c)) {
                numeros++;
            } else if (Character.isUpperCase(c)) {
                mayusculas++;
            } else if (Character.isLowerCase(c)) {
                minusculas++;
            }
        }
        boolean esFuerte = numeros >= 5 && mayusculas >= 2 && minusculas >= 1;
        //Password.setEsFuerte(esFuerte);
        return esFuerte;
    }

    public static void listarContraseñas() {
        System.out.println("Lista de todas las contraseñas:");
        for (Password p : contraseña) {
            System.out.println(p.toString());
        }
    }
}

