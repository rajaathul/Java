import java.util.*;

interface FarmElement {
    void displayInfo();
}

interface ListInterface<T> {
    void addItem(T item);

    List<T> getItems();
}

interface SetInterface<T> {
    void addItem(T item);

    Set<T> getItems();
}

interface QueueInterface<T> {
    void enqueueItem(T item);

    T dequeueItem();

    Queue<T> getItems();
}

class CropList implements FarmElement, ListInterface<String> {
    private ArrayList<String> crops;

    public CropList() {
        this.crops = new ArrayList<>();
    }

    @Override
    public void addItem(String crop) {
        crops.add(crop);
    }

    @Override
    public List<String> getItems() {
        return crops;
    }

    @Override
    public void displayInfo() {
        System.out.println("Crops: " + crops);
    }
}

class PestSet implements FarmElement, SetInterface<String> {
    private HashSet<String> pests;

    public PestSet() {
        this.pests = new HashSet<>();
    }

    @Override
    public void addItem(String pest) {
        pests.add(pest);
    }

    @Override
    public Set<String> getItems() {
        return pests;
    }

    @Override
    public void displayInfo() {
        System.out.println("Pests: " + pests);
    }
}

class TaskQueue implements FarmElement, QueueInterface<String> {
    private Queue<String> tasks;

    public TaskQueue() {
        this.tasks = new LinkedList<>();
    }

    @Override
    public void enqueueItem(String task) {
        tasks.add(task);
    }

    @Override
    public String dequeueItem() {
        return tasks.poll();
    }

    @Override
    public Queue<String> getItems() {
        return tasks;
    }

    @Override
    public void displayInfo() {
        System.out.println("Task Queue: " + tasks);
    }
}

public class Practice_5 {
    public static void main(String[] args) {
        // Example usage of the implemented classes

        // Create instances of classes implementing different interfaces
        ListInterface<String> cropList = new CropList();
        SetInterface<String> pestSet = new PestSet();
        QueueInterface<String> taskQueue = new TaskQueue();

        // Add data to the elements
        cropList.addItem("coffee");
        pestSet.addItem("pest");
        taskQueue.enqueueItem("Planting");

        // Display information using the common interface method
        ((FarmElement) cropList).displayInfo();
        ((FarmElement) pestSet).displayInfo();
        ((FarmElement) taskQueue).displayInfo();

        // Additional functionalities specific to each interface
        System.out.println("Crop List: " + cropList.getItems());
        System.out.println("Pest Set: " + pestSet.getItems());
        System.out.println("Dequeued Task: " + taskQueue.dequeueItem());
    }
}
