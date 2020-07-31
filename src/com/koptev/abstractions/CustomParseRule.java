package com.koptev.abstractions;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public interface CustomParseRule {
    String Parse(Element element);
}
