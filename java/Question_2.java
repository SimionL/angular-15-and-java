import java.util.concurrent.TimeUnit;

public class Question_2 {

	public static void main(String[] args){

		try {
			for(int i=1; i<=4 ; i++) {

				new EmailLauncher().launchEmail(i);
				System.out.println();
				System.out.println();
				TimeUnit.SECONDS.sleep(2);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}