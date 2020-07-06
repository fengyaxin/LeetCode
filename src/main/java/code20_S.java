import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 */

public class code20_S {
    public static void main(String[] args) {
        String s="{[(hghjj)]}(){}[]";
        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        stack.push('#');
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }

            if((c==')'&&stack.pop()!='(')||(c==']'&&stack.pop()!='[')||(c=='}'&&stack.pop()!='{')){
              return false;
            }
        }
        if(stack.peek()!='#'){
            return false;
        }
return true;
    }
}
