package com.service_desc_2.servicedesc2.service;

import com.service_desc_2.servicedesc2.entity.Employee;
import com.service_desc_2.servicedesc2.entity.Ticket;
import com.service_desc_2.servicedesc2.repository.EmployeeRepository;
import com.service_desc_2.servicedesc2.repository.TicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TicketServiceTest {

    private TicketRepository ticketRepository;
    private EmployeeRepository employeeRepository;
    private TicketService ticketService;

    @BeforeEach
    void setUp() {
        ticketRepository = mock(TicketRepository.class);
        employeeRepository = mock(EmployeeRepository.class);
        ticketService = new TicketService(ticketRepository, employeeRepository);
    }

    @Test
    void createTicket() {
        Ticket ticket = new Ticket();
        ticket.setTitle("Test Ticket");

        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);

        Ticket createdTicket = ticketService.createTicket(ticket);

        assertNotNull(createdTicket);
        assertEquals("Test Ticket", createdTicket.getTitle());
    }

    @Test
    void getAllTickets() {
        Ticket ticket1 = new Ticket();
        ticket1.setTitle("Test Ticket 1");

        Ticket ticket2 = new Ticket();
        ticket2.setTitle("Test Ticket 2");

        when(ticketRepository.findAll()).thenReturn(List.of(ticket1, ticket2));

        List<Ticket> tickets = ticketService.getAllTickets();

        assertEquals(2, tickets.size());
    }
}
