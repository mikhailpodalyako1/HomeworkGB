import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class hw6 {
    private static final Random RAND = new Random();
    private static final int CHAR_BOUND_L = 65;
    private static final int MAX_LENGTH = 100;
    private static final int WORD_LENGTH = 10;
    private static final int FILES_AMOUNT = 2;
    private static final int CHAR_BOUND_H = 90;
    private static final int WORDS_AMOUNT = 5;
    private static final String SEARCH = "FIND_ME";

    private static FileOutputStream fos;
    private static FileInputStream fis;

    private static String generateSymbols(int amount) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < amount; i++)
            sequence.append((char) (CHAR_BOUND_L + RAND.nextInt(CHAR_BOUND_H - CHAR_BOUND_L)));
        return sequence.toString();
    }

    private static void writeFileContents(String fileName, int length) {
        try {
            fos = new FileOutputStream(fileName);
            fos.write(generateSymbols(length).getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println("Something wrong " + fileName + " Reason: " + e.getCause());
        }
    }

    private static void writeFileContents(String fileName, int words, int length) {
        try {
            fos = new FileOutputStream(fileName);
            for (int i = 0; i < words; i++) {
                if (RAND.nextInt(WORDS_AMOUNT) == WORDS_AMOUNT / 2)
                    fos.write(SEARCH.getBytes());
                else
                    fos.write(generateSymbols(length).getBytes());
                fos.write(' ');
            }
            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println("Чтото не так " + e.getCause());
        }

    }

    private static void mergeFiles(String inputFile1, String inputFile2, String outputFile) {
        try {
            fos = new FileOutputStream(outputFile);
            int ch;
            fis = new FileInputStream(inputFile1);
            while ((ch = fis.read()) != -1)
                fos.write(ch);
            fis.close();

            fis = new FileInputStream(inputFile2);
            while ((ch = fis.read()) != -1) {
                fos.write(ch);
            }
            fis.close();

            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println("Что-то не так " + e.getCause());
        }
    }
    public static void main(String[] args) {
        String[] fileNames = new String[FILES_AMOUNT];
        for (int i = 0; i < fileNames.length; i++)
            fileNames[i] = "file_" + i + ".txt";

        for (int i = 0; i < fileNames.length; i++)
            if (i < 2)
                writeFileContents(fileNames[i], MAX_LENGTH);
            else
                writeFileContents(fileNames[i], WORDS_AMOUNT, WORD_LENGTH);
        System.out.println("Результат работы первого задания в файлах file_0 и file_1.");

        mergeFiles(fileNames[0], fileNames[1], "SUM.txt");
        System.out.println("Результат соединения в SUM.");
    }

    }
