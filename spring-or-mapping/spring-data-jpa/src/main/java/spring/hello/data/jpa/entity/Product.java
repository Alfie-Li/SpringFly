package spring.hello.data.jpa.entity;

import javax.persistence.*;

@Entity(name = "Product")
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence-generator"
    )
    @SequenceGenerator(
            name = "sequence-generator",
            sequenceName = "product_sequence"
    )
    private Long id;

    @Column(name = "product_name")
    private String name;

    // Getters and setters
}
