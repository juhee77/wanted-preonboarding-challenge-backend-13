package com.wanted.preonboarding.theater.service.handler;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Theater {
    private TicketSeller ticketSeller;

    public Theater() {
        ticketSeller = setTicketSeller(0L, List.of(7000L, 8000L, 8080L));
    }

    private TicketSeller setTicketSeller(Long amount, List<Long> tickeList) {
        List<Ticket> tickets = tickeList.stream().map(Ticket::new).collect(Collectors.toList());

        TicketOffice ticketOffice = new TicketOffice(amount, tickets);
        this.ticketSeller = new TicketSeller(ticketOffice);
        return ticketSeller;
    }

    public void enter(Audience audience, int wantedMovie) {
        Ticket ticket = ticketSeller.getTicketOffice().getTicket(wantedMovie); //구매하려는 티켓

        if (!audience.getBag().hasInvitation()) { //초대권이 없는 경우만 티켓을 구매한다.
            buyTicket(audience, ticket);
        }

        audience.getBag().setTicket(ticket);
    }

    private void buyTicket(Audience audience, Ticket ticket) {
        audience.getBag().minusAmount(ticket.getFee()); //구매하려는 티켓을 구매한다.
        ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
    }
}
