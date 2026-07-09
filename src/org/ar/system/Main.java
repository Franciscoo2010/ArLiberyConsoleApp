/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.ar.system;

import org.ar.util.Conexion;

public class Main {
    public static void main(String[] args) {
        //sout
        //MVC Modelo,Vista, Controlador. Esto mejora la legibilidad y estandariza en código (patron de diseño)
        //DAO (objeto de acceso a datos)
        MenuPrincipal menu = new MenuPrincipal();
        menu.iniciarSistema();
        Conexion db = new Conexion();
        db.conectar();
    }
}
