package org.skypro.skyshop;

public class SearchEngine {
    private Searchable[] items;
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
}
