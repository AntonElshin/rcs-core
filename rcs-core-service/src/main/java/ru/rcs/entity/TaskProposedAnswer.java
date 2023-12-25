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
 * Предложенный ответ на задание
 */
@Getter
@Setter
@Entity
@ToString
@Accessors(chain = true)
@RequiredArgsConstructor
@Table(name = "task_proposed_answer")
public class TaskProposedAnswer {

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
     * Предложенный ответ
     */
    @Column(name = "proposed_answer")
    private String proposedAnswer;

    /**
     * Признак правильного ответа
     */
    @Column(name = "is_correct")
    private Boolean isCorrect;

    /**
     * Цвет правильного ответа
     */
    @OneToOne
    @JoinColumn(name = "correct_answer_choose_color_id")
    private AnswerChooseColor answerChooseColor;

    /**
     * Изображение для предложенного ответа задания с типом choose
     */
    @OneToOne(targetEntity = Image.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "task_proposed_answer_image", joinColumns = @JoinColumn(name = "task_proposed_answer_id"))
    private Image taskImage;

}
