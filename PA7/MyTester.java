import java.util.ArrayList;
import java.util.Arrays;

public class MyTester {
    public static void main(String[] args){
        ArrayList<Integer> inputList = new ArrayList<Integer>(
			Arrays.asList(
					new Integer[] { 5, 4, 1, 7, 2, 9, 6, 3 }
			)
		);
		MyMinHeap<Integer> minHeap = new MyMinHeap<>(inputList);
		Integer[] expected = { 1, 2, 5, 3, 4, 9, 6, 7 };
        boolean result = true;
        for (int i = 0; i < 8; i++){
            System.out.println(minHeap.data.get(i));
        }
    }
}
