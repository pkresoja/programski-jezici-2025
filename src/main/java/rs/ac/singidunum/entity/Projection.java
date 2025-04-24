package rs.ac.singidunum.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "projection")
@NoArgsConstructor
@Getter
@Setter
public class Projection {

    @Id
    @Column(name = "projection_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer movieId;

    @Column(nullable = false)
    private LocalDateTime time;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @JsonIgnore
    private LocalDateTime deletedAt;
}
