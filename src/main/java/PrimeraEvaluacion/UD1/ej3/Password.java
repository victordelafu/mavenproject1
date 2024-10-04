/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PrimeraEvaluacion.UD1.ej3;

import java.util.Random;

/**
 *
 * @author Alumno
 */
public class Password {
    static Random random = new Random();

    private int longitud;
    private String contraseña;
    private int id;

    public boolean isEsFuerte() {
        return esFuerte;
    }

    public static Random getRandom() {
        return random;
    }

    public static void setRandom(Random random) {
        Password.random = random;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEsFuerte(boolean esFuerte) {
        this.esFuerte = esFuerte;
    }

    public Password( int id, int longitud, String contraseña) {
        this.longitud = longitud;
        this.contraseña = contraseña;
        this.id = id;
    }
    private final static int LongitudDefecto = 8;
    private boolean esFuerte;
    
    public static int getLongitudDefecto() {
        return LongitudDefecto;
    }
    
    public Password(int longitud, String contraseña) {
        this.longitud = longitud;
        this.contraseña = contraseña;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    @Override
    public String toString(){
        return "ID: " + id + ", Longitud: " + longitud + ", Contraseña: " + contraseña + ", Es fuerte: " + esFuerte;
    }
    
}
