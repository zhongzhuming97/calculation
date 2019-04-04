package Utils;

import java.util.Random;

public class CreateExpression {
	private static final String characters = "()+-/*";

	public static String createRandomExpression() {
		Random rand = new Random();
		StringBuffer expression=new StringBuffer();
		char []chs=characters.toCharArray();
		//生成1～10个字符或者数字
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
		Random rand=new Random();
		StringBuffer expression=new StringBuffer();
		char []chs=characters.toCharArray();
		int length=rand.nextInt(10)+1;
		while(length>0){
			boolean isNumber = rand.nextBoolean();
			// 若当前生成的为数字
			if (isNumber) {// 产生数字
				float number = rand.nextFloat() * 100;
				expression.append(number);
			} else {//产生字符
				int position=rand.nextInt(6);
				char ch=chs[position];
				//字符前一个为字符
				if(Character.isLetter(expression.charAt(expression.length()-1))){

				}
				expression.append(ch);
			}
			length--;
		}
		
		
		return "";
	}
}
