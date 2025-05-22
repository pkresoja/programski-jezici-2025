package rs.ac.singidunum.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.entity.Ticket;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findAllByDeletedAtIsNull();

    Optional<Ticket> findByIdAndDeletedAtIsNull(Integer id);
}
