import java.util.Random;

public class MySort {
	
	
	public static void SelectionSort(int[] a){
		// ѡ������
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
		//��������
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
		// ð������
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
		// ��������
		if(p<q)
		{
			int r = Partion(a, p, q);
			QuickSort(a, p, r-1);
			QuickSort(a,r+1,q);			
		}
	}
	

	public static int Partion(int[] a, int p, int q){
		// ������Ŀ����õ�һ��Ԫ����Ϊpivot
		// ���������ѡ��pivot������Ҳ�ܼ�
		Random y = new Random();
		int pivot = y.nextInt(q-p+1)+p;//�������Ԫ
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
		// ��������������ֵ��λ��
		int temp;
		temp = a[b];
		a[b] = a[c];
		a[c] = temp;
	}
	
	public static void MergeSort(int[] a){
		//�鲢����
		int[] temp = new int[a.length];
		Sort(a, 0, a.length-1, temp);
	}
	public static void Sort(int[] a, int left, int right, int[] temp){
		//�鲢�����е�����
		if(left<right)
		{
			int mid = (left+right)/2;
			Sort(a, left, mid, temp);
			Sort(a, mid+1, right, temp);
			Merge(a, left, mid, right, temp);
		}
	}
	public static void Merge(int[] a, int left, int mid, int right, int[] temp){
		//�鲢�����еĹ鲢
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
			//ע��˴�ѭ���������������tempֻ����ʱ�����飬���������е���
			a[left++]=temp[t++];
		}
	}
	
	
	
	public static void HeapSort(int[] a){
		//�����򣬹ؼ��ǽ�����
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
		//������
		for(int i=(length-1)/2-1; i>=0; i--)
		{
			if(2*i+2>=length)
			{
				if(a[i]<a[2*i+1])
					Swap(a, i, 2*i+1);
			}
			else
			{
				if(a[i]<a[2*i+1])
					Swap(a, i, 2*i+1);//����ΪʲôҪ�Ⱥ�����Ƚ�
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