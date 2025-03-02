package com.mHealth.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "recommended")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recommended {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long articleId;

	private String articleName;
	private String category;
}
