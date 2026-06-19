package org.ar.model;

public class Categoria {

    long cui;
    String nombre;
    String apellido;
    String correoElectronico;

    //constructores
    public Categoria(long cui, String nombre, String apellido, String correoElectronico) {
        this.cui = cui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
    }
    


    // gestor and setters

    public long getCui() {
        return cui;
    }

    public void setCui(long cui) {
        this.cui = cui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
       // formatear a mayusculas
        String nombreMayusculas = nombre.toUpperCase();
        // formatear a inicial con Mayusculas 
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

} 
