package Behavioral.ChainOfResponsibility;

// It allows an object to send a request to other objects. without knowing 
// which one is going to handle it.

// Here we take a scenario of a Customer Service Department (CSR), having three levels of support
// Three levels of CSR = Customer Service Respresentative
// Level 1,2,3, handling basic, intermediate and critical issues respectively.
// If the issue is critical and we pass onto level 1, it escalates the issue to the higher level of 
// support until the issue is resolved completely.

interface CSR {
    void handleRequest(Request request);

    void setNextHandler(CSR csr);
}

class Level1CSR implements CSR {

    private CSR nextHandler;

    @Override
    public void handleRequest(Request request) {
        if (request.gePriority() == Priority.Normal) {
            System.out.println("Issue handled by Level 1 CSR");
        } else if (nextHandler != null) {
            // else send it to next handler to handle it
            System.out.println("Issue sent to upper level from level 1");
            nextHandler.handleRequest(request);
        }
    }

    @Override
    public void setNextHandler(CSR csr) {
        this.nextHandler = csr;
    }

}

class Level2CSR implements CSR {

    private CSR nextHandler;

    @Override
    public void handleRequest(Request request) {
        if (request.gePriority() == Priority.Intermediate) {
            System.out.println("Issue handled by Level 2 CSR");
        } else if (nextHandler != null) {
            // else send it to next handler to handle it
            System.out.println("Issue sent to upper level from level 2");
            nextHandler.handleRequest(request);
        }
    }

    @Override
    public void setNextHandler(CSR csr) {
        this.nextHandler = csr;
    }
}

class Level3CSR implements CSR {

    private CSR nextHandler;

    @Override
    public void handleRequest(Request request) {
        if (request.gePriority() == Priority.Critical) {
            System.out.println("Issue handled by Level 3 CSR");
        } else if (nextHandler != null) {
            // else send it to next handler to handle it
            nextHandler.handleRequest(request);
        }
    }

    @Override
    public void setNextHandler(CSR csr) {
        // No handler after third level CSR
    }

}

class Request {
    private Priority priority;

    public Request(Priority priority) {
        this.priority = priority;
    }

    public Priority gePriority() {
        return priority;
    }
}

enum Priority {
    Normal, Intermediate, Critical
}

public class Solution {

    public static void main(String[] args) {
        CSR level1Csr = new Level1CSR();
        CSR level2Csr = new Level2CSR();
        CSR level3Csr = new Level3CSR();

        Request critical = new Request(Priority.Critical);

        // we set the handlers
        level1Csr.setNextHandler(level2Csr);
        level2Csr.setNextHandler(level3Csr);

        // giving the critical request to handle
        // It will be sent to the upper level till it gets handled
        level1Csr.handleRequest(critical);
    }
}
