package com.ensa.gi4.controller;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Users;
import com.ensa.gi4.service.api.GestionMaterielService;
import com.ensa.gi4.service.api.GestionUsersService;
import com.ensa.gi4.service.impl.GestionMaterielServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("controllerPricipal")
public class GestionMaterielController {

	@Autowired
    private GestionMaterielServiceImpl gestionLivreService;

    @Autowired
    @Qualifier("materielService")
    private GestionMaterielServiceImpl gestionMaterielService;

    @Autowired
    @Qualifier("usersService")
    private GestionUsersService gestionUsersService;

    public void listerMateriel() {
        gestionMaterielService.listerMateriel();
    }

    public GestionMaterielController() {
    }

    public GestionMaterielController(GestionMaterielService livreService) {
        this.gestionLivreService = (GestionMaterielServiceImpl) livreService;
    }

    public void checkUsers() {
    	int erreur =0;
    	if(erreur == 1) {
    		System.out.println("username ou password incorrect");
    		
    	}
    	 System.out.println("Login:");
         Scanner scanner = new Scanner(System.in);
         String username = scanner.next();
         System.out.println("password:");
         Scanner scannerp = new Scanner(System.in);
         String password = scannerp.next();
     	Users userCo = gestionUsersService.verifierUtilsateur(username, password);

        if( userCo != null) {
        	erreur=0;
        	if(userCo.getRole().equals("admin")) {
        	afficherMenuAdmin();
        	}else {
        	afficherMenuEmployee();
        	}
        }
        else {
		System.out.println("username ou password incorrect");

       checkUsers();
       }
  
    }
    
  
    
    public void afficherMenuAdmin() {
        System.out.println("1- pour lister les matérieaux, entrer 1");
        System.out.println("2- pour ajouter un nouveau matériel, entrer 2");
        System.out.println("3- pour supprimer un matériel, entrer 3");
        System.out.println("4- pour marquer un matériel indisponible, entrer 4");
        System.out.println("5- pour accéder au service d'allocation, entrer 5");
        System.out.println("6- pour afficher la liste des matériels alloués par chaque utilisateur, entrer 6");
        System.out.println("7- pour chercher un matériel , entrer 7");

        System.out.println("0- pour sortir de l'application, entrer 0");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("0".equals(next)) {
            sortirDeLApplication();
        } else if ("1".equals(next)) {
            listerMateriel();
        } else if ("2".equals(next)) {
        	// ajouter nouveau matériel
    		System.out.println("Pour ajouter un livre, entrer 1");
    		System.out.println("Pour ajouter une chaise , entrer 2");
    		String type = scanner.next();
    		System.out.println("Entrez son nom");
    		String nom = scanner.next();
    		System.out.println("Entrez son code");
    		String code = scanner.next();
    		//verifier si c'est un livre ou une chaise
    		if ("1".equals(type)) {
    			Livre l = new Livre();
    			l.setName(nom);
    			l.setCode(code);
    			gestionMaterielService.ajouterNouveauMateriel(l);
    		}else if ("2".equals(type)) {
    			Chaise c = new Chaise();
    			c.setName(nom);
    			c.setCode(code);
    			gestionMaterielService.ajouterNouveauMateriel(c);
    		}else {System.out.println("Type inéxistant");}
        	
        }else if("3".equals(next)) {
            System.out.println("code du materiel à supprimer");
            String asupp = scanner.next();
        	gestionMaterielService.suppMateriel(asupp);
        }else if("4".equals(next)) {
          
        }else if("5".equals(next)) {
           afficherMenuEmployee();
        }else if("6".equals(next)) {
           
        }else if("7".equals(next)) {
        	 System.out.println("code du materiel à chercher");
             String achercher = scanner.next();
             if(gestionMaterielService.findOne(achercher)) {
                 System.out.println("Materile existant");
             }else {System.out.println("Materile inexistant");
}
         }
        else {
            System.out.println("choix invalide");
        }
    }

    public void afficherMenuEmployee() {
        System.out.println("1- pour voir la liste des matériels, entrer 1");
        System.out.println("2- pour allouer un matériel, entrer 2");
        System.out.println("3- pour rendre un matériel, entrer 3");
        System.out.println("4- pour voir la liste de tes matériels alloués, entrer 4");
        System.out.println("5- pour chercher un matériel, entrer 5");
        System.out.println("0- pour sortir de l'application, entrer 0");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("0".equals(next)) {
            sortirDeLApplication();
        } else if ("1".equals(next)) {
            listerMateriel();
        } else if ("2".equals(next)) {
            // ajouter nouveau matériel
        	
        }else if("3".equals(next)) {
         
        }
        else {
            System.out.println("choix invalide");
        }
    }

    private void sortirDeLApplication() {
        System.exit(0);
    }

}
