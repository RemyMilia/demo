package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entities.DayOfLife;

@Repository
public interface IDayOfLifeRepository extends JpaRepository<DayOfLife, Long> {

  DayOfLife findById(Long id);
}
