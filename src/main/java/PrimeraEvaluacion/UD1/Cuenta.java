/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PrimeraEvaluacion.UD1;

/**
 *
 * @author Alumno
 */
public class Cuenta {
    private double cantidad;
    private String titular;

    

    

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    public double getCantidad() {
        return cantidad;
    }

    public Cuenta(String titular, double contabilidad) {
        this.cantidad = contabilidad;
        this.titular = titular;
    }
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    public boolean retirar(double monto) {
        if (monto > 0 && monto <= cantidad) {
            cantidad -= monto;
            return true;
        } else {
            return false;
        }
    }
    public boolean ingresar(double monto) {
        if (monto > 50) {
            cantidad += monto;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
      return "El titular: "+titular+" Tiene una cantidad de: "+cantidad+" euros en su cuenta";
    }
   
}
