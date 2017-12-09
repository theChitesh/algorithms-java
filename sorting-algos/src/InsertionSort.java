
public class InsertionSort {

	public static void main(String[] args) {
		
		
		int array[] = {3,6,1,90,3,21,52};
		
		for(int i : sort(array)) {
			System.out.println(i);
		}

	}
	
	
	public static int[] sort(int []array) {
		
		for(int i =1 ; i < array.length ;i++) {
			
			int key = array[i];
			int j = i -1;
			while(j >= 0 && key < array[j]) {
				
				int temp = array[j];
				array[j] = array[j +1];
				array[j +1] = temp;
				j --;
			}
		}
		
		return array;
	}
	

}
