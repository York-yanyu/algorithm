import java.util.Random;

public class MySort {
	
	
	public static void SelectionSort(int[] a){
		// 选择排序
		int index = 0;
		if((a == null)||(a.length == 0))
		{
			return;
		}
		for(int i=0; i<a.length; i++){
			index = i;
			for(int j=i+1; j<a.length; j++){
				if(a[j]<a[index]){
					index = j;
				}
			}
			if(index != i)
			{
				Swap(a, i, index);
			}			
		}		
	
	}
	
	
	public static void InsertionSort(int[] a){
		//插入排序
		if((a == null)||(a.length < 2))
		{
			return;
		}
		
		for(int i=1; i<a.length; i++)
		{
			for(int j=i; j>0; j--)
			{
				if(a[j]<a[j-1])
				{
					Swap(a, j, j-1);
				}
				else
				{
					break;
				}
			}
		}
	}
	
	public static void BubbleSort(int[] a){
		// 冒泡排序
		if((a == null)||(a.length < 2))
		{
			return;
		}
		for(int i=0; i<a.length-1; i++)
		{
			for(int j=0; j<a.length-1-i; j++)
			{
				if(a[j]>a[j+1])
				{
					Swap(a, j, j+1);
				}
			}
		}
	}
	
	public static void QuickSort(int[] a, int p, int q){
		// 快速排序
		if(p<q)
		{
			int r = Partion(a, p, q);
			QuickSort(a, p, r-1);
			QuickSort(a,r+1,q);			
		}
	}
	

	public static int Partion(int[] a, int p, int q){
		// 最基础的快排用第一个元素作为pivot
		// 可以随机化选择pivot，方法也很简单
		Random y = new Random();
		int pivot = y.nextInt(q-p+1)+p;//随机找主元
		Swap(a, p, pivot);		
		int x = a[p];
		int i = p;
		for(int j=p+1; j<a.length; j++)
		{
			if(a[j]<=x)
			{
				i += 1;
				Swap(a, i, j);
			}
		}
		Swap(a, p, i);
		return i;
		
	}
	
	public static void Swap(int[] a, int b, int c){
		// 交换数组中两个值的位置
		int temp;
		temp = a[b];
		a[b] = a[c];
		a[c] = temp;
	}
	
	public static void MergeSort(int[] a){
		//归并排序
		int[] temp = new int[a.length];
		Sort(a, 0, a.length-1, temp);
	}
	public static void Sort(int[] a, int left, int right, int[] temp){
		//归并排序中的排序
		if(left<right)
		{
			int mid = (left+right)/2;
			Sort(a, left, mid, temp);
			Sort(a, mid+1, right, temp);
			Merge(a, left, mid, right, temp);
		}
	}
	public static void Merge(int[] a, int left, int mid, int right, int[] temp){
		//归并排序中的归并
		int i = left;
		int j = mid+1;
		int t = 0;
		while(i<=mid && j<=right)
		{
			if(a[i]<=a[j])
			{
				temp[t++]=a[i++];
			}
			else
			{
				temp[t++]=a[j++];
			}
		}
		while(i<=mid)
		{
			temp[t++]=a[i++];
		}
		while(j<=right)
		{
			temp[t++]=a[j++];
		}
		t=0;
		while(left<=right)
		{
			//注意此处循环的条件，这里的temp只是临时的数组，并不是所有的数
			a[left++]=temp[t++];
		}
	}
	
	
	
	public static void HeapSort(int[] a){
		//堆排序，关键是建立堆
		if((a == null)||(a.length < 2))
		{
			return;
		}
		for(int i=0; i<a.length; i++)
		{
			BuildHeap(a, a.length-i);
			Swap(a, 0, a.length-i-1);
		}
			
	}
	public static void BuildHeap(int[] a, int length){
		//调整堆
		for(int i=(length)/2-1; i>=0; i--)
		{
			if(2*i+2>=length)
			{
				if(a[i]<a[2*i+1])
					Swap(a, i, 2*i+1);
			}
			else
			{
				if(a[i]<a[2*i+1])
					Swap(a, i, 2*i+1);//这里为什么要先和左结点比较
				if(a[i]<a[2*i+2])
					Swap(a, i, 2*i+2);
			}
		}
	}

	
	
	
	public static void main(String[] args) {
		
		int[] a = {6, 10, 13, 5, 8, 3, 2, 11}; 
		for (int element: a) 
			System.out.print(element+" ");
		System.out.println();
		//QuickSort(a, 0, a.length);
		//SelectionSort(a);
		//InsertionSort(a);
		//BubbleSort(a);
		//MergeSort(a);
		HeapSort(a);
		for (int element: a) 
			System.out.print(element+" ");		

	}
	

}
