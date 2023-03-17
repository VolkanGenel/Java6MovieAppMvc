package com.volkan.repository.entity;

import com.volkan.repository.entity.enums.UserType;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * userrepository - userservice usercontroller
 * -register işlemi yapalım ve verileri teker teker alalım
 * - bu veriler name surname password ve email
 */
@Builder // Builder, bir sınıftan nesne türetmek için özel oluşturulmuş bir method
@Data // Data,get, set methodlarını tanımlar
@NoArgsConstructor // Parametresiz constructor tanımlar
@AllArgsConstructor // 1....n kadar olan tüm parametreli constructorları tanımlar
@ToString // sınıf için toString methodunu tanımlar
@Entity
@Table(name = "tbluser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String surName;
    @Column(length = 50)
    private String email;
    @Column(length = 15)
    private String phone;
    @Column(length = 32)
    private String password;
    @ElementCollection
    private List<Long> favMovies;
    @ElementCollection
    private List<Long> favGenres;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UserType userType = UserType.USER;
    @ElementCollection
    private List<Long> comments;
}
