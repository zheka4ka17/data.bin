package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExps {
    public static void main(String[] args) throws IOException {
        //Строка содержит только один символ
        String s1 = " ", s2 = "ab";
        Pattern pattern = Pattern.compile(".");
        Matcher matcher = pattern.matcher(s2);
        // System.out.println(matcher.matches());
        check("..", " ", "ab");
        check(".{5}", "12345", "234");

        //Строка содержит одну или более букву "a", а за ней одну букву "b"
        check("a+b", "aab", "abb");
        //Строка содержит несколько или ни одной буквы "a", а за ней одну букву "b"
        check("a*b", "b", "abb");
        //Слово состоит из двух букв, первая из которых "a"
        check("a.", "ab", "abb");
// Последняя буква в строке "a"
        check(".*a", "ba", "abb");
        // Опеределенная позиция - третья буква "a"
        check(".{2}a.*", "cba", "aab");
        //Первая и последня буква а
        check("a.*a", "ababa", "abbbbb");
        // первая и последняя буквы одинаковые
        check("(.).*\\1", "abcda", "abb");
        //Не должно начинаться с а or b
        check("[^ab ].*", "abcda", "bb");
        //Четные символы а
        check("(.).*\\1", "abcda", "abb");
        // слово содержит а
        check("[a-zA-Z]*[a-zA-Z]*", "abcda", "abb");
        //В строке содержатся цифры
        check("[0-9]+", "8119adf", "fabv");
        check("\\d+", "1", "baca");
        // Строка является вещественным число с фиксированной точкой
        check("[+-?]\\d+[.]?\\d*?", "+2", "bffsl1h");
        // Проверить номер телефона в формате 8(029)-123=34-98
        check("8\\(\\d{3}\\)-\\d{3}-\\d{2}-\\d{2}", "8(029)-264-10-17", "98(023)-123-45-67");


        TextFileReader textFileReader = new TextFileReader("src/com/company/data/vocab.txt");
        ArrayList list = (ArrayList) textFileReader.getList();
       // System.out.println(list.toString());

        for (var str : list) {
            if (check1(".{5}", str.toString()))
            System.out.println(str.toString());


        }


    }

    //Строка содержит только один символ
    public static void check(String pattern, String s1, String s2) {

        boolean b1 = Pattern.compile(pattern).matcher(s1).matches();
        boolean b2 = Pattern.compile(pattern).matcher(s2).matches();
        System.out.println(b1 + " " + b2);


    }

    public static boolean check1(String pattern, String s1) {

        boolean b1 = Pattern.compile(pattern).matcher(s1).matches();

       return b1;
    }

    static class TextFileReader {
        String fileName;
        private List<String> list = new ArrayList<String>();

        TextFileReader(String fileName) throws IOException {
            this.fileName = fileName;
            StringBuilder sb;
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                sb = new StringBuilder();
                String line = br.readLine();
                while (line != null) {
                    if (!line.equals(""))
                        list.add(line);
                    line = br.readLine();
                }
            }
        }

        public List<String> getList() {
            return list;
        }
    }
}

