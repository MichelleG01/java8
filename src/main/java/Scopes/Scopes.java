package Scopes;

import SintaxisOperaciones.Operacion;

public class Scopes {

    private static double atributo1;
    private double atributo2;

    public double probarLocalVariable() {
        //Para una clase anonima o para una expresion anonima el scopes es igual, la variable debe ser final
        final double n3 = 3;
        OperacionDos op = new OperacionDos() {
            @Override
            public double calcular(double n1, double n2) {
                return n1 + n2 + n3;
            }
        };

        Operacion operacion = (x,y) -> {
            return x + y + n3;
        };
        return  op.calcular(1, 1);
    }

    public double probarAtributosStaticVariables() {
        //Probar cuando se define variables globales

        //En el jdk 1.7 hacia atras esel mismo comportamiento para objetos anonimos
        Operacion op = new Operacion() {
            @Override
            public double calcularPromedio(double n1, double n2) {
                atributo1 = n1 + n2;
                atributo2 = atributo1;
                return (atributo2);
            }
        };

        OperacionDos operacion = (x, y) -> {
            atributo1 = x + y;
            atributo2 = atributo1;
            return (atributo2);
        };
        return operacion.calcular(3, 2);
    }

    public static void main(String[] args)  {
        Scopes app = new Scopes();
        //System.out.println(app.probarLocalVariable());
        System.out.println(app.probarAtributosStaticVariables());
    }
}
