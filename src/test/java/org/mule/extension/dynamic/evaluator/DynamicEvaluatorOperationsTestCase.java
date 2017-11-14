package org.mule.extension.dynamic.evaluator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mule.runtime.api.metadata.MediaType.APPLICATION_JSON;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;
import org.mule.runtime.api.metadata.TypedValue;
import org.mule.runtime.api.streaming.bytes.CursorStreamProvider;
import org.mule.runtime.core.api.util.IOUtils;

import org.junit.Test;

public class DynamicEvaluatorOperationsTestCase extends MuleArtifactFunctionalTestCase {

  /**
   * Specifies the mule config xml with the flows that are going to be executed in the tests, this file lives in the test resources.
   */
  @Override
  protected String getConfigFile() {
    return "dynamic-evaluator-config.xml";
  }

  @Test
  public void staticExpression() throws Exception {
    TypedValue<String> result = flowRunner("staticExpression").run().getMessage().getPayload();
    assertThat(result.getValue(), is("hello world"));
  }

  @Test
  public void expressionWithSimpleParameters() throws Exception {
    TypedValue<String> result = flowRunner("expressionWithSimpleParameters").run().getMessage().getPayload();
    assertThat(result.getValue(), is("hello world"));
  }

  @Test
  public void expressionWithCustomMediaType() throws Exception {
    TypedValue<CursorStreamProvider> result = flowRunner("customMediaType").keepStreamsOpen().run().getMessage().getPayload();

    assertThat(IOUtils.toString(result.getValue()), is("\"Hello world\""));
    assertThat(result.getDataType().getMediaType().matches(APPLICATION_JSON), is(true));
  }
}
