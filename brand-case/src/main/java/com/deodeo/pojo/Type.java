package com.deodeo.pojo;

public class Type {
    private Integer id; //商品id
    private String typename; //商品类型名
    private Integer dec; //权重

    public Type() {
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                ", dec=" + dec +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getDec() {
        return dec;
    }

    public void setDec(Integer dec) {
        this.dec = dec;
    }
}
