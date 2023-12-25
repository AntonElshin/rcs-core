package ru.rcs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

/**
 * Предметы
 */
@Getter
@Setter
@Entity
@ToString
@Accessors(chain = true)
@RequiredArgsConstructor
@Table(name = "subject")
public class Subject {

  /**
   * Идентификатор предмета
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
