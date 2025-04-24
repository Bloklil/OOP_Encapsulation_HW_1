package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;

public interface Searchable {
    String getSearchTerm();

    String getContent();

    String getName();

    default String getStringRepresentation() {
        return getName() + " - " + getContent();

    }

}
