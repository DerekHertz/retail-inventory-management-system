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

        boolean isValid = true;
        // check if inv is greater than maxInv or less than minInv
        if (partInv > maxInv) {
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                    "🌸 Your greenhouse is overflowing! Current stock (" + partInv +
                            ") exceeds maximum capacity (" + maxInv + "). " +
                            "Your garden bed is full to capacity!"
            ).addConstraintViolation();
            isValid = false;
        } else if (partInv < minInv) {
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                    "🌱 Your inventory is wilting! Current stock (" + partInv +
                            ") is below the minimum growing level (" + minInv + "). " +
                            "Time to water your stock!"
            ).addConstraintViolation();
            isValid = false;
        }
        return isValid;
    }
}
