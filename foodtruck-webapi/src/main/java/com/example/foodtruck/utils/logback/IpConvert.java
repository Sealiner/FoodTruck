package com.example.foodtruck.utils.logback;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;

@Slf4j
public class IpConvert extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {
        try {
            log.trace("IpConvert-------InetAddress.getLocalHost():{}", InetAddress.getLocalHost());
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            log.error("Error when getting ip", e);
        }
        return null;
    }
}