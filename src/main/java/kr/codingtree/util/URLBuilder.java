package kr.codingtree.util;

import lombok.SneakyThrows;

import java.net.URL;
import java.net.URLEncoder;

public class URLBuilder {

    private String url;
    private StringBuilder sb = new StringBuilder();

    public URLBuilder(String url) {
        this.url = url;
    }

    @SneakyThrows
    public URLBuilder append(String key, String value) {
        if (sb.length() > 0) {
            sb.append("&");
        } else {
            sb.append("?");
        }

        sb.append(URLEncoder.encode(key, "UTF-8"))
                .append("=")
                .append(URLEncoder.encode(value, "UTF-8"));

        return this;
    }

    @SneakyThrows
    public URL toURL() {
        return new URL(url + sb.toString());
    }

}
