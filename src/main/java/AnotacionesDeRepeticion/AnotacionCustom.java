package AnotacionesDeRepeticion;

public @interface AnotacionCustom {

    String nombre();
    boolean habilitado() default true;
}