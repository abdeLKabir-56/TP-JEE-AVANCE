package com.abdel;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer_GestionLivres {
    public static void main(String[] args) {
        try {
            GestionBibliotheque gestionBibliotheque = new GestionBibliothequeImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("GestionBibliotheque", gestionBibliotheque);
            System.out.println("Serveur RMI pour la gestion de la bibliothèque est prêt.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
