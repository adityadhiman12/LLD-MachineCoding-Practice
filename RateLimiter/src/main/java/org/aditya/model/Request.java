package org.aditya.model;

import java.time.Instant;

public class Request {
    private Instant timeStamp;
    private Integer count;

    public Request(Instant timeStamp, Integer count) {
        this.timeStamp = timeStamp;
        this.count = count;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
