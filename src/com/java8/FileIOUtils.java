package com.java8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * @author 212331901
 * @date 2019/3/11
 */
public class FileIOUtils {

    private final Charset charset = Charset.forName("UTF-8");

    /**
     * Files.newBufferedReader
     * @param path
     */
    public void readAndPrintFile(String path) {
        Path path1 = Paths.get(path);
        try(BufferedReader bufferedReader = Files.newBufferedReader(path1, charset)){
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                Arrays.stream(line.split(" ")).forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Files.lines -> stream
     * @param path
     */
    public void readPrintFileLines(String path) {
        Path path1 = Paths.get(path);
        try{
            Files.lines(path1).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Files.write string
     * @param dest
     */
    public void writeStringToFile(String dest) {
        Path path1 = Paths.get(dest);
        Charset charset = Charset.forName("UTF-8");
        String line = "CNN JW 2019-4-1 2019-5-1 20\n";
        try {
            Files.write(path1, line.getBytes(charset));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Files.write iterable
     * @param dest
     */
    public void appendStringsToFile(String dest) {
        Path path1 = Paths.get(dest);
        Charset charset = Charset.forName("UTF-8");
        String line = "CNN JW 2019-4-1 2019-5-1 20";
        String line2 = "ABC JW 2019-4-1 2019-5-1 30";
        try {
            Files.write(path1, Arrays.asList(line, line2), charset, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Files.newBufferedWriter
     * @param dest
     */
    public void writeStringToFileBuffered(String dest) {
        Path path1 = Paths.get(dest);
        Charset charset = Charset.forName("UTF-8");
        String line = "CNN JW 2019-4-1 2019-5-1 10\n";
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path1, charset)) {
            bufferedWriter.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        FileIOUtils fileIOUtils = new FileIOUtils();
//        fileIOUtils.readAndPrintFile("C:\\git_repo\\booking\\src\\main\\resources\\orderOfCity.txt");

        String dest = "C:\\git_repo\\booking\\src\\main\\resources\\toOrderOfCity.txt";
//        fileIOUtils.writeStringToFile(dest);
        fileIOUtils.appendStringsToFile(dest);
        fileIOUtils.readPrintFileLines(dest);
    }
}
