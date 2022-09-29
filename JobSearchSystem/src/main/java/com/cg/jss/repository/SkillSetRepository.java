package com.cg.jss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.jss.entity.Skillset;
@Repository
public interface SkillSetRepository extends JpaRepository<Skillset, Integer>{
	List<Skillset> findBySkill(String skill);

}
