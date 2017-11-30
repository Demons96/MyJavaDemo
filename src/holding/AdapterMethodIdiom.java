//: holding/AdapterMethodIdiom.java
//The "Adapter Method" idiom allows you to use foreach�����������������ϰ��������ʹ��foreach
//with additional kinds of Iterables.ʹ���������͵�Iterables��
package holding;
import java.util.*;

/**
 * ���������
 * Iterable�Ľӿڰ���һ���ܲ���Iterator�ķ���������foreach
 */
class ReversibleArrayList<T> extends ArrayList<T> {
	public ReversibleArrayList(Collection<T> c) {
		super(c);
	}

	// ����һ�����������
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
				Arrays.asList("To be or not to be �� �� �� �� �� ��".split(" ")));
		// Grabs the ordinary iterator via iterator():ͨ��iterator()��ȡ��ͨ�ĵ�����:
		for (String s : ral)
			System.out.print(s + " ");
		System.out.println();
		// ��ȡ�������
		for (String s : ral.reversed())
			System.out.print(s + " ");
	}
} /* Output:
To be or not to be
be to not or be To
*///:~
