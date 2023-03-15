package brutalForce.question1.src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import brutalForce.question1.src.data.Item;

public class ItemsGroup {
    private List<CountingItem> groupList = new ArrayList<>();

    public ItemsGroup() {
        super();
    }

    public void printData() {
        System.out.println("Dados do grupo:\n");
        groupList.forEach(item -> item.printData());

        System.out.println("Valor total: " + getItemsValue());
        System.out.println("Peso total: " + getItemsWeight());
        System.out.println("Quantidade total: " + getItemsQuantity());
        System.out.println();
    }

    public void addToGroupList(CountingItem item) {
        String itemName = item.getItem().getName();
        int findedItemPosition = -1;
        int ind = 0;

        while(findedItemPosition == -1 && ind < groupList.size()) {
            String iterationItemName = groupList.get(ind).getItem().getName();
            if(iterationItemName.equals(itemName)) findedItemPosition = ind;
            
            ind++;
        }

        if(findedItemPosition != -1) {
            CountingItem findedItem = groupList.get(findedItemPosition);
            findedItem.setQuantity(
                findedItem.getQuantity() + item.getQuantity()
            );
            return;
        }

        groupList.add(CountingItem.FromAnotherCountingItem(item));
        sortGroupList();
    }

    private void sortGroupList() {
        groupList.sort(new Comparator<CountingItem>() {
            public int compare(CountingItem first, CountingItem second) {
                String firstName = first.getItem().getName();
                String secondName = second.getItem().getName();

                return firstName.compareTo(secondName);
            };
        });
    }

    public boolean fitsOnBackpack() {
        return getItemsWeight() <= Main.problemData.getBackpackCapaciy();
    }

    public List<CountingItem> getGroupList() {
        return groupList;
    }

    public int getItemsQuantity() {
        int itemsQuantity = 0;
        for(CountingItem countingItem : groupList) {
            itemsQuantity += countingItem.getQuantity();
        }

        return itemsQuantity;
    }

    public double getItemsValue() {
        double itemsValue = 0;
        for(CountingItem countingItem : groupList) {
            Item item = countingItem.getItem();
            itemsValue += item.getValue() * countingItem.getQuantity();
        }

        return itemsValue;
    }

    public double getItemsWeight() {
        double itemsWeight = 0;
        for(CountingItem countingItem : groupList) {
            Item item = countingItem.getItem();
            itemsWeight += item.getWeight() * countingItem.getQuantity();
        }

        return itemsWeight;
    }

    public String getUniqueString() {
        String uniqueString = "";
        for(CountingItem countingItem : groupList) {
            Item item = countingItem.getItem();
            uniqueString += item.getName() + countingItem.getQuantity();
        }

        return uniqueString;
    }

    public boolean equals(ItemsGroup itemsGroup) {
        return getUniqueString().equals(itemsGroup.getUniqueString());
    }
}
