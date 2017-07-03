package algorithm.sort;

public class SimpleSort {

	/**
	 * 《算法》P156 选择排序
	 * @param source
	 */
	public static void selectionSort(int[] source){
		int len = source.length;
		int count = 0;
		for(int i=0;i<len;i++){
			int min = i;
			for(int j=i+1;j<len;j++){//执行次数为(n-1)+...+2+1
				count++;
				if(source[j]<source[min]){
					min = j;
				}
			}
			if(i!=min){
				exchange(source,i,min);
				//print(source);
			}
		}
		System.out.println(count);
	}
	
	/**
	 * 《算法》P157 插入排序
	 * @param source
	 */
	public static void insertionSort(int[] source){
		int len = source.length;
		int count = 0;
		for(int i=1;i<len;i++){
			for(int j=i;j>0 && source[j]<source[j-1];j--){
				count++;
				exchange(source,j,j-1);
				//print(source);
			}
		}
		System.out.println(count);
	}
	
	
	
	public static void exchange(int[] source,int first,int second){
		int temp = source[first];
		source[first] = source[second];
		source[second] = temp;
	}
	
	public static void print(int[] source){
		for(int i:source){
			System.out.print(i+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] source = {31,4,43,5,4,10,1,40};
		//selectionSort(source);
		insertionSort(source);
		for(int i:source){
			System.out.print(i+",");
		}
	}
}
