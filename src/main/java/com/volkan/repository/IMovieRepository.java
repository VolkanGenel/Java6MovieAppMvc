package com.volkan.repository;

import com.volkan.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
@Transactional //
public interface IMovieRepository extends JpaRepository<Movie,Long> {
    List<Movie> findAllByRatingGreaterThan (double rate);
    List<Movie> findAllByPremiredBefore(LocalDate date);

    @Query("select rating,count(rating) from Movie group by rating")
    Object [] searchByRating();
    @Query("select rating,count(rating) from Movie group by rating having rating=?1")
    Object searchByRating(double rate);
    List<Movie> findAllByRatingIn(List<Double> ratings);
    List<Movie> findAllByNameIn(List<String> names);
    Integer countAllByRating(double rating);



}
