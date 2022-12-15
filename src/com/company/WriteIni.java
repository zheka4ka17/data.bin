package com.company;
/*
Сохранить в ini файл следующую информацию:
[options]
desc = Описание изделия №1
name = Изделие №1
number = 12345
value = 3.2
 */

import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;

public class WriteIni {
    public static void main(String[] args) {
        String filename= "src/com/company/data/data.ini";
        File file = new File(filename);
        try {
            file.createNewFile();
            Wini ini =new Wini(file);
            ini.put("optoins","desc","Описание");
            ini.put("options", "name", "Изделие №1");
            ini.put("options", "number", 12345);
            ini.put("options", "value", 3.2);
            ini.store();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
