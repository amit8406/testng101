package utils;

public class SwpNumberWithoutThirdVar {

	public static void main(String[] args) {
		int a= 10;
		int b= 20;
		System.out.println("Before Swap:");
		System.out.println("a="+a+", b="+b);
		
		a = a+b;
		b = a-b;
		a = a-b;
		
		System.out.println("After Swap:");
		System.out.println("a="+a+", b="+b);
		

	}

}
