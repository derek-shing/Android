package com.lambdaschool.intentsdemo;

public class Image {
    private String uri;
    private String name;

    public Image(String uri, String name) {
        this.uri = uri;
        this.name = name;
    }

    public Image(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public String getName() {
        return name;
    }
}
