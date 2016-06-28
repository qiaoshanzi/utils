package utils;

public class FindKth {
	public int findKth(int a[], int b[], int k, int aStart, int aEnd, int bStart, int bEnd) {
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
		if (aLen == 0)
			return b[bStart + k];
		if (bLen == 0)
			return a[aStart + k];
		if (k == 0)
			return a[aStart] >= b[bStart] ? b[bStart] : a[aStart];
		int aMid=k*aLen/(aLen+bLen);
		int bMid=k-1-aMid;
		aMid=aMid+aStart;
		bMid=bMid+bStart;
		if(aMid>bMid){
			k=k-(bMid-bStart+1);
			aEnd=aMid;
			bStart=bMid+1;
		}else{
			k=k-(aMid-aStart+1);
			bEnd=bMid;
			aStart=aMid+1;
		}
		return findKth(a,b,k,aStart,aEnd,bStart,bEnd);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
