package sneha.ust.model;

//Contact Person Bean Class

public class ContactPerson {

	private int contactId;
	private String contactName;
	private int vendorId;
	private String department;
	private String eMail;
	private String phone;
	private String isActiveP;
	
	
	//Default Constructor
	public ContactPerson() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//Parameterized constructor
	public ContactPerson(int contactId, String contactName, int vendorId,
			String department, String eMail, String phone, String isActiveP) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.vendorId = vendorId;
		this.department = department;
		this.eMail = eMail;
		this.phone = phone;
		this.isActiveP = isActiveP;
	}

	
	//Getters and Setters
	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIsActiveP() {
		return isActiveP;
	}

	public void setIsActiveP(String isActiveP) {
		this.isActiveP = isActiveP;
	}

	
	//To String Method
	@Override
	public String toString() {
		return "ContactPerson [contactId=" + contactId + ", contactName="
				+ contactName + ", vendorId=" + vendorId + ", department="
				+ department + ", eMail=" + eMail + ", phone=" + phone
				+ ", isActiveP=" + isActiveP + "]";
	}
	
	
	
}
