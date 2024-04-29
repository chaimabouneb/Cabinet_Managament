package cabinet_management;

import java.util.Map;
import java.util.HashMap;
import java.io.*;

public class Management {
    private Map<String, Orthophoniste> docs;
    private String storageFilePath;

    public Management() {
        docs = new HashMap<String, Orthophoniste>();
        storageFilePath = "newfile.txt";
    }

    public Orthophoniste getUtilisateur(Orthophoniste user) {
        return docs.get(user.getNom());

    }

    public Orthophoniste authentifier(String pseudo) {
        chargerUtilisateurs();
        if (docs.containsKey(pseudo)) {
            System.out.println("il existe");
            return docs.get(pseudo);
        } else {
            System.out.println("il n'existe pas !");
            return null;
        }
    }

    public void setUtilisateur(Orthophoniste user) {
        docs.put(user.getNom(), user);

    }

    public void ajouterUtilisateur(Orthophoniste user) {
        chargerUtilisateurs(); // Load existing users

        if (!docs.containsKey(user.getNom())) {
            docs.put(user.getNom(), user);
            sauvegarderUtilisateurs(); // Save the updated users, including the new user
            System.out.println("Orthophoniste ajouté avec succès !");
        } else {
            System.out.println("Pseudo déjà utilisé. Veuillez choisir un autre pseudo.");
        }
    }

    public void sauvegarderUtilisateurs() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(storageFilePath))) {
            outputStream.writeObject(docs);
            System.out.println("Sauvegarde des utilisateurs effectuée avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des utilisateurs : " + e.getMessage());
        }

    }

    public void chargerUtilisateurs() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(storageFilePath))) {
            Map<String, Orthophoniste> loadedUtilisateurs = (Map<String, Orthophoniste>) inputStream.readObject();
            docs.putAll(loadedUtilisateurs); // Merge the loaded users with the existing ones
            System.out.println("Chargement des utilisateurs effectué avec succès !");
        } catch (FileNotFoundException e) {
            System.out.println(
                    "Le fichier de stockage des utilisateurs n'existe pas. Un nouveau fichier sera créé lors de la sauvegarde.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement des utilisateurs : " + e.getMessage());
        }
    }

}
