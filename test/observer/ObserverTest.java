package observer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dogs.observer.DogListObserver;
import mock.ListControllerSpy;

class ObserverTest {

	@Test
	void observerCanCallUpdateOnController() {
		ListControllerSpy controller = new ListControllerSpy();
		DogListObserver observer = new DogListObserver(controller);
		
		observer.update();
		
		assertTrue(controller.hasUpdateBeenCalled);
	}

}
