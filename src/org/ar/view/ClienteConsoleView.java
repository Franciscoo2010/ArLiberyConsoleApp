package org.ar.view;
import java.util.Scanner;
import java.util.List;
import org.ar.model.Clientes;


public class ClienteConsoleView {
    private final Scanner leer = new Scanner(System.in);
    
    //metodo para mostrar las opciones de este menú
    public int mostrarMenu(){
        int opcion = 0;
        
        System.out.println("-------Gestion de Clientes---------");
        System.out.println("-1 CREAR NUEVO CLIENTE-");
        System.out.println("-2 LISTAR CLIENTES-");
        System.out.println("-3 BUSCAR CLIENTE POR ID-");
        System.out.println("-4 MODIFICAR CLIENTE-");
        System.out.println("-5 ELIMINAR CLIENTE-");
        System.out.println("-6 REGRESAR MENU PRINCIPAL-");
        System.out.println("-Seleccione una opción-");
        opcion = Integer.parseInt(leer.nextLine());
        return opcion;
    }
    public long solicitarCUI(){
        System.out.println("ingrese el CUI del cliente");
        return Long.parseLong(leer.nextLine());
    }
    
    public String solicitarNombreCliente(){
        System.out.println("ingrese el Nombre del cliente");
        String nombre;
        nombre = leer.nextLine();
        return nombre;
        //otra forma de hacerlo
    }
    
    public String solicitarApellidoCliente(){
        System.out.println("ingrese el Apellido del cliente");
        return leer.nextLine();
    }
    
    public String solicitarCorreoElectronico(){
        System.out.println("ingrese el correo electronico");
        return leer.nextLine();
    }
    
    //mostrar el detalle de un CLIENTE
    public void mostrarCliente(Clientes cliente){
        System.out.println("--- DATOS DEL CLIENTE ---");
        System.out.println("CUI: " + cliente.getCui());
        System.out.println("NOMBRE: " + cliente.getNombre());
        System.out.println("APELLIDO: " + cliente.getApellido());
        System.out.println("CORREO: " + cliente.getCorreoElectronico());
    }
    //mostrar la lista de CLIENTES -- lista de objeto List<T>, ArrayList<Cliente>
    public void mostrarListaClientes(List<Clientes> clientes){
        System.out.println("--LISTA DE CLIENTES ---");
        //tabla usando la propidad %- tamaño de columtas
        System.out.println("|CUI   |   NOMBRE  |   APELLIDO   |  CORREO ELECTRÓNICO  |");
        System.out.printf("%-10s %-10s %-10s %-10s", "CUI","NOMBRE","APELLIDO","CORREO");
        
        for (Clientes cliente : clientes) {
                    System.out.printf("%-10s %-10s %-10s %-10s", 
                            cliente.getCui(), cliente.getNombre(), cliente.getApellido(), cliente.getCorreoElectronico());

        }
    }
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
}
