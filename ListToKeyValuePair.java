import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.HashMap;

/* Given flolowing list. What is the best possible way to make a key
 * value (Character, Integer) pair from its object using only the
 * latest java features?
 */

public class ListToKeyValuePair {
  public static void main(String[] args) {
    
    var v1 = IntStream.rangeClosed(97, 122).boxed().collect(Collectors.toList());
    //Option 1
    var opt1 = v1.stream().collect(Collectors.toMap(e -> Character.toChars(e)[0], e -> e));
    //Option 2
    var opt2 = new HashMap<Character, Integer>();
    for (Integer i : v1) {
      opt2.put((char)(int) i, i);
    }
    //Option 3
    var opt3 = v1.stream().collect(Collectors.toMap(e -> (char)(int) e, e -> e));
    //Option 4
    var opt4 = v1.stream().collect(Collectors.toMap(e -> Character.getCharacter(e), e -> Integer.getInteger(e)));
    //Option 5
    var opt5 = v1.stream().collect(Collectors.toKeyValuePair(e -> (char)e, e -> e));

    //System.out.println("Result: "+optX);
  }
}
