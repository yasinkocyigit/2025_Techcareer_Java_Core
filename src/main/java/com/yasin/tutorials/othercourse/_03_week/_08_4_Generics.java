package com.yasin.tutorials.othercourse._03_week;

// Bounded Generics (Generics Sınırlamalar)
public class _08_4_Generics<T extends Number> {

    // Field
    private String name;
    private T price;

    // METHOD
    public <X> void printData(X number) {
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

    @SuppressWarnings({ "rawtypes", "unchecked" })
    // PSVM
    public static void main(String[] args) {
        _08_4_Generics generics = new _08_4_Generics();
        generics.setName("Yasin");
        // generics.setPrice("44.0 TL");
        System.out.println(generics.getName() + " " + generics.getPrice());

        generics.setPrice(44.0);
        System.out.println(generics.getName() + " " + generics.getPrice());

        generics.printData(55);
        generics.printData("55");
        generics.printData(55.44);
    }
}
