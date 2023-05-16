package sorting;

class DataParserFactory {
    public static void newInstance(String dataType, String sortingType) {
        if (dataType.equalsIgnoreCase("long")) {
            new LongParser("numbers", sortingType);
            return;
        } else if (dataType.equalsIgnoreCase("line")) {
            new LineParser("lines", sortingType);
            return;
        } else if (dataType.equalsIgnoreCase("word")) {
            new WordParser("words", sortingType);
            return;
        }
        new WordParser("words", sortingType);
    }
}