package ru.rcs.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Форматы ввода ответов на задания с типом typing
 */
@Getter
@Setter
@Entity
@ToString
@Accessors(chain = true)
@RequiredArgsConstructor
@Table(name = "answer_typing_format")
public class AnswerTypingFormat {

    /**
     * Идентификатор формата ответа
     */
    @Id
    @NotNull
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    /**
     * Системное название
     */
    @NotNull
    @Column(name = "system_name")
    private String systemName;

    /**
     * Название
     */
    @NotNull
    @Column(name = "name")
    private String name;

    /**
     * Описание
     */
    @NotNull
    @Column(name = "description")
    private String description;

}
