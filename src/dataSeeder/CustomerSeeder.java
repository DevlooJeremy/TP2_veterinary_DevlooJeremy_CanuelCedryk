package dataSeeder;

import dogRepository.ICustomerRepository;
import dogs.model.Customer;

public class CustomerSeeder {
	
	public CustomerSeeder(ICustomerRepository repository) {
		repository.add(new Customer("Thomas", "Paquet","418.380.3141","ThomasPaquet@gmail.com"));
		repository.add(new Customer("Jean", "Dujardin","418.381.3141","JeanDujardin@gmail.com"));
		repository.add(new Customer("François", "Legault","418.382.3141","FrancoisLegault@gmail.com"));
		repository.add(new Customer("Bruno", "Marchand","418.383.3141","BrunoMarchand@gmail.com"));
	}
}
