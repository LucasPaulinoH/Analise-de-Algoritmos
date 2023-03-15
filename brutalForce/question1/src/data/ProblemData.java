package brutalForce.question1.src.data;

import java.util.ArrayList;
import java.util.List;

public class ProblemData {
    private double backpackCapaciy;
    private List<Item> items = new ArrayList<>();

    public ProblemData() {
        super();
    }

    public ProblemData(double backpackCapaciy, List<Item> items) {
        this.backpackCapaciy = backpackCapaciy;
        this.items = items;
    }

    public double getBackpackCapaciy() {
        return backpackCapaciy;
    }

    public void setBackpackCapaciy(double backpackCapaciy) {
        this.backpackCapaciy = backpackCapaciy;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
