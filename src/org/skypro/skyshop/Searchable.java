package org.skypro.skyshop;

public interface Searchable {
    String getSearchTerm();

    String getContent();

    String getName();

    default String getStringRepresentation() {
        return getName() + " - "+getContent();

    }

}
