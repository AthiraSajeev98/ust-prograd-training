public class Kata {
    public static String lastSurvivor(String letters, int[] coords) {
      StringBuilder obj = new StringBuilder(letters);
      for(int i = 0; i < coords.length; i++){
        obj.deleteCharAt(coords[i]);
      }
        return obj.toString();
    }
}