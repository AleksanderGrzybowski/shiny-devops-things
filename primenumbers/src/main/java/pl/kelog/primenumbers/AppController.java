package pl.kelog.primenumbers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
public class AppController {
    
    private final PrimeGeneratorService primeGeneratorService;
    
    public AppController(PrimeGeneratorService primeGeneratorService) {
        this.primeGeneratorService = primeGeneratorService;
    }
    
    @RequestMapping("/generate/{count}")
    public ResponseEntity<List<Long>> generate(@PathVariable("count") Integer count) {
        try {
            return ResponseEntity.ok(primeGeneratorService.generate(count));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
