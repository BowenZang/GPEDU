package org.example.memonto;

import java.util.Stack;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-07-21 09:19:45
 */
public class DraftsBox {

    private final Stack<ArticleMemento> articleMementos = new Stack<>();

    public ArticleMemento getArticleMemento() {
        return articleMementos.pop();
    }

    public void addArticleMemento(ArticleMemento articleMemento) {
        articleMementos.push(articleMemento);
    }

}
