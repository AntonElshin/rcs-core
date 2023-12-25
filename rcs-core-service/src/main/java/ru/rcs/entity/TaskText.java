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
 * Текст задания
 */
@Getter
@Setter
@Entity
@ToString
@Accessors(chain = true)
@RequiredArgsConstructor
@Table(name = "task_text")
public class TaskText {

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
    @JoinColumn(name = "task_id")
    private Task task;

    /**
     * Заголовок задания
     */
    @NotNull
    @Column(name = "header")
    private String header;

    /**
     * Текст задания
     */
    @NotNull
    @Column(name = "text")
    private String text;
}
