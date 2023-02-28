package part4.HM_4_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reader {
    private String fio; //ФИО
    private EmailAddress email; //электронный адрес
    private boolean subscriber; //флаг согласия на рассылку
    private List<Book> books; //взятые книги

    public Reader(String fio, EmailAddress email, boolean subscriber) {
        this.fio = fio;
        this.email = email;
        this.subscriber = subscriber;
        this.books = new ArrayList<>();
    }

    public boolean isSubscriber() {
        return subscriber;
    }

    public String getFio() {
        return fio;
    }

    public EmailAddress getEmail() {
        return email;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Reader reader = (Reader) o;
        return fio.equals(reader.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio);
    }
}
