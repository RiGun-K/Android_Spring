package com.example.android_spring.repository;

import com.example.android_spring.domain.AndroidBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<AndroidBoard, Long> {

    @Query(value = "SELECT * FROM board b WHERE b.title LIKE %:searchBoard%", nativeQuery = true)
    List<AndroidBoard> findAllBysearchBoard(@Param("searchBoard") String searchBoard);

    @Query(value = "SELECT * FROM board b ORDER BY b.saved_time DESC", nativeQuery = true)
    List<AndroidBoard> findAllListDesc();

    @Query(value = "SELECT * FROM board b ORDER BY b.board_views DESC", nativeQuery = true)
    List<AndroidBoard> findAllListViewDesc();
}
