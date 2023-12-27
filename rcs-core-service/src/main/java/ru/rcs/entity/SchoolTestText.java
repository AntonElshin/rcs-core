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
@Table(name = "school_test_text")
public class SchoolTestText {

    /**
     * Идентификатор текста задания
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    /**
     * Школьный текст
     */
    @Exclude
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_test_id", referencedColumnName = "id")
    private SchoolTest schoolTest;

    /**
     * Заголовок задания
     */
    @Column(name = "header")
    private String header;

    /**
     * Текст задания
     */
    @NotNull
    @Column(name = "text")
    private String text;
}
