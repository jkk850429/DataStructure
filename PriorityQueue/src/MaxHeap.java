public class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;
    private final static int FRONT = 1;
    public MaxHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        this.Heap = new int[this.maxsize+1];
        Heap[0] = Integer.MAX_VALUE;
    }
    private int getParent(int pos){
        return pos/2;
    }
    private int getLChild(int pos){
        return pos*2;
    }
    private int getRChild(int pos){
        return pos*2+1;
    }
    private boolean isLeaf(int pos){
        if(pos<=this.size && pos>=size/2){
            return true;
        }
        return false;
    }
    private void swap(int pos1, int pos2){
        int tmp = this.Heap[pos1];
        this.Heap[pos1] = this.Heap[pos2];
        this.Heap[pos2] = tmp;
    }
    private int maxIndex(int index1, int index2){
        if(this.Heap[index1] > this.Heap[index2]){
            return index1;
        }else{
            return index2;
        }
    }
    private void Heaptify(int pos){
        int L = this.getLChild(pos);
        int R = this.getRChild(pos);
        int min = 0;
        if(L <= this.size){
            min = maxIndex(pos, L);
            if(R <= this.size){
                min = maxIndex(min, R);
            }
        }else{
            min = pos;
        }
        if(min!=pos){
            this.swap(min, pos);
            this.Heaptify(min);
        }
    }
    public void makeHeap() {
        for (int j = this.size / 2; j > 0; j--) {
            this.Heaptify(j);
        }
    }
    public void insert(int element){
        if(this.size >= this.maxsize){
            return;
        }
        this.size += 1;
        Heap[this.size] = element;
        int pivot = this.size;
        while(this.Heap[pivot] > this.Heap[getParent(pivot)]){
            this.swap(pivot, getParent(pivot));
            pivot = getParent(pivot);
        }
    }
    public int remove() {
        int poppedElement = this.Heap[FRONT];
        this.Heap[FRONT] = this.Heap[this.size];
        this.size -= 1;
        this.Heaptify(FRONT);
        return poppedElement;
    }
    public void print(){
        for(int i=1;i<=this.size/2;i++){
            System.out.println("Parent:" + this.Heap[i]);
            System.out.println("LChild:" + this.Heap[getLChild(i)]);
            System.out.println("RChild:" + this.Heap[getRChild(i)]);
        }
    }
    public void printAllElements(){
        for(int i=1;i<=this.size;i++){
            System.out.print(this.Heap[i] + " ");
        }
        System.out.println("\n");
    }
    public static void main(String args[]){
        MaxHeap max_Heap = new MaxHeap(15);
        max_Heap.makeHeap();
        max_Heap.insert(5);
        max_Heap.insert(3);
        max_Heap.insert(17);
        max_Heap.insert(4);
        max_Heap.insert(8);
        max_Heap.insert(10);
        max_Heap.printAllElements();
        System.out.println(max_Heap.remove());
        max_Heap.printAllElements();
    }
}
