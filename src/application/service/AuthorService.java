package application.service;

@Service
public class AuthorService implements AddAuthorUseCase, UpdateAuthorUseCase, DeleteAuthorUseCase, GetAuthorUseCase {

    private final SaveAuthorPort saveAuthorPort;
    private final LoadAuthorPort loadAuthorPort;
    private final DeleteAuthorPort deleteAuthorPort;
    private final AuthorMapper authorMapper;

    public AuthorService(SaveAuthorPort saveAuthorPort, LoadAuthorPort loadAuthorPort, DeleteAuthorPort deleteAuthorPort, AuthorMapper authorMapper) {
        this.saveAuthorPort = saveAuthorPort;
        this.loadAuthorPort = loadAuthorPort;
        this.deleteAuthorPort = deleteAuthorPort;
        this.authorMapper = authorMapper;
    }

    @Override
    public void addAuthor(Author author) {
        saveAuthorPort.saveAuthor(authorMapper.toEntity(author));
    }

    @Override
    public void updateAuthor(Author author) {
        saveAuthorPort.saveAuthor(authorMapper.toEntity(author));
    }

    @Override
    public void deleteAuthor(Long id) {
        deleteAuthorPort.deleteAuthor(id);
    }

    @Override
    public Author getAuthor(Long id) {
        return authorMapper.toModel(loadAuthorPort.loadAuthor(id));
    }
}