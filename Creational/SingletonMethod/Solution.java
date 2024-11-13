package Creational.SingletonMethod;

class ApiInstance {
    private static ApiInstance instance;
    private static int count = 0;

    public ApiInstance() {
    }

    public static ApiInstance getInstance() {
        if (instance == null) {
            count += 1;
            System.out.println("Instance created for " + count + " times");
            instance = new ApiInstance();
        }
        return instance;
    }
}

public class Solution {

    public static void main(String[] args) {
        ApiInstance.getInstance();
        ApiInstance.getInstance();
        ApiInstance.getInstance();
    }
}
