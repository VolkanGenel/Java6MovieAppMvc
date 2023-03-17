package com.volkan.repository.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Builder // Builder, bir sınıftan nesne türetmek için özel oluşturulmuş bir method
@Data // Data,get, set methodlarını tanımlar
@NoArgsConstructor // Parametresiz constructor tanımlar
@AllArgsConstructor // 1....n kadar olan tüm parametreli constructorları tanımlar
@ToString // sınıf için toString methodunu tanımlar
@Entity
@Table(name = "tblmovie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;
    private String image;
    private String name;
    private String country;
    private Double rating;
    @Lob
    private String summary;
    private LocalDate premired;
    private String url;
    @ElementCollection
    private List<Long> genres;
    @ElementCollection (fetch = FetchType.EAGER)
    private List<Long> comments;
}
