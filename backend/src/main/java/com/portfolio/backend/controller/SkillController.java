package com.portfolio.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.entity.Skill;
import com.portfolio.backend.service.SkillService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "*")
public class SkillController {
	private final SkillService skillService;
	public SkillController(SkillService skillService) {
		this.skillService = skillService;
	}
	
	@PostMapping
	public ResponseEntity<Skill> createSkill(@Valid @RequestBody Skill skill){
		return ResponseEntity.ok(skillService.createSkill(skill));
	}
	@GetMapping
	public ResponseEntity<List<Skill>> getAllSkills(){
		return ResponseEntity.ok(skillService.getAllSkills());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Skill> getSkill(@PathVariable Long id){
		return ResponseEntity.ok(skillService.getSkillById(id));
	}
	
	
}
