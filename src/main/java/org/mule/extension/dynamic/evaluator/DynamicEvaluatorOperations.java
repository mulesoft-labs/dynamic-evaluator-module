package org.mule.extension.dynamic.evaluator;

import static org.mule.runtime.api.meta.ExpressionSupport.REQUIRED;
import org.mule.runtime.api.el.BindingContext;
import org.mule.runtime.api.el.ExpressionLanguage;
import org.mule.runtime.api.metadata.TypedValue;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.metadata.OutputResolver;
import org.mule.runtime.extension.api.annotation.param.Content;
import org.mule.runtime.extension.api.annotation.param.NullSafe;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.runtime.operation.Result;

import java.util.Map;

import javax.inject.Inject;

/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */
public class DynamicEvaluatorOperations {

  @Inject
  private ExpressionLanguage expressionLanguage;

  @OutputResolver(output = ObjectOutputTypeResolver.class)
  public Result<Object, Void> evaluateDynamic(@Expression(REQUIRED) String expression,
                                              @Optional @NullSafe @Content Map<String, Object> parameters) {

    final BindingContext.Builder builder = BindingContext.builder();
    parameters.forEach((key, value) -> builder.addBinding(key, TypedValue.of(value)));

    TypedValue<Object> value = (TypedValue<Object>) expressionLanguage.evaluate(expression, builder.build());

    return Result.<Object, Void>builder().output(value.getValue())
        .mediaType(value.getDataType().getMediaType())
        .build();
  }


}
