package application.service;

@Service
public class OrderService implements PlaceOrderUseCase, UpdateOrderUseCase, DeleteOrderUseCase, GetOrderUseCase {

    private final SaveOrderPort saveOrderPort;
    private final LoadOrderPort loadOrderPort;
    private final DeleteOrderPort deleteOrderPort;
    private final OrderMapper orderMapper;

    public OrderService(SaveOrderPort saveOrderPort, LoadOrderPort loadOrderPort, DeleteOrderPort deleteOrderPort, OrderMapper orderMapper) {
        this.saveOrderPort = saveOrderPort;
        this.loadOrderPort = loadOrderPort;
        this.deleteOrderPort = deleteOrderPort;
        this.orderMapper = orderMapper;
    }

    @Override
    public void placeOrder(Order order) {
        saveOrderPort.saveOrder(orderMapper.toEntity(order));
    }

    @Override
    public void updateOrder(Order order) {
        saveOrderPort.saveOrder(orderMapper.toEntity(order));
    }

    @Override
    public void deleteOrder(Long id) {
        deleteOrderPort.deleteOrder(id);
    }

    @Override
    public Order getOrder(Long id) {
        return orderMapper.toModel(loadOrderPort.loadOrder(id));
    }
}
