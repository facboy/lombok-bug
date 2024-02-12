package org.facboy.lombok;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Inject;
import javax.inject.Qualifier;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class NestedClassAndAnnotationNestedInNonImportedSibling {

  @RequiredArgsConstructor(onConstructor_ = @Inject)
  @Getter
  public static class Inner {
    @Other.OtherNested.MyQualifier
    private final int someVal;
  }

  public static class Other {

    public static class OtherNested {
      @Qualifier
      @Retention(RetentionPolicy.RUNTIME)
      public @interface MyQualifier {}
    }
  }
}
