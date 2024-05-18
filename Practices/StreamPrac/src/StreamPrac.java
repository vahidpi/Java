import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
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
//    System.out.println("Hello World, Java app");
//    staticMethod();
//
    StreamPrac streamPrac = new StreamPrac();
//
//    streamPrac.publicNonStaticMethodInClass();
//    streamPrac.privateNonStaticMethodInClass();
//
//    example1();
//    streamPrac.example2();
//    example3();
//    streamPrac.example4();

    //streamPrac.exFunc();

    // 1
    //    Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
    //    for (int number : streamPrac.findUniqueNumbers2(numbers))
    //      System.out.println(number);

    // 2
    // int x = nthLowestSelling(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
    // System.out.println(x);

    // 3

      boolean[][] matrix = new boolean[][] {
          {false, true, false, false, true},
          {true, false, false, false, false},
          {false, false, false, true, false},
          {false, false, true, false, false},
          {true, false, false, false, false}
      };
      System.out.println(getMinimumConnections2(matrix)); // should print 1

  }
  private static class UnionFind {
    private int[] parent;
    private int count;

    public UnionFind(int n) {
      parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
      count = n;
    }

    public int find(int p) {
      while (p != parent[p]) {
        parent[p] = parent[parent[p]];
        p = parent[p];
      }
      return p;
    }

    public void union(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);
      if (rootP == rootQ) {
        return;
      }
      parent[rootP] = rootQ;
      count--;
    }

    public int count() {
      return count;
    }
  }

  public static int getMinimumConnections2(boolean[][] matrix){
    int n = matrix.length;
    int[] parent = new int[n];
    int count = n;

    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j]) {
          int root1 = find(parent, i);
          int root2 = find(parent, j);
          if (root1 != root2) {
            parent[root1] = root2;
            count--;
          }
        }
      }
    }

    return count - 1;
  }

  private static int find(int[] parent, int i) {
    while (parent[i] != i) {
      parent[i] = parent[parent[i]];
      i = parent[i];
    }
    return i;
  }

  public static int getMinimumConnections(boolean[][] matrix) {
    int n = matrix.length;
    UnionFind uf = new UnionFind(n);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j]) {
          uf.union(i, j);
        }
      }
    }

    return uf.count() - 1;
  }

  public static int nthLowestSelling(int[] sales, int n) {
    Map<Integer, Integer> bookSales = new HashMap<>();
    for (int sale : sales) {
      bookSales.put(sale, bookSales.getOrDefault(sale, 0) + 1);
    }

    List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(bookSales.entrySet());
    sortedEntries.sort(Map.Entry.comparingByValue());

    if (n > sortedEntries.size()) {
      throw new IllegalArgumentException("n is larger than the number of distinct book sales");
    }

    return sortedEntries.get(n - 1).getKey();
  }



  public Collection<Integer> findUniqueNumbers2(Collection<Integer> numbers) {
    return numbers.stream()
        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() == 1)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());

  }

  public Collection<Integer> findUniqueNumbers(Collection<Integer> numbers){
    Map<Integer, Integer> frequency = new HashMap<>();
    for (int num : numbers) {
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    }
    Set<Integer> result = new HashSet<>();
    for (int num : frequency.keySet()) {
      if (frequency.get(num) == 1) {
        result.add(num);
      }
    }
    return result;


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
