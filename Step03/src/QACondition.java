import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
		
		Clause clause = new Clause();
		if(!isEmpty(qaCode)){
			clause.add(new CodeCondition(this.qaCode));
		}
		if(!isEmpty(productCode)){
			clause.add(new ProductCodeCondition(this.productCode));
		}
		return clause.getWhereClause();
	}
	
	private boolean isEmpty(String inputValue){
		return !(inputValue != null && !inputValue.equals(""));
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	abstract class Condition {
		public abstract String execute();
	}
	class CodeCondition extends Condition {
		private String qaCode;
		public CodeCondition(String qaCode){
			this.qaCode = qaCode;
		}
		@Override
		public String execute() {
			StringBuilder builder = new StringBuilder();
			builder.append("qa_code = \"");
			builder.append(this.qaCode);
			builder.append("\"");	
			return builder.toString();
		}
	}
	class ProductCodeCondition extends Condition {
		private String productCode;
		public ProductCodeCondition(String productCode){
			this.productCode = productCode;
		}
		@Override
		public String execute() {
			StringBuilder builder = new StringBuilder();
			builder.append("product_code like \"");
			builder.append(this.productCode);
			builder.append("%\"");	
			return builder.toString();
		}
	}
	class Clause {
		private List<Condition> list = new ArrayList<Condition>(); 
		public void add(Condition condition){
			list.add(condition);
		}
		public String getWhereClause(){
			StringBuilder builder = new StringBuilder();
			ListIterator<Condition> iterator = list.listIterator();
			while(iterator.hasNext()){
				builder.append(iterator.next().execute());
				if(iterator.hasNext()){
					builder.append(" and ");
				}
			}
			return builder.toString();
		}
	}
}
