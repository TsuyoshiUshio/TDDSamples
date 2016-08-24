
public class QACondition {
	private String qaCode;
	private String productCode;
	public void setQACode(String qaCode) {
		this.qaCode = qaCode;
	}

	public String getQACode() {
		return this.qaCode;
	}

	public String getWhereClause() {
		StringBuilder builder = new StringBuilder();

		if(isEmpty(qaCode)){
			builder.append("qa_code = \"");
			builder.append(this.qaCode);
			builder.append("\"");			
		}else if(isEmpty(productCode)){
			builder.append("product_code like \"");
			builder.append(this.productCode);
			builder.append("%\"");
		}
		return builder.toString();
	}
	
	private boolean isEmpty(String inputValue){
		return inputValue != null && !inputValue.equals("");
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
}
