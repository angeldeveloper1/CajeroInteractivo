package com.proyecto1;

/**
 * Simular la interaccion de un cajero
 * Mostrar saldo actual
 * Depositar dinero a la cuenta
 * Retirar dinero de la cuenta
 */
public class Cajero {
    /*
    Aqui he creado 3 atributos. titular para mostrar nombre, dinero para poder hacer deposito o retiro y total dinero
    para poder guardar y hacer operaciones.
     */
    private String titular;
    private double dinero;
    private double totalDinero;

    // Aqui he creado un constructor con 1 parametro (titular) para poder llamarlo en la clase Main y poner un nombre
    // En este caso he puesto el mio (Angel Chung).
    public Cajero (String titular) {
        this.titular = titular;
    }
    // Un Get titular para poder llamarlo en el Main y mostrar el titular.
    public String getTitular() {
        return titular;
    }
    // Un Set dinero para poder ingresar la cantidad de dinero (deposito o retiro)
    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    // Un get total dinero para poder imprimir el balance de la cuenta
    public double getTotalDinero() {
        return totalDinero;
    }
    // Metodo para hacer el deposito a la cuenta
    void depositoCuenta() {
        this.totalDinero+=dinero;
    }
    // Metodo para hacer retiros de la cuenta
    void retiroCuenta(){
        this.totalDinero-=dinero;
    }

}
