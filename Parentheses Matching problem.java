public static boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char e : s.toCharArray()) {
            if (e == '{' || e == '[' || e == '(') {
                stack.push(e);
                continue;
            }
            if (e == '}' || e == ']' || e == ')')
                if (stack.isEmpty())
                    return false;
            char a;
            switch (e) {
                case '}' : a = stack.pop();
                           if (a != '{') return false;
                           break;
                case ']' : a = stack.pop();
                            if (a != '[') return false;
                            break;
                case ')' : a = stack.pop();
                           if (a != '(') return false;
                           break;
            }
        }
        return stack.isEmpty();
        }
