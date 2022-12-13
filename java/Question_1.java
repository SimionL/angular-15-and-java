public class Question_1 {

	private static String starString(int n) {
		String result = "";
		if(0<=n) {
			long stringLength = 1;
			for (; 0<n ; --n) {
				stringLength *= 2;
			}
			while(result.length() < stringLength){
				result = result.concat("*");
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(starString(1));
		System.out.println(starString(2));
		System.out.println(starString(3));
		System.out.println(starString(4));
		System.out.println(starString(5));
	}
}