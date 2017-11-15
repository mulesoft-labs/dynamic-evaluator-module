# DynamicEvaluator Extension

Allows to evaluate dynamic DataWeave expressions by supplying the DW script and a set of bindings.

For example:

```
 <dynamic-evaluator:evaluate-dynamic expression="#[vars.expression]">
    <dynamic-evaluator:parameters>#[{'name': 'world'}]</dynamic-evaluator:parameters>
</dynamic-evaluator:evaluate-dynamic>
```

Add this dependency to your application pom.xml

```
<groupId>org.mule.modules.x</groupId>
<artifactId>dynamic-evaluator</artifactId>
<version>1.0.0-rc-SNAPSHOT</version>
<classifier>mule-plugin</classifier>
```
