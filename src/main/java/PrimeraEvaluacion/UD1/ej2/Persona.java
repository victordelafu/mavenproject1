/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PrimeraEvaluacion.UD1.ej2;

/**
 *
 * @author Víctor de la fuente
 */

public class Persona {
    //: nombre, edad, DNI, sexo (H hombre, M mujer), peso y altura
    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso, altura;

    public Persona(String nombre, int edad, String DNI, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }
    public boolean calcularEdad(int edad) {
        if (edad >= 18) {
            System.out.println(nombre+"Es mayor de edad, tiene: "+edad+" años");
            return true;
        } else {
            System.out.println("Es menor");
            return false;
        }
    }
    @Override
    public String toString() {
      return "Persona: "+nombre+", Edad: "+edad+" años de edad, DNI:"+ DNI+", sexo: "+sexo+", peso: "+peso+", altura: "+altura;
    }
}
