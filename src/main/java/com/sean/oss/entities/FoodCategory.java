package com.sean.oss.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "FoodCategories")
public class FoodCategory {

	@Id
	private String id;
	private String name;
	private String description;
	private boolean isHidden;
}
