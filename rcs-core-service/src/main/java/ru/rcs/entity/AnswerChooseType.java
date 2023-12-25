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
 * Способ выбора ответа на задания с типом choose
 */
@Getter
@Setter
@Entity
@ToString
@Accessors(chain = true)
@RequiredArgsConstructor
@Table(name = "answer_choose_type")
public class AnswerChooseType {

    /**
     * Идентификатор способа выбора
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
