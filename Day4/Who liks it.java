class Solution {
    public static String whoLikesIt(String... names) {
//       //Do your magic here
      for (int i=0;i<=names.length;i++){
        if (names.length==0)
      {
        return "no one likes this";
      }
      else if(names.length==1)
      {
        return (names[i]+ " likes this");
      }
      else if(names.length==2)
      {
        return (names[i]+ " and"+ " "+ names[1]+ " like this");
      }
      else if(names.length==3)
      {
        return names[0] + ", " + names[1] +  " and " + names[2] + " like this";
      }
      else{
            return names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
      }
      }
        return "";
    }
}