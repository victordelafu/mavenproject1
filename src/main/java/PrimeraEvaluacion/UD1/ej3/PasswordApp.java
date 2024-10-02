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

    public static void main(String[] args) {
        contraseña.add(new Password(5, "01234"));
        contraseña.add(new Password(5, "98765"));
        contraseña.add(new Password(3, "567"));
        System.out.println("---BIENVENIDO AL SISTEMA DE GESTIÓN DE CONTRASEÑAS---");
        System.out.println("Escoge una opción:\n1->Generar Contraseña\n2->Ver fuerza de la contraseña");

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
        String caracteresPermitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder contraseña = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteresPermitidos.length());
            contraseña.append(caracteresPermitidos.charAt(index));
        }
        return contraseña.toString();
    }
}
