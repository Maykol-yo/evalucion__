/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maykol
 */
package controlador.java;
import java.util.Scanner;

public class controlador {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            controlador ctrl = new controlador();
            String rpta = "si";
            
            System.out.println("BIENVENIDO AL SISTEMA DE GESTIÓN DEL INSTITUTO INNOVA");
            
            while (rpta.equalsIgnoreCase("si")) {
                try {
                    System.out.println("\n--- INGRESO DE DATOS DEL ALUMNO ---");
                    System.out.print("Nombre completo: ");
                    String nombre = sc.nextLine();
                    
                    System.out.print("Tipo de documento (DNI o RESIDENCIA): ");
                    String tipo = sc.nextLine();
                    
                    System.out.print("Número de documento: ");
                    String numero = sc.nextLine();
                    
                    System.out.print("Nivel socioeconómico (A, B o C): ");
                    String nivel = sc.nextLine();
                    
                    System.out.print("Tipo de beca (NINGUNA, PARCIAL o TOTAL): ");
                    String beca = sc.nextLine();
                    
                    // Instanciación y validación automática
                    Alumno a = new Alumno(nombre, tipo, numero, nivel, beca);
                    ctrl.agregarAlumno(a);
                    
                    System.out.println("\n[SISTEMA] Alumno registrado con éxito.");
                    
                } catch (Exception e) {
                    // Captura y muestra errores de validación sin cerrar el programa
                    System.out.println("\n[ERROR] " + e.getMessage());
                }
                
                System.out.print("\n¿Desea agregar a otro alumno? (si/no): ");
                rpta = sc.nextLine();
            }
            
            // Mostrar lista final antes de cerrar
            ctrl.listarAlumnos();
            System.out.println("\nProceso finalizado. Gracias por usar el sistema del Instituto Innova.");
        }
    }

    private void listarAlumnos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    



    private static class Alumno {

        public Alumno(String nombre, String tipo, String numero, String nivel, String beca) {
        }
    }
}
