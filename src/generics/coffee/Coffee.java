//: generics/coffee/Coffee.java
package generics.coffee;

// 咖啡，用于生成类
public class Coffee {
  private static long counter = 0;
  private final long id = counter++;
  public String toString() {
    return getClass().getSimpleName() + " " + id;
  }
} ///:~
