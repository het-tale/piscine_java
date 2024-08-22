package module02.ex01;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class StringSimilarity {
    private String textA;
    private String textB;
    private List<String> dict;

    public StringSimilarity(String textA, String textB) {
        this.textA = textA;
        this.textB = textB;
        dict = new ArrayList<String>();
    }

    public void createDictionary() throws Exception {
        HashMap<String, Integer> uniqueDict = new HashMap<>();
        String[] wordsA = textA.split(" ");
        String[] wordsB = textB.split(" ");
        for (String word : wordsA) {
            uniqueDict.put(word, null);
        }
        for (String word : wordsB) {
            uniqueDict.put(word, null);
        }
        for (String word : uniqueDict.keySet()) {
            this.dict.add(word);
        }
        Collections.sort(this.dict);
        FileWriter file = new FileWriter("dictionary.txt");
        for (String word : this.dict) {
            file.write(word);
            file.write(" ");
        }
        file.close();
    }

    public Vector<Integer> createVector(String text) {
        Vector<Integer> vect = new Vector<Integer>(this.dict.size());
        String[] a = text.split(" ");
        int count = 0;

        for (String word : this.dict) {
            count = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i].equals(word)) {
                    count++;
                }
            }
            vect.add(count);
        }
        return vect;
    }

    public void calculateSimilarity() {
        Vector<Integer> vectA = createVector(this.textA);
        Vector<Integer> vectB = createVector(this.textB);
        double numerator = 0;
        double sumA = 0;
        double sumB = 0;
        double denominator = 0;
        for (int i = 0; i < vectA.size(); i++) {
            numerator += vectA.elementAt(i) * vectB.elementAt(i);
            sumA += vectA.elementAt(i) * vectA.elementAt(i);
            sumB += vectB.elementAt(i) * vectB.elementAt(i);
        }
        denominator = Math.sqrt(sumA) * Math.sqrt(sumB);
        double similarity = numerator / denominator;
        double rounded = Math.floor(similarity * 100) / 100;
        System.out.format("Similarity = %.2f", rounded);
        System.out.println("");

    }

    public void application() throws Exception {
        createDictionary();
        calculateSimilarity();

    }

    public List<String> getDict() {
        return this.dict;
    }
}
