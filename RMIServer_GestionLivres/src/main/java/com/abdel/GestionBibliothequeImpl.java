package com.abdel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class GestionBibliothequeImpl extends UnicastRemoteObject implements GestionBibliotheque {
    private Livre livre;
    private List<Livre> livreList;
    protected GestionBibliothequeImpl() throws RemoteException {
        super();
        this.livreList = new ArrayList();
    }

    @Override
    public void ajouterLivre(String titre, String auteur) throws RemoteException {
      livre = new Livre();
      livre.setTitre(titre);
      livre.setAuteur(auteur);
      livreList.add(livre);
    }

    @Override
    public String rechercherLivre(String titre) throws RemoteException {
        livre = new Livre();
        for (Livre livre : livreList) {
            if (livre.getTitre().equals(titre)) {
                return livre.getAuteur();
            }
        }
        return null;
    }

    @Override
    public List<String> listerLivres() throws RemoteException {
        List<String> liste = new ArrayList<>();
        for (Livre livre : livreList) {
            liste.add("titre:" +livre.getTitre() + ", auteur:"  + livre.getAuteur());
        }
        return liste;
    }


}
