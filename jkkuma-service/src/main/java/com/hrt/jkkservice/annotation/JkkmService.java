package com.hrt.jkkservice.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;



/**
 * @author kiirokuma
 *
 */
@Retention(RUNTIME)
@Target(TYPE_USE)
public @interface JkkmService {

}
