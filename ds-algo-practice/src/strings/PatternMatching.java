package strings;

public class PatternMatching {
    public static void main(String[] args) {

        String str = "MNJKLSADFJAGAGANSASIERTFJAGA";
        String find = "FJAGA";

        boolean isFound = findText(str, find);
        System.out.println(isFound);
    }

    public static boolean findText(String text, String find){

        char chars[] = text.toCharArray();
        char findChars[] = find.toCharArray();

        int index = 0;
        int count = 0;
        boolean isFound = false;

        for (int i=0; i < chars.length; i++){
            if (index < findChars.length && chars[i] == findChars[index]) {
                if (index == findChars.length-1){
                    isFound = true;
                    index = 0;
                    count++;
                }
                index++;
            } else {
                index = 0;
            }
        }
        System.out.println(count);
        return isFound;
    }
}
