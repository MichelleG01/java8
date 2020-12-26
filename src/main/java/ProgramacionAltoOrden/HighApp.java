package ProgramacionAltoOrden;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HighApp {

    private Function<String, String> convertirMayusculas = x -> x.toUpperCase();
    private Function<String, String> convertirMinusculas = x -> x.toLowerCase();

    public static void main(String[] args) {
        HighApp app = new HighApp();
        app.imprimir(app.convertirMayusculas, "michelle");
        app.imprimir(app.convertirMinusculas, "MICHELLE");

        String rpta = app.mostrar("Hola ").apply("A todos");
        System.out.println(rpta);

        List<String> lista = new ArrayList<>();
        lista.add("Como");
        lista.add("Estan");
        lista.add("ComoTodos");

        //app.filtrar(lista, System.out::println, 5, null);
        app.filtrar(lista, System.out::println, 0, "Como");

    }

    public void imprimir(Function<String, String> funcion, String valor) {
        System.out.println(funcion.apply(valor));
    }

    public Function<String, String> mostrar(String mensaje) {
        //Al parametro de entrada vamos a adicionarle a la salida el mensaje que viene como parametro
        return (String x) -> mensaje + x;
    }

    public void filtrar(List<String> lista, Consumer<String> consumidor, int longitud, String cadena) {
        //lista.stream().filter(this.establecerLogicaFiltro(longitud)).forEach(consumidor);
        lista.stream().filter(this.establecerLogicaFiltro(cadena)).forEach(consumidor);
    }

    public Predicate<String> establecerLogicaFiltro(int longitud){
        return texto -> texto.length() < longitud;
    }

    //Sobrecarga de metodos
    public Predicate<String> establecerLogicaFiltro(String cadena){
        return texto -> texto.contains(cadena);
    }


}
