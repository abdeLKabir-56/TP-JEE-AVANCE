package com.abdel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GestionBibliotheque extends Remote {
    void ajouterLivre(String titre, String auteur) throws RemoteException;
    String rechercherLivre(String titre) throws RemoteException;
    List<String> listerLivres() throws RemoteException;
}
