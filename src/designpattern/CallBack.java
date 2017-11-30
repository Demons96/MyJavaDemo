package designpattern;

// 回掉例子
public class CallBack {

	public static void main(String[] args) {
		new Student("小明").callHelp(1, 2);
		
		new SuperCalculator().add(2, 3, new doJob() {
			public void add(int a, int b, int result) {
				System.out.println(a + " + " + b + " = " + result);
			}
		});
	}
}

// 回掉接口
interface doJob {
	public void add(int a, int b, int result);
}

// 调用接口方法并将结果返回给调用方
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
			System.out.println(name + "求助小红计算:" + a + " + " + b + " = " + result);
		}
	}
}