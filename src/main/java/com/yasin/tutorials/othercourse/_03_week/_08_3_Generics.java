package com.yasin.tutorials.othercourse._03_week;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class _08_3_Generics<T> {

    private String name;
    private T price;

    // METHOD
    public <U> void printData(U number) {
        System.out.println(number);
    }

    // GETTER AND SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getPrice() {
        return price;
    }

    public void setPrice(T price) {
        this.price = price;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    // PSVM
    public static void main(String[] args) {
        _08_3_Generics generics = new _08_3_Generics();
        generics.setName("Yasin");
        generics.setPrice("44.0 TL");
        System.out.println(generics.getName() + " " + generics.getPrice());

        generics.setPrice(44.0);
        System.out.println(generics.getName() + " " + generics.getPrice());

        generics.printData(55);
        generics.printData("55");
        generics.printData(55.44);

    }
}
