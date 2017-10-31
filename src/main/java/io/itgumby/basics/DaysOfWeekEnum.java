package io.itgumby.basics;

import lombok.Getter;

@Getter
public enum DaysOfWeekEnum {

    SUNDAY("off"),
    MONDAY("working"),
    TUESDAY("working"),
    WEDNESDAY("working"),
    THURSDAY("working"),
    FRIDAY("working"),
    SATURDAY("off");

    private String typeOfDay;
    DaysOfWeekEnum(String type) {
        typeOfDay = type;
    }
}
