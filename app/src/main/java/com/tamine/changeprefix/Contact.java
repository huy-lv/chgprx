package com.tamine.changeprefix;

/**
 * Created by huylv on 17-Mar-17.
 */

public class Contact  {

    public int sectionManager;
    public int sectionFirstPosition;
    public boolean isHeader;
    boolean change;
    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Contact(String name, boolean isHeader, int sectionManager, int sectionFirstPosition) {
        this.name = name;
        change = true;
        this.sectionManager = sectionManager;
        this.sectionFirstPosition = sectionFirstPosition;
        this.isHeader = isHeader;
    }

    public Contact(Contact c, boolean isHeader, int sectionManager, int sectionFirstPosition) {
        this.name = c.getName();
        this.number = c.getNumber();
        change = true;
        this.sectionManager = sectionManager;
        this.sectionFirstPosition = sectionFirstPosition;
        this.isHeader = isHeader;
    }

    public int getSectionManager() {
        return sectionManager;
    }

    public void setSectionManager(int sectionManager) {
        this.sectionManager = sectionManager;
    }

    public int getSectionFirstPosition() {
        return sectionFirstPosition;
    }

    public void setSectionFirstPosition(int sectionFirstPosition) {
        this.sectionFirstPosition = sectionFirstPosition;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

    public boolean isChange() {
        return change;
    }

    public void setChange(boolean change) {
        this.change = change;
    }

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

    public void setValue(String header, boolean b, int sectionManager, int sectionFirstPosition) {
        name = header;
        isHeader = b;
        this.sectionManager = sectionManager;
        this.sectionFirstPosition = sectionFirstPosition;
    }

    public void setValue(boolean b, int sectionManager, int sectionFirstPosition) {
        isHeader = b;
        this.sectionManager = sectionManager;
        this.sectionFirstPosition = sectionFirstPosition;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", sectionManager=" + sectionManager +
                ", sectionFirstPosition=" + sectionFirstPosition +
                ", isHeader=" + isHeader +
                ", change=" + change +
                '}';
    }
}
