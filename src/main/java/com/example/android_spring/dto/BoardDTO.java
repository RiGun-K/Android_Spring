package com.example.android_spring.dto;

import com.example.android_spring.domain.AndroidBoard;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDTO {

    private Long boardId;
    private String title;
    private String content;
    private String password;
    private Integer boardViews = 0;
    private String savedTime;

    @Builder
    public BoardDTO(Long boardId, String title, String content) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
    }

    public BoardDTO(AndroidBoard androidBoard) {
        this.boardId = androidBoard.getBoardId();
        this.title = androidBoard.getTitle();
        this.content = androidBoard.getContent();
    }

}
