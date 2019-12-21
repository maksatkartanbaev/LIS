package sample;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {

    private final SimpleStringProperty ISBN;
    private final SimpleStringProperty title;
    private final SimpleStringProperty author;
    private final SimpleStringProperty publisher;
    private final SimpleIntegerProperty availability;
    private final SimpleFloatProperty rating;

    public Book(String isbn, String title, String author, String publisher, Integer availability, Float rating) {
        this.ISBN = new SimpleStringProperty(isbn);
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.publisher = new SimpleStringProperty(publisher);
        this.availability = new SimpleIntegerProperty(availability);
        this.rating = new SimpleFloatProperty(rating);
    }

    public String getISBN() {
        return ISBN.get();
    }

    public String getTitle() {
        return title.get();
    }

    public String getAuthor() {
        return author.get();
    }

    public String getPublisher() {
        return publisher.get();
    }

    public Integer isAvailability() {
        return availability.get();
    }

    public Float getRating() {
        return rating.get();
    }
}