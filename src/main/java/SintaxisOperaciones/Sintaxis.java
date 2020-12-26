package SintaxisOperaciones;

public class Sintaxis {

    public double probarSintaxos() {
        //VideoUno.Operacion operacion = (double x, double y) -> (x+y) / 2;
        //VideoUno.Operacion operacion = (double x, double y) -> {return (x+y) / 2;};

        //Si tengo mas de una linea es bueno utilizar {}, pero com lambda no es recomendable
        //hacer este uso ya que las expreciones deben ser mas legibles
        /*VideoUno.Operacion operacion = (double x, double y) -> {
            double a = 2.0;
            System.out.println(a);
            return (x+y) / 2 + a;
        };*/

        //Indicar sin tipo de parametro
        Operacion operacion = (x, y) -> (x+y) / 2;

        //Se puede definir sin parametros la expresion, tendria que cambiar la interfaz para que no reciba
        //parametros el metodo
        //VideoUno.Operacion operacion = () -> 2;

        return operacion.calcularPromedio(2, 3);


    }

    public static void main(String[] args)  {
        Sintaxis app = new Sintaxis();
        System.out.println(app.probarSintaxos());
    }
}
