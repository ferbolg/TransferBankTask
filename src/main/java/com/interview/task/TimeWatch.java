package com.interview.task;

import java.util.concurrent.TimeUnit;

/**
 * Created by szi on 4/23/2017.
 */
/*
    Idea borrowed from here: http://stackoverflow.com/questions/1770010/how-do-i-measure-time-elapsed-in-java
 */
public class TimeWatch {
    long starts;

    public static TimeWatch start() {
        return new TimeWatch();
    }

    private TimeWatch() {
        reset();
    }

    public TimeWatch reset() {
        starts = System.nanoTime();
        return this;
    }

    public long time() {
        long ends = System.nanoTime();
        return ends - starts;
    }

    public long time(TimeUnit unit) {
        return unit.convert(time(), TimeUnit.NANOSECONDS);
    }
}
