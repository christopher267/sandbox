package com.charles.sandbox.persist.dataobject.automobile;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.charles.sandbox.business.dataobject.part.EnginePartDTO;
import com.charles.sandbox.business.dataobject.part.InteriorPartDTO;

@Entity
@Table(name = "AUTOMOBILE")
public class Automobile {
	
	@Id
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String year;
	
	@Column
	private String model;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private List<EnginePartDTO> engineParts;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<InteriorPartDTO> interiorParts;

}
