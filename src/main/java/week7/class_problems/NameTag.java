package main.java.week7.class_problems;

public class NameTag {
    private final String nickname;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        if (parts.length >= 2) {
            this.nickname = parts[0] + " " + parts[1].charAt(0) + ".";
        } else {
            this.nickname = fullName;
        }
    }

    public String getNickname() {
        return nickname;
    }
}