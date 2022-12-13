import java.util.LinkedList;

/**
 * @author Laurentiu
 * sending an HTML email to an internal server (so without the disclaimer), encrypted with DES, with the retry functionality
 */
public class EmailType_2 implements Email{

	@Override
	public int getType() {
		return 2;
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
		return "internal server";
	}

	public LinkedList<Encryption> getEncryptionType() {
		LinkedList<Encryption> encryptionList = new LinkedList<>();
		encryptionList.add(Encryption.DES);
		return encryptionList;
	}

	@Override
	public final boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof EmailType_2)) return false;

		EmailType_2 other = (EmailType_2)o;

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