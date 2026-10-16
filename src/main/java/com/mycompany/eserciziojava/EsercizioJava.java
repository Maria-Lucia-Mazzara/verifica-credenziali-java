
/**
 * ESERCIZIO: Verifica Credenziali
 * Autore: Maria Lucia
 * 
 * Descrizione del funzionamento:
 * 1. CREAZIONE: Genera un file di testo (credenziali.txt) contenente user e password validi.
 * 2. INPUT: Chiede all'utente di digitare da tastiera il proprio user e la password.
 * 3. LETTURA E VERIFICA: Legge il file di testo parola per parola e controlla se 
 *    le credenziali digitate corrispondono a una delle coppie salvate.
 * 4. RISULTATO: Stampa a schermo se l'accesso è consentito o rifiutato.
 */

package com.mycompany.eserciziojava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class EsercizioJava {

    public static void main(String[] args) {
        
        // 1. Scrittura del file con le credenziali 
        try {
            
            FileWriter file_scrittura = new FileWriter(new File("credenziali.txt"));
            
            
            file_scrittura.write("admin segreta123\n");
            file_scrittura.write("marilu ciao2026\n");
            file_scrittura.write("utente password\n");
            
            file_scrittura.close();
            System.out.println("File credenziali.txt creato con successo nel sistema.");
            System.out.println("---------------------------------------------------");
            
        } catch (Exception e) {
            System.out.println("Errore durante la creazione del file: " + e);
        }

        // 2. Lettura dell'input da tastiera (Verifica credenziali)
        Scanner tastiera = new Scanner(System.in);
        
        System.out.println("Inserisci lo user: ");
        String inputUser = tastiera.next(); 
        
        System.out.println("Inserisci la password: ");
        String inputPass = tastiera.next();
        
        boolean accessoConsentito = false; 

        // 3. Lettura del file e controllo
        try {
            File file = new File("credenziali.txt");
            Scanner lettoreFile = new Scanner(file);

           
            while (lettoreFile.hasNext() && accessoConsentito == false) {
                String fileUser = lettoreFile.next(); 
                String filePass = lettoreFile.next(); 

                // Se user e password inseriti sono uguali a quelli letti nel file
                if (inputUser.equals(fileUser) && inputPass.equals(filePass)) {
                    accessoConsentito = true;
                    
                }
            }
            lettoreFile.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Errore: Il file credenziali.txt non e' stato trovato!");
        }

        // 4. Risultato finale
        System.out.println("---------------------------------------------------");
        if (accessoConsentito) {
            System.out.println("Accesso consentito!");
        } else {
            System.out.println("Accesso rifiutato.");
        }
        
        tastiera.close();
    }
}