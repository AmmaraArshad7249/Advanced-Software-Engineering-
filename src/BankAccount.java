public class BankAccount {
	private String no;
	private String username;
	private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String zipcode;
    private String accountType;
    private boolean encryption;
    private double amount;
    
    
	public String getNo() {
		return no;
	}


	public BankAccount(String name, String email, String phone, String address,
			String username, String password, String city, String zipcode, String accountType, boolean encryption, double amount) {
	super();
	this.username = username;
	this.password = password;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.address = address;
	this.city = city;
	this.zipcode = zipcode;
	this.accountType = accountType;
	this.encryption = encryption;
	this.amount = amount;
}


	public void setNo(String no) {
		this.no = no;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isEncryption() {
		return encryption;
	}

	public void setEncryption(boolean encryption) {
		this.encryption = encryption;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

}
