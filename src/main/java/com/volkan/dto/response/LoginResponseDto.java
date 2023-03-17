package com.volkan.dto.response;

import com.volkan.repository.entity.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder // Builder, bir sınıftan nesne türetmek için özel oluşturulmuş bir method
@Data // Data,get, set methodlarını tanımlar
@NoArgsConstructor // Parametresiz constructor tanımlar
@AllArgsConstructor // 1....n kadar olan tüm parametreli constructorları tanımlar
public class LoginResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
//    private List<Long> favMovies;
//    private List<Long> favGenres;
    private UserType userType;
    private List<Long> comments;
}
