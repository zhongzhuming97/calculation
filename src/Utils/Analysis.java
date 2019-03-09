package Utils;

/**
 * 分析表达式类，分析改表达式是否正确
 * 
 * @author apple
 *
 */
public class Analysis {
	// 判断中缀表达式是否符合规范
	// test 55.6+4*60/2+33+(4.7*5.6)/5
	private int current;
	private char token;
	private char[] tokens;

	public Analysis(String infix) {
		this.current = 0;
		this.tokens = infix.toCharArray();
		// TODO Auto-generated constructor stub
	}

	public void exp() throws MyException {
		term();
		while ((token == '+') || (token == '-')) {
			match(token);
			term();
		}
	}

	public void term() throws MyException {
		factor();
		while ((token == '*') || (token == '/')) {
			match(token);
			factor();
		}
	}

	public void factor() throws MyException {
		// 将String转为char基本类型
		if (token == '(') {
			match(token);
			exp();
			match(')');
		} else if (Character.isDigit(token)) {
			int len = 0;
			// 将数字匹配
			while ((Character.isDigit(token) || token == '.') && current < tokens.length) {
				// len可用来截取匹配的数，带小数点的数也可以
				len++;
				match(token);
			}
		} else if (token == '-') {
			match(token);
			exp();
		} else {
			System.out.println("发生错误 当前位置:" + (current + 1));
			throw new MyException(current + 1);
		}
	}

	public void match(char c) {
		System.out.println("已经匹配" + c);
		current++;
		if (current < tokens.length)
			token = tokens[current];
		else
			token = '#';// 结束标记
	}

	public void analysis() {
		try {
			token = tokens[current];
			exp();
		} catch (MyException e) {
			System.out.println(e.errorMessage());
		}
	}
}
