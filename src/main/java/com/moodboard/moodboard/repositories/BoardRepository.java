package com.moodboard.moodboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moodboard.moodboard.entities.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
