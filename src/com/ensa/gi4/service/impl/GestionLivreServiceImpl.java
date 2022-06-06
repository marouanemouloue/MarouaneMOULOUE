package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.api.MaterielDao;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class GestionLivreServiceImpl implements GestionMaterielService, SmartInitializingSingleton {
    // bd goes here
    @Autowired
    MaterielDao materielDao;
    @Override
    public void init() {
        System.out.println("inititialisation du service");
    }

    @Override
    public void listerMateriel() {
        System.out.println("Liste de matériel :\n 3 Livres \n 4 chaises");
    }

    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {
      
		// à compléter
    	if(materielDao.addOne(materiel)== 1) {
            System.out.println("L'ajout du matériel " + materiel.getName() + " effectué avec succès !");

    	};
        System.out.println("L'ajout du matériel " + materiel.getName() + " effectué avec succès !");
    }
    

    @Override
	public void suppMateriel(String id) {
		// TODO Auto-generated method stub
    	materielDao.deleteOne(id);
		
	}

	@Override
    public void afterSingletonsInstantiated() {
        System.out.println("toto");

    }

	@Override
	public boolean findOne(String code) {
		// TODO Auto-generated method stub
		return false;
	}
}
