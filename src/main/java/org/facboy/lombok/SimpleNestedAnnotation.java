package org.facboy.lombok;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Inject;
import javax.inject.Qualifier;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor_ = @Inject)
@Getter
public class SimpleNestedAnnotation {

  @MyQualifier private final int someVal;

  @Qualifier
  @Retention(RetentionPolicy.RUNTIME)
  public @interface MyQualifier {}
}
