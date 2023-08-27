package com.wanted.preonboarding.theater.domain;

import java.time.LocalDateTime;

public class RequestMessage {
        private LocalDateTime invitation; //초대권을 가지고 있는 경우
        private int wantedMovieNumber; //몇번쨰 영화를 보려고 하는지
        private Long audienceAmount;//손님이 가진 돈

    public RequestMessage(LocalDateTime invitation, int wantedMovieNumber, Long audienceAmount) {
        this.invitation = invitation;
        this.wantedMovieNumber = wantedMovieNumber;
        this.audienceAmount = audienceAmount;
    }

    public RequestMessage(int wantedMovieNumber, Long audienceAmount) {
        invitation = null;
        this.wantedMovieNumber = wantedMovieNumber;
        this.audienceAmount = audienceAmount;
    }

    public LocalDateTime getInvitation() {
        return invitation;
    }

    public int getWantedMovieNumber() {
        return wantedMovieNumber;
    }

    public Long getAudienceAmount() {
        return audienceAmount;
    }
}
