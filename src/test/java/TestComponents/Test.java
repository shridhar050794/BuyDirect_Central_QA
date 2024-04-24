package TestComponents;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test na=new Test();
		na.a();
		
	}
public void a() {
	for(int x =1;x<=5 ;x++) {
		for (int y=1;y<=x;y++) {
			System.out.print(y+" ");
		}
		System.out.println();
	}
}

public void a(int x) {
	System.out.println("x"+x);
	
}
public void a (String j) {
	System.out.println("J"+j);
}

}
