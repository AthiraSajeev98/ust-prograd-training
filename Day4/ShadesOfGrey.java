public class ShadesOfGrey {

    static String[] shadesOfGrey(int num) {
        num = Math.max(0, Math.min(254, num));
        String[] result = new String[num];
        for (int i = 1; i <= num; ++i) {
            result[i - 1] = String.format("#%02x%02x%02x", i, i, i);
        }
        return result;
    }
}