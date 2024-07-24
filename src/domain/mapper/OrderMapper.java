package domain.mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toModel(OrderEntity entity);
    OrderEntity toEntity(Order model);
}
