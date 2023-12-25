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
 * Вопросы заданий
 */
@Getter
@Setter
@Entity
@ToString
@Accessors(chain = true)
@RequiredArgsConstructor
@Table(name = "task_question")
public class TaskQuestion {

    /**
     * Идентификатор вопроса
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
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    /**
     * Номер вопроса в задании
     */
    @NotNull
    @Column(name = "number")
    private Integer number;

    /**
     * Текст вопроса
     */
    @NotNull
    @Column(name = "text")
    private String text;

    /**
     * Предзаполненный ответ
     */
    @NotNull
    @Column(name = "prefilled_answer")
    private String prefilledAnswer;

    /**
     * Изображение для вопроса задания
     */
    @OneToOne(targetEntity = Image.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "task_question_image", joinColumns = @JoinColumn(name = "task_question_id"))
    private Image taskQuestionImage;

    /**
     * Правильный ответ на вопрос задания с типом typing
     */
    @OneToOne(targetEntity = TaskQuestionCorrectTypingAnswer.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "task_question_correct_typing_answer", joinColumns = @JoinColumn(name = "task_question_id"))
    private TaskQuestionCorrectTypingAnswer taskQuestionCorrectTypingAnswer;

}
