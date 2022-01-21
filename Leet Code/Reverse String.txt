class Solution {
    public void reverseString(char[] s) {
        
       int length = s.length;
        char reverse[]=new char[100000];

    if (length == 0)
        return ;
        

    int j=0;
    for (int i=length-1; i >=0; i--){
      reverse[j]=s[i];
        j++;
    }

    for (int i=0; i < length; i++){
        s[i]=reverse[i];
    }
    
    System.out.print(s);

    }
}