package utils;

public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length,l2=nums2.length;
        if(l1==0) return l2%2==0?(double)(nums2[l2/2]+nums2[l2/2-1])/2:nums2[l2/2];
        if(l2==0) return l1%2==0?(double)(nums1[l1/2]+nums1[l1/2-1])/2:nums1[l1/2];
        if((l1+l2)%2==0){
           return (findKth(nums1,nums2,(l1+l2)/2,0,l1-1,0,l2-1)+findKth(nums1,nums2,(l1+l2)/2-1,0,l1-1,0,l2-1))/2;
        }else{
            return findKth(nums1,nums2,(l1+l2)/2,0,l1-1,0,l2-1);
        }
    }
    public double findKth(int a[], int b[], int k, int aStart, int aEnd, int bStart, int bEnd) {
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
		if(a[aMid]>b[bMid]){
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
		new MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
	}

}
