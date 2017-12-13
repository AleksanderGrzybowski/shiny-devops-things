package pl.kelog.primenumbers;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Arrays.asList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class AppControllerTest {
    
    private MockMvc mockMvc;
    private PrimeGeneratorService primeGeneratorService;
    
    @Before
    public void setup() {
        primeGeneratorService = mock(PrimeGeneratorService.class);
        mockMvc = standaloneSetup(new AppController(primeGeneratorService)).build();
    }
    
    @Test
    public void should_return_first_five_primes() throws Exception {
        when(primeGeneratorService.generate(5)).thenReturn(asList(2L, 3L, 5L, 7L, 11L));
        
        mockMvc.perform(get("/generate/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0]", is(2)))
                .andExpect(jsonPath("$[1]", is(3)))
                .andExpect(jsonPath("$[2]", is(5)))
                .andExpect(jsonPath("$[3]", is(7)))
                .andExpect(jsonPath("$[4]", is(11)));
    }
    
    @Test
    public void should_return_400_given_negative_count() throws Exception {
        when(primeGeneratorService.generate(5)).thenThrow(IllegalArgumentException.class);
        
        mockMvc.perform(get("/generate/5"))
                .andExpect(status().isBadRequest());
    }
}