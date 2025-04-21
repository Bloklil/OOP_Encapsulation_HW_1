package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

public final class Article implements Searchable {
    private final String nameArticle;
    private final String textArticle;


    public Article(String nameArticle, String textArticle) {
        this.nameArticle = nameArticle;
        this.textArticle = textArticle;
    }

    public String getNameArticle() {
        return nameArticle;
    }

    public String getTextArticle() {
        return textArticle;
    }

    @Override
    public String getSearchTerm() {
        return getNameArticle() + getTextArticle();
    }

    @Override
    public String getContent() {
        return getTextArticle();
    }

    @Override
    public String getName() {
        return getNameArticle();
    }
}
