package org.example.dto;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;
@Data
public class Article {

    private Source source;
    private Object author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    public Source getSource() {
        return source;
    }


}
