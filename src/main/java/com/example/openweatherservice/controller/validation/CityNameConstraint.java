package com.example.openweatherservice.controller.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = CityParameterValidator.class )
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
public @interface CityNameConstraint {

    String message() default "Invalid city name";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
