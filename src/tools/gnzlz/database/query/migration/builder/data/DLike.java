package tools.gnzlz.database.query.migration.builder.data;

public class DLike{
	
	boolean not;
	Object column;
	
	public DLike(Object column, boolean not) {
		this.column = column;
		this.not = not;
	}
	
	public String column() {
		if(column instanceof DColumn)
			return ((DColumn)column).column();
		return column.toString();
	}
	
	public String not() {
		return not ? " NOT":"";
	}
	
	public String like() {
		return column().concat(not()).concat(" LIKE ?");
	}
	
	@Override
	public String toString() {
		return like();
	}
}