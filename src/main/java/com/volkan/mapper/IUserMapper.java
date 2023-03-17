package com.volkan.mapper;


import com.volkan.dto.request.MovieCommentCreateRequestDto;
import com.volkan.dto.request.UserRegisterRequestDto;
import com.volkan.dto.response.LoginResponseDto;
import com.volkan.repository.entity.Movie;
import com.volkan.repository.entity.MovieComment;
import com.volkan.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Heer framework ve uygulama için nesne yaratma ve işleme mekanizmaları farklıdır bu nedenle
 * SpringBoot için Mapper kullanılacak ise Model olarak spring kullanılacağı belirtilmelidir.
 * TargetPolicy -> Eşleştirme yapılacak ikii bileşen(Object) birebir birbirine uymayabilir,
 * bu nedenle eşleştirme yaparken istisna fırlatır. İşte bu noktada eşleşmeyen alanların
 * görmezden gelinmesi için IGNORE kullanmak mantıklı olacaktır.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    /**
     * Bu interface den bir nesne yaratmak için kullanılır.
     */
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);
    /**
     * Buradan itibaren dönüşüm yapmak istediğimiz sınıflara ait methodlar tanımlıyoruz.
     * DİKKATTT!!!!
     * burada yazılan methodun adının ve kullanılan keywordlerin bir önemi yoktur.
     */
    User toUser(final UserRegisterRequestDto dto);
    LoginResponseDto toLoginResponseDto(final User user);
    MovieComment toMovieComment(final MovieCommentCreateRequestDto dto);
}
