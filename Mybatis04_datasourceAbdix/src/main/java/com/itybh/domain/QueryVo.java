package com.itybh.domain;

import java.util.List;

public class QueryVo {
    private User user;
    private List<Integer> snum;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getSnum() {
        return snum;
    }

    public void setSnum(List<Integer> snum) {
        this.snum = snum;
    }
}
