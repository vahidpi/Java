import Entities.BMW;
import Entities.Ford;
import Entities.Honda;
import Entities.ICar;

public class CarFactory {
    public static ICar getCar(String type) throws Exception{
        ICar car;
        if(type=="B")
            car=new BMW();
        else if(type=="F")
            car=new Ford();
        else if(type=="H")
            car=new Honda();
        else
            throw new Exception("Not valid type");

       return car;
    }
}
