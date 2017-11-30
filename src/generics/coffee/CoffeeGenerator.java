//: generics/coffee/CoffeeGenerator.java
// Generate different types of Coffee:产生不同类型的咖啡
package generics.coffee;

import java.util.*;
import cn.demon96.util.*;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
	private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};
	private static Random rand = new Random(47);

	// For iteration: 有参数时的生成次数
	private int size = 0;

	public CoffeeGenerator() {
	}
	
	public CoffeeGenerator(int sz) {
		size = sz;
	}

	@Override
	public Coffee next() {
		try {
			return (Coffee) types[rand.nextInt(types.length)].newInstance();
			// 随机生成一个子类
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 返回的迭代器
	class CoffeeIterator implements Iterator<Coffee> {
		int count = size;

		public boolean hasNext() {
			return count > 0;
		}

		public Coffee next() {
			count--;
			return CoffeeGenerator.this.next();
		}

		public void remove() { // Not implemented
			throw new UnsupportedOperationException();
		}
	};

	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}

	public static void main(String[] args) {
		CoffeeGenerator gen = new CoffeeGenerator();
		for (int i = 0; i < 5; i++)
			System.out.println(gen.next());
		for (Coffee c : new CoffeeGenerator(5))
			System.out.println(c);
	}

}/* Output:
Americano 0
Latte 1
Americano 2
Mocha 3
Mocha 4
Breve 5
Americano 6
Latte 7
Cappuccino 8
Cappuccino 9
*///:~

