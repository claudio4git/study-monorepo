package br.com.jccf.springdepth.services.nonbean;

import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ofPattern;

public class TimeService {

    private final Boolean is24;

    public TimeService(Boolean is24) {
        this.is24 = is24;
    }

    public String getTime() {
        var localTime = LocalDateTime.now();

        if (is24) {
            return localTime.format(ofPattern("dd/MM/yyyy kk:mm:ss"));
        }
        return localTime.format(ofPattern("dd/MM/yyyy hh:mm:ss"));
    }
}
