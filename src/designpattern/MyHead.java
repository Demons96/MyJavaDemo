package designpattern;

// ����ģʽ�����ӣ�ֻ��һ��ͷ
public class MyHead {
	// ע����������
	private static final MyHead head = new MyHead();
	
	private MyHead() {
	}

	public static MyHead getInstance() {
		return head;
	}
	
	public void say() {
		System.out.println("Hello my head��");
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			MyHead m = MyHead.getInstance();
			System.out.print(m.toString()+":");
			m.say();
		}
	}
}
