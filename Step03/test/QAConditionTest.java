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
	
	@Test
	public void testInputProductCode(){
		QACondition condition = new QACondition();
		condition.setProductCode("AA0");
		assertEquals("product_code like \"AA0%\"",condition.getWhereClause());
	}

	@Test
	public void testInputQACodeAndProductCode(){
		QACondition condition = new QACondition();
		condition.setQACode("QA001");
		condition.setProductCode("AA0");
		assertEquals("qa_code = \"QA001\"", condition.getWhereClause());
	}
	
	@Test
	public void testMultipleAttributes(){
		QACondition condition = new QACondition();
		condition.setProductCode("AA0");
		condition.setDateFrom("2007/10/10");
		condition.setDateTo("2007/12/25");
		assertEquals("product_code like \"AA0%\" and created_date between \"2007/10/10\" and \"2007/12/25\"", condition.getWhereClause());
		
	}
	
	
}
