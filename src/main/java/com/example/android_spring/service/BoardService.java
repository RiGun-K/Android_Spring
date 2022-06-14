package com.example.android_spring.service;


import com.example.android_spring.domain.AndroidBoard;
import com.example.android_spring.dto.BoardDTO;
import com.example.android_spring.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;


    public void signupBoard(BoardDTO boardDTO) {

        /* 실제 DB에 값을 저장하기 위해서는 객체불러서 넣어야함 */
        AndroidBoard androidBoard = new AndroidBoard();
        androidBoard.setTitle(boardDTO.getTitle());
        androidBoard.setContent(boardDTO.getContent());
        androidBoard.setPassword(boardDTO.getPassword());
        androidBoard.setSavedTime(LocalDate.now().toString());
        boardRepository.save(androidBoard);
//
//        boardDTO.setTitle(boardDTO.getTitle());
//        boardDTO.setContent(boardDTO.getContent());
//        boardDTO.setPassword(boardDTO.getPassword());
    }

    public void updateBoard(BoardDTO boardDTO) {
        Optional<AndroidBoard> androidBoard = boardRepository.findById(boardDTO.getBoardId());
        androidBoard.get().setTitle(boardDTO.getTitle());
        androidBoard.get().setContent(boardDTO.getContent());
//        androidBoard.get().setPassword(boardDTO.getPassword());
        androidBoard.get().setSavedTime(LocalDate.now().toString());
        boardRepository.save(androidBoard.get());
    }

    public void deleteBoard(Long boardId) {
        Optional<AndroidBoard> androidBoard = boardRepository.findById(boardId);
        boardRepository.delete(androidBoard.get());
    }

    public void addViewBoard(Long boardId) {
        Optional<AndroidBoard> androidBoard = boardRepository.findById(boardId);
        androidBoard.get().setBoardViews(androidBoard.get().getBoardViews() + 1);
        boardRepository.save(androidBoard.get());
    }
}
