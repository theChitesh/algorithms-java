
public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Integer.MAX_VALUE);
		
		int array[] = {3,6,1,90,3,21,52};
		
		for(int i : sort(array)) {
			System.out.println(i);
		}
	}
	
	public static int[] sort(int [] array) {
		
		
		int min_index , min_value, temp= 0;
		
		for(int i =0 ; i < array.length ; i++) {
			
			int min_temp = array[i];
			min_index = i;
			
			for(int j = i; j < array.length; j ++ ) {
				if(min_temp > array[j]) {
					min_temp = array[j];
					min_index = j;
				}
			}
			
			if(min_temp < array[i]) {
				array[min_index] = array[i];
				array[i] = min_temp;
			}
		}
		
		
		return array;
	}

}
