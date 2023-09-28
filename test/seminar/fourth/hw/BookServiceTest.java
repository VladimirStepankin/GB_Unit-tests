package seminar.fourth.hw;

import seminar.fourth.book.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class BookServiceTest {
    private BookService bookService;
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    void testFindBookById() {
        // Arrange
        String bookId = "1";
        Book expectedBook = new Book(bookId, "Book 1", "Author 1");
        when(bookRepository.findById(bookId)).thenReturn(expectedBook);

        // Act
        Book result = bookService.findBookById(bookId);

        // Assert
        assertEquals(expectedBook, result);
    }

    @Test
    void testFindAllBooks() {
        // Arrange
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("1", "Book 1", "Author 1"));
        expectedBooks.add(new Book("2", "Book 2", "Author 2"));
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Act
        List<Book> result = bookService.findAllBooks();

        // Assert
        assertEquals(expectedBooks, result);
    }
}
