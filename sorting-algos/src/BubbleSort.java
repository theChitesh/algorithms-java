
public class BubbleSort {
	
	private static int value;
	public static void main(String[] args) {
		int array[] = {3,6,1,90,3,21,52};
		

		
		for(int i : sort(array)) {
			System.out.println(i);
		}
	}
	
	public static int[] sort(int [] array) {
	
		for(int i =0 ;i< array.length -1 ; i ++) {
			
			for(int j =0 ; j < array.length -1 -i; j++) {
				
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
				
			}
			
		}
		
		
		
		return array;
	}

}
