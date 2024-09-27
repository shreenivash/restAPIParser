package org.example;

public class RemoveDuplicate {

    public static void main(String[] args) {
       // System.out.println( "Hello World!" );
        int[] s = {2, 3, 2, 3, 7, 8, 9, 5};

        for (int i =0 ; i < s.length;i ++){
            for(int j=0;j<s.length;j++){
                if (s[i]==s[j] && i!=j){
                    break;
                }
                else if(j==s.length-1){
                        System.out.println(s[i]);
                }
            }

        }
    }
}
