package utils;

import java.io.Serializable;

public enum Semester implements Serializable {
    FOURTH(4),
    FIFTH(5),
    SEVENTH(7);
    private Integer value;

    Semester(Integer s) {
        this.value = s;
    }
    public Integer getValue() {
        return value;
    }

}
