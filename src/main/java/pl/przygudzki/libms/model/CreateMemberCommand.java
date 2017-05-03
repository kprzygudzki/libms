package pl.przygudzki.libms.model;

public class CreateMemberCommand {

	private String name;
	private String address;

	String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
