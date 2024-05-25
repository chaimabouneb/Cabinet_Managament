package cabinet_management;

import java.util.Map;
import java.util.HashMap;
import java.io.*;

public class Management {
    private Map<String, Orthophoniste> docs;
    
    private String storageFilePath;

    public Management() {
        docs = new HashMap<>();
        storageFilePath = "users_data.ser"; // Changed storage file name for clarity
        chargerUtilisateurs(); // Load users at initialization
    }

    public Orthophoniste getUtilisateur(String nom) {
        return docs.get(nom);
    }

    public static class PassIncorrectException extends Exception {
        public PassIncorrectException(String message) {
            super(message);
        }
    }

    public Orthophoniste authentifier(String pseudo, String pass)
            throws PassIncorrectException, Orthophoniste.PassIncorrectException {
        if (docs.containsKey(pseudo)) {
            Orthophoniste o = docs.get(pseudo);
            if (o.authentifierPasse(pass)) {
                return o;
            } else {
                throw new PassIncorrectException("Password incorrect.");
            }
        } else {
            throw new PassIncorrectException("User not found.");
        }
    }

    public void ajouterUtilisateur(Orthophoniste user) {
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
            e.printStackTrace(); // Print the stack trace for debugging purposes
        }
    }

    public void chargerUtilisateurs() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(storageFilePath))) {
            Map<String, Orthophoniste> loadedUtilisateurs = (Map<String, Orthophoniste>) inputStream.readObject();
            // Clear existing data and replace it with loaded data
            docs.clear();
            docs.putAll(loadedUtilisateurs);
            System.out.println("Chargement des utilisateurs effectué avec succès !");
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier de stockage des utilisateurs n'existe pas.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement des utilisateurs : " + e.getMessage());
        }
    }
}
