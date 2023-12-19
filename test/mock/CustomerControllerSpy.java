package mock;

import java.util.Collection;

import dogs.controller.ICustomerController;
import dogs.model.Customer;

public class CustomerControllerSpy implements ICustomerController{

	public boolean hasListCustomerBeenCalled;
	
	@Override
	public void listCustomer() {
		this.hasListCustomerBeenCalled = true;
		
	}

	@Override
	public void showResult(Collection<Customer> result) {
		// TODO Auto-generated method stub
		
	}

}
