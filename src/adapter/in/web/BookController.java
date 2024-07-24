package adapter.in.web;

@RestController
@RequestMapping("/books")
public class BookController {

    private final AddBookUseCase addBookUseCase;
    private final UpdateBookUseCase updateBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;
    private final GetBookUseCase getBookUseCase;

    public BookController(AddBookUseCase addBookUseCase, UpdateBookUseCase updateBookUseCase, DeleteBookUseCase deleteBookUseCase, GetBookUseCase getBookUseCase) {
        this.addBookUseCase = addBookUseCase;
        this.updateBookUseCase = updateBookUseCase;
        this.deleteBookUseCase = deleteBookUseCase;
        this.getBookUseCase = getBookUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> addBook(@RequestBody Book book) {
        addBookUseCase.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        updateBookUseCase.updateBook(book);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        deleteBookUseCase.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Book book = getBookUseCase.getBook(id);
        return ResponseEntity.ok(book);
    }
}
