package com.ll.basic1.question;

import java.time.LocalDateTime;
import java.util.List;

import com.ll.basic1.answer.Answer;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
    @Id // ID 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 고유 값, 자동 증가
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT") // 길이 제한 없는 텍스트
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) // 일대다, 질문 삭제 시 종속된 답변도 삭제
    private List<Answer> answerList;
}

