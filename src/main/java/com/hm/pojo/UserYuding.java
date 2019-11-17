package com.hm.pojo;

import java.util.List;

/*mybatis一对多关联查询*/
public class UserYuding {

    private User user;
    private Fenlei fenlei;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Fenlei getFenlei() {
        return fenlei;
    }

    public void setFenlei(Fenlei fenlei) {
        this.fenlei = fenlei;
    }
}
