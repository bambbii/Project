package sist.com.jdbc.app;

import javax.swing.table.AbstractTableModel;

public class JtableBoardProcess extends AbstractTableModel {

	private Object[][] data;
	private String []columnName;
	
	
	public JtableBoardProcess(Object[][] data) {
		super();
		this.data = data;
	}
	

	public String[] getColumnName() {
		return columnName;
	}


	public void setColumnName(String[] columnName) {
		this.columnName = columnName;
	}


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnName[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		data[rowIndex][columnIndex]=aValue;
	}

}
