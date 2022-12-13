import java.util.LinkedList;

/**
 * @author Laurentiu
 * sending a plain text email to an outside resource and encrypted first with DES and then with AES
 */
public class EmailType_4 implements Email{
	@Override
	public int getType() {
		return 4;
	}

	public LinkedList<Encryption> getEncryptionType() {
		LinkedList<Encryption> encryptionList = new LinkedList<>();
		encryptionList.add(Encryption.DES);
		encryptionList.add(Encryption.AES);
		return encryptionList;
	}

	@Override
	public String getBody() {
		return "plain text";
	}

	@Override
	public String getAddressee() {
		return "outside resource";
	}

	@Override
	public final boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof EmailType_4)) return false;

		EmailType_4 other = (EmailType_4)o;

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