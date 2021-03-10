package tn.esprit.spring.exceptions;

public class ImageStorageException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3906182980091088184L;

	public ImageStorageException(String message) {
        super(message);
    }

    public ImageStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
