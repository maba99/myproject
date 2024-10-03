package com.service_desc_2.servicedesc2.controller;

import com.service_desc_2.servicedesc2.entity.Ticket;
import com.service_desc_2.servicedesc2.service.TicketService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @GetMapping("/get")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PutMapping("/{ticketId}/assign/{employeeId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Ticket assignEmployee(@PathVariable Long ticketId, @PathVariable Long employeeId) {
        return ticketService.assignEmployee(ticketId, employeeId);
    }

    @PutMapping("/{ticketId}/unassign")
    @PreAuthorize("hasRole('ADMIN')")
    public Ticket unassignEmployee(@PathVariable Long ticketId) {
        return ticketService.unassignEmployee(ticketId);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Ticket updateTicket(@RequestBody Ticket ticket) {
        return ticketService.updateTicket(ticket);
    }
}
