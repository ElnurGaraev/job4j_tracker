package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book alphabet = new Book("Alphabet", 25);
        Book shrek = new Book("Shrek", 70);
        Book hobbit = new Book("Hobbit", 110);
        Book kolobok = new Book("kolobok", 100);
        Book[] books = new Book[4];
        books[0] = alphabet;
        books[1] = shrek;
        books[2] = hobbit;
        books[3] = kolobok;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCount() + "pages.");
        }
        Book cleanCode = new Book("Clean code", 101);
        books[3] = cleanCode;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCount() + "pages.");
        }
        for (int index = 0; index < books.length; index++) {
            Book temp = books[0];
            books[0] = books[3];
            books[3] = temp;
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCount() + "pages.");
        }
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + " - " + bk.getCount() + "pages.");
            }
        }
    }
}
