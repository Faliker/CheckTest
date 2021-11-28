package main.java.by.velyuga.check.util;

public final class Rounding {
    private Rounding(){
    }

    public static double convert(double convertValue) {
        return (Math.round(convertValue * 100.0) / 100.0);
    }
}