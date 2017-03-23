package com.tamine.changeprefix;

/**
 * Created by huylv on 17-Mar-17.
 */

public class Contact  {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    long id;
    String name;
    String number;

    public boolean isChange() {
        return change;
    }

    public void setChange(boolean change) {
        this.change = change;
    }

    boolean change;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Contact( String name, String number) {
        this.name = name;
        this.number = number;
    }
}
