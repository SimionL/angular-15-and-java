/**
 * @author Laurentiu
 * sending a plain text email to an outside resource, with a disclaimer added at the end, unencrypted and no retry
 */
public class EmailType_1 implements Email{

	@Override
	public int getType() {
		return 1;
	}

	@Override
	public String getBody() {
		return "plain text";
	}

	@Override
	public String getAddressee() {
		return "outside resource";
	}

	public String getDisclaimer() {
		return "disclaimer message 1";
	}

	@Override
	public final boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof EmailType_1)) return false;

		EmailType_1 other = (EmailType_1)o;

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