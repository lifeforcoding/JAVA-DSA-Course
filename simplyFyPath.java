public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < path.length()) {
            //1st Step
            //This piece of code will skip the current char if it equals to "/"
            String temp = path.charAt(i) + "";
            if (temp.equals("/")) {
                i++;
                continue;
            }
            //2nd Step
            //This piece of code ascertain the substring starting from other than '/' char and up to the index of next available '/'
            //And store it in the sub var, if there was no '/' was available after the current index then just put the substring from
            //Current to last
            String sub;
            if (path.indexOf("/",i) < 0) {
                sub = path.substring(i);
                i = path.length();
            }
            else {
                sub = path.substring(i, path.indexOf("/", i));
                i = path.indexOf("/",i);
            }
            //3rd Step
            //This piece of code checks the substring var sub and pop the element if ".." in it and skip if "." or "" in it
            //Otherwise push it to the stack
            if (!sub.equals(".") && !sub.equals("..")  && !sub.equals(""))
                stack.push(sub);
            else {
                if (!stack.empty() & sub.equals(".."))
                    stack.pop();
            }
        }
        //4th Step
        //This piece of code add the element in answer list from the stack in the order of bottom to top
        if (stack.isEmpty()) return "/";
        while (!stack.isEmpty())
            res.insert(0,stack.pop()).insert(0,"/");
        return res.toString();
    }
