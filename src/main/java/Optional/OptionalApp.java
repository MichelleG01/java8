package Optional;

import java.util.Optional;

public class OptionalApp {

    public static void main(String[] args) {
        OptionalApp app = new OptionalApp();
        app.probar(null);
        //app.orElse(null);
        app.orElse("Hola");
        //app.orElseThrow("Como");
        app.isPresent("Estas");
    }

    public void probar(String valor){
        //System.out.println(valor.contains("Hola"));

        try{
            Optional op = Optional.empty(); //Creamos un objeto optional vacio
            op.get();
        }catch(Exception e){
            System.out.println("No hay elemento");
        }
    }

    public void orElse(String valor){
        //Si nuestro valor acepta nulos debemos utilizar el ofNullable
        Optional<String> op = Optional.ofNullable(valor);
        //Si el valor el nulo vamos a definirle un valor por defecto
        String x = op.orElse("predeterminado");
        System.out.println(x);
    }

    public void orElseThrow(String valor){
        Optional<String> op = Optional.ofNullable(valor);
        ///Si el valor es nulo podemos lanzar una excepcion
        op.orElseThrow(NumberFormatException::new);
    }

    public void isPresent(String valor){
        Optional<String> op = Optional.ofNullable(valor);
        //Para validar si el valor a sido inicializado o no
        System.out.println(op.isPresent());
    }

}
