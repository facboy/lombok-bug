package org.facboy.lombok;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Inject;
import javax.inject.Qualifier;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.facboy.lombok.other.MyQualifier;

public class NestedClassAndNestedAnnotationWithOverridingImport {

  /**
   * Should be annotated with {@link org.facboy.lombok.other.MyQualifier}
   */
  @RequiredArgsConstructor(onConstructor_ = @Inject)
  @Getter
  public static class Inner {
    @MyQualifier private final int someVal;
  }

  public static class Other {

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyQualifier {}
  }
}
