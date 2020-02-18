package com.company.edificio;

import java.util.ArrayList;
import java.util.List;

public class Edificio {
    public static void main(String[] args) {

        Ascensor ascensor = new Ascensor(10, 5);

        Motor motor = new Motor(ascensor);
        List<Persona> personas = new ArrayList<>();

//        Persona andres = new Persona("Andres", ascensor, 2, 9);
//        Persona roberto = new Persona("Roberto", ascensor, 2, 5);
//        Persona rodrigo = new Persona("Rodrigo", ascensor, 4, 1);
//        Persona jesus = new Persona("Jesus", ascensor, 3, 6);
//        Persona marco = new Persona("Marco", ascensor, 1, 10);
//
//        personas.add(andres);
//        personas.add(roberto);
//        personas.add(rodrigo);
//        personas.add(jesus);
//        personas.add(marco);

        for (int i = 1; i < 20 ; i++) {
            int pisoE = (int) Math.floor(Math.random()*10+1);
            int pisoS = (int) Math.floor(Math.random()*10+1);

            if(pisoE==pisoS) pisoE = (int) Math.floor(Math.random()*10+1);

            Persona persona = new Persona("persona " + i, ascensor, pisoE,pisoS);
            personas.add(persona);
        }

        motor.start();

        for (Persona p: personas) {
            p.start();
        }

    }
}
