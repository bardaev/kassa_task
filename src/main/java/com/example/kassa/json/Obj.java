package com.example.kassa.json;

import java.io.Serializable;

public class Obj implements Serializable {

    private Long current;

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }
}
