package pl.przygudzki.libms.application;

import java.util.UUID;

public class MemberDto {

	private String name;
	private String address;
	private UUID id;

	void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	void setId(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

}
