/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaniProcesos.ActDani;

import java.io.IOException;

/**
 *
 * @author Alumno
 */
public class ProcesosenJava {

    public static void main(String[] args) {
        //una forma
        try {
            ProcessBuilder p = new ProcessBuilder("cmd","/C", "shutdown", "/r", "/t", "60", "/c", "'Apagando equipo'");
            Process pr = p.start();
        } catch (IOException e){
            e.printStackTrace();
        }
        }
    }
