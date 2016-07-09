package utils;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
        int len=s.length();
        if(len<2) return s;
        boolean [][]f=new boolean[len][len];
        int longest=0;
        String re = null;
        for(int i=0;i<len;i++){
            for(int j=0;j<=i;j++){
                if(i==j||s.charAt(i)==s.charAt(j)&&((i-j)==1||j+1<len&&i-1>=0&&f[j+1][i-1])){
                	System.out.println(i+ " "+j);
                    f[j][i]=true;
                    if(i-j+1>longest){
                        longest=i-j+1;
                        re=s.substring(j,i+1);
                    }
                }
            }
        }
        return re;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LongestPalindromicSubstring().longestPalindrome("aaaa");
	}

}
