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
 * Evaluation operations
 *
 * @since 1.0
 */
public class DynamicEvaluatorOperations {

  @Inject
  private ExpressionLanguage expressionLanguage;

  /**
   * Evaluates the DW script given in the {@code expression}, which is another DW expression which returns the actual
   * transformation to be evaluated.
   * <p>
   * Optionally, you can also provide parameters to that transformation
   *
   * @param expression an expression containing the transformation to be evaluated
   * @param parameters the transformation bindings
   * @return the transformation result
   */
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
