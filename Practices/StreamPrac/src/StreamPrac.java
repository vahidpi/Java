import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPrac {

  List<String> stringList = List.of("Adorable"
      , "Beverage"
      , "Caramelized"
      , "Dina"
      , "Eloquent"
      , "Flamboyant"
      , "Gali"
      , "Holographic"
      , "Incandescent"
      , "Juxtaposition");

  public static void main(String[] args) {
    System.out.println("Hello World, Java app");
    staticMethod();

    StreamPrac streamPrac = new StreamPrac();

    streamPrac.publicNonStaticMethodInClass();
    streamPrac.privateNonStaticMethodInClass();

    example1();
    streamPrac.example2();
    example3();
    streamPrac.example4();
  }

  static void staticMethod() {
    System.out.println("Static method can be called directly.");
  }

  public void publicNonStaticMethodInClass() {
    System.out.println("Public methods (non static) must be called by creating objects.");
  }

  private void privateNonStaticMethodInClass() {
    System.out.println("Private methods (non static) must be called by creating objects.");
  }

  static void example1() {
    // Suppose you have a list of integers, and you want to calculate the sum of all the even numbers in the list.
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    int sum = numbers.stream()
        .filter(num -> num % 2 == 0)
        .mapToInt(Integer::intValue) // convert to primitive int
        .sum();
    System.out.println(sum);
  }

  public void example2() {
    // Given a list of strings, filter out all strings that have length less than 5.
    List<String> out = stringList.stream().filter(str -> str.length() < 5)
        .collect(Collectors.toList()); // collect the filtered words into a new list
    System.out.println(out);
  }


  static void example3() {
    // Given a list of integers, calculate the sum of all the squares of even numbers.
    List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    int sum = integerList.stream()
        .filter(n -> n % 2 == 0)
        .map(n -> n * n)
        .reduce(0, Integer::sum); // calculate the sum of the squares
    System.out.println("example3," + sum);
  }

  public void example4() {
    // Given a list of strings, find the first string that starts with the letter "A".
    String startWithA = stringList.stream()
        .filter(str -> str.toUpperCase().startsWith("A"))
        .findFirst()
        //.get();
        .orElse("Not found");
    System.out.println("example4," + startWithA);
  }
  // .map(BigDecimal::new)   ?
  //  .orElse(/*some default value*/);

  /*
   * Given a list of strings, filter out all strings that have length less than 5.
   * Given a list of integers, calculate the sum of all the squares of even numbers.
   * Given a list of strings, find the first string that starts with the letter "A".
   * Given a list of integers, find the maximum value.
   * Given a list of strings, sort the strings in descending order of length.
   * Given a list of integers, create a new list that contains only the distinct elements of the original list.
   * Given a list of strings, concatenate all the strings together into a single string.
   * Given a list of integers, calculate the product of all the odd numbers.
   * Given a list of strings, count the number of strings that contain the letter "e".
   * Given a list of integers, create a new list that contains only the even numbers in the original list.
   */
}
