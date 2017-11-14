package org.mule.extension.dynamic.evaluator;

import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;


/**
 * This is the main class of an extension, is the entry point from which configurations, connection providers, operations
 * and sources are going to be declared.
 */
@Extension(name = "Dynamic Evaluator")
@Operations(DynamicEvaluatorOperations.class)
@Xml(prefix = "dynamic-evaluator", namespace = "http://www.mulesoft.org/schema/mule/dynamic-evaluator")
public class DynamicEvaluatorExtension {

}
