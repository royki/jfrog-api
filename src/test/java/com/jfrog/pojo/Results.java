package com.jfrog.pojo;

public class Results {
    private String uri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "ClassPojo [uri = " + uri + "]";
    }
}