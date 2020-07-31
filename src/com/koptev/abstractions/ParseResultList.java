package com.koptev.abstractions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParseResultList implements Iterable<ParseResultItem> {
    private final List<ParseResultItem> items;

    public ParseResultList(List<ParseResultItem> items) {
        this.items = items;
    }

    @Override
    public @NotNull Iterator<ParseResultItem> iterator() {
        return items.iterator();
    }
    public int size() { return items.size(); }

}
