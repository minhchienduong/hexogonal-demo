package adapter.in.web;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AddAuthorUseCase addAuthorUseCase;
    private final UpdateAuthorUseCase updateAuthorUseCase;
    private final DeleteAuthorUseCase deleteAuthorUseCase;
    private final GetAuthorUseCase getAuthorUseCase;

    public AuthorController(AddAuthorUseCase addAuthorUseCase, UpdateAuthorUseCase updateAuthorUseCase, DeleteAuthorUseCase deleteAuthorUseCase, GetAuthorUseCase getAuthorUseCase) {
        this.addAuthorUseCase = addAuthorUseCase;
        this.updateAuthorUseCase = updateAuthorUseCase;
        this.deleteAuthorUseCase = deleteAuthorUseCase;
        this.getAuthorUseCase = getAuthorUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> addAuthor(@RequestBody Author author) {
        addAuthorUseCase.addAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        author.setId(id);
        updateAuthorUseCase.updateAuthor(author);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        deleteAuthorUseCase.deleteAuthor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
        Author author = getAuthorUseCase.getAuthor(id);
        return ResponseEntity.ok(author);
    }
}