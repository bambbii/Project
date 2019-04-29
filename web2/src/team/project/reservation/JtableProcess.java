package team.project.reservation;

import javax.swing.table.AbstractTableModel;

public class JtableProcess extends AbstractTableModel{
	private String [] colname;
	private Object [][]data;

	public JtableProcess() {
		super();
	}
	
	public JtableProcess(String[] colname, Object[][] data) {
		super();
		this.colname = colname;
		this.data = data;
	}

	public Object[][] getData() {
		return data;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}

	public String[] getColname() {
		return colname;
	}

	public void setColname(String[] colname) {
		this.colname = colname;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colname.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colname[column];
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
