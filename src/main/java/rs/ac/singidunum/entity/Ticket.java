package rs.ac.singidunum.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String uuid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "projection_id", nullable = false)
    private Projection projection;

    @Column(nullable = false)
    private Integer seat;

    private LocalDateTime paidAt;
    private LocalDateTime usedAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @JsonIgnore
    private LocalDateTime deletedAt;
}
