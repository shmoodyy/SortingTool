package sorting;

import java.util.ArrayList;
import java.util.List;

class LongParser extends DataParser {
    LongParser(String dataName, String sortingType) {
        super.dataName = dataName;
        super.sortingType = sortingType;
        parseLong();
    }
    public void parseLong() {
        List<Long> numbers = new ArrayList<>();

        String input = null;
        while (scanner.hasNext()) {
            try {
                input = scanner.next();
                long number = Long.parseLong(input);
                numbers.add(number);
            } catch (Exception e) {
                System.out.printf("\"%s\" is not a long. It will be skipped.", input);
            }
        }

        sortingHat(numbers);
    }
}