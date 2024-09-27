package org.example.dto;

import lombok.Data;
import java.util.List;
@Data
public class NewsApiResponse {

    private String status;
    private Integer totalResults;
    private List<Article> articles;



}









