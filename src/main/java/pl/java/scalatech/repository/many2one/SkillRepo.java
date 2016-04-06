package pl.java.scalatech.repository.many2one;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.many2one.Skill;

public interface SkillRepo extends JpaRepository<Skill, Long>{

}
