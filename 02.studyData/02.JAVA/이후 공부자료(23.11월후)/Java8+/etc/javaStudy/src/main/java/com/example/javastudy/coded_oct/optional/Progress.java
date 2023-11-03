package com.example.javastudy.coded_oct.optional;

import java.time.Duration;

public class Progress {
    private Duration studyDuration;

    private boolean finished;

    public Duration getStudyDuration(){
        return studyDuration;
    }

    public void setStudyDuration(Duration duration){
        this.studyDuration = studyDuration;
    }
}
