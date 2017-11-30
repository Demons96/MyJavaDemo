package designpattern;

// �ص�����
public class CallBack {

	public static void main(String[] args) {
		new Student("С��").callHelp(1, 2);
		
		new SuperCalculator().add(2, 3, new doJob() {
			public void add(int a, int b, int result) {
				System.out.println(a + " + " + b + " = " + result);
			}
		});
	}
}

// �ص��ӿ�
interface doJob {
	public void add(int a, int b, int result);
}

// ���ýӿڷ�������������ظ����÷�
class SuperCalculator {
	public void add(int a, int b, doJob customer) {
		int result = a + b;
		customer.add(a, b, result);
	}
}

class Student {
	private String name = null;

	public Student(String name) {
		this.name = name;
	}

	public void callHelp(int a, int b) {
		new SuperCalculator().add(a, b, new doHomeWork());
	}

	public class doHomeWork implements doJob {
		@Override
		public void add(int a, int b, int result) {
			System.out.println(name + "����С�����:" + a + " + " + b + " = " + result);
		}
	}
}