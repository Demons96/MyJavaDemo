package designpattern;

// 单例模式的例子，只有一个头
public class MyHead {
	// 注意垃圾回收
	private static final MyHead head = new MyHead();
	
	private MyHead() {
	}

	public static MyHead getInstance() {
		return head;
	}
	
	public void say() {
		System.out.println("Hello my head。");
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			MyHead m = MyHead.getInstance();
			System.out.print(m.toString()+":");
			m.say();
		}
	}
}
