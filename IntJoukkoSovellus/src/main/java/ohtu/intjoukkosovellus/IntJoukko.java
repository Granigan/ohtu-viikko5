package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on näin paljon isompi
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        this.joukko = new int[KAPASITEETTI];
        this.kasvatuskoko = OLETUSKASVATUS;
        alkioidenLkm = 0;
        if (kapasiteetti > 0) {
            this.joukko = new int[kapasiteetti];
        }
        if (kasvatuskoko > 0) {
            this.kasvatuskoko = kasvatuskoko;
        }
    }

    public boolean lisaa(int luku) {
        if (etsiIndeksi(this.joukko, luku) == -1) {
            if (alkioidenLkm == this.joukko.length) {
                this.joukko = kasvata(this.joukko);
            }
            joukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            return true;
        }
        return false;
    }

    private int[] kasvata(int[] joukko) {
        int[] uusi = new int[alkioidenLkm + kasvatuskoko];
        return kopioiTaulukko(joukko, uusi);
    }

    private int[] kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
        return uusi;
    }

    public boolean kuuluu(int luku) {
        return etsiIndeksi(this.joukko, luku) > -1;
    }

    private int etsiIndeksi(int[] joukko, int haettava) {
        int indeksi = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (haettava == joukko[i]) {
                indeksi = i;
            }
        }
        return indeksi;
    }

    public boolean poista(int luku) {
        int indeksi = etsiIndeksi(this.joukko, luku);
        if (indeksi > -1) {
            joukko[indeksi] = 0;
            tiivista(indeksi);
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    private void tiivista(int indeksi) {
        for (int i = indeksi; i < alkioidenLkm - 1; i++) {
            joukko[i] = joukko[i + 1];
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    private int[] trimmaa(int[] joukko) {
        int[] uusi = new int[alkioidenLkm];
        for (int i = 0; i < alkioidenLkm; i++) {
            uusi[i] = joukko[i];
        }
        return uusi;
    }

    @Override
    public String toString() {
        this.joukko = trimmaa(this.joukko);
        return Arrays.toString(joukko).replace("[", "{").replace("]", "}");
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukko[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(i);
        }

        return z;
    }

}
