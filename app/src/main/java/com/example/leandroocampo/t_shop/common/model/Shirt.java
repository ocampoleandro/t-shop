package com.example.leandroocampo.t_shop.common.model;

import org.parceler.Parcel;

@Parcel(Parcel.Serialization.BEAN)
public class Shirt extends BaseEntity {

    private String name;
    private long price = 0;
    private String colour;
    private int quantity = 0;
    private String size;
    private String picture;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shirt shirt = (Shirt) o;

        if (price != shirt.price) return false;
        if (!name.equals(shirt.name)) return false;
        if (!colour.equals(shirt.colour)) return false;
        if (!size.equals(shirt.size)) return false;
        return picture.equals(shirt.picture);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (int) (price ^ (price >>> 32));
        result = 31 * result + colour.hashCode();
        result = 31 * result + size.hashCode();
        result = 31 * result + picture.hashCode();
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
