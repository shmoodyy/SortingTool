package sorting;

import java.util.ArrayList;
import java.util.List;

class WordParser extends DataParser {
    WordParser(String dataName, String sortingType) {
        super.dataName = dataName;
        super.sortingType = sortingType;
        parseWord();
    }
    public void parseWord() {
        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            String word = scanner.next();
            words.add(word);
        }
        sortingHat(words);
    }
}