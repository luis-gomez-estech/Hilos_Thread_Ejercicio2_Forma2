package com.luisgomez;

import java.util.Random;

public class Liebre extends Thread {

    private String nombre;

    private int casillas;

    private long initialTime;

    private int tiempoEntreHilos=1;

    public Liebre(String name, int casillas) {
        super(name);
        this.casillas = casillas;
    }

    @Override
    public void run() {



        while (casillas < 70){


            try {

                Thread.sleep(1000);


            // EXPLICACION (*)

            Random random = new Random();

            int numRandom = random.nextInt(100) + 1; // Genera desde 0 a 99, (el 100 no lo incluye, por tanto le sumamos 1
            // asi obtenemos numeros aleatorios desde 1 hasta 100


            if(numRandom>0&&numRandom<=20){

                casillas +=0;

            } else if (numRandom>20&&numRandom<=40){

                casillas +=9;

            } else if (numRandom>20&&numRandom<=40){

                casillas +=9;

            } else if (numRandom>40&&numRandom<=50){

                casillas -=12;

            }
            else if (numRandom>50&&numRandom<=80){

                casillas +=1;

            }
            else if (numRandom>80&&numRandom<=100){

                casillas -=2;

            }

            // Para que no haya valores por debajo de cero
            if(casillas <0){

                casillas =0;
            }

            // LLamamos al metodo para que aplique e tiempo de espera para volver a imprimir

            //this.esperarXsegundos(tiempoEntreHilos);

            // Con this.getName, obtenemos el nombre de la clase como otras veces, pero en este caso casi q ponerlo a mano

            System.out.println(this.getName() + " - " + casillas + " casillas.");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

        // Si ha llegado a 70 casillas entonces imprime que ha terminado

        System.out.println(Thread.currentThread().getName() + " ha llegado a la meta ");
    }

    /*
    private void esperarXsegundos(int segundos){
        try{
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
    */



    // (*)
        /* Ahora creamos un numero random, y para calcular la probabilodad
             si ese numero esta comprendido entre estos rangos tendra un valor:

            Liebre

            20% - De 0 a 20 - 0 casillas
            20% - De 20 a 40 - 9 casillas positivos
            10% - De 40 a 50 - 12 negativos
            30% - De 50 a 80 - 1 paso positivo
            20% - De 80 a 100 - 2 negativos

            o calculado del 1 al 10

            1 - 0 casillas
            2 - 0 casillas
            3 - 9
            4 - 9
            5 - 12 negativos
            6 - 1
            7 - 1
            8 - 1
            9 - 2 negativos
            10 - 2 negativos

            Tortuga

            50% - De 0 a 50 - 3 positivos
            20% - De 50 a 70 - 6 negativos
            30% - De 70 a 100 - 1 positivo



            */

}


