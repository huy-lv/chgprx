package com.tamine.changeprefix;

/**
 * Created by huylv on 24-Mar-17.
 */

public class Prefix {
    String province;
    int oldPrefix;
    int newPrefix;

    public Prefix(String province, int oldPrefix, int newPrefix) {

        this.province = province;
        this.oldPrefix = oldPrefix;
        this.newPrefix = newPrefix;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getOldPrefix() {
        return oldPrefix;
    }

    public void setOldPrefix(int oldPrefix) {
        this.oldPrefix = oldPrefix;
    }

    public int getNewPrefix() {
        return newPrefix;
    }

    public void setNewPrefix(int newPrefix) {
        this.newPrefix = newPrefix;
    }
}
