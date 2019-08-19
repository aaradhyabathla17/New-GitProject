package crux7april;

public class hauffmanclient {

	public static void main(String[] args) {
		String str="aaaabcddddd";
		hauffmann hc=new hauffmann(str);
		System.out.println(hc.encode("abcdddd"));
		System.out.println(hc.decode("111001010000"));

	}
}}}
}}}}}}}}
