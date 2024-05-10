package com.mini_project.modal;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Books {
    private Integer id;
    private String name;
    private Double price;
    private Integer stock;
    private String author;
    private Integer totalPages;
    private Integer yearCreated;
    private boolean status;
    private Categories category;

}
