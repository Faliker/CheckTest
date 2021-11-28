package main.java.by.velyuga.check.recorder;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Calendar;

public final class CheckRecorder {
    private CheckRecorder() {
    }

    public static void writeCheckOnFile(StringBuilder outStrBuild) {
        Calendar calendar = Calendar.getInstance();
        long timeInMillis = calendar.getTimeInMillis();
        String relativePathOut = "src\\main\\output\\check" + timeInMillis + ".txt";
        Path path = Paths.get(relativePathOut).toAbsolutePath();
        File fileOut = new File(path.toString());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut))) {
            writer.write(outStrBuild.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}