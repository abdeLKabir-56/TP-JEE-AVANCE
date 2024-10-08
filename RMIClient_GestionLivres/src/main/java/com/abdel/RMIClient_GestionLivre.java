package com.abdel;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class RMIClient_GestionLivre {
    public static void main(String[] args) {
        try {
            // Connexion au registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            GestionBibliotheque gestionBibliotheque = (GestionBibliotheque) registry.lookup("GestionBibliotheque");

            Scanner scanner = new Scanner(System.in);
            int choix;

            do {
                System.out.println("\nMenu Bibliothèque :");
                System.out.println("1. Ajouter un livre");
                System.out.println("2. Rechercher un livre");
                System.out.println("3. Lister tous les livres");
                System.out.println("0. Quitter");
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();
                scanner.nextLine(); // Consomme la nouvelle ligne

                switch (choix) {
                    case 1:
                        System.out.print("Titre du livre : ");
                        String titre = scanner.nextLine();
                        System.out.print("Auteur du livre : ");
                        String auteur = scanner.nextLine();
                        gestionBibliotheque.ajouterLivre(titre, auteur);
                        break;

                    case 2:
                        System.out.print("Titre du livre à rechercher : ");
                        String titreRecherche = scanner.nextLine();
                        String resultat = gestionBibliotheque.rechercherLivre(titreRecherche);
                        System.out.println(resultat);
                        break;

                    case 3:
                        List<String> livres = gestionBibliotheque.listerLivres();
                        System.out.println("Liste des livres :");
                        for (String livre : livres) {
                            System.out.println(livre);
                        }
                        break;

                    case 0:
                        System.out.println("Au revoir !");
                        break;

                    default:
                        System.out.println("Choix invalide.");
                }
            } while (choix != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
