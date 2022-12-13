import java.util.LinkedList;

/**
 * @author Laurentiu
 * sending an HTML email to an outside resource, with a disclaimer added at the end and encrypted with AES with retries in case of errors
 */
public class EmailType_3 implements Email{

	@Override
	public int getType() {
		return 3;
	}

	@Override
	public int getAttemptsNumber() {
		return 3;
	}

	@Override
	public String getBody() {
		return "HTML email";
	}

	@Override
	public String getAddressee() {
		return "outside resource";
	}

	public LinkedList<Encryption> getEncryptionType() {
		LinkedList<Encryption> encryptionList = new LinkedList<>();
		encryptionList.add(Encryption.AES);
		return encryptionList;
	}

	public String getDisclaimer() {
		return "disclaimer message 3";
	}

	@Override
	public final boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof EmailType_3)) return false;

		EmailType_3 other = (EmailType_3)o;

		return this.getType() == other.getType() && 
				this.getAddressee().equals(other.getAddressee()) &&
				this.getAttemptsNumber() == other.getAttemptsNumber() &&
				this.getBody().equals(other.getBody());
	}

	@Override
	public final int hashCode() {
		return this.getType();
	}
}