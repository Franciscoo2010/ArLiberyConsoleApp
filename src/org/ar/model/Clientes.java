package org.ar.model;

public class Clientes {


    // atributos dde clase
    long cui;
    String nombre;
    String apellido;
    String correoElectronico;

    //constructores
public Clientes(long cui, String nombre, String apellido, String correoElectronico) {
        this.cui = cui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
}
    //getter and setters

   

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
        //formatear matuscula
        String nombreMayuscula = nombre.toUpperCase();
        //formatear a Iniciar con Mayúscila
        this.nombre = nombreMayuscula;
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

// Constructor vacío requerido para poder instanciar un cliente vacío y luego llenarlo con setters
public Clientes() {
}

    }

