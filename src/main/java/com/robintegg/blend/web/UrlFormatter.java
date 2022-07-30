package com.robintegg.blend.web;

import java.net.URL;

import lombok.SneakyThrows;

public class UrlFormatter {

    @SneakyThrows
    public String format(String url) {
        return new URL(url).getHost();
    }

}
