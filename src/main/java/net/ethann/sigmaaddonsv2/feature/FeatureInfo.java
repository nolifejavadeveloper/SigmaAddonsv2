package net.ethann.sigmaaddonsv2.feature;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FeatureInfo {
    String name();
    String description() default "";
    boolean enabledByDefault() default false;
    Category category();
}
