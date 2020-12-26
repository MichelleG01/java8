package AnotacionesDeRepeticion;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class App {

    public static void main(String[] args) {
        //Invocamos el arrary de anotaciones
        Lenguaje[] lenguajeArray = LenguajeProgramacion.class.getAnnotationsByType(Lenguaje.class);
        System.out.println("Se tiene " + lenguajeArray.length + " anotaciones en Lenguaje[]");

        //Si quiero saber que anotaciones hay, nos apoyamos en el api reflections
        Lenguajes len = LenguajeProgramacion.class.getAnnotation(Lenguajes.class);
        for(Lenguaje elemento : len.value()) {
            System.out.println(elemento.value());
        }

    }

    //Por default el scout de la retencion (el ambito de esta anotacion) es clase, pero hay un ambito que debemos
    //especificar cuando estamos ejecutando el codigo y este ambito es RUNTIME
    @Retention(RetentionPolicy.RUNTIME)
    //Creacion de anotacion customizable
    public @interface Lenguajes {
        Lenguaje[] value() default {}; //Aqui hacemos referencia de que estamos utilizando un arreglo
        //con una anotacion llamada Lenguaje
    }

    @Repeatable(value = Lenguajes.class) //Con esto indicamos que las anotaciones repetidas sean leidas por la jbm
    public @interface Lenguaje{ //Aqui creamos ese arreglo
        String value();
        //Estas serian anotaciones lineales
        String nombreUsuario() default "Michelle";
    }

    //Indicamos algunos elementos descriptivos  que tipo de lenguajes es
    //Para las 1.7 hacia abajo se hacia de esta forma
	/*@Lenguajes({
		@Lenguaje("Java"),
		@Lenguaje("Python")
	})*/
    //En la version 1.8
    @Lenguaje("Java")
    @Lenguaje("Python")
    public interface LenguajeProgramacion{

    }

}
