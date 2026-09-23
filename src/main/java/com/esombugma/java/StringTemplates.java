package com.esombugma.java;

import com.esombugma.java.util.Message;

public class StringTemplates {

    static void main() {
        before();
        after();
    }

    private static void before() {
        String name = "World";
        String message = String.format("[BEFORE] Hello, %s! Welcome to Java 21.", name);
        Message.displayMessage(message);
    }

    private static void after() {
        String name = "Simba";
        String message = STR."[AFTER] Hello \{name}, I am your father!";
        Message.displayMessage(message);
    }
}