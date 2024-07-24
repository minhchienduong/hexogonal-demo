package domain.mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toModel(BookEntity entity);
    BookEntity toEntity(Book model);
}