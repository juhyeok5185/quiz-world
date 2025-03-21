package com.danny.quizworld.schedule;


import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduledTasks {

    private final ScheduledTasksFacade scheduledTasksFacade;

    @Scheduled(cron = "0 1 0 * * *", zone = "Asia/Seoul")
    public void triggerAtMidnight01() {
        scheduledTasksFacade.expiredSubscribe();
    }



}
