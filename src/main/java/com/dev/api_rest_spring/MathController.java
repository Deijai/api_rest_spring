package com.dev.api_rest_spring;

import com.dev.api_rest_spring.exception.ErrorMathException;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {


    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum (@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new ErrorMathException("Set number value.");
        }
        Double sum = convertDouble(numberOne) + convertDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value = "/min/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double min(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new ErrorMathException("Set number value.");
        }
        Double min = convertDouble(numberOne) - convertDouble(numberTwo);
        return min;
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new ErrorMathException("Set number value.");
        }
        Double mult = convertDouble(numberOne) * convertDouble(numberTwo);
        return mult;
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new ErrorMathException("Set number value.");
        }
        Double div = convertDouble(numberOne) / convertDouble(numberTwo);
        return div;
    }

    @RequestMapping(value = "/med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double med(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new ErrorMathException("Set number value.");
        }
        Double med = (convertDouble(numberOne) + convertDouble(numberTwo)) / 2;
        return med;
    }

    @RequestMapping(value = "/raiz/{number}", method = RequestMethod.GET)
    public Double med(@PathVariable("number") String number) {
        if(!isNumeric(number) || !isNumeric(number)){
            throw new ErrorMathException("Set number value.");
        }
        Double raiz = Math.sqrt((convertDouble(number)));
        return raiz;
    }

    private Double convertDouble(String str) {
        if(str == null) return 0D;
        String number = str.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(str);

        return 0D;
    }

    private boolean isNumeric(String str) {
        if(str == null) return false;
        String number = str.replaceAll(",", ".");
            return str.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
