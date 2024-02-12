package org.facboy.lombok;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.lang.annotation.Annotation;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AnnotationTest {

  @ParameterizedTest
  @MethodSource("args")
  void paramShouldBeAnnotated(Class<?> objectClass)
      throws ReflectiveOperationException {
    var field = objectClass.getDeclaredField("someVal");
    var fieldAnnotation = field.getAnnotations()[0].annotationType();

    var constructor = objectClass.getConstructor(Integer.TYPE);
    var annotations = constructor.getParameterAnnotations();

    assertThat(annotations[0].length, is(1));
    assertThat(annotations[0][0].annotationType(), is(fieldAnnotation));
  }

  @ParameterizedTest
  @MethodSource("args")
  void getterShouldBeAnnotated(Class<?> objectClass)
      throws ReflectiveOperationException {
    var field = objectClass.getDeclaredField("someVal");
    var fieldAnnotation = field.getAnnotations()[0].annotationType();

    var m = objectClass.getMethod("getSomeVal");
    var annotations = m.getAnnotations();

    assertThat(annotations.length, is(1));
    assertThat(annotations[0].annotationType(), is(fieldAnnotation));
  }

  static List<Arguments> args() {
    return List.of(
        arguments(SimpleNestedAnnotation.class),
        arguments(
            SimpleNestedAnnotationWithConflictingImport.class),
        arguments(
            NestedClassAndAnnotationNestedInImportedSibling.Inner.class),
        arguments(
            NestedClassAndAnnotationNestedInNonImportedSibling.Inner.class),
        arguments(
            NestedClassAndNestedAnnotation.Inner.class),
        arguments(
            NestedClassAndNestedAnnotationImported.Inner.class),
        arguments(
            NestedClassAndNestedAnnotationWithConflictingNestedImport.Inner.class),
        arguments(
            NestedClassAndNestedAnnotationWithOverridingImport.Inner.class),
        arguments(
            NestedClassAndNestedAnnotationWithOverridingNestedAnnotationImport.Inner.class),
        arguments(
            NestedClassAndNestedAnnotation.Inner.class),
        arguments(
            TwiceNestedClassAndSiblingAnnotation.Other.OtherInner.class),
        arguments(
            TwiceNestedClassAndUpperAnnotation.Other.OtherInner.class));
  }
}
