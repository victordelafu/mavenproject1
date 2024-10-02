/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PrimeraEvaluacion.UD1.ej2;

import java.util.Random;
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
    static Random random = new Random();

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
            System.out.println(nombre + " Es mayor de edad, tiene: " + edad + " años");
            return true;
        } else {
            System.out.println(nombre + " Es menor");
            return false;
        }
    }

    public int calcularPeso(double peso) {
        double altura1 = altura * altura;
        double imc = peso / altura1;
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else if (imc >25) {
            return 1;
        } else {
            return 2;
        }
    }
    public boolean verSexo(char sexo){
        if(sexo=='H'){
            System.out.println(nombre+" es de sexo Masculino");
            return true;
        }else{
            System.out.println(nombre+" es de sexo Femenino");
            return false;
        }
    }
    public String generarDNI(String documento){
        int numeroAleatorio =random.nextInt(90000000);
        String documentacion = Integer.toString(numeroAleatorio);
        char letraAleatoria = (char) (random.nextInt(26) + 'A');
        String documentacionFinal = documentacion + letraAleatoria;
        return documentacionFinal;
    }
    public String generarDNI() {
        int numeroDNI = 10000000 + random.nextInt(90000000);
        char letraDNI = calcularLetraDNI(numeroDNI);
        return numeroDNI + "" + letraDNI;
    }

    
    private char calcularLetraDNI(int dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letras.charAt(dni % 23);
    }
    @Override
    public String toString() {
        return "Persona: " + nombre + ", Edad: " + edad + " años de edad, DNI:" + DNI + ", sexo: " + sexo + ", peso: " + peso + ", altura: " + altura;
    }
}
