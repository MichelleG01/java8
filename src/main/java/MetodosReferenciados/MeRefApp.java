package MetodosReferenciados;

import java.util.Arrays;
import java.util.Comparator;

public class MeRefApp {

    public static void main(String[] args)  {
        //Para hacer uso de los metodos referenciados debemos utilizar interfaz funcional
        //Con los metodos referenciados no aceptan parametros hasta el momento, por un tema de currificacion

        MeRefApp app = new MeRefApp();
        //app.operar();
        //app.referenciarMetodoInstanciaObjetoArbitrario();

        //Esta interfaz tiene un unico metodo que es saludar y la extamos implementando con la expresion
        //de la derecha (es un metodo de instancia )
        //Operacion op = app::referenciarMetodoInstanciaObjetoParticular;
        //op.saludar();

        app.referenciarConstructor();

    }

    public static void referenciarMetodoStatic() {
        System.out.println("Método Referido static");
    }

    public void referenciarMetodoInstanciaObjetoArbitrario() {
        String[] nombres = { "Mito", "Code", "Jaime" };

        /*
        Arrays.sort(nombres, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        }); */

        //Expresion lambda
        //Arrays.sort(nombres, (s1,s2) -> s1.compareToIgnoreCase(s2));
        //System.out.println(Arrays.toString(nombres));

        //Esto es un metodo de instancia y no estatico, porque estoy llamando al metodo que es practicamente
        //de la instancia de la variable que viene en el array
        Arrays.sort(nombres, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(nombres));
    }

    public void referenciarMetodoInstanciaObjetoParticular() {
        System.out.println("Método Referido Instancia de Objeto en particular");
    }

    public void referenciarConstructor() {
        /*
        IPersona iper = new IPersona(){
            //Implementacion anonima
            @Override
            public Persona crear(int id, String nombre) {
                return new Persona(id, nombre); }

        };
        iper.crear(1, "MitoCode"); */

        //Con lambda
        //IPersona iper2 = (x,y)->(new Persona(x,y));
        //Persona per = iper2.crear(1, "MitoCode");
        //System.out.println(per.getId()+" - "+per.getNombre());

        //Con metodos referenciados
        IPersona iper3 = Persona::new;
        Persona per = iper3.crear(1, "MitoCode");
        System.out.println(per.getId() + " - " + per.getNombre());
    }

    public void operar() {
        //Operacion op = () -> MeRefApp.referenciarMetodoStatic();
        //op.saludar();
        //Sustituir la referencia lambda anterior por una referencia a un metodo
        Operacion op2 = MeRefApp::referenciarMetodoStatic;
        op2.saludar();
    }

}
