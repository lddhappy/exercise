package org.learn.exercise.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

public class FileUtil {

    public static byte[] getFileContent(String fullPath) {
        File f = new File(fullPath);
        if ((!f.exists()) || (!f.isFile())) {
            throw new RuntimeException(fullPath + "not exists or not file");
        }
        byte[] bs = new byte[(int) f.length()];
        try (FileInputStream inputStream = new FileInputStream(f)) {
            inputStream.read(bs);
            return bs;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String getFileString(String fullPath, Charset charset) {
        byte[] bs = getFileContent(fullPath);
        return new String(bs, charset);
    }

    /**
     * 写入文件内容
     *
     * @param fullPath 文件的完整路径，如果文件不存在会自动创建
     * @param content  文件内容
     */
    public static void writeFileContent(String fullPath, byte[] content) {
        try {
            File f = new File(fullPath);
            if (!f.exists() || (!f.isFile())) {
                f.createNewFile();
            }
            try (FileOutputStream outputStream = new FileOutputStream(f)) {
                outputStream.write(content);
            } catch (Exception inner) {
                throw inner;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
