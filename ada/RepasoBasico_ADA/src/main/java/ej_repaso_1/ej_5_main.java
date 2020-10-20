package ej_repaso_1;

/**
 *
 * @author amrsin
 */
public class ej_5_main {

    public static void main(String[] args) {
        //var
        int num_random;
        int num;
        int num_aleatorios[] = new int[15];
        boolean encontrado = false;

        //bucle para buscar random y añadir random a num_aleatorios[]
        for (int i = 0; i < num_aleatorios.length; i++) {

            num_random = (int) (Math.random() * 90 + 1);
            //bucle para comprobar si existe el random
            for (int j = 0; j < num_aleatorios.length; j++) {
                //si existe volvemos una posicion atras en el bucle i    
                if (num_random == num_aleatorios[j]) {
                    encontrado = true;
                    i--;
                    break;
                }
            }
            // si no se ha encontrado añadimos el num_random al array
            if (!encontrado) {

                num_aleatorios[i] = num_random;

            }

            encontrado = false;
        }
        System.out.println("----------------");
        System.out.println("Carton bingo");
        //bucle para imprimir contenido array
        for (int i = 0; i < num_aleatorios.length; i++) {

            System.out.print(num_aleatorios[i] + "|");
        }
    }
}
