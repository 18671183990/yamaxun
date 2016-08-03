package com.alan.yamaxun.bean;

/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun.bean
 * className:   Time
 * author:  Alan
 * time:    2016/8/3	15:16
 * desc:    时间的实体类
 */
public class Time {
    private String hour;
    private String minute;
    private String second;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hour='" + hour + '\'' +
                ", minute='" + minute + '\'' +
                ", second='" + second + '\'' +
                '}';
    }
}
