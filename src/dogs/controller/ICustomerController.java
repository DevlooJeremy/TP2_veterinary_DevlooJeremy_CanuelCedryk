package dogs.controller;

import java.util.Collection;

import dogs.model.Customer;

public interface ICustomerController {
	public void listCustomer();
	public void showResult(Collection<Customer> result);
}
