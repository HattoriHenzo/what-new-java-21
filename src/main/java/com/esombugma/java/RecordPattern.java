package com.esombugma.java;

import com.esombugma.java.util.Message;

public class RecordPattern {

    record Point(float x, float y) { }

    static void main() {
        Object object = new Point(1, 2);
        before(object);
        after(object);
    }

    private static void before(Object object) {
        if  (object instanceof Point(float x, float y)) {
            Message.displayMessage(String.format("[BEFORE] X = %f, and Y = %f", x, y));
        }
    }

    private static void after(Object object) {
        if  (object instanceof Point point) {
            Message.displayMessage(String.format("[AFTER] X = %f, and Y = %f", point.x, point.y));
        }
    }
}


