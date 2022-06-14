package com.example.android_spring.controller;

import com.example.android_spring.domain.AndroidBoard;
import com.example.android_spring.dto.BoardDTO;
import com.example.android_spring.repository.BoardRepository;
import com.example.android_spring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    /* 게시글 등록 */
    @PostMapping("/board_Signup")
    @ResponseBody
    public void signupBoard(@RequestBody BoardDTO boardDTO) {
        System.out.println(boardDTO);
        boardService.signupBoard(boardDTO);
    }

    /* 게시글 수정 */
    /* @RequestBody 로 받을경우 JSON 형식으로 보내야 함 !!
     */
    @PutMapping("/board_Update")
    @ResponseBody
    public void updateBoard(@RequestBody BoardDTO boardDTO) {
        boardService.updateBoard(boardDTO);
    }

    /* 게시글 삭제 */
    /* @RequestParam 로 받을경우 url에 ?키값=벨류값 형식으로 맞춰줘야함 !
       여기서 받을때 키값 맞춰줘야함 = boardId
     */
    @DeleteMapping("/board_Delete/{boardId}")
    public void deleteBoard(@PathVariable("boardId") Long boardId) {
        boardService.deleteBoard(boardId);
    }

    /* 게시글 조회 (최신순) */
    @GetMapping("/board_List")
    public List<AndroidBoard> MyList() {
        List<AndroidBoard> boardList = boardRepository.findAllListDesc();
        return boardList;
    }

    /* 게시글 조회 (조회순) */
    @GetMapping("/board_ViewList")
    public List<AndroidBoard> MyViewList() {
        List<AndroidBoard> boardList = boardRepository.findAllListViewDesc();
        return boardList;
    }

    /* 게시글 상세조회 */
    @GetMapping("/board_DetailList/{boardId}")
    public AndroidBoard MyViewDetailList(@PathVariable("boardId") Long boardId) {
        Optional<AndroidBoard> androidBoard = boardRepository.findById(boardId);
        androidBoard.get().setBoardViews(androidBoard.get().getBoardViews() + 1);
        boardRepository.save(androidBoard.get());
        return androidBoard.get();
    }

//    /* 게시글 조회수 UP */
//    @PostMapping("/board_CountView")
//    public void countAddView(@RequestParam Long boardId) {
//        boardService.addViewBoard(boardId);
//    }

    /* 게시글 검색 */
    @GetMapping("/board_Search/{searchBoard}")
    public List<AndroidBoard> searchCampingList(@PathVariable("searchBoard") String searchBoard) {
        List<AndroidBoard> androidBoards = boardRepository.findAllBysearchBoard(searchBoard);
        return androidBoards;
    }



}

