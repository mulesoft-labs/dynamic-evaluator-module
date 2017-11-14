package org.mule.extension.dynamic.evaluator;

import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;


/**
 * Allows to evaluate dynamic DataWeave expressions by supplying the DW script and a set of bindings.
 */
@Extension(name = "Dynamic Evaluator")
@Operations(DynamicEvaluatorOperations.class)
@Xml(prefix = "dynamic-evaluator", namespace = "http://www.mulesoft.org/schema/mule/dynamic-evaluator")
public class DynamicEvaluatorExtension {

}
