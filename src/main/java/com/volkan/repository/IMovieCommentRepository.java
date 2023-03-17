package com.volkan.repository;

import com.volkan.repository.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IMovieCommentRepository extends JpaRepository<MovieComment,Long> {
    List<MovieComment> findAllByMovieId(Long movieId);
    List<MovieComment> findAllByUserId(Long userId);
    List<MovieComment> findAllByMovieIdAndDateBetween(Long movieId, LocalDate startDate, LocalDate endDate);
    List<MovieComment> findAllByUserIdAndDateBetween(Long userId, LocalDate startDate, LocalDate endDate);

}
