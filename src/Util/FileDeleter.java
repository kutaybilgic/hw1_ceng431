package Util;

import java.io.*;

public class FileDeleter {

    public static void deleteFile(String pathName1, String name, String pathName2){
        File newFile = new File(pathName1);

        try (InputStream in = new FileInputStream(name);
             OutputStream out = new FileOutputStream(newFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File oldFile = new File(pathName2);
        if (oldFile.exists()) {
            oldFile.delete();
        }
    }
}
