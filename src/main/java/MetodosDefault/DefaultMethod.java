package MetodosDefault;

public class DefaultMethod implements  PersonaA, PersonB{

    public static void main(String[] args)  {
        DefaultMethod app = new DefaultMethod();
        app.caminar();
        app.hablar();
    }

    @Override
    public void caminar() {
        System.out.println("Hola");
    }

    @Override
    public void hablar() {
        //PersonaA.super.hablar();
        //Si lo vamos a sobreescribir
        System.out.println("Sofka");
    }
}
