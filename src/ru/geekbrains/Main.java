package ru.geekbrains;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "2", "3", "4", "5", "6", "7", "7", "9", "20"
        );

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Integer count;
        for(String w : words){
            count = map.get(w);
            map.put(w, (count == null ? 1 : ++count));
        }
        System.out.println(map);

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Вася", "+7(921)999-99-99");
        phoneBook.add("Вася", "+7(921)999-99-91");
        phoneBook.add("Вася", "+7(921)999-99-92");

        phoneBook.add("Петя", "+7(921)999-99-99");
        phoneBook.add("Даша", "+7(921)999-99-00");

        System.out.println(phoneBook.get("Петя"));
        System.out.println(phoneBook.get("Даша"));
        System.out.println(phoneBook.get("Вася"));
    }
}

class PhoneBook {
    private TreeMap<String, HashSet<String>> phones = new TreeMap<>();

    public void add(String surname, String number){
        HashSet<String> numbers =  phones.get(surname) != null ? phones.get(surname) : new HashSet<>();
        numbers.add(number);
        phones.put(surname, numbers);
    }

    public String get(String surname){
        return surname + ": " + phones.get(surname).toString();
    }
}
