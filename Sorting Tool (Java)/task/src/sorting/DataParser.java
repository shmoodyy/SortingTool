package sorting;

import java.util.*;
import java.util.stream.Collectors;

class DataParser {
    Scanner scanner = new Scanner(System.in);
    protected String sortingType, dataName, inputFile, outputFile;
    int totalItems;
    int frequency;
    List<Integer> frequencyList = new ArrayList<>();

    public String getSortingType() {
        return sortingType;
    }

    public String getDataName() {
        return dataName;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public double getFrequencyRate(int freq, int total) {
        return (freq / (double) total) * 100;
    }

    public <T> void printTotal(List<T> dataList) {
        setTotalItems(dataList.size());
        System.out.printf("Total %s: %d.%n", getDataName(), getTotalItems());
        if (getSortingType().equalsIgnoreCase("natural")) {
            if (getDataName().matches("numbers|words")) {
                System.out.print("Sorted data:");
            } else {
                System.out.println("Sorted data:");
            }
        }
    }

    public void printData(Map<String, Integer> sortedMap) {
        sortedMap.forEach((k, v) -> System.out.printf("%s: %d time(s), %.0f%%%n"
                , k, v, getFrequencyRate(v, getTotalItems())));
    }

    public <T> void printData(List<T> dataList) {
        dataList.forEach((data) -> {
            if (getDataName().matches("numbers|words")) {
                System.out.print(" "  + data);
            } else {
                System.out.println(data);
            }
        });
    }

    public <T extends Comparable<? super T>> void sortingHat(List<T> dataList) {
        Collections.sort(dataList);
        printTotal(dataList);
        if (getSortingType().equals("byCount")) {
            printData(sortByCount(dataList));
        } else {
            printData(dataList);
        }
    }

    public <T> List<T> listElements(List<T> dataList) {
        List<T> elementList = new ArrayList<>();
        for (var element : dataList) {
            setFrequency(Collections.frequency(dataList, element));
            if (!elementList.contains(element)) {
                frequencyList.add(getFrequency());
                elementList.add(element);
            }
        }
        return elementList;
    }

    public <T> Map<String, Integer> getFrequencyMap(List<T> elementList) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < frequencyList.size(); i++) {
            frequencyMap.put(elementList.get(i).toString(), frequencyList.get(i));
        }
        return frequencyMap;
    }

    public <T> Map<String, Integer> sortByCount(List<T> dataList) {
        Map<String, Integer> sortedTreeMap = new TreeMap<>(getFrequencyMap(listElements(dataList)));

        Map<String, Integer> sortedKeys;
        if (getDataName().equalsIgnoreCase("numbers")) {
            sortedKeys = new TreeMap<>((key1, key2) -> {
                Integer num1 = Integer.parseInt(key1);
                Integer num2 = Integer.parseInt(key2);
                return num1.compareTo(num2);
            });

            sortedKeys.putAll(sortedTreeMap);
        } else {
            sortedKeys = new TreeMap<>(sortedTreeMap);
        }

        // sort the map by value and pass that into a new sorted map to print
        return sortedKeys.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}