import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class FirstMockTest {
	@Test
	public void testGetBar() {
		Foo foo = mock(Foo.class);
		Bar bar = new Bar();
		when(foo.getBar()).thenReturn(bar);
		assertEquals(foo.getBar(), bar);
		verify(foo).getBar();
		// verify(bar).getName(); This line will fail. This isn't called.
	}

}
