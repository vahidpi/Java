import java.util.Observable;
import java.util.Observer;

public class ConcreteClassA implements Observer {
    private String name;

    public ConcreteClassA(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable observable, Object o) {
        Celebrity c = (Celebrity) observable;
        String message = String.format("AA %s received %s From %s", name, o.toString(), c.getName());
        System.out.println(message);
    }
}
