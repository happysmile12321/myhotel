package com.hm.pojo;

/*mybatis一对多关联查询*/
public class KefangFeilei {
    private Fenlei fenlei;
    private Kefang kefang;

    public Fenlei getFenlei() {
        return fenlei;
    }

    public void setFenlei(Fenlei fenlei) {
        this.fenlei = fenlei;
    }

    public Kefang getKefang() {
        return kefang;
    }

    public void setKefang(Kefang kefang) {
        this.kefang = kefang;
    }
}
