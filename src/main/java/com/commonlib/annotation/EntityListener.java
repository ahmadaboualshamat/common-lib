package com.commonlib.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityListener {
    Class listenerClass() ;
    String[] createMethods();
    String[] updateMethods();
    String[] deleteMethods();
}
