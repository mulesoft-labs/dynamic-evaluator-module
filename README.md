# DynamicEvaluator Extension

Allows to evaluate dynamic DataWeave expressions by supplying the DW script and a set of bindings.

For example:

```
<dynamic-evaluator:evaluate-dynamic>
    <dynamic-evaluator:expression><![CDATA[
        %dw 2.0
        output application/json
        ---
        'Hello ' ++ 'world'
    ]]></dynamic-evaluator:expression>
    <dynamic-evaluator:parameters>#[{'name': 'world'}]</dynamic-evaluator:parameters>
</dynamic-evaluator:evaluate-dynamic>
```

Add this dependency to your application pom.xml

```
<groupId>org.mule.modules.x</groupId>
<artifactId>dynamic-evaluator</artifactId>
<version>1.0.0-SNAPSHOT</version>
<classifier>mule-plugin</classifier>
```
