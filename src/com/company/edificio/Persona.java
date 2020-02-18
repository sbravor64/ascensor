package com.company.edificio;

public class Persona extends Thread {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    String nom;
    Ascensor ascensor;
    int numPisoEntrada;
    int numPisoSalida;

    public Persona(String nom, Ascensor ascensor, int numPisoEntrada, int numPisoSalida) {
        this.nom = nom;
        this.ascensor = ascensor;
        this.numPisoEntrada = numPisoEntrada;
        this.numPisoSalida = numPisoSalida;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        for(;;){
                ascensor.entrar(numPisoEntrada);
                System.out.println(ANSI_RED + getNom() + " entra al ascensor | Sale en el " + numPisoSalida + "º" + ANSI_RESET);

                ascensor.salir(numPisoSalida);
                System.out.println(ANSI_GREEN + getNom() + " sale del ascensor" + ANSI_RESET);

                break;
        }
    }
}
