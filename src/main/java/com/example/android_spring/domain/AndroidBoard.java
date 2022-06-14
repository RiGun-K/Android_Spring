package com.example.android_spring.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "board")
public class AndroidBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardId;

    @Column()
    private String title;
    private String content;
    private String password;

    @Column
    private Integer boardViews = 0;
    @CreatedDate
    private String savedTime;

    public AndroidBoard(){}

    public AndroidBoard(Long boardId, String title, String content, String password, Integer boardViews, String savedTime) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.password = password;
        this.boardViews = boardViews;
        this.savedTime = savedTime;
    }
}
