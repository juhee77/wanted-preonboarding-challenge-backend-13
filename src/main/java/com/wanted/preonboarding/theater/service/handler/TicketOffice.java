package com.wanted.preonboarding.theater.service.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private long amount; //영화관이 가진 돈
    private final List<Ticket> tickets;

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }

    public TicketOffice(long amount, List<Ticket> tickets) {
        this.amount = amount;
        this.tickets = tickets;
    }

    public Ticket getTicket(int i){
        if (tickets.size() <= i) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 영화번호 입니다.");
        }
        return tickets.get(i);
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
