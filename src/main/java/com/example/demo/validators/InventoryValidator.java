package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidInventory constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part item, ConstraintValidatorContext constraintValidatorContext) {
        int partInv = item.getInv();
        int minInv = item.getMinInv();
        int maxInv = item.getMaxInv();
        // return true if partInv is greater than or equal to minInv and less than or equal to maxInv else return false
        if (partInv > maxInv) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Solution: Reduce inventory, current value is greater than max inventory").addConstraintViolation();
            return false;
        } else if (partInv < minInv) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Solution: Increase inventory, current value is less than min inventory").addConstraintViolation();
            return false;
        }

        return true;
    }
}
