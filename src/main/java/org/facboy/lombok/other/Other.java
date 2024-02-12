package org.facboy.lombok.other;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;

public class Other {
  @Qualifier
  @Retention(RetentionPolicy.RUNTIME)
  public @interface MyQualifier {}
}
