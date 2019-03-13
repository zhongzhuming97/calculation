package Utils;

import Utils.Exception.MyException;

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
	private String ruleOperation;
	public Analysis(String infix) {
		this.current = 0;
		ruleOperation="+-*/";
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
			// 匹配number
			int len = 0;
			boolean hasPoint=false;
			// test 5+7（/
			while (true) {
				// len可用来截取匹配的数，带小数点的数也可以
				if (Character.isDigit(token)  && current < tokens.length) {
					len++;
					match(token);
				} else if(token=='.') {
					if(hasPoint) {
						//第二次出现小数点,抛出异常
						throw new MyException(current, tokens);
					}else {
						len++;
						hasPoint=true;
						match(token);
					}
				}else if((!ruleOperation.contains(String.valueOf(token))
						&&token!='#')
						&&token!=')'){
					//当前的是非运算符且不是最后一个符号，‘#’代表表达式已结束
					throw new MyException(current, tokens);
				}else {
					break;
				}
			}
		} else if (token == '-') {
			match(token);
			exp();
		} else {
			System.out.println("表达式不正确，发生异常匹配");
			throw new MyException(current, tokens);
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
			System.out.print(e.errorMessage());
		}

	}
}
