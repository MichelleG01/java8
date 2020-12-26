package SintaxisOperaciones;

import java.util.*;

public class LambdaApp {

    public void ordenar() {
        List<String> lista = new ArrayList<>();
        lista.add("MitoCode");
        lista.add("Code");
        lista.add("Mito");

        //Como lo necesito (Enfoque imperativo)
        /* Collections.sort(lista, new Comparator<String>() {
            @Override
            public int compare (String o1, String o2){
                return o1.compareTo(o2);
            }
        }); */

        //Que es lo que necesito (Enfoque declarativo)
        Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));

        for (String elemento : lista) {
            System.out.println(elemento);
        }
    }

    public void calcular() {

        /*VideoUno.Operacion operacion = new VideoUno.Operacion() {
            //Clase anonima
            @Override
            public double calcularPromedio(double n1, double n2) {
                return (n1 + n2) / 2;
            }
        };
        System.out.println(operacion.calcularPromedio(2, 3)); */

        Operacion operacion = (double x, double y) -> (x+y) / 2;
        System.out.println(operacion.calcularPromedio(2, 3));

    }

    public static void main(String[] args)  {
        LambdaApp app = new LambdaApp();
        app.ordenar();
        app.calcular();
    }
}
