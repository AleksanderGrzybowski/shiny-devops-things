package pl.kelog.primenumbers;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrimeGeneratorServiceTest {
    
    private PrimeGeneratorService primeGeneratorService = new PrimeGeneratorService();
    
    @Test
    public void should_properly_generate_first_prime_number() {
        assertThat(primeGeneratorService.generate(1)).isEqualTo(singletonList(2L));
    }
    
    @Test
    public void should_properly_generate_first_five_prime_numbers() {
        assertThat(primeGeneratorService.generate(5)).isEqualTo(asList(2L, 3L, 5L, 7L, 11L));
    }
    
    @Test
    public void should_properly_generate_empty_list_if_zero_given() {
        assertThat(primeGeneratorService.generate(0)).isEqualTo(emptyList());
    }
    
    @Test
    public void should_throw_on_negative_count() {
        assertThatThrownBy(() -> primeGeneratorService.generate(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}