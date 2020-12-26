package RxJava;

import rx.Observable;
import rx.functions.Action1;

import java.util.ArrayList;
import java.util.List;

public class RxJavaApp {
    private List<Integer> lista1;
    private List<Integer> lista2;

    public static void main(String[] args) {
        /* List<String> lista = new ArrayList<>();
         lista.add("Estamos");
         lista.add("Aprendiendo");
         lista.add("Rx");

         Observable<String> obs = Observable.from(lista);
         obs.subscribe(new Action1<String>(){
             @Override
             public void call(String elemento) {
                System.out.println(elemento);
            }
         }); */

        RxJavaApp app = new RxJavaApp();
        app.buscar();

    }

    public RxJavaApp() {
        lista1 = new ArrayList<>();
        lista2 = new ArrayList<>();
        this.llenarListas();
    }

    public void llenarListas() {
        for (int i = 0; i < 10000; i++) {
            lista1.add(i);
            lista2.add(i);
        }
    }

    public void buscar() {
        Observable<Integer> obs1 = Observable.from(lista1);
        Observable<Integer> obs2 = Observable.from(lista2);

        //El merge me va a permitir unir dos observables para obtener un unico resultado
        //Como es asincrono no toma tanto tiempo si fuera secuencial debemos comparar
        //si una lista tiene el uno y despues con la otra lista
		/*Observable.merge(obs1, obs2).subscribe(new Action1<Integer>(){
			@Override
			public void call(Integer numero) {
				if(numero == 1){
					System.out.println(numero);
				}
			}
		}); */

		//Lo anterior en una expresion lambda
        Observable.merge(obs1, obs2).filter(x -> x==1).subscribe(System.out::println);
        Observable.merge(obs1, obs2).filter(x -> x==1).subscribe(x -> {
            if(x == 1){
                System.out.println(x);
            }
        });
    }

}
