package wareysis.com.br.flcx.models;

import java.util.HashMap;
import java.util.Map;


public class AcquirersModel {
	private String companyName;
	private String cpfCnpj;
	private String email;
	private String fantasyName;
	private Map<String, String> type = new HashMap<>();

	public AcquirersModel(String companyName, String cpfCnpj, Map<String, String> type) {
		super();
		this.companyName = companyName;
		this.cpfCnpj = cpfCnpj;
		this.type = type;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public String getEmail() {
		return email;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public Map<String, String> getType() {
		return type;
	}
	
	

}
