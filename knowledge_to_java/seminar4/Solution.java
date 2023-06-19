import java.util.Stack;

    // Учитывая строку, s содержащую только символы '(', ')', '{' '}', '[' ']',,,,,,,,,,,,,,,и,,, определите, является ли введенная строка допустимой.
    // Строка ввода допустима, если:
    // Открытые скобки должны быть закрыты скобками того же типа.
    // Открытые скобки должны быть закрыты в правильном порядке.
    // Каждой закрывающей скобке соответствует открывающая скобка того же типа.

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)

                return false;
        }

        return stack.isEmpty();
    }
}