package HeapSort;

public class HeapSort {	
		private static int size; 
		private static int[] A; 
		
		public HeapSort(int[] array){
			A = array;
			size = array.length-1;
		}
		
		private static void swap(int i, int j){
			int temp = A[i];
			A[i] = A[j];
			A[j] = temp;
		}
		
		private void heapify(int i, int j){
			int left = 2*i+1;
			int right = 2*i +2;
			int maximum = i;
			if(left <= size && A[left] > A[i]){
				maximum = left;
			}
			if(right <= size && A[right] > A[maximum]){
				maximum = right;
			}
			if( maximum != i){
				swap(i, maximum);
				heapify(maximum, i);
			}
		}
		
		private void build(){
			int n = size;
			for(int i = (n/2); i >=0 ; i--){
				heapify(i, n);
			}
		}
		
		private void sort(){
			build();
			 
			for(int i = size; i > 0; i--){
				swap(0, i);
				size = size-1;
				heapify(0, i-1);
			}
		}
		
		private static void printHeap(){
			int len = A.length;
			
			for (int i = 0; i < len; i++){
				System.out.printf("%d, ", A[i]);
			}
			System.out.println(); 
		}
	}