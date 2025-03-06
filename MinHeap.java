import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }
    private int leftChild(int parent) {
        return 2 * parent + 1;
    }

    private int rightChild(int parent) {
        return 2 * parent + 2;
    }


    private int parent(int child) {
        return (child - 1) / 2;
    }


    private void heapify(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);


        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }


        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = value;
        int current = size;
        size++;

        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }


    public void deleteMin() {
        if (size <= 0) {
            System.out.println("Heap is empty");
            return;
        }

        heap[0] = heap[size - 1];
        size--;

        heapify(0);
    }


    public void display() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return;
        }
        System.out.println("Heap elements: " + Arrays.toString(Arrays.copyOfRange(heap, 0, size)));
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);


        System.out.println("Inserting elements into the heap...");
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(9);
        minHeap.insert(8);
        
        minHeap.display();  


        System.out.println("Deleting the minimum element (root)...");
        minHeap.deleteMin();

        minHeap.display();  
    }
}
