package src.utils;

import java.io.File;
import java.util.Scanner;

import src.data.Item;
import src.data.ProblemData;

public class FileReader {
    private enum ItemPosition {
        NamePosition,
        WeightPosition,
        ValuePosition;
    } 

    public static ProblemData getProblemDataFromFile() {
        try {
            File file = new File("question1/backpackData.txt");
            Scanner scanner = new Scanner(file);

            ProblemData problemData = new ProblemData();
            while(scanner.hasNextLine()) {
                setProblemDataUsingScanner(problemData, scanner);
            }

            scanner.close();
            return problemData;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private static void setProblemDataUsingScanner(
        ProblemData problemData, Scanner scanner
    ) {
        String lineData[] = scanner.nextLine().split(" ");
        boolean isCapacityLine = lineData[0].equals("capacity");

        if(isCapacityLine) {
            String capacityString = lineData[1];
            problemData.setBackpackCapaciy(
                Double.valueOf(capacityString)
            );
            return;
        }

        Item item = new Item();
        for(int ind=0 ; ind<lineData.length ; ind++) {
            setItemAttribute(item, lineData[ind], ind);
        }
        problemData.getItems().add(item);
    }

    private static void setItemAttribute(
        Item item, String attribute,
        int lineDataPosition
    ) {
        ItemPosition parsedPosition = ItemPosition.values()[lineDataPosition];

        switch(parsedPosition) {
            case NamePosition: {
                item.setName(attribute);
                return;
            }
            case WeightPosition: {
                item.setWeight(Double.valueOf(attribute));
                return;
            }
            case ValuePosition: {
                item.setValue(Double.valueOf(attribute));
                return;
            }
        }
    }
}
