package br.com.jccf.springdepth.services.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ofPattern;

@Service
public class TimeService {

    @Value("${app.is24}")
    private Boolean is24;

    public String getTime() {
        var localTime = LocalDateTime.now();

        if (is24) {
            return localTime.format(ofPattern("dd/MM/yyyy kk:mm:ss"));
        }
        return localTime.format(ofPattern("dd/MM/yyyy hh:mm:ss"));
    }
}
