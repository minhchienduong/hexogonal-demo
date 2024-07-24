package application.service;

@Service
public class BookService implements AddBookUseCase, UpdateBookUseCase, DeleteBookUseCase, GetBookUseCase {

    private final SaveBookPort saveBookPort;
    private final LoadBookPort loadBookPort;
    private final DeleteBookPort deleteBookPort;
    private final BookMapper bookMapper;

    public BookService(SaveBookPort saveBookPort, LoadBookPort loadBookPort, DeleteBookPort deleteBookPort, BookMapper bookMapper) {
        this.saveBookPort = saveBookPort;
        this.loadBookPort = loadBookPort;
        this.deleteBookPort = deleteBookPort;
        this.bookMapper = bookMapper;
    }

    @Override
    public void addBook(Book book) {
        saveBookPort.saveBook(bookMapper.toEntity(book));
    }

    @Override
    public void updateBook(Book book) {
        saveBookPort.saveBook(bookMapper.toEntity(book));
    }

    @Override
    public void deleteBook(Long id) {
        deleteBookPort.deleteBook(id);
    }

    @Override
    public Book getBook(Long id) {
        return bookMapper.toModel(loadBookPort.loadBook(id));
    }
}

