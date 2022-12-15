package com.company;

import java.util.*;

public class HW {
    public static void main(String[] args) {
        createDeque();
        printDeque();



        for (int i=0;i<5;i++){
            HashMap<String, Integer> hm = createDeque().pollFirst();//здесь можно было вывести и в обратном порядке, вывел так чтобы было все в цикле и не сильно сложно
            System.out.println("HashMap N: "+ (i+1));
            if (hm != null) {
                for (Map.Entry entry : hm.entrySet()) {
                    String k = (String) entry.getKey();
                    int v = (int) entry.getValue();
                    System.out.println("Key: " + k + ", Value: " + v);
                }
            }
        }
    }
    public static Deque<HashMap> createDeque(){
        Deque<HashMap> deque= new ArrayDeque<>() ;

        for (int i=0 ; i<5; i++)
            deque.addFirst(createHashMap());
        return deque;
    }

    public static void printDeque(){
        System.out.println(createDeque());
    }




    public static HashMap<String, Integer> createHashMap(){
        HashMap<String, Integer> hashmap= new HashMap<>();

        for (int i=0; i<5; i++ ){
            Random random = new Random();
            int wordLength = random.nextInt(9) + 1;
            String key="";
            int value=0;
            for (int j = 0; j < wordLength; j++) {
                int unicodeOfElement = random.nextInt('z' - 'a') + 'a';
                key+=(char)unicodeOfElement;
            }
            value= random.nextInt(20);

            hashmap.put(key,value);
        }
        return hashmap;
    }
}
