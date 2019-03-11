package Main;

import java.util.Scanner;

import Utils.Analysis;
import Utils.InfixToSuffix;
import Utils.Exception.MyException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	public static void test() {
		String a = InfixToSuffix.toSuffix("55.6+4*60/2+33+(4.7*5.6)/5");// 传入 一串 算数公式
		System.out.println(a);
		System.out.println(InfixToSuffix.dealEquation(a));
		Analysis analysis = new Analysis("46797+4676-546*464+(5+45/44)/4");
		analysis.analysis();
	}

}
