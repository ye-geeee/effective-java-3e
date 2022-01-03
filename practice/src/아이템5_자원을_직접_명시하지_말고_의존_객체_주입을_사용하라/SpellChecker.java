package src.아이템5_자원을_직접_명시하지_말고_의존_객체_주입을_사용하라;

import java.util.Collections;
import java.util.List;

class Lexicon {
    // ...
}

public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isValid(String word) {
        return true;
    }

    public List<String> suggestions(String type) {
        return Collections.emptyList();
    }
}
