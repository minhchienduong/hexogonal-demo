package domain.mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toModel(AuthorEntity entity);
    AuthorEntity toEntity(Author model);
}
