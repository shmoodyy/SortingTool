package sorting;

import java.util.ArrayList;
import java.util.List;

class LineParser extends DataParser {
    LineParser(String dataName, String sortingType) {
        super.dataName = dataName;
        super.sortingType = sortingType;
        parseLine();
    }

    public void parseLine() {
        List<String> lines = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }

        sortingHat(lines);
    }
}

