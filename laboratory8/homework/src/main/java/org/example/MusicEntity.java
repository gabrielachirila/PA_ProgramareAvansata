package org.example;

public abstract class MusicEntity {
    protected int id;

    public MusicEntity() {}

    public void setId (int id) {
        this.id = id;
    }

    public int getId () {
        return this.id;
    }
}
