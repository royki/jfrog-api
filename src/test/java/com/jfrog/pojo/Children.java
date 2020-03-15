package com.jfrog.pojo;

public class Children {
    private String folder;

    private String uri;

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "ClassPojo [folder = " + folder + ", uri = " + uri + "]";
    }
}