package main.java.by.velyuga.check.recorder;

import java.io.*;
import java.util.Calendar;

public final class CheckRecorder {
    private CheckRecorder() {
    }

    public static void writeCheckOnFile(StringBuilder outStrBuild) {
        Calendar calendar = Calendar.getInstance();
        long timeInMillis = calendar.getTimeInMillis();
        String path = "./src/main/output/check" + timeInMillis + ".txt";
        File fileOut = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut))) {
            writer.write(outStrBuild.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}