package Utils;

import java.util.Random;

public class CreateExpression {
	private static final String characters = "+-/*()";

	public static String createRandomExpression() {
		Random rand = new Random();
		StringBuffer expression = new StringBuffer();
		char[] chs = characters.toCharArray();
		// 生成1～10个字符或者数字
		int length = rand.nextInt(10) + 1;
		while (length > 0) {
			boolean isNumber = rand.nextBoolean();
			// 若当前生成的为数字
			if (isNumber) {// 产生数字
				float number = rand.nextFloat() * 100;
				expression.append(number);
			} else {// 产生字符
				int position = rand.nextInt(6);
				char ch = chs[position];
				expression.append(ch);
			}
			length--;
		}
		return expression.toString();
	}

	public static String createExactExpression() {
		Random rand = new Random();
		StringBuffer expression = new StringBuffer();

		int length = rand.nextInt(10) + 3;
		int hasLeft = 0;
		while (length > 0) {
			boolean isNumber = rand.nextBoolean();
			// 若当前生成的为数字
			if (isNumber) {// 产生数字
				if (expression.length() > 0) {
					char previous = expression.charAt(expression.length() - 1);
					if (Character.isDigit(previous)) {// 前一位为数字，这时候不能产生数字
						char temp = generateOpAndBrackets(4);
						expression.append(temp);
					} else {
						float number = generateNumber();
						expression.append(number);
					}
				} else {
					float number = generateNumber();
					expression.append(number);
				}
			} else {// 产生字符
				// 字符前一个为字符
				char ch = '.';
				if (expression.length() > 0) {
					char previous = expression.charAt(expression.length() - 1);
					if (characters.contains(String.valueOf(previous))) {
						// 若前一个为字符
						if (previous == '(') {
							ch = '(';
							hasLeft++;
						} else if (previous == ')') {
							if (hasLeft > 0)
								ch = generateOpAndBrackets(6);
							else
								ch = generateOpAndBrackets(4);// 只能为+-*/
						} else {
							int i = rand.nextInt(4);
							if (i >= 2) {
								String temp = String.valueOf(generateNumber());
								expression.append(temp);
							} else {
								ch = '(';
								hasLeft++;
							}
						}
					} else {
						// 前一符号为数字
						ch = generateOpAndBrackets(4);
					}
				} else {
					ch = '(';// 第一个为字符
					hasLeft++;
				}
				if (ch != '.')
					expression.append(ch);
			}
			length--;
		}
		// 最后处理
		char c = expression.charAt(expression.length() - 1);
		while (c == '+' || c == '-' || c == '*' || c == '/' || c == '(') {
			expression.deleteCharAt(expression.length() - 1);
			if (c == '(')
				hasLeft--;
			if(expression.length()==0) break;
			c = expression.charAt(expression.length() - 1);
		}
		while (hasLeft > 0) {
			expression.append(')');
			hasLeft--;
		}

		return expression.toString();
	}

	/**
	 * 
	 * @return
	 */
	public static float generateNumber() {
		Random rand = new Random();
		float number = rand.nextFloat() * 100;
		return number;
	}

	/**
	 * 
	 * @param num
	 * @return
	 */
	public static char generateOpAndBrackets(int num) {
		Random rand = new Random();
		int position = rand.nextInt(num);
		char[] chs = characters.toCharArray();
		char temp = chs[position];
		return temp;
	}
}
