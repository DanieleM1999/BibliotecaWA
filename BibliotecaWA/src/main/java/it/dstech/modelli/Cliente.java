package it.dstech.modelli;

public class Cliente {

	private String usernameC;
	private String passC;

	public Cliente(String usernameC, String passC) {
		this.usernameC = usernameC;
		this.passC = passC;
	}

	public String getUsernameC() {
		return usernameC;
	}

	public void setUsernameC(String usernameC) {
		this.usernameC = usernameC;
	}

	public String getPassC() {
		return passC;
	}

	public void setPassC(String passC) {
		this.passC = passC;
	}

}
