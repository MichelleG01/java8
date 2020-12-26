package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapApp {
    private Map<Integer, String> map;

    public static void main(String[] args) {
        MapApp app = new MapApp();
        app.poblar();
        //app.imprimir_v7();
        //app.insertarSiAusente();
        //app.imprimir_v8();
        //app.operarSiPresente();
        //app.obtenerOrPredeterminado();
        app.recolectar();
    }

    public void poblar() {
        map = new HashMap<>();
        map.put(1, "Hola");
        map.put(2, "Como");
        map.put(3, "Rstas");
    }

    public void imprimir_v7() {
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.println("Llave: " + e.getKey() + " Valor: " + e.getValue());
        }
    }

    //En la version 1.8
    public void imprimir_v8() {
        //Por estantar la k de key y la v de value
        //map.forEach((k,v) -> System.out.println("Llave: " + k + " Valor: " + v));
        map.entrySet().stream().forEach(System.out::println);
    }

    public void recolectar() {
        //Esta operacion se utiliza mucho con listas o con mapas
        //Si tenemos un conjunto de elementos en un mapa o lista y queremos filtrar esos elementos
        //bajo un criterio y si este criterio obedece extraer esos elementos a otra lista o mapa
        Map<Integer, String> mapaRecolectado = map.entrySet().stream()
                .filter(e -> e.getValue().contains("o"))
                //aqui armamos llave y valor
                .collect(Collectors.toMap(p -> p.getKey(), p-> p.getValue()));
        //Imprimir mapa
        mapaRecolectado.forEach((k,v)-> System.out.println("Llave: " + k + " Valor: " + v));
    }

    public void insertarSiAusente() {
        //Agregar un valor si no se encuentra, no sobreescribe
        map.putIfAbsent(4, "Michelle"); //aqui si lo agrega
        map.putIfAbsent(2, "Michelle"); //aqui no
    }

    public void operarSiPresente() {
        //Si se encutra la llave 3 hace la operacion
        map.computeIfPresent(3, (k,v)-> k + v);
        System.out.println(map.get(3));
    }

    public void obtenerOrPredeterminado() {
        //Si el numero 5 no tiene valor pone ese por defecto
        String valor = map.getOrDefault(5, "valor por defecto");
        System.out.println(valor);
    }

}
