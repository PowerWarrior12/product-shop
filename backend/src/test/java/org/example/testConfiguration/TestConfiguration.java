package org.example.testConfiguration;

import org.example.utils.TimeProvider;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.time.Duration;
import java.time.Instant;

@org.springframework.boot.test.context.TestConfiguration
public class TestConfiguration {
    @Bean
    @Primary
    TimeProvider getTimeProvider() {
        TimeProvider timeProvider = Mockito.mock(TimeProvider.class);

        Instant start = Instant.now();
        Instant end = start.plusSeconds(10000);
        Mockito.when(timeProvider.getCurrentTimeOfCurrentTimeZone()).thenReturn(start);
        Mockito.when(timeProvider.getTimeOfCurrentTimeZoneWithOffset(start, Duration.ofMinutes(30))).thenReturn(end);

        return timeProvider;
    }
}
