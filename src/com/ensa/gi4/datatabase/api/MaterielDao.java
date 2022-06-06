package com.ensa.gi4.datatabase.api;

import com.ensa.gi4.modele.Materiel;

import java.util.List;

public interface MaterielDao {
    List<Materiel> findAll();

    Materiel findOne(String id);
    // compléter par les autres méthodes
    int addOne(Materiel m);
	int deleteOne(String id);
    
}
