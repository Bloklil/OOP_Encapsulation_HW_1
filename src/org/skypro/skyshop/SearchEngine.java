package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> items = new ArrayList<>();

    public SearchEngine() {
    }

    public void add(Searchable item) {
        items.add(item);
    }

    public TreeMap<String, Searchable> search(String searchTerm) {
        TreeMap<String, Searchable> resultM = new TreeMap<>();
        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().contains(searchTerm)) {
                resultM.put(item.getName(), item);
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
}