package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.domain.RequestMessage;
import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Theater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(RequestMessage audienceInfo) {
        Audience audience = Audience.getInstance(audienceInfo);
        theater.enter(audience, audienceInfo.getWantedMovieNumber());
        return "Have a good time.";
    }
}
