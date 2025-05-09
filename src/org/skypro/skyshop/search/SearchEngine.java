package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.*;
import java.util.Comparator;

public class SearchEngine {
    private final Set<Searchable> items = new HashSet<>();

    public SearchEngine() {
    }

    public void add(Searchable item) {
        items.add(item);
    }

    public Set<Searchable> search(String searchTerm) {
        Set<Searchable> resultM = new TreeSet<>(new SearchableComparable());
        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().contains(searchTerm)) {
                resultM.add(item);
            }
        }
        return resultM;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            int count = countOccurrences(item.getSearchTerm().toLowerCase(), search.toLowerCase());
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящих результатов для запроса: " + search);
        }
        return bestMatch;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }

    public static class SearchableComparable implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return s2.getName().compareToIgnoreCase(s1.getName());
        }
    }
}