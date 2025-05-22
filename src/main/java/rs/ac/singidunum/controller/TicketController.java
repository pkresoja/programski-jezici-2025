package rs.ac.singidunum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Ticket;
import rs.ac.singidunum.service.TicketService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/api/ticket")
public class TicketController {

    private final TicketService service;

    @GetMapping
    public List<Ticket> getTickets() {
        return service.getTickets();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getTicketById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createTicket(@RequestBody Ticket ticket) {
        service.createTicket(ticket);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createTicket(@PathVariable Integer id, @RequestBody Ticket ticket) {
        service.updateTicket(id, ticket);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicket(@PathVariable Integer id) {
        service.deleteTicket(id);
    }
}
