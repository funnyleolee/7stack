package me.sevenstack.blog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface Bind {
	Class model();

}
