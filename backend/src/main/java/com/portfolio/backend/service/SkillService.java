package com.portfolio.backend.service;

import java.util.List;

import com.portfolio.backend.entity.Skill;

public interface SkillService {
	Skill createSkill (Skill skill);
	List<Skill> getAllSkills();
	Skill getSkillById(Long id);
}
