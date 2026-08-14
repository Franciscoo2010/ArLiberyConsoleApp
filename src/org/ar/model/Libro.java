package org.ar.model;

import java.math.BigDecimal;
import java.time.LocalDate;

//POJO: Nombre, atributos, constructores, getters y setters
public class Libro {

    /*
    create table libros(
        isbn varchar(20) primary key,
        titulo varchar(100) not null,
        fecha_publicacion date,
        precio decimal(8,2) not null,
        id_categoria int,
        nit_editorial varchar(20)
    );
     */

    //atributos de clase
    String isbn;
    String titulo;
    LocalDate fechaPublicacion;
    BigDecimal precio;
    Integer idCategoria;
    String nitEditorial;

    //constructores: asignación de datos, instanciar objetos
    //vacio
    public Libro() {
    }
    //lleno o con parametros
    public Libro(String isbn, String titulo, LocalDate fechaPublicacion, BigDecimal precio, Integer idCategoria, String nitEditorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
        this.idCategoria = idCategoria;
        this.nitEditorial = nitEditorial;
    }
    //personalizador


    //getter and setters

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        //formatear a Mayusucual
        String tituloMayusculas = titulo.toUpperCase();
        //formatear a Inicia con Mayusuculas
        this.titulo = tituloMayusculas;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNitEditorial() {
        return nitEditorial;
    }

    public void setNitEditorial(String nitEditorial) {
        this.nitEditorial = nitEditorial;
    }

}
