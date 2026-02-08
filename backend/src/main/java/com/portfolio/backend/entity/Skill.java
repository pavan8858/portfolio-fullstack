package com.portfolio.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="skills")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Category is required")
	private String name ;
	@NotBlank(message = "Category is required")
	private String category;
	@Min(value=0,message= "Proficiency must be between 0 and 100")
	@Max(value = 100, message = "proficency must be between 0 and 100")
	private int proficiencyLevel;
	private String iconUrl;
	public Skill() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getProficiencyLevel() {
		return proficiencyLevel;
	}
	public void setProficiencyLevel(int proficiencyLevel) {
		this.proficiencyLevel = proficiencyLevel;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	
}
