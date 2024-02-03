package com.proyecto1;

import java.util.Scanner;

/**
 * Este es la clase Main para la interaccion
 */
public class Main {

    public static void main(String[] args) {
        // Instanciando objeto cj de la clase Cajero con un parametro (mi nombre)
        Cajero cj = new Cajero("Angel Chung");

        Scanner sc = new Scanner(System.in);
        // Atributos opciones y dinero
        int opcion = 0;
        // Este atributo nos sirve para pedir al usuario la cantidad que vaya a ingresar para el deposito o retiro.
        double dinero;
        // Imprimiendo la bienvenida con mi nombre
        System.out.println("Bienvenido " +cj.getTitular() + "\n");

        // Usando un loop para que el usuario pueda salir el programa cuando desee (opcion 4).
        while (opcion != 4){
            System.out.println("Empresa de Banco");
            System.out.println("1. Ver balance de la cuenta");
            System.out.println("2. Depositar dinero a la cuenta");
            System.out.println("3. Retirar dinero de la cuenta");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opcion\n");
            // sc.hasNextInt sirve para que el usuario ingrese solo enteros, en caso contrario pasara al else para que vuelva a ingresar numeros enteros
            if (sc.hasNextInt()){
                // Lee la opcion del usuario
                opcion = sc.nextInt();

                // Fuera del rango 1 al 4 debera ingresar nuevamente las opciones hasta que se cumpla
                if (opcion < 1 || opcion > 4){
                    System.out.println("Error, elija una opcion valida");
                    continue;
                }
                // Imprime el balance total de la cuenta
                if (opcion == 1){
                    System.out.println("Su cuenta tiene una cantidad de $" +cj.getTotalDinero());
                    continue;
                }
                // Creando una variable condicion true
                boolean condicion = true;
                // while por si el usuario ingresa un numero menos o igual que cero (0)
                while (condicion) {
                    // Deposita dinero a la cuenta y su saldo aumentara
                    if (opcion == 2) {
                        System.out.println("Ingrese la cantidad a depositar");
                        dinero = sc.nextDouble();
                        /*Si es menor que cero, se imprime un mensaje y un continue que volvera al while (condicion)
                         que aun sera true y debera ingresar nuevamente la cantidad*/
                        if (dinero <= 0) {
                            System.out.println("Error al depositar. Intente nuevamente.");
                            continue;
                        }
                        // Ha cumplido y ha depositado correctamente
                        System.out.println("Ha depositado $" +dinero + " Correctamente.");
                        // Asignando el valor dinero
                        cj.setDinero(dinero);
                        // llama al metodo y hace la operacion
                        cj.depositoCuenta();
                    }
                    /* Si se cumple con todo (osea que no entra al if (dinero <= 0)), la condicion sera falsa y se terminara
                       el bloque while de la variable condicion
                    */
                    condicion = false;
                }
                // Asignamos true a la condicion para que sea verdadera nuevamente para preparar y esperar la opcion del usuario
                condicion = true;
                while (condicion){

                    if (opcion == 3) {
                        System.out.println("Ingrese la cantidad a retirar");
                        dinero = sc.nextDouble();
                        // Si es mayor que el total, debera ingresar nuevamente la cantidad a retirar.
                        if (dinero > cj.getTotalDinero()) {
                            System.out.println("No tiene suficiente dinero para retirar. Intente nuevamente.");
                            // Regresa al while para que ingrese nuevamente la cantidad a retirar
                            continue;
                        }
                        // En caso contrario, se hace el retiro exitosamente.
                        System.out.println("Ha retirado $ " +dinero + " Correctamente.");
                        cj.setDinero(dinero);
                        cj.retiroCuenta();
                    }
                    // condicion false para salir del loop while y regresar al menu de opciones
                    condicion = false;
                }
                // Salir del programa
                if (opcion == 4){
                    System.out.println("Hasta pronto " +cj.getTitular() +"!");
                }
            /* Si se ingresa un caracter o cualquier otra cosa que no sea numero al sc.hasNextInt()
               se imprimira el mensaje de error y se borrara el dato ingresado por el usuario para que vuelva a
               ingresar un nuevo dato (INT).
             */
            } else {
                System.out.println("Error, Ingrese un numero entero.");
                sc.next();
            }


        }
    }
}