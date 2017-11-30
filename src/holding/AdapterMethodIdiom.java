//: holding/AdapterMethodIdiom.java
//The "Adapter Method" idiom allows you to use foreach“适配器方法”这个习语允许您使用foreach
//with additional kinds of Iterables.使用其他类型的Iterables。
package holding;
import java.util.*;

/**
 * 反向迭代器
 * Iterable的接口包含一个能产生Iterator的方法，可用foreach
 */
class ReversibleArrayList<T> extends ArrayList<T> {
	public ReversibleArrayList(Collection<T> c) {
		super(c);
	}

	// 返回一个反向迭代器
	public Iterable<T> reversed() {
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					int current = size() - 1;

					public boolean hasNext() {
						return current > -1;
					}

					public T next() {
						return get(current--);
					}

					public void remove() { // Not implemented
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
}

public class AdapterMethodIdiom {
	public static void main(String[] args) {
		ReversibleArrayList<String> ral = new ReversibleArrayList<String>(
				Arrays.asList("To be or not to be 生 存 还 是 毁 灭".split(" ")));
		// Grabs the ordinary iterator via iterator():通过iterator()获取普通的迭代器:
		for (String s : ral)
			System.out.print(s + " ");
		System.out.println();
		// 获取反向迭代
		for (String s : ral.reversed())
			System.out.print(s + " ");
	}
} /* Output:
To be or not to be
be to not or be To
*///:~
