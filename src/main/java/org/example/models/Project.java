package org.example.models;

public class Project {
    private int id;
    private String name;

    private double value;

    public Project(final int id, final String name, final double value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }


    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(final double value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }
}
