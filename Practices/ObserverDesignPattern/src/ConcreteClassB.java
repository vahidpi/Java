import java.util.Observable;
import java.util.Observer;

public class ConcreteClassB implements Observer {
    private String name;

    public ConcreteClassB(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable observable, Object o) {
        Celebrity c = (Celebrity) observable;
        String message = String.format("BB %s received %s From %s", name, o.toString(), c.getName());
        System.out.println(message);
    }
}
