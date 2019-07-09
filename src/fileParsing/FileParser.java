package fileParsing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileParser {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\User\\Desktop\\somedoc.txt");

        List<String> findingText = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(file); // поток который подключается к текстовому файлу
            BufferedReader bufferedReader = new BufferedReader(fileReader); // соединяем FileReader с BufferedReader
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if ((line.isEmpty()) == false) {
                    findingText.add(line);
                }
            }
            bufferedReader.close(); // закрываем поток
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getMessage();
        }

        System.out.println(findingText); // выводим содержимое файла на экран построчно

    }
}