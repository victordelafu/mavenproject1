import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class VisualizarCarpetas {
    public static void main(String[] args) throws InterruptedException {
        Scanner entrada = new Scanner(System.in);

        try {
            // Ejecutamos el primer comando 'dir' al inicio
            Process p = new ProcessBuilder("cmd", "/C", "dir").start();

            // Leemos y mostramos la salida del primer comando 'dir'
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
            }

            // Esperamos a que el proceso termine
            int exitCode = p.waitFor();
            System.out.println("Código de salida del proceso: " + exitCode);

            // Bucle para permitir al usuario ingresar comandos y ejecutarlos
            boolean realizado = false;
            do {
                System.out.println("Introduce un comando para ejecutarlo en la consola (o 'exit' para salir):");
                String comando = entrada.nextLine();  // Leemos toda la línea

                // Si el usuario ingresa 'exit', salimos del bucle
                if (comando.equalsIgnoreCase("exit")) {
                    realizado = true;
                    break;
                }

                // Ejecutamos el comando que el usuario ingrese
                try {
                    Process comandoProceso = new ProcessBuilder("cmd", "/C", comando).start();

                    // Leemos y mostramos la salida del comando del usuario
                    try (BufferedReader r = new BufferedReader(new InputStreamReader(comandoProceso.getInputStream()))) {
                        String lineaComando;
                        while ((lineaComando = r.readLine()) != null) {
                            System.out.println(lineaComando);
                        }
                    }

                    // Esperamos a que el comando termine
                    int comandoExitCode = comandoProceso.waitFor();
                    System.out.println("Código de salida del comando: " + comandoExitCode);

                } catch (IOException | InterruptedException e) {
                    System.out.println("Error al ejecutar el comando: " + e.getMessage());
                    e.printStackTrace();
                }

            } while (!realizado);

        } catch (IOException e) {
            System.out.println("Error al ejecutar el proceso: " + e.getMessage());
            e.printStackTrace();
        } finally {
            entrada.close();
        }
    }
}

