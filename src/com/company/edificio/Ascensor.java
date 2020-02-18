package com.company.edificio;

public class Ascensor {
    int cont=0;
    int numP=0;
    int limitPerson;
    int limitPiso;

    public Ascensor(int limitPiso, int limitPerson) {
        this.limitPiso = limitPiso;
        this.limitPerson = limitPerson;
    }

    public int getCont() {
        return cont;
    }

    public synchronized void entrar(int numPiso){
        try {
            while (numP != numPiso || cont==limitPerson){
                wait();
            }
            cont++;
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void notificar(){
        notifyAll();
    }

    public synchronized void salir(int numPiso) {
        try {
            while (numP !=numPiso || cont==0) wait();
            cont--;
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        notifyAll();
    }
}
