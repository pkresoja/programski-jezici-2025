package rs.ac.singidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.entity.Customer;
import rs.ac.singidunum.entity.Projection;
import rs.ac.singidunum.entity.Ticket;
import rs.ac.singidunum.repo.CustomerRepository;
import rs.ac.singidunum.repo.ProjectionRepository;
import rs.ac.singidunum.repo.TicketRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final CustomerRepository customerRepository;
    private final ProjectionRepository projectionRepository;

    public List<Ticket> getTickets() {
        return ticketRepository.findAllByDeletedAtIsNull();
    }

    public Optional<Ticket> getTicketById(Integer id) {
        return ticketRepository.findByIdAndDeletedAtIsNull(id);
    }

    public void createTicket(Ticket model) {
        Ticket ticket = new Ticket();
        ticket.setUuid(UUID.randomUUID().toString());
        ticket.setSeat(model.getSeat());

        if (!customerRepository.existsByIdAndDeletedAtIsNull(model.getCustomer().getId()))
            throw new RuntimeException("CUSTOMER_NOT_FOUND");

        Customer customer = new Customer();
        customer.setId(model.getCustomer().getId());
        ticket.setCustomer(customer);

        if (!projectionRepository.existsByIdAndDeletedAtIsNull(model.getProjection().getId()))
            throw new RuntimeException("PROJECTION_NOT_FOUND");

        Projection projection = new Projection();
        projection.setId(model.getProjection().getId());
        ticket.setProjection(projection);

        ticket.setCreatedAt(LocalDateTime.now());
        ticketRepository.save(ticket);
    }

    public void updateTicket(Integer id, Ticket model) {
        Ticket ticket = this.getTicketById(id).orElseThrow();
        ticket.setSeat(model.getSeat());

        Customer customer = new Customer();
        customer.setId(model.getCustomer().getId());
        ticket.setCustomer(customer);

        Projection projection = new Projection();
        projection.setId(model.getProjection().getId());
        ticket.setProjection(projection);

        ticket.setUpdatedAt(LocalDateTime.now());
        ticketRepository.save(ticket);
    }

    public void deleteTicket(Integer id) {
        Ticket ticket = this.getTicketById(id).orElseThrow();
        ticket.setDeletedAt(LocalDateTime.now());
        ticketRepository.save(ticket);
    }
}
