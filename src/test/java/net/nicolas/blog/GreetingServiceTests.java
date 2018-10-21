package net.nicolas.blog;

import net.nicolas.blog.services.NamesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GreetingServiceTests {

    @Mock
    private NamesService namesService;

    @InjectMocks
    private GreetingService greetingService;

    @Test
    public void test1(){
        when(namesService.get()).thenReturn("Carl");
        assertEquals("Hello Carl", greetingService.greet());
    }

    @Test
    public void test2(){
        NamesService ns = mock(NamesService.class);
        when(ns.get()).thenReturn("Carl");
        GreetingService ds = new GreetingService(ns);
        assertEquals("Hello Carl", ds.greet());
    }
}
