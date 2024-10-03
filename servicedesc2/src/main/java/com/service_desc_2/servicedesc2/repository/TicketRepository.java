package com.service_desc_2.servicedesc2.repository;

import com.service_desc_2.servicedesc2.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> { ;
}
