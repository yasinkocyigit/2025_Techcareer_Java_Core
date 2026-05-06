package com.yasin.tutorials.othercourse._03_week;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class _08_2_Generics {

    public static void main(String[] args) {
        // Eğer Generics kullanmazsak type safe
        List<String> data = new ArrayList();
        data.add("Yasin"); // String
        // data.add(44); // Exception in thread "main" java.lang.ClassCastException
        data.add(String.valueOf(44));

        // String name= (String)data.get(0);
        String name = (String) data.get(1);
        System.out.println(name);
    }
}
