//package com.fareye.training.annotation;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//import java.lang.annotation.*;
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE)
//@Documented
//@Constraint(validatedBy = com.fareye.training.annotations.AnnotationValidator.class)
//public @interface DuplicateTitle {
//    public String message() default "Title already exists";
//    public Class<?>[] groups() default {};
//    //represents additional information about annotation
//    public Class<? extends Payload>[] payload() default {};
//}