package com.esombugma.java;

import com.esombugma.java.util.Message;

public class VirtualThreads {

    void main() {
        before();
        after();
    }

    private static void before() {
        Thread thread = new Thread(() -> Message.displayMessage("[BEFORE] Hello from a virtual thread!"));
        thread.start();
    }

    private static void after() {
        Thread thread = Thread.ofVirtual().start(() -> Message.displayMessage("[AFTER] Hello from a virtual thread!"));
        try {
            thread.join();
        } catch (InterruptedException e) {
            Message.displayMessage(e.getMessage());
        }
    }
}
