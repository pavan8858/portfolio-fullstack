package com.portfolio.backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Skill;
import com.portfolio.backend.exception.ResourceNotFoundException;
import com.portfolio.backend.repository.SkillRepository;
import com.portfolio.backend.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {
	private final SkillRepository skillRepository;
	
	public SkillServiceImpl(SkillRepository skillRepository) {
		this.skillRepository = skillRepository;
	}

	@Override
	public Skill createSkill(Skill skill) {
		// TODO Auto-generated method stub
		return skillRepository.save(skill);
	}

	@Override
	public List<Skill> getAllSkills() {
		// TODO Auto-generated method stub
		return skillRepository.findAll();
	}

	@Override
	public Skill getSkillById(Long id) {
		// TODO Auto-generated method stub
		return skillRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Skill not found"));
	}
}
