package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String calculator() {
        return calculatorService.calculatorHello();
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        calculatorService.checkingValues(num1, num2);
        return num1 + " + " + num2 + " = " + calculatorService.plus(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        calculatorService.checkingValues(num1, num2);
        return num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        calculatorService.checkingValues(num1, num2);
        return num1 + " * " + num2 + " = " + calculatorService.multiply(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        calculatorService.checkingValues(num1, num2);
        return num1 + " / " + num2 + " = " + calculatorService.divide(num1, num2);
    }
}

