package com.example.demo.Entity;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data
@AllArgsConstructor
public class RH extends Acteur {
	

	

	@OneToMany(mappedBy = "rh")
	private List<Offre> offre;

}
