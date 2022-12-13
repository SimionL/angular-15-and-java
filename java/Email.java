import java.util.LinkedList;

public interface Email {

	int getType();
	String getBody();
	String getAddressee();

	default int getAttemptsNumber() {
		return 0;
	}

	default LinkedList<Encryption> getEncryptionType() {
		return null;
	}

	default String getDisclaimer() {
		return null;
	}
}