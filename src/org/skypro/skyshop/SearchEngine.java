package org.skypro.skyshop;

public class SearchEngine {
    private final Searchable[] items;
    private int count;

    public SearchEngine(int size) {
        this.items = new Searchable[size];
        this.count = 0;
    }

    public void add(Searchable item) {
        if (count < items.length) {
            items[count++] = item;
        }
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] result = new Searchable[5];
        int resultIndex = 0;
        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().contains(searchTerm)) {
                result[resultIndex++] = item;
                if (resultIndex == 5) {
                    break;
                }
            }
        }
        return result;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            if (item == null || item.getSearchTerm() == null) {
                continue;
            }
            String term = item.getSearchTerm();
            int count = countOccurrences(term, search);

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