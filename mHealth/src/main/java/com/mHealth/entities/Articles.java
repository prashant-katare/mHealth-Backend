package com.mHealth.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "articles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Articles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long articleId;

	private String articleName;
	private String articleContent;
	private String category;
	private Long categoryId;

}
