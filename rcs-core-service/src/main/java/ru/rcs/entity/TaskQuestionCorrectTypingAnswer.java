package ru.rcs.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Правильный ответ на вопрос задания с типом typing
 */
@Getter
@Setter
@Entity
@ToString
@Accessors(chain = true)
@RequiredArgsConstructor
@Table(name = "task_question_correct_typing_answer")
public class TaskQuestionCorrectTypingAnswer {

    /**
     * Идентификатор текста задания
     */
    @Id
    @NotNull
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    /**
     * Задание
     */
    @Exclude
    @NotNull
    @OneToOne
    @JoinColumn(name = "task_question_id")
    private TaskQuestion taskQuestion;

    /**
     * Правильный текстовый ответ
     */
    @NotNull
    @Column(name = "correct_typing_answer")
    private String correctTypingAnswer;

}
