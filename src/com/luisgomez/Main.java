package com.luisgomez;

public class Main {

    public static void main(String[] args) {

        // Mensaje inicial

        System.out.println();

        System.out.println("¡¡Comienza la Carrera!!");

        System.out.println();

        // obtenemos el tiempo inicial

        long startTime = System.currentTimeMillis();

        // Variables que van a ir contando el tiempo de cada hilo

        long tiempoTortuga=0;
        long tiempoLiebre=0;

        //Creacion de los procesos o hilos

        Liebre liebre = new Liebre("Liebre",0);
        Tortuga tortuga = new Tortuga("Tortuga",0);


        //iniciamos los hilo

        liebre.start();
        tortuga.start();


        // Ahora en el main obtenemos lso calculos para saber quien ha llegadp antes, despues o a la vez
        //Para ello, por un lado usamos isAlive el cual nos devuleve true o false,
        // y asi vamos a ir comprobando si los hilos continuan en marcha o han terminado
        // y asi, vamos a calcular cuanto tiempo lleva cada uno desde el principio hasta el final de cada hilo


        while (liebre.isAlive() || tortuga.isAlive()){

            long tiempo = System.currentTimeMillis() - startTime;

            if (liebre.isAlive()){
                tiempoLiebre = tiempo;
            }

            if (tortuga.isAlive()){
                tiempoTortuga = tiempo;
            }
        }


        // Una vez acaban los hilos, y dependiendo del tiempo que ha tardado cada uno en llegar, imprime quien ha ganado

        if (tiempoLiebre == tiempoTortuga){

            System.out.println("Empate");

        } else if (tiempoLiebre > tiempoTortuga){

            System.out.println("La Tortuga ha ganado la carrera");

        } else {

            System.out.println("La Liebre ha ganado la carrera");
        }
    }
}
