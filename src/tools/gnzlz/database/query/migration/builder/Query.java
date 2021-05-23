package tools.gnzlz.database.query.migration.builder;

import java.util.ArrayList;

public abstract class Query<Q extends Query<?>>{
	
	protected Query(){}
	
	public abstract String query();
	
	/*************************
	 * Values Object;
	 *************************/
	
	private ArrayList<Query<?>.Value> values;

	/*************************
	 * Values
	 *************************/

	protected ArrayList<Query<?>.Value> values() {
		if(values == null) values = new ArrayList<Query<?>.Value>();
		return values;
	}

	protected void addValue(byte type, Object value) {
		values().add(new Value(type, value));
	}

	protected void addValues(ArrayList<Query<?>.Value> arrayList) {
		values().addAll(arrayList);
	}

	public Object[] objects() {
		Object[] objects = new Object[values().size()];
		int i=0;
		for (Query<?>.Value value : values()) {
			objects[i] = value.value; i++;
		}
		return objects;
	}
	
	/*************************
	 * Values
	 *************************/
	
	class Value{
		public static final byte WHERE = 1;
		public static final byte SET = 2;
		public static final byte VALUES = 3;
		
		public byte type;
		public Object value;
		
		public Value(byte type, Object value) {
			this.type = type;
			this.value = value;
		}
	}
}