package pl.przygudzki.libms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Member {

	@Id
	@GeneratedValue
	private UUID id;

	private String name;
	private String address;

	public Member(CreateMemberCommand command) {
		name = command.getName();
		address = command.getAddress();
	}

	public Member() {
	}

	public void export(MemberExporter exporter) {
		exporter.exportId(id);
		exporter.exportName(name);
		exporter.exportAddress(address);
	}

}
