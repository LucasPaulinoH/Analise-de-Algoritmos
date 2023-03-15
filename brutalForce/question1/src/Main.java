package brutalForce.question1.src;

import java.util.ArrayList;
import java.util.List;

import brutalForce.question1.src.data.Item;
import brutalForce.question1.src.data.ProblemData;
import brutalForce.question1.src.utils.FileReader;

public class Main {
    public static ProblemData problemData = FileReader.getProblemDataFromFile();
    
    private static List<ItemsGroup> bestGroups = new ArrayList<>();
    private static List<ItemsGroup> allPossibleGroups;

    public static void main(String args[]) {
        int initialItemsQuantity = problemData.getItems().size();
        setInitialGroups(problemData.getItems());

        int lastGroupsInitialPosition = 0;
        boolean allPossibilitiesConsidered = false;

        while(!allPossibilitiesConsidered) {
            int allGroupsPreviousSize = allPossibleGroups.size();

            for(int ind=0 ; ind<initialItemsQuantity ; ind++) {
                CountingItem iterationInitialItem = allPossibleGroups.get(ind).getGroupList().get(0);
                addNewGroupsForInitialItem(
                    lastGroupsInitialPosition, allGroupsPreviousSize,
                    iterationInitialItem
                );
            }

            lastGroupsInitialPosition = allGroupsPreviousSize;
            allPossibilitiesConsidered = allGroupsPreviousSize == allPossibleGroups.size();
        }

        bestGroups.forEach(group -> group.printData());
    }

    private static void setInitialGroups(List<Item> items) {
        List<ItemsGroup> initialGroups = new ArrayList<>();

        items.forEach(item -> {
            ItemsGroup group = new ItemsGroup();
            group.addToGroupList(new CountingItem(item));

            if(group.fitsOnBackpack()) {
                initialGroups.add(group);
                verifyAndAddToBestGroups(group);
            }
        });

        allPossibleGroups = initialGroups;
    }

    private static void addNewGroupsForInitialItem(
        int lastGroupsInitialPosition,
        int allGroupsPreviousSize, CountingItem iterationInitialItem
    ) {
        int lastGroupsIterator = lastGroupsInitialPosition;

        while(lastGroupsIterator < allGroupsPreviousSize) {
            ItemsGroup newGroup = new ItemsGroup();
            newGroup.addToGroupList(iterationInitialItem);

            ItemsGroup previousGroup = allPossibleGroups.get(
                lastGroupsIterator
            );
            previousGroup.getGroupList().forEach(
                iterationItem -> newGroup.addToGroupList(iterationItem)
            );

            boolean groupIsPresent = groupIsAlreadyOnPossibilities(newGroup);
            if(!groupIsPresent && newGroup.fitsOnBackpack()) {
                allPossibleGroups.add(newGroup);
                verifyAndAddToBestGroups(newGroup);
            }

            lastGroupsIterator++;
        }
    }

    private static boolean groupIsAlreadyOnPossibilities(ItemsGroup group) {
        boolean groupIsPresent = false;
        int ind = 0;

        while(!groupIsPresent && ind < allPossibleGroups.size()) {
            ItemsGroup iterationGroup = allPossibleGroups.get(ind++);
            if(iterationGroup.equals(group)) groupIsPresent = true;
        }

        return groupIsPresent;
    }

    private static void verifyAndAddToBestGroups(ItemsGroup group) {
        if(bestGroups.size() == 0) {
            bestGroups.add(group);
            return;
        }

        double firstGroupValue = bestGroups.get(0).getItemsValue();
        double newGroupValue = group.getItemsValue();

        if(firstGroupValue > newGroupValue) return;
        if(firstGroupValue < newGroupValue) bestGroups.clear();
        bestGroups.add(group);
    }
}