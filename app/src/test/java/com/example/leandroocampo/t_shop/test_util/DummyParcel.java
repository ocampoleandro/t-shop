package com.example.leandroocampo.t_shop.test_util;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel(Parcel.Serialization.BEAN)
public class DummyParcel {

    private String field;

    @ParcelConstructor
    public DummyParcel(String field){
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DummyParcel that = (DummyParcel) o;

        return field.equals(that.field);

    }

    @Override
    public int hashCode() {
        return field.hashCode();
    }

    public String getField() {
        return field;
    }
}
