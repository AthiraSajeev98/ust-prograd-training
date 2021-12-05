public class Kata {
  public static String high(String s) {
    
    String[] words = s.split("\\s");
    int[] scores = new int[words.length];
    int highestscore=0, 
    highestindex=0;
        for (int j = 0; j < words.length; j++) {
            int score = 0;
            for (int i = 0; i <words[j].length() ; i++) {
                score += words[j].charAt(i)-'a'+1;
            }
            scores[j]=score;
        }
     for (int i=0;i<scores.length;i++) {
            if(scores[i]>highestscore){
                highestscore=scores[i];
                highestindex=i;
            }
        }
    return words[highestindex];
  }
}