package part4.HM_4_6;

import java.util.*;
import java.util.stream.Collectors;

/*
Реализуем работу библиотеки.

Для каждой книги библиотечного фонда известны автор, название и год издания.
Для читателя библиотеки будем хранить ФИО и электронный адрес. Каждый читатель может взять в библиотеке одну
или несколько книг — их тоже сохраним.
Ещё нам понадобится флаг читательского согласия на уведомления по электронной почте. Рассылки организуют
сотрудники библиотеки: напоминают о сроке возврата книг, сообщают новости.

Код всех классов уже подготовлен, необходимо добавить исходные данные (несколько книг, читателей и “раздать” книги).

Каждый пункт реализовать в виде отдельного метода, используя stream api.
1.	Получить список всех книг библиотеки, отсортированных по году издания.
2.	Требуется создать список рассылки (объекты типа EmailAddress) из адресов всех читателей библиотеки.
При этом флаг согласия на рассылку не учитывать.
3.	Снова нужно получить список рассылки. Но на этот раз включаем в него только адреса читателей,
которые согласились на рассылку. Дополнительно нужно проверить, что читатель взял из библиотеки больше одной книги.
4.	Получить список всех книг, взятых читателями. Список не должен содержать дубликатов (книг одного автора,
с одинаковым названием и годом издания).
5.	Проверить, взял ли кто-то из читателей библиотеки какие-нибудь книги Оруэлла.
6.	Узнать наибольшее число книг, которое сейчас на руках у читателя.
7.	Вернёмся к нашим email-рассылкам. Теперь нужно не просто отправить письма всем, кто согласился на рассылку, —
будем рассылать разные тексты двум группам:
написать метод, который вернёт два списка адресов:
- с пометкой OK — если книг не больше двух,
- или TOO_MUCH — если их две и больше.
Порядок групп не важен.
 */
public class Task_4_6 {


    //1.	Метод, чтобы получить список всех книг библиотеки, отсортированных по году издания.
    public static List<Book> getSortedBooksByPublicationYear(Library library) {
        return library.getBooks().stream()
                .sorted(Comparator.comparing(Book::getIssueYear))
                .collect(Collectors.toList());
    }

    //2.	Метод, чтобы создать список рассылки (объекты типа EmailAddress) из адресов всех читателей библиотеки.
    // При этом флаг согласия на рассылку не учитывать.
    public List<EmailAddress> getEmailAddressesOfAllReaders(List<Reader> readers) {
        return readers.stream()
                .map(Reader::getEmail)
                .collect(Collectors.toList());
    }

    //3.	Метод, чтобы получить список рассылки. Но на этот раз включаем в него только адреса читателей,
    // которые согласились на рассылку. Дополнительно нужно проверить, что читатель взял из библиотеки больше одной книги.
    public static List<String> generateMailingList(List<Reader> readers) {
        return readers.stream()
                .filter(Reader::isSubscriber)
                .filter(reader -> reader.getBooks().size() > 1)
                .map(reader -> reader.getEmail().getEmail())
                .collect(Collectors.toList());
    }

    //4.	Метод, чтобы получить список всех книг, взятых читателями. Список не должен содержать дубликатов
    // (книг одного автора, с одинаковым названием и годом издания).
    public List<Book> getAllBorrowedBooks(List<Reader> readers) {
        return readers.stream()
                .flatMap(reader -> reader.getBooks().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    //5.	Метод, чтобы проверить, взял ли кто-то из читателей библиотеки какие-нибудь книги Оруэлла.
    public boolean anyReadersBorrowedOrwellBooks(List<Reader> readers) {
        return readers.stream()
                .flatMap(reader -> reader.getBooks().stream())
                .anyMatch(book -> book.getAuthor().equals("Оруэлл"));
    }

    //6.	Метод, чтобы узнать наибольшее число книг, которое сейчас на руках у читателя.
    public static int getLargestNumberOfBooksOnHand(List<Reader> readers) {
        return readers.stream()
                .map(Reader::getBooks)
                .mapToInt(List::size)
                .max()
                .orElse(0);
    }

    //7.	Вернёмся к нашим email-рассылкам. Теперь нужно не просто отправить письма всем, кто согласился
    // на рассылку — будем рассылать разные тексты двум группам:
    // написать метод, который вернёт два списка адресов:
    // - с пометкой OK — если книг не больше двух,
    // - или TOO_MUCH — если их две и больше.
    // Порядок групп не важен.
    public static Map<String, List<String>> getEmailAddresses(Library library) {
        return library.getReaders().stream()
                .collect(Collectors.partitioningBy(
                        reader -> reader.getBooks().size() <= 2,
                        Collectors.mapping(
                                reader -> reader.getEmail().getEmail(),
                                Collectors.toList())))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        e -> e.getKey() ? "OK" : "TOO_MUCH",
                        Map.Entry::getValue));
    }
}
