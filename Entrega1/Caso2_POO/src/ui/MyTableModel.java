package ui;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

class MyTableModel extends AbstractTableModel {
    private ArrayList<ArrayList<Object>> data;
    private String[] columnNames;

    public MyTableModel(ArrayList<ArrayList<Object>> data, String[] columnNames) {
        this.data = data;
        this.columnNames = columnNames;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).get(columnIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}