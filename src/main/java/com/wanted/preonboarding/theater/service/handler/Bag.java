package com.wanted.preonboarding.theater.service.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class Bag {
    private Long amount; //가지고 있는 돈
    private final Invitation invitation; //초대날짜
    private Ticket ticket;//티켓 발급 이후에 고객이 가지고 있는 티켓

    public Bag(long amount){
        this(null, amount);
    }
    public Bag(Invitation invitation, long amount){
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }
    public boolean hasTicket() {
        return ticket != null;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public void minusAmount(long amount) {
        if (this.amount < amount) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "금액이 부족합니다.");
        }
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
