package com.robintegg.blend.web;

import java.net.URL;

import lombok.SneakyThrows;

public class UrlFormatter {

    @SneakyThrows
    public String format(String url) {
        if(url == null) return null;
        return new URL(url).getHost();
    }

}
