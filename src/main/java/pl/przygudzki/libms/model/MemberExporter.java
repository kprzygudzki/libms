package pl.przygudzki.libms.model;

import java.util.UUID;

public interface MemberExporter {

	void exportName(String name);

	void exportAddress(String address);

	void exportId(UUID id);

}
