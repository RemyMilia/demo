package application.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "dayoflife")
public class DayOfLife implements Serializable {

  private static final long serialVersionUID = 644139741371097397L;

  @Id
  @SequenceGenerator(name = "sid", sequenceName = "sid", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sid")
  @Column(name = "id")
  private Long id;

  @Column(name = "dayoflife")
  private Date dayOfLife;

  @Column(name = "sensations")
  private String sensations;

  public DayOfLife() {
    super();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDayOfLife() {
    return dayOfLife;
  }

  public void setDayOfLife(Date dayOfLife) {
    this.dayOfLife = dayOfLife;
  }

  public String getSensations() {
    return sensations;
  }

  public void setSensations(String sensations) {
    this.sensations = sensations;
  }
}
