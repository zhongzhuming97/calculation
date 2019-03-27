package Main;

import java.util.Random;

import Utils.Analysis;
import Utils.CreateExpression;
import Utils.InfixToSuffix;
/**
 * 
 * @author apple
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	public static void test() {
		String a = InfixToSuffix.toSuffix("55.6+4*60/2+33+(4.7*5.6)/5");// 传入 一串 算数公式
		System.out.println(a);
		System.out.println(InfixToSuffix.dealEquation(a));//计算得出结果
		Random rand =new Random();
		System.out.println(rand.nextDouble());
		System.out.println(rand.nextInt(1000));
		int count=10;
		while(count>0) {
		String s=CreateExpression.createRandomExpression();
		System.out.println(s);
		Analysis analysis = new Analysis(s);
		analysis.analysis();
		count--;
		}
	}

}
