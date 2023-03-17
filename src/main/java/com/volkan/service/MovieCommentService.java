package com.volkan.service;

import com.volkan.repository.IMovieCommentRepository;
import com.volkan.repository.entity.MovieComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieCommentService implements IServiceCrud<MovieComment> {
    private final IMovieCommentRepository movieCommentRepository;

    @Override
    public MovieComment save(MovieComment movieComment) {
        return movieCommentRepository.save(movieComment);
    }

    @Override
    public Iterable<MovieComment> saveAll(Iterable<MovieComment> t) {
        return movieCommentRepository.saveAll(t);
    }

    @Override
    public MovieComment update(MovieComment movieComment) {
        return null;
    }

    @Override
    public void delete(MovieComment movieComment) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<MovieComment> findAll() {
        return movieCommentRepository.findAll();
    }

    @Override
    public Optional<MovieComment> findById(long id) {
        return movieCommentRepository.findById(id);
    }

    public List<MovieComment> findAllByMovieId(Long movieId) {
        return findAllByMovieId(movieId);
    }
    public List<MovieComment> findAllByUserId(Long userId) {
        return findAllByUserId(userId);
    }
    
    public List<MovieComment> findAllByMovieIdAndDateBetween(Long movieId, String startDate, String endDate) {
        LocalDate date1 = LocalDate.parse(startDate);
        LocalDate date2 = LocalDate.parse(endDate);
        return movieCommentRepository.findAllByMovieIdAndDateBetween(movieId,date1,date2);
    }
    public List<MovieComment> findAllByUserIdAndDateBetween(Long userId, String startDate, String endDate) {
        LocalDate date1 = LocalDate.parse(startDate);
        LocalDate date2 = LocalDate.parse(endDate);
        return movieCommentRepository.findAllByUserIdAndDateBetween(userId,date1,date2);
    }

}
