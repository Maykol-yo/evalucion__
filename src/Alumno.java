/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Maykol
 */


public class Alumno {
    // Atributos privados (Encapsulamiento)
    private String nombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nivelSocioeconomico;
    private String beca;

    // Constructor que asegura la integridad de los datos desde la creación
    public Alumno(String nombre, String tipoDocumento, String numeroDocumento, String nivel, String beca) {
        setNombre(nombre);
        setTipoDocumento(tipoDocumento);
        setNumeroDocumento(numeroDocumento);
        setNivelSocioeconomico(nivel);
        setBeca(beca);
    }

    // Métodos Setter con validaciones (Reglas de Negocio)[cite: 3]
    private  void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    private void setTipoDocumento(String tipoDocumento) {
        if (!tipoDocumento.equalsIgnoreCase("DNI") && !tipoDocumento.equalsIgnoreCase("RESIDENCIA")) {
            throw new IllegalArgumentException("Tipo de documento inválido (DNI o RESIDENCIA).");
        }
        this.tipoDocumento = tipoDocumento.toUpperCase();
    }

    private void setNumeroDocumento(String numeroDocumento) {
        // Validación obligatoria: DNI (8 dígitos) o Residencia (11 dígitos)[cite: 3]
        if (tipoDocumento.equalsIgnoreCase("DNI") && numeroDocumento.length() != 8) {
            throw new IllegalArgumentException("El DNI debe tener exactamente 8 dígitos.");
        }
        if (tipoDocumento.equalsIgnoreCase("RESIDENCIA") && numeroDocumento.length() != 11) {
            throw new IllegalArgumentException("El carné de Residencia debe tener 11 dígitos.");
        }
        this.numeroDocumento = numeroDocumento;
    }

    private void setNivelSocioeconomico(String nivel) {
      
    if (nivel == null ||
        (!nivel.equalsIgnoreCase("A") &&
         !nivel.equalsIgnoreCase("B") &&
         !nivel.equalsIgnoreCase("C"))) {
        
        throw new IllegalArgumentException("Nivel inválido");
    }

    }

    private void setBeca(String beca) {
        if (!beca.equalsIgnoreCase("NINGUNA") && !beca.equalsIgnoreCase("PARCIAL") && !beca.equalsIgnoreCase("TOTAL")) {
            throw new IllegalArgumentException("Tipo de beca inválida (NINGUNA, PARCIAL o TOTAL).");
        }
        this.beca = beca.toUpperCase();
    }

    // Lógica para el cálculo automático de pensión[cite: 3]
    public double calcularPensionFinal() {
        double montoBase = 0;
        switch (nivelSocioeconomico) {
            case "A" -> montoBase = 1000;
            case "B" -> montoBase = 800;
            case "C" -> montoBase = 600;
            default -> {
            }
        }

        // Aplicación de beneficios de beca[cite: 3]
        if (beca.equals("TOTAL")) return 0; // Exento de pago[cite: 3]
        if (beca.equals("PARCIAL")) return montoBase * 0.5; // Reducción al 50%[cite: 3]
        
        return montoBase;
    }

    public void verDatos() {
        System.out.println("Alumno: " + nombre + " | " + tipoDocumento + ": " + numeroDocumento + 
                           " | Nivel: " + nivelSocioeconomico + " | Beca: " + beca + 
                           " | Pensión Final: S/ " + calcularPensionFinal());
    }
}
