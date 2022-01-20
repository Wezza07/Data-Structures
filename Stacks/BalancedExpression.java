import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    private final List<Character> LeftBrackets
            = Arrays.asList('(' , '<' , '[' , '{');
    private final List<Character> RightBrackets
            = Arrays.asList(')' , '>' , ']' , '}');

    public boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()){

            if (isLeftBracket(ch))
                stack.push(ch);

            if (isRightBracket(ch)){
                if (stack.empty()) return false;

                var top = stack.pop();
                if (!isMatching(top , ch)) return false;
            }

        }
        return stack.empty();
    }

    private boolean isLeftBracket(char ch){
        return LeftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch){
        return RightBrackets.contains(ch);
    }

    private boolean isMatching(char left , char right){
        return LeftBrackets.indexOf(left) == RightBrackets.indexOf(right);
    }
}
