package Utils.Exception;

/**
 * 处理异常类
 *
 * @author apple
 */
public class MyException extends Exception {
    // position为tokens数组下标
    private int position;
    char[] tokens;

    public MyException(int position, char[] tokens) {
        this.position = position;
        this.tokens = tokens;
    }

    public String errorMessage() {
        String eMessage = "";
        if (position >= tokens.length) {
            position--;
        }
        if (position == 0) {
            eMessage = "当前发生错误的位置为" + (position + 1) + '\n'+ "当前符号为："+tokens[position]+" 前面应该加数字";
            return eMessage;
        }
        eMessage = "当前发生错误的位置为" + (position + 1) + '\n';
        switch (tokens[position - 1]) {
            case '(':
            case '+':
            case '-':
            case '*':
            case '/':
                eMessage += "当前位置" + (position + 1) + "符号: " + tokens[position] + " 和前一个位置 " + position + "符号: "
                        + tokens[position] + "之间必须存在数字";
                break;
            case '.':
                eMessage += "存在两个小数点";
                break;
            default:
                eMessage += "存在两个小数点";
                break;
        }

        return eMessage;
    }
}
