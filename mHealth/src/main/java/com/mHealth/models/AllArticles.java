package com.mHealth.models;

import java.util.List;

import com.mHealth.entities.Articles;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllArticles {

	private Long categoryId;
	private String categoryName;
	private List<Articles> articles;

}
