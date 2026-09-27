package main.java.week7.class_problems;

public class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public void changeCode(String oldCode, String newCode) {
        if (this.code.equals(oldCode)) {
            this.code = newCode;
        }
    }
}