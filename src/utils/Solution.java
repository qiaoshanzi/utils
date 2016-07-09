package utils;

public class Solution {
	public String multiply(String num1, String num2) {
        int len1=num1.length(),len2=num2.length();
        if(len1<1||len2<1||num1.equals("0")||num2.equals("0")) return Integer.toString(0);
        int[] re=new int[len1+len2+1];
        int mul=0;
        int m,n=0,p,q;
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                p=0;
                while(mul>0){
                	//System.out.println(p+" "+mul);
                	n=re[len1-1-i+len2-1-j+p]+mul;
                    re[len1-1-i+len2-1-j+p]=n%10;
                    mul=n/10;
                    p++;
                }
            }   
        }
        StringBuilder sb=new StringBuilder();
        boolean flag=false;
        for(int i=len1+len2;i>=0;i--){
            if(re[i]==0&&!flag){
                continue;
            }else if(re[i]!=0){
                flag=true;
                sb.append(re[i]);
            }else{
                sb.append(re[i]);
            }
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().multiply("9","9"));
	}

}
