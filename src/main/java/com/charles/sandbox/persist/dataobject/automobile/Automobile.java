package com.charles.sandbox.persist.dataobject.automobile;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.charles.sandbox.persist.dataobject.part.EnginePart;

@Entity
@Table(name = "AUTOMOBILE")
public class Automobile {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String manufacturer;
	
	@Column
	private Long year;
	
	@Column
	private String model;
	
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "automobile_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private List<EnginePart> engineParts;
	
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "part_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private List<InteriorPart> interiorParts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<EnginePart> getEngineParts() {
		return engineParts;
	}

	public void setEngineParts(List<EnginePart> engineParts) {
		this.engineParts = engineParts;
	}

//	public List<InteriorPart> getInteriorParts() {
//		return interiorParts;
//	}
//
//	public void setInteriorParts(List<InteriorPart> interiorParts) {
//		this.interiorParts = interiorParts;
//	}
}
