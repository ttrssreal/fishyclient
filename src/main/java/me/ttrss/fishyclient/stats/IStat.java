package me.ttrss.fishyclient.stats;

public interface IStat<T> {
    void setValue(T value);
    String getValue();
    String getName();
    boolean hasColor();
    int getColor();
}
