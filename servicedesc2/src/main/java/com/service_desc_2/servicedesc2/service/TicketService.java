package com.service_desc_2.servicedesc2.service;

import com.service_desc_2.servicedesc2.entity.Employee;
import com.service_desc_2.servicedesc2.entity.Ticket;
import com.service_desc_2.servicedesc2.repository.EmployeeRepository;
import com.service_desc_2.servicedesc2.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final EmployeeRepository employeeRepository;

    public TicketService(TicketRepository ticketRepository, EmployeeRepository employeeRepository) {
        this.ticketRepository = ticketRepository;
        this.employeeRepository = employeeRepository;
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket assignEmployee (Long ticketId, Long employeeId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        ticket.setAssignedEmployee(employee);
        return ticketRepository.save(ticket);
    }

    public Ticket unassignEmployee (Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
        ticket.setAssignedEmployee(null);
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
