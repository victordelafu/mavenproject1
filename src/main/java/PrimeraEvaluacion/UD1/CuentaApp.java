/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PrimeraEvaluacion.UD1;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Victor de la Fuente
 */
public class CuentaApp {

    static Random random = new Random();
    static String correoCuenta;
    static String contraseñaCuenta;
    static boolean registrado = false;
    static boolean iniciado = false;
    static double cantidad;
    static ArrayList<Cuenta> cuentas = new ArrayList();
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        //Datos de prueba:
        cuentas.add(new Cuenta("victor", 28000));
        cuentas.add(new Cuenta("carmen", 100));
        cuentas.add(new Cuenta("ivan", 350));
        System.out.println("---BIENVENIDO AL BANCO MAS FIABLE DEL MUNDO---");
        boolean continuar = true;
        while (continuar) {
            System.out.println("""
            \nSeleccione una opcion:
                1. Iniciar Sesión
                2. Dar de alta cuenta
                3. Listado Cuentas disponibles
                4. Retirar fondos
                5. Ingresar fondos
                6. Salir del programa                             
             """);
            int eleccionMenu = entrada.nextInt();
            switch (eleccionMenu) {
                case 1:
                    IniciarSesion();
                    break;
                case 2:
                    darDeAlta();
                    break;
                case 3:
                    mostrarCuentas();
                    break;
                case 4:
                    retirarFondos();
                    break;
                case 5:
                    ingresar();
                    break;
                case 6:
                    continuar = false;
                default:
                    System.out.println("Introduce una opcion valida");
                    break;
            }
        }

    }

    private static void darDeAlta() {
        if (iniciado == true) {
            do {
                System.out.println("Introduce al titular de la cuenta");
                String nombre = entrada.next();
                System.out.println("Introduce el saldo de la cuenta de este titular");
                cantidad = entrada.nextDouble();
                if (cantidad < 0) {
                    System.out.println("Introduce una cantidad válida");
                    break;
                }
                cuentas.add(new Cuenta(nombre, cantidad));
                System.out.println("Quieres introducir mas usuarios?----'Si o no'");
                String eleccion = entrada.next();
                if (eleccion.equalsIgnoreCase("no")) {
                    break;
                }
            } while (true);
        } else {
            System.out.println("No puedes acceder al sistema sin iniciar sesion");
        }
    }

    private static void mostrarCuentas() {
        if (iniciado == true) {
            System.out.println("Las cuentas creadas hasta el momento son: ");
            for (Cuenta c : cuentas) {
                System.out.println(c);
            }
        } else {
            System.out.println("No puedes acceder al sistema sin iniciar sesion");
        }
    }

    private static void retirarFondos() {
        if (iniciado == true) {
            boolean encontrado = false;
            do {
                System.out.println("Identificate para retirar fondos de la cuenta");
                String titular1 = entrada.next();

                for (Cuenta c : cuentas) {
                    if (c.getTitular().equals(titular1)) {
                        encontrado = true;
                        System.out.println("Cuanto deseas retirar de la cuenta de " + c.getTitular());
                        double retiro = entrada.nextDouble();
                        if (retiro > c.getCantidad()) {
                            System.out.println("Este retiro es imposible ya que supera " + c.getCantidad() + " del titular " + c.getTitular());
                        } else {

                            c.ingresar(retiro);
                            System.out.println("Retiro de " + retiro + " realizado con exito. Nuevo saldo: " + c.getCantidad());
                        }
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Introduce un nombre válido");
                }
            } while (!encontrado);
        } else {
            System.out.println("No puedes acceder al sistema sin iniciar sesion");
        }
    }

    private static void ingresar() {

        boolean encontrado = false;
        do {
            System.out.println("¿A que cliente quieres ingresar dinero?");
            String titular1 = entrada.next();

            for (Cuenta c : cuentas) {
                if (c.getTitular().equals(titular1)) {
                    encontrado = true;
                    System.out.println("Cuanto deseas ingresar en la cuenta de " + c.getTitular());
                    double ingreso = entrada.nextDouble();
                    if (ingreso < 50) {
                        System.out.println("No es posible ingresar cantidades menores a 50euros");
                    } else {

                        c.ingresar(ingreso);
                        System.out.println("Ingreso de " + ingreso + " realizado con exito. Nuevo saldo: " + c.getCantidad());
                    }
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Introduce un nombre válido");
            }
        } while (!encontrado);
    }

    private static void IniciarSesion() {
        do {
            if (registrado) {
                System.out.println("Introduce tu correo");
                String correo = entrada.next();
                if (correo.equals(correoCuenta)) {
                    System.out.println("Introduce tu contraseña");
                    String contraseña = entrada.next();
                    if (contraseña.equals(contraseñaCuenta)) {
                        System.out.println("Sesión iniciada");
                        iniciado = true;
                        break;
                    } else {
                        System.out.println("Su contraseña no es correcta");
                    }
                } else {
                    System.out.println("Este correo no existe");
                }

            } else {
                System.out.println("No hay ninguna cuenta registrada, regístrate para acceder al sistema");
                System.out.println("Introduce un correo electrónico");
                correoCuenta = entrada.next();
                System.out.println("Introduce tu nombre");
                String nombre = entrada.next();
                System.out.println("1. Crear una contraseña\n2. Generar automáticamente una");
                int eleccion = entrada.nextInt();
                if (eleccion == 1) {
                    System.out.println("Recuerde que su contraseña debe tener mínimo 8 caracteres");
                    String contraseña = entrada.next();
                    if (contraseña.length() >= 8) {
                        System.out.println("Vuelva a introducir la contraseña");
                        String contraseña2 = entrada.next();
                        if (contraseña2.equals(contraseña)) {
                            System.out.println("Se ha registrado con éxito");
                            contraseñaCuenta = contraseña;
                            registrado = true;
                        } else {
                            System.out.println("Las contraseñas no coinciden");
                        }
                    } else {
                        System.out.println("La contraseña es demasiado corta");
                    }
                } else {
                    int contraseñaR = random.nextInt(90000000) + 10000000; // Generar un número de 8 dígitos
                    contraseñaCuenta = Integer.toString(contraseñaR);
                    System.out.println("Su contraseña se ha creado con éxito: " + contraseñaCuenta);
                    registrado = true;
                }
            }
        } while (!iniciado);
    }
}
