import java.util.LinkedList;
public class EmailLauncher  implements EmailService {

	@Override
	public void send(Email email) throws Exception {

		System.out.println("I'm starting to send the email");

		if(2 == (int)(Math.random() * 4) + 1) {
			throw new Exception();
		}

		StringBuilder encryption = new StringBuilder();

		LinkedList<Encryption> encryptionList = email.getEncryptionType();

		if(encryptionList != null) {

			encryptionList.forEach(e -> encryption.append(e + " "));
		}

		System.out.println(" type: " + email.getType());

		if(!encryption.toString().trim().isEmpty()) {
			System.out.println(" with encryption: " + encryption);
		}
		else {
			System.out.println(" unencrypted");
		}

		if(email.getAddressee().equals("outside resource")) {
			System.out.println(" email logged");
		}

		System.out.println(" with body: " + email.getBody());

		if(email.getDisclaimer() != null) {
			System.out.println(" with disclaimer: " + email.getDisclaimer());
		}
		else {
			System.out.println(" without the disclaimer");
		}

		System.out.println(" to address: " + email.getAddressee());

		if(0 < email.getAttemptsNumber()) {
			System.out.println(" with sending operation up to " + email.getAttemptsNumber() + " times");
		}
		else {
			System.out.println(" no retry");
		}

		System.out.println("Email sent successfully");
	}
	/**
	 * in a real scenario, this method must contain more parameters, for a full email content customization.
	 * @param emailType
	 */
	public void launchEmail(int emailType) {

		switch(emailType){
		case(1):{
			processing(new EmailType_1());
			break;
		}
		case(2):{
			processing(new EmailType_2());
			break;
		}
		case(3):{
			processing(new EmailType_3());
			break;
		}
		case(4):{
			processing(new EmailType_4());
			break;
		}
		default:{
			System.out.println("Email type was not identified. Please provide a valid email type!");
		}
		}
	}

	private void processing(Email email) {

		int retry = email.getAttemptsNumber();

		if(retry == 0) {
			try {
				send(email);
			}
			catch(Exception e) {
				System.out.println("Failed to send email! No more attempts left.");
			}
		}
		else {
			for(int i = 1 ; i <= retry ; i++) {
				try {
					send(email);
					break;
				}
				catch(Exception e) {
					System.out.println("Failed to send email!");
					if(i < retry) {
						System.out.println("I'm trying again");
					}
					else {
						System.out.println("No more attempts left.");
					}
					System.out.println();
				}
			}
		}
	}
}