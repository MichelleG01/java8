package Nashorn;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class NashornApp {
    //Estos atributos me van a permitir levantar el motor de javascript en java 8
    private ScriptEngineManager m;
    private ScriptEngine e;
    //Para invocar nuevas funciones
    private Invocable invocador;

    public static void main(String[] args) throws Exception {
        NashornApp app = new NashornApp();
        app.llamarFunciones();
        app.implementarInterfaz();
    }

    public NashornApp() {
        m = new ScriptEngineManager();
        e = m.getEngineByName("nashorn"); //Hacemos referencia al motor que vamos a usar

        invocador = (Invocable)e;
    }

    public void llamarFunciones() throws Exception {
        //Aqui solo vamos hacer el codigo puro de javascript
        //e.eval("print('JS desde Java')");

        e.eval(new FileReader("src/main/java/Nashorn/archivo.js"));

        String rpta = (String) invocador.invokeFunction("calcular", "2", "3");
        System.out.println(rpta); //concatena los string

        double rpta2 = (double) invocador.invokeFunction("calcular", 2, 3);
        System.out.println(rpta2); //suma los datos
    }

    public void implementarInterfaz() throws Exception {
        e.eval(new FileReader("src/main/java/Nashorn/archivo.js"));

        Object implementacion = e.get("hiloImpl"); //Llamamos la referencia del archivo.js
        Runnable r = invocador.getInterface(implementacion, Runnable.class);

        Thread th1 = new Thread(r);
        th1.start();

        Thread th2 = new Thread(r);
        th2.start();
    }

}
