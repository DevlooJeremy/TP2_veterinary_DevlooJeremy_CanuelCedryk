package dto;

public class CustomerDTO {

		public final String firstName;
		public final String lastName;
		public final String phone;
		public final String email;
		public final int id;
		
		public CustomerDTO(String firstName,String lastName,String phone,String email,int id) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.email = email;
			this.id = id;
		}
}
