package com.d4i.sample.movie.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CATEGORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity implements Serializable {

	private static final long serialVersionUID = 4471777119419172870L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySeq")
	@SequenceGenerator(name = "categorySeq", sequenceName = "category_id_seq", allocationSize=1)
	private Long id;

	@Column(name = "NAME", unique = true)
	private String name;

	@Column(name = "AVAILABLE", unique = true)
	private Boolean available;

}
