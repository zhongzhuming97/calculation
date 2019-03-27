package Utils;

import java.util.Random;

public class CreateExpression {
	private static final String characters = "()+-/*";

	public static String createRandomExpression() {
		Random rand = new Random();
		StringBuffer expression=new StringBuffer();
		char []chs=characters.toCharArray();
		int length=rand.nextInt(10)+1;
		while (length>0) {
			boolean isNumber = rand.nextBoolean();
			// 若当前生成的为数字
			if (isNumber) {// 产生数字
				float number = rand.nextFloat() * 100;
				expression.append(number);
			} else {//产生字符
				int position=rand.nextInt(6);
				char ch=chs[position];
				expression.append(ch);
			}
			length--;
		}
		return expression.toString();
	}
	public static String createExactExpression() {
		
		
		
		
		return "";
	}
}
