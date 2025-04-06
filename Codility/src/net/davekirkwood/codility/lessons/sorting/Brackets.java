
import java.util.Stack;

public class Brackets {

    public int solution(String S) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            String str = S.substring(i, i + 1);
            if (str.equals("(") || str.equals("{") || str.equals("[")) {
                stack.push(str);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                String top = stack.pop();
                if (str.equals(")") && !top.equals("(")) {
                    return 0;
                }
                if (str.equals("}") && !top.equals("{")) {
                    return 0;
                }
                if (str.equals("]") && !top.equals("[")) {
                    return 0;
                }
            }
        }
        if (!stack.isEmpty()) {
            return 0;
        }
        return 1;
    }
}
