package com.ll.basic1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import com.ll.basic1.answer.Answer;
import com.ll.basic1.question.Question;
import com.ll.basic1.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Transactional // 테스트 때만 발생. 재기동
    @Test
    void testJpa() {
        Optional<Question> oq = this.questionRepository.findById(2); // 질문 아이디가 2값인거 oq에 넣고
        assertTrue(oq.isPresent()); // 존재한다면
        Question q = oq.get(); // q에 oq 불러오고

        List<Answer> answerList = q.getAnswerList(); // q에 답변리스트 불러오고

        assertEquals(1, answerList.size()); // 답변리스트 크기가 1이냐
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent()); // 답변이 ""냐
    }
}