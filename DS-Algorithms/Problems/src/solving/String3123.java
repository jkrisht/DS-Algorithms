package solving;

public class String3123 {
	public static void main(String[] args) {
		String s12 = "Afsdfsdf";

		System.out.println(s12.charAt(0));
		System.out.println(s12.codePointAt(0));
		System.out.println(s12.codePointBefore(4));
		System.out.println(s12.concat("1212"));
		System.out.println(s12);
		System.out.println(s12.compareTo("Afsdfsdf1"));
		System.out.println(s12.intern());
		System.out.println(s12.isEmpty());
		System.out.println(Integer.parseInt("123"));
		
		System.out.println(s12.substring(0, 2));
	}
}
