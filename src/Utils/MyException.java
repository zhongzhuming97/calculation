package Utils;


/**
 * 处理异常类
 * @author apple
 *
 */
public class MyException extends Exception{
	private int position;
	public MyException(int position) {
		this.position=position;
	}
	public String errorMessage() {
		String eMessage="当前发生错误的位置为"+position;;
		return eMessage;
	}
}
