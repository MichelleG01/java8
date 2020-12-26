package Streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsApp {
    private List<String> lista;
    private List<String> numeros;

    public static void main(String[] args) {
        StreamsApp app = new StreamsApp();
        //app.filtrar();
        //app.ordenar();
        //app.transformar();
        //app.limitar();
        app.contar();
    }

    public StreamsApp(){
        lista = new ArrayList<>();
        lista.add("Hola");
        lista.add("Sofkianos");
        lista.add("Que tal!");
        lista.add("Bienvenidos");

        numeros = new ArrayList<>();
        numeros.add("1");
        numeros.add("2");
    }

    public void filtrar(){
        //Lo filtramos y despues lo imprimimos
        lista.stream().filter(x -> x.startsWith("M")).forEach(System.out::println);
    }

    public void ordenar(){
        //Ordener de fotma descendente
        //lista.stream().sorted().forEach(System.out::println);

        //Ordenar de forma ascendente
        lista.stream().sorted((x,y)-> y.compareTo(x)).forEach(System.out::println);
    }

    public void transformar(){
        //Si quiero transformar los elementos en mayuscula. Map hace esta transformacion
        //lista.stream().map(String::toUpperCase).forEach(System.out::println);

        //Si quiero transformar los datos a enteros y a ese elemento sumarle 1
		/*for(String x : numeros){
			int num = Integer.parseInt(x) + 1;
			System.out.println(num);
		}*/
        //Lo anterior pero con stream
        numeros.stream().map(x -> Integer.parseInt(x) + 1).forEach(System.out::println);
    }

    public void limitar(){
        lista.stream().limit(2).forEach(System.out::println);
    }

    public void contar(){
        long x = lista.stream().count();
        System.out.println(x);
    }

}
