package org.facboy.lombok;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Inject;
import javax.inject.Qualifier;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class TwiceNestedClassAndUpperAnnotation {

  public static class Other {

    /** This should be annotated with {@link MyQualifier} */
    @RequiredArgsConstructor(onConstructor_ = @Inject)
    @Getter
    public static class OtherInner {
      @MyQualifier
      private final int someVal;
    }
  }

  @Qualifier
  @Retention(RetentionPolicy.RUNTIME)
  public @interface MyQualifier {}
}
