package com.jfrog.pojo;

public class GETArtifactsAPIPojo {
    private String path;

    private String lastUpdated;

    private Children[] children;

    private String created;

    private String repo;

    private String lastModified;

    private String uri;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Children[] getChildren() {
        return children;
    }

    public void setChildren(Children[] children) {
        this.children = children;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "ClassPojo [path = " + path + ", lastUpdated = " + lastUpdated + ", children = " + children + ", created = " + created + ", repo = " + repo + ", lastModified = " + lastModified + ", uri = " + uri + "]";
    }

}