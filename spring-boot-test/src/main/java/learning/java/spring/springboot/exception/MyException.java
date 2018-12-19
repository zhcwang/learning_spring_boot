package learning.java.spring.springboot.exception;

public class MyException extends RuntimeException {
	
	private static final long serialVersionUID = -5837697020347589354L;

	private String code;
	
	private String message;

	public MyException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
