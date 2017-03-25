package com.tamine.changeprefix;

/**
 * Created by huylv on 25-Mar-17.
 */

public class Changing {
    public int indexInContacts;
    public int indexInPrefix;
    public int type;
    public int length;

    public Changing(int indexInContacts, int indexInPrefix, int type, int length) {
        this.indexInContacts = indexInContacts;
        this.indexInPrefix = indexInPrefix;
        this.type = type;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Changing{" +
                "indexInContacts=" + indexInContacts +
                ", indexInPrefix=" + indexInPrefix +
                ", type=" + type +
                ", length=" + length +
                '}';
    }
}
