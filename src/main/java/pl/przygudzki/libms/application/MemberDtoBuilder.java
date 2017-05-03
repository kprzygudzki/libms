package pl.przygudzki.libms.application;

import pl.przygudzki.libms.model.MemberExporter;

import java.util.UUID;

public class MemberDtoBuilder implements MemberExporter {

	private MemberDto dto = new MemberDto();

	public MemberDto build() {
		MemberDto result = dto;
		dto = new MemberDto();
		return result;
	}

	@Override
	public void exportName(String name) {
		dto.setName(name);
	}

	@Override
	public void exportAddress(String address) {
		dto.setAddress(address);
	}

	@Override
	public void exportId(UUID id) {
		dto.setId(id);
	}

}
