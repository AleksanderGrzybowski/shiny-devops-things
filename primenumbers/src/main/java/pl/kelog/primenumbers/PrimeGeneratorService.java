package pl.kelog.primenumbers;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

@Service
public class PrimeGeneratorService {
    public List<Long> generate(int count) {
        return LongStream.iterate(2L, i -> i + 1)
                .filter(PrimeGeneratorService::isPrime)
                .limit(count)
                .boxed()
                .collect(toList());
    }
    
    private static boolean isPrime(long number) {
        return LongStream.rangeClosed(2, (int) Math.sqrt(number)).allMatch(divisor -> number % divisor != 0);
    }
}
