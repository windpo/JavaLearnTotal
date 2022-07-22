package java_homework;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 风之诗
 * @version 1.0
 */
public class Book {
    private String bookName;
    private int ID;
    private static int bookID=1;
    private double price;
    private static int bookNumbers;

    public Book(String bookName, double price) throws PriceException {
        if(price-10<0||price-100>0){
            throw new PriceException();
        }
        this.bookName = bookName;
        this.price = price;
        ID=bookID++;
        bookNumbers++;
    }

    @Override
    public String toString() {
        return
                "书名='" + bookName + '\'' +
                ", 书号=" + ID +
                ", 书价=" + price;
    }

    public static void main(String[] args) {
        final ArrayList<Book> books = new ArrayList<>();
        try {
            books.add(new Book("Java程序设计",101));
            books.add(new Book("C程序设计",44.8));
            books.add(new Book("C++程序设计",38.7));
        } catch (PriceException p){
            final Logger logger = Logger.getLogger("Book.java");
            logger.log(Level.SEVERE,"价格错误，请重新定义价格",p);
        }

        for (Book b :
                books) {
            System.out.println(b);
        }
    }
}
class PriceException extends Exception{
    public PriceException() {
    }

    public PriceException(String message) {
        super(message);
    }

}