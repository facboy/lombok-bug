package org.facboy.lombok;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Inject;
import javax.inject.Qualifier;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class NestedClassAndNestedAnnotation {

  @RequiredArgsConstructor(onConstructor_ = @Inject)
  @Getter
  public static class Inner {
    @MyQualifier
    private final int someVal;
  }

  @Qualifier
  @Retention(RetentionPolicy.RUNTIME)
  public @interface MyQualifier {}
}
