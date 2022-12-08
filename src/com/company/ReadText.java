package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadText {
    public static void main(String[] args) {
        String fileName = "src/com/company/data/data.txt";
        StringBuilder sb;
        //Try with resources (новый синтаксис try, начиная с Java 7)
        try (FileReader fr = new FileReader(fileName)) {
            System.out.println("Character encoding: " + fr.getEncoding());
            sb = new StringBuilder();
            int i;
            while ((i = fr.read()) != -1) {
                sb.append((char) i);

            }
            fr.close();

            System.out.println(sb.toString());
            String s = sb.toString();
            s = s.replaceAll("[^-\\+\\.0-9]","");
            double x = Double.parseDouble(s);

            System.out.println(x);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
