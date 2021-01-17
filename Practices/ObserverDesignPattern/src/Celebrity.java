import java.util.Observable;

public class Celebrity extends Observable {
    public String getName() {
        return name;
    }

    private String name;

    public Celebrity(String name) {
        this.name = name;
    }

    public void tweet(String message){
        System.out.println(name+" said"+message);
        setChanged();
        notifyObservers(message);
    }
}
