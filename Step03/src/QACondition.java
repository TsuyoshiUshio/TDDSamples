import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class QACondition {
	private String qaCode;
	private String productCode;
	private String dateFrom;
	private String dateTo;
	public void setQACode(String qaCode) {
		this.qaCode = qaCode;
	}
	public void setDateFrom(String fromDate){
		this.dateFrom = fromDate;
	}
	public void setDateTo(String toDate){
		this.dateTo = toDate;
	}

	public String getQACode() {
		return this.qaCode;
	}

	public String getWhereClause() {
		
		Clause clause = new Clause();
		if(!isEmpty(qaCode)){
			clause.add(new CodeCondition(this.qaCode));
		} else {
			if(!isEmpty(productCode)){
				clause.add(new ProductCodeCondition(this.productCode));
			}
			if(!isEmpty(dateFrom) && !isEmpty(dateTo)){
				clause.add(new DateCondition(this.dateFrom, this.dateTo));
			}
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
	class DateCondition extends Condition {
		private String dateFrom;
		private String dateTo;
		public DateCondition(String dateFrom, String dateTo){
			this.dateFrom = dateFrom;
			this.dateTo = dateTo;
		}
		@Override
		public String execute() {
			StringBuilder builder = new StringBuilder();
			builder.append("created_date between \"");
			builder.append(this.dateFrom);
			builder.append("\" and \"");
			builder.append(this.dateTo);
			builder.append("\"");
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
