package MetodosDefault;

public interface PersonB {

    default public void hablar() {
        System.out.println("buenas noches - en PersonasB");
    }

}
