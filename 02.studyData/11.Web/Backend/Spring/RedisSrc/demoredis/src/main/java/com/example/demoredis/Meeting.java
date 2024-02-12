package com.example.demoredis;


import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDate;

@RedisHash("Meetings")
public class Meeting {

    @Id
    private String id;
    private String title;
    private LocalDate startAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDate startAt) {
        this.startAt = startAt;
    }
}
