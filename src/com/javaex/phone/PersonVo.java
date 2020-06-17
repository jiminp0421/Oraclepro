package com.javaex.phone;

public class PersonVo {
	
	
	//필드
	private int personId;
	private String Name; //사람이름
	private String Hp;	//사람핸드폰번호
	private String Company;	//사람회사번호
	

	//생성자
	
	public PersonVo(String Name, String Hp, String Company) {
		super();
		this.Name = Name;
		this.Hp = Hp;
		this.Company = Company;
	}
	
	public PersonVo(int personId, String Name, String Hp, String Company) {
		super();
		this.personId = personId;
		this.Name = Name;
		this.Hp = Hp;
		this.Company = Company;
	}


	
	public int getpersonId() {
		return personId;
	}


	public void setpersonId(int personId) {
		this.personId = personId;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getHp() {
		return Hp;
	}


	public void setHp(String hp) {
		Hp = hp;
	}


	public String getCompany() {
		return Company;
	}


	public void setCompany(String company) {
		Company = company;
	}

}
