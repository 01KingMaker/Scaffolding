package main;

import java.util.HashMap;
import java.util.Map;

interface MyFunction {
    void execute(int x, int y);
}

public class Main {
    public static void main(String[] args) {
        Map<String, MyFunction> functionMap = new HashMap<>();
        functionMap.put("add", (x, y) -> System.out.println(x + y));
        functionMap.put("multiply", (x, y) -> System.out.println(x * y));

        String functionName = "add";
        int arg1 = 3;
        int arg2 = 4;

        if (functionMap.containsKey(functionName)) {
            functionMap.get(functionName).execute(arg1, arg2);
        } else {
            System.out.println("Function not found");
        }
    }
}
