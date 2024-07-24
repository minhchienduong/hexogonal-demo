package domain.entity;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookId;
    private int quantity;
    private LocalDate orderDate;

    // Constructors, getters, and setters
}

