public class Main {

    public static void main(String[] args){

        Celebrity celeb1 = new Celebrity( "Celeb1");
        Celebrity celeb2 = new Celebrity( "Celeb2");

        ConcreteClassA follower1 = new ConcreteClassA( "Follwer1");
        ConcreteClassB follower2 = new ConcreteClassB( "Follwer2");
        ConcreteClassA follower3 = new ConcreteClassA( "Pollwer3");

        celeb1.addObserver(follower1);
        celeb1.addObserver(follower2);

        celeb2.addObserver(follower3);
        celeb2.addObserver(follower2);

        celeb1.tweet("Message 1");
        celeb2.tweet("Message 1");

        System.out.println("-———-----");

        celeb1.deleteObserver(follower1);
        celeb2.addObserver(follower1);

        celeb1.tweet("Message 2");
        celeb2.tweet("Message 2");
    }
}
