package ru.rcs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

/**
 * Тесты
 */
@Getter
@Setter
@Entity
@ToString
@Accessors(chain = true)
@RequiredArgsConstructor
@Table(name = "school_test")
public class SchoolTest {

  /**
   * Идентификатор теста
   */
  @Id
  @NotNull
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid2")
  private String id;

  /**
   * ID Школьного класса
   */
  @NotNull
  @OneToOne
  @JoinColumn(name = "school_class_id")
  private SchoolClass schoolClass;

  /**
   * ID Предмета
   */
  @NotNull
  @OneToOne
  @JoinColumn(name = "subject_id")
  private Subject subject;

  /**
   * Отображаемое имя
   */
  @NotNull
  @Column(name = "display_name")
  private String displayName;

}
