package ForEachRemovelfSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ColeccionApp {

    private List<String> lista;

    public static void main(String... mitocode) {
        ColeccionApp app = new ColeccionApp();
        app.llenarLista();
        //app.usarRemoveIf();
        app.usarSort();
        app.usarForEach();
    }

    public void llenarLista() {
        lista = new ArrayList<>();

        lista.add("Hola");
        lista.add("Sofkianos");
        lista.add("Que tal!");
    }

    public void usarForEach() {
        //Forma tradicional para recorrer el ArrayList
		/*for(String elemento : lista){
			System.out.println(elemento);
		}*/

        //Este .forEach, este metodo pide un consumer que es una interfaz funcional, que tiene un metodo asep
        //Y este recibe una logica que implementemos o una expresion lambda
        //lista.forEach(x -> System.out.println(x));

        //Con referencia a metodos
        lista.forEach(System.out::println);

    }

    public void usarRemoveIf() {
        ///Forma tradiconal de eliminar un elemento
		/*Iterator<String> it = lista.iterator(); //Para que al eliminar en el cliclo no arroje error de concurrent
		while(it.hasNext()){ //Recorremos hasta que tenga elementos
			if(it.next().equalsIgnoreCase("Code")){
				it.remove();
			}
		}*/

        //.removeIf Hace uso de los predicados
        lista.removeIf(x -> x.equalsIgnoreCase("Code"));

    }

    public void usarSort() {
        //Para ordenar haciamos use de:
        //Collections.sort(lista);

        lista.sort((x,y)-> x.compareTo(y));
    }

}
