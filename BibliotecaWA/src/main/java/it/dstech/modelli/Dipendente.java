package it.dstech.modelli;

public class Dipendente {

	private String usernameD;
	private String passD;

	public Dipendente(String usernameD, String passD) {
		this.usernameD = usernameD;
		this.passD = passD;
	}

	public String getUsernameD() {
		return usernameD;
	}

	public void setUsernameD(String usernameD) {
		this.usernameD = usernameD;
	}

	public String getPassD() {
		return passD;
	}

	public void setPassD(String passD) {
		this.passD = passD;
	}

}
