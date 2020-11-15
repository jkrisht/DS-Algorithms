package others;

public class ReverseAString {
    /*
    https://medium.com/techie-delight/stack-data-structure-practice-problems-and-interview-questions-9f08a35a7f19
    https://www.techiedelight.com/reverse-string-without-using-recursion/
     */
    public static void main(String[] args) {
        String text = "WORD";
        StringBuilder builder = new StringBuilder();

        char[] ch = text.toCharArray();

        int begin = 0;
        int end = text.length()-1;

        while (begin < end){
            char temp = ch[begin];
            ch[begin++] = ch[end];
            ch[end--] = temp;
        }
        for (char c: ch) {
            builder.append(c);
        }

        System.out.println(builder);
    }
}
