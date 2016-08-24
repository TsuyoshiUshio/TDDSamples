import static org.junit.Assert.*;

import org.junit.Test;

public class QAConditionTest {

	@Test
	public void testInputQACode() {
		QACondition condition = new QACondition();
		condition.setQACode("QA001");
		assertEquals("QA001", condition.getQACode());
		assertEquals("qa_code = \"QA001\"", condition.getWhereClause());
	}
	@Test
	public void testInputAnyQACodes(){
		QACondition condition = new QACondition();
		condition.setQACode("QA002");
		assertEquals("qa_code = \"QA002\"", condition.getWhereClause());
	}
	


}
