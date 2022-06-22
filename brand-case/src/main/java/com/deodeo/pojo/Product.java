package com.deodeo.pojo;

public class Product {
    private Integer id; //商品id
    private String number;//商品编号
    private String tradeName;//商品名
    private Integer type;//商品名
    private String date;//商品生产日期
    private String quality;//商品保质期
    private Integer stock;//商品库存
    private String unit;//商品计量单位
    private String typeName;
    public Integer getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", tradeName='" + tradeName + '\'' +
                ", date='" + date + '\'' +
                ", quality='" + quality + '\'' +
                ", stock=" + stock +
                ", unit='" + unit + '\'' +
                '}';
    }

}

/*
    insert into tb_product (id, number, trade_name, date, quality, stock, unit)
    values(null,'5588722','芬达','2022-4-20','365天',100000,'瓶');

    insert into tb_product (id, number, trade_name, date, quality, stock, unit)
    values(null,'5588723','乐事薯片','2022-4-20','18个月',666666,'包');

    insert into tb_product (id, number, trade_name, date, quality, stock, unit)
    values(null,'5588724','可比克薯片','2022-4-20','18个月',52410,'包');

    insert into tb_product (id, number, trade_name, date, quality, stock, unit)
    values(null,'5588725','冰红茶热带风味','2022-4-20','18个月',80142,'瓶');

    insert into tb_product (id, number, trade_name, date, quality, stock, unit)
    values(null,'5588726','干酪蛋糕','2022-4-20','365天',841002,'袋');

    insert into tb_product (id, number, trade_name, date, quality, stock, unit)
    values(null,'5588790','汤达人豚骨','2022-4-20','18个月',30000,'包');

    insert into tb_product (id, number, trade_name, date, quality, stock, unit)
    values(null,'5588788','UFO飞碟泡面','2022-4-20','18个月',54020,'盒');

    insert into tb_product (id, number, trade_name, date, quality, stock, unit)
    values(null,'5588711','东北大板','2022-4-20','30天',400,'包');*/
