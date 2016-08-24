
public class QACondition {
	private String qaCode;
	public void setQACode(String qaCode) {
		this.qaCode = qaCode;
	}

	public String getQACode() {
		return this.qaCode;
	}

	public String getWhereClause() {
		StringBuilder builder = new StringBuilder();
		builder.append("qa_code = \"");
		builder.append(this.qaCode);
		builder.append("\"");
		return builder.toString();
	}


}
