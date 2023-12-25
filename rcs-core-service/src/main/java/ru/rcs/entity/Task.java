package ru.rcs.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import lombok.experimental.Accessors;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Задания тестов
 */
@Getter
@Setter
@Entity
@ToString
@Accessors(chain = true)
@RequiredArgsConstructor
@Table(name = "task")
public class Task {

    /**
     * Идентификатор задания
     */
    @Id
    @NotNull
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    /**
     * Школьный тест
     */
    @Exclude
    @NotNull
    @OneToOne
    @JoinColumn(name = "school_test_id")
    private SchoolTest schoolTest;

    /**
     * Номер задания в тесте
     */
    @NotNull
    @Column(name = "number")
    private Integer number;

    /**
     * Формулировка задания
     */
    @NotNull
    @Column(name = "task_statement")
    private String taskStatement;

    /**
     * Подсказка задания
     */
    @Column(name = "task_hint")
    private String taskHint;

    /**
     * Количество ответов на вопрос
     */
    @Column(name = "task_question_answer_quantity")
    private Integer taskQuestionAnswerQuantity;

    /**
     * Тип задания
     */
    @NotNull
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne
    @JoinColumn(name = "task_type_id")
    private TaskType taskType;

    /**
     * Изображение для задания
     */
    @OneToOne(targetEntity = Image.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "task_image", joinColumns = @JoinColumn(name = "task_id"))
    private Image taskImage;

    /**
     * Текст задания
     */
    @OneToOne(targetEntity = TaskText.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "task_text", joinColumns = @JoinColumn(name = "task_id"))
    private TaskText taskText;

    /**
     * Позиция для ответа на задание
     */
    @OneToOne(targetEntity = AnswerPosition.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "task_answer_position", joinColumns = @JoinColumn(name = "task_id"))
    private AnswerPosition taskAnswerPosition;

    /**
     * Формат ответа на задание с типом typing
     */
    @OneToOne(targetEntity = AnswerTypingFormat.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "task_answer_typing_format", joinColumns = @JoinColumn(name = "task_id"))
    private AnswerTypingFormat taskAnswerTypingFormat;

    /**
     * Способ выбора ответа на задания с типом choose
     */
    @OneToOne(targetEntity = AnswerChooseType.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "task_answer_choose_type", joinColumns = @JoinColumn(name = "task_id"))
    private AnswerChooseType taskAnswerChooseType;

    /**
     * Цвета для ответа на задания с типом choose
     */
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = AnswerChooseColor.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "task_answer_choose_color", joinColumns = @JoinColumn(name = "task_id"))
    private List<AnswerChooseColor> taskAnswerChooseColors;

    /**
     * Вариант отображения задания
     */
    @OneToOne(targetEntity = ViewType.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "task_view_type", joinColumns = @JoinColumn(name = "task_id"))
    private ViewType viewType;

    /**
     * Правильный ответ для задания с типом typing
     */
    @OneToOne(targetEntity = TaskCorrectTypingAnswer.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "task_correct_typing_answer", joinColumns = @JoinColumn(name = "task_id"))
    private TaskCorrectTypingAnswer taskCorrectTypingAnswer;

    /**
     * Вопросы заданий
     */
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskQuestion> taskQuestion;

    /**
     * Предложенные ответы на задание
     */
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskProposedAnswer> taskProposedAnswers;
}
