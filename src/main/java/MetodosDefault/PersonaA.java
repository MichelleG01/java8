package MetodosDefault;

public interface PersonaA {

    public void caminar();

    //El metodo default me lo proporciona Java 8
    default public void hablar() {
        System.out.println("buenos dias - PersonaA");
    }
}
