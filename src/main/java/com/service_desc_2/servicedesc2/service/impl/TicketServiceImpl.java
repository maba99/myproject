package com.service_desc_2.servicedesc2.service.impl;

import com.service_desc_2.servicedesc2.entity.Ticket;

import java.util.List;

public interface TicketServiceImpl {
    Ticket createTicket(Ticket ticket);
    Ticket assignEmployee(Long ticketId, Long employeeId);
    Ticket unassignEmployee(Long ticketId);
    List<Ticket> getAllTickets();
    Ticket updateTicket(Ticket ticket);
}