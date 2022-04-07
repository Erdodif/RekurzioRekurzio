package hu.petrik.recursion.bs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Generator {
    private ArrayList<String> words;

    public Generator() {
        words = new ArrayList<>();
        readFromFile();
    }

    private void readFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("rejto-piszkos-fred.txt"));
            String line = br.readLine();
            while (line != null) {
                line = stringTrim(line);
                if (!line.isBlank()) {
                    String[] wordArray = line.split(" ");
                    for (String word : wordArray) {
                        if (!(word.isBlank() || Arrays.asList(getIrrelevantWords()).contains(word))) {
                            words.add(word);
                        }
                    }
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Olvasási hiba");
        }
    }

    private String stringTrim(String string) {
        return string.replaceAll("^[ ]{2,}$", " ")
                .replaceAll("[\n.,;:?!()\"']*", "")
                .replaceAll("-", "")
                .toLowerCase();
    }

    private static String[] getIrrelevantWords() {
        return new String[]{"is", "és", "hogy", "vagy", "a", "az", "ez", "ezt", "ha", "egy", "volt", "mint", "mert"};
    }

    public String getRandomWord() {
        return words.get((int) (Math.random() * words.size()));
    }

    private String capitalize(String string){
        return String.valueOf(string.charAt(0)).toUpperCase() +
                string.substring(1);
    }

    private ArrayList<String> getWordChain(int length){
        ArrayList<String> wordChain = new ArrayList<>();
        wordChain.add(getRandomWord());
        while (length != 0){
            wordChain.add(getFrequentNeigbour(wordChain.get(wordChain.size()-1)));
            length--;
        }
        return wordChain;
    }

    public String getSentence(int length) {
        StringBuilder boby = new StringBuilder();
        ArrayList<String> wordchain = getWordChain(length);
        for (int i = 1; i < length-1; i++) {
            boby.append(wordchain.get(i)+" ");
        }
        boby.append(wordchain.get(wordchain.size()-1));
        return capitalize(boby.append(".").toString());
    }

    private String getFrequentNeigbour(String word) {
        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<String> neighbour = new ArrayList<>();
        AtomicInteger index = new AtomicInteger();
        words.forEach(w -> {
            if (w.equals(word)) {
                indexes.add(index.get());
                neighbour.add(words.get(index.get()+1));
            }
            index.getAndIncrement();
        });
        String mostFrequent = "";
        for (Integer position : indexes) {
            if (position < words.size() - 1 &&
                    Collections.frequency(neighbour, words.get(position + 1)) >
                            Collections.frequency(neighbour, mostFrequent)
            ) {
                mostFrequent = words.get(position + 1);
            }
        }
        return mostFrequent;
    }

    public void printWords() {
        for (String word : words) {
            System.out.print(word + " ");
        }
    }
}
