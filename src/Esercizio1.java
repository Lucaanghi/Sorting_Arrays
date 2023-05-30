/**
 * NOME E COGNOME: Luca Anghinolfi
 * NUMERO MATRICOLA: 0001019783
 * EMAIL: luca.anghinolfi2@studio.unibo.it
 **/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Esercizio1 {
    public static void main(String args[]) throws FileNotFoundException {
        //COMPLESSITA' COMPUTAZIONALE: O(n log(n)k)
        //dove k è la lunghezza della stringa

        int m = Integer.parseInt(args[0]);
        String nomeFile = args[1];

        List<Coppia> valori = new ArrayList<>();

        inserimentoValori(nomeFile, valori);

        Collections.sort(valori);

        visualizzaValori(m, valori);
    }

    /**
     * Visualizza i primi m valori dell'array
     *
     * @param m      numero di valori da visualizzare
     * @param valori lista dei valori da visualizzare
     */
    private static void visualizzaValori(int m, List<Coppia> valori) {
        for (int i = 0; i < m; i++) {
            Coppia c = valori.get(i);
            System.out.println(c.chiave + " " + c.stringa);
        }
    }

    /**
     * Inserisce i valori contenuti nel file specificato nei parametri
     *
     * @param nomeFile nome del file da cui prendo i dati
     * @param valori   lista dei valori da visualizzare
     * @throws FileNotFoundException se il nome del file non è valido
     */
    private static void inserimentoValori(String nomeFile, List<Coppia> valori) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(nomeFile));
        while (sc.hasNext()) {
            valori.add(new Coppia(sc.nextInt(), sc.next()));
        }
    }

    /**
     * E' una classe che serve a conservare
     * valori composti da coppia intero stringa
     */
    static class Coppia implements Comparable<Coppia> {
        public final int chiave;
        public final String stringa;

        public Coppia(int chiave, String stringa) {
            this.chiave = chiave;
            this.stringa = stringa;
        }

        @Override
        public int compareTo(Coppia o) {
            if (this.chiave == o.chiave) {
                return this.stringa.compareTo(o.stringa);
            }
            return Integer.compare(this.chiave, o.chiave);
        }
    }
}