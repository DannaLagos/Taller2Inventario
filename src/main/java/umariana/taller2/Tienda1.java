/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.taller2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import producto.Producto;

/**
 *@author ANYELI JARAMILLO
 * @author DANNA LAGOS
 */
public class Tienda1 {
    private final ArrayList<Producto> misProductos;
    private final Scanner lector;

public Tienda1() {
        //Permite inicializar los productos de una clase
        misProductos = new ArrayList<>();
        lector = new Scanner(System.in);
    }
    //Muestra el Menu de Opciones
    public void mostrarMenu() {
        boolean activo = true;
        
        do {
            //Imprimir el Menu
            System.out.println("====== Menu de opciones ======");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Ordenar por Cantidad");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Salir");
            System.out.println("Digite su opción");
            System.out.println("=======================================");
            
            
            //Lee las opciones del usuario
            int opcion = lector.nextInt();
                //Ejecuta la accion, de opcion selecionada
                switch (opcion) {
                case 1:
                    //Llama al metodo que Agrega el Producto
                    agregarProducto();
                    break;
                case 2:
                    if (misProductos.size() == 0) {
                        System.out.println("No hay productos agregados.");
                    } else {
                        //Llama al metodo que llama al Inventario
                        mostrarInventario();
                    }
                    break;
                case 3:
                    if (misProductos.size() == 0) {
                        System.out.println("No hay productos agregados.");
                    } else {
                        //Llama al metodo que Ordena por Cantidad
                        ordenarCantidad();
                    }
                    break;

                case 4:
                    if(misProductos.size()==0){
                        System.out.println("No hay productos agregados");
                    } else {
                        //Llama al metodo y elimina el producto 
                    eliminarProducto();
                    }
                    break;
                case 5:
                    //Cambia la variable para salir del menu
                    activo = false;
                    System.out.println("Programa terminado");
                    break;
                default:
                    //Para opciones invalidas
                    System.out.println("opcion no valida");
            }
        } 
        //Bucle para cuando se cumple las variables
        while (activo);
    }
    
    //Agrega nuevo Producto
    public void agregarProducto() {
        System.out.println("Ingrese el id del producto");
        int idProducto = lector.nextInt();
        lector.nextLine();
        System.out.println("Ingrese el nombre del producto");
        String nombre = lector.nextLine();
        System.out.println("Ingrese el precio del producto");
        double precio = lector.nextDouble();
        System.out.println("Ingrese la cantidad del producto");
        int cantidad = lector.nextInt();
        //Crea un nuevo Objeto
        Producto nuevoProducto = new Producto(idProducto,  nombre, precio, cantidad);
        //Agrega el nuevoProducto al ArrayList de misProductos
        misProductos.add(nuevoProducto);
        System.out.println("Producto agregado satisfactoriamente");
        
        
    }

    //Muestra el inventario
    public void mostrarInventario() {
        
                        System.out.println("====Mostrar Inventario====");
                        //Repite la informacion del inventario
                        for(Producto producto: misProductos){
                            System.out.println("idProducto: "+producto.getIdProducto());
                            System.out.println("Nombre: "+producto.getNombre());
                            System.out.println("Precio: "+producto.getPrecio());
                            System.out.println("Cantidad: "+producto.getCantidad());
                            System.out.println("==================");
                        }  
                    }
    //Ordena los productos por cantidad
    public void ordenarCantidad(){
                        System.out.println("===Productos por orden de cantidad===");
                        for (int i=0; i < misProductos.size()-1;i++) {
                            for (int j=i+1;j < misProductos.size();j++) {
                                Producto producto1 = misProductos.get(i);
                                Producto producto2 = misProductos.get(j);
                                if (producto1.getCantidad()>producto2.getCantidad()) {
                                    //Intercambia los productos si están en el orden incorrecto
                                    misProductos.set(i,producto2);
                                    misProductos.set(j,producto1);
                               }
                             }
                          }
                        //Repide los productos ordenados
                        for (Producto producto: misProductos) {
                            System.out.println("idProducto: "+ producto.getIdProducto()
                                    +"\nNombre: " + producto.getNombre()
                                    +"\nPrecio: " + producto.getPrecio()
                                    +"\nCantidad: " + producto.getCantidad()
                                    +"\n==================");
                        } 
    }
    //Elimina Producto del Inventario
    public void eliminarProducto(){
        System.out.println("Digite el Id del producto que quiere eliminar");
                    int id = lector.nextInt();
                    boolean encontrado=false;
                    
                    Iterator<Producto> it = misProductos.iterator();
                    while (it.hasNext()){
                        Producto p= it.next();
                        //// Compara el ID del producto con el ID ingresado por el usuario
                        if(p.getIdProducto()== id){
                           // Elimina el producto si se encuentra
                           it.remove();
                           encontrado = true;
                        break;
                       }
                    }
                     if (encontrado) {
                         System.out.println("El producto con id "+id+" ha sido eliminado");
                     } else {
                         System.out.println("No se encontro ningun producto con ese Id");
                 }
        }
    
    //Entrada del Programa
    public static void main(String[] args) {
        //Crea un Objeto de la clase tienda1
        Tienda1 organizador = new Tienda1();
        //Llama al metodo de mostrarmenu de Opciones para la ejecutacion
        organizador.mostrarMenu();
    }
}

    

