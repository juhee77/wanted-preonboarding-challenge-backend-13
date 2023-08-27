package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.domain.RequestMessage;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public static Audience getInstance(RequestMessage audienceInfo) {
        Bag bag;
        if (audienceInfo.getInvitation() != null) {
            bag = new Bag(new Invitation(audienceInfo.getInvitation()), audienceInfo.getAudienceAmount());
        }else{
            bag = new Bag(audienceInfo.getAudienceAmount());
        }
        return new Audience(bag);
    }

    public Bag getBag(){ return bag;}
}