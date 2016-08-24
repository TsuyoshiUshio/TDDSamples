
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
		if(qaCode != null && !qaCode.equals("")){
			builder.append("qa_code = \"");
			builder.append(this.qaCode);
			builder.append("\"");			
		}else if(productCode != null && !productCode.equals("")){
			builder.append("product_code like \"");
			builder.append(this.productCode);
			builder.append("%\"");
		}
		return builder.toString();
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
}
