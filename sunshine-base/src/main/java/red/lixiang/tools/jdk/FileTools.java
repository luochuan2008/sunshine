package red.lixiang.tools.jdk;

import red.lixiang.tools.jdk.io.IOTools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * @Author lixiang
 * @CreateTime 2019-08-02
 **/
public class FileTools {

    /**
     * 获取文件的后缀名,包含 '.'
     * @param fileName
     * @return
     */
    public  static String getSuffixName(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public  static String getSuffixNameNoDot(String fileName){
        return fileName.substring(fileName.lastIndexOf(".")+1);
    }

    /**
     * 获取文件名
     * @param fileName
     * @return
     */
    public  static String getNameWithoutSuffix(String fileName){
        return fileName.substring(0,fileName.lastIndexOf("."));
    }

    public static String fileBase64Content(File file){
        try {
            FileInputStream inputStream = new FileInputStream(file);
            byte[] bytes = IOTools.readByte(inputStream);
            inputStream.close();
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String fileBase64Content(String path){
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static void main(String[] args) {
        String suffixName = getSuffixNameNoDot("aa.jpg");
        System.out.println(suffixName);
    }
}
