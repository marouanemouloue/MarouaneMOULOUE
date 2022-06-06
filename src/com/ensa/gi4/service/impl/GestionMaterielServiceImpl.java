package com.ensa.gi4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensa.gi4.datatabase.api.MaterielDao;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

@Component("materielService")
public class GestionMaterielServiceImpl implements GestionMaterielService {
    @Autowired
    MaterielDao materielDao;
    // bd goes here
    @Override
    public void init() {
        System.out.println("inititialisation du service");
    }

    @Override
    public void listerMateriel() {
        System.out.println(materielDao.findAll());
    }
    
    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {
        // à compléter
    	if(materielDao.addOne(materiel)== 1) {
            System.out.println("L'ajout du matériel " + materiel.getName() + " effectué avec succès !");
    	};
    }

	@Override
	public void suppMateriel(String id) {
		// TODO Auto-generated method stub
		materielDao.deleteOne(id);
		
	}

	@Override
	public boolean findOne(String code) {
		// TODO Auto-generated method stub
		if(materielDao.findOne(code) != null) {
		return true;}
		return false;
	}


}
