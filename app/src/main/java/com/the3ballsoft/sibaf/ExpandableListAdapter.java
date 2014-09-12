package com.the3ballsoft.sibaf;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


/* Esta clase es una maraña para controlar las listas, ya todas las funciones estan hechas
   para agregar los items a los padres (salones a bloques) conforme uno quiera.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }
    private Context context;
    private ArrayList<String> groups;
    private ArrayList<ArrayList<AbstractGroupItem>> children;

    public ExpandableListAdapter(Context context, ArrayList<String> groups,
                                 ArrayList<ArrayList<AbstractGroupItem>> children) {
        this.context = context;
        this.groups = groups;
        this.children = children;
    }

    //Esta función nos añade la información que queremos mostrar en el adapter
    public void addItem(AbstractGroupItem groupItem) {
        if (!groups.contains(groupItem.getGroup())) {
            groups.add(groupItem.getGroup());
        }
        int index = groups.indexOf(groupItem.getGroup());
        if (children.size() < index + 1) {
            children.add(new ArrayList<AbstractGroupItem>());
        }
        children.get(index).add(groupItem);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return children.get(groupPosition).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        AbstractGroupItem groupItem = (AbstractGroupItem) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.salones_child, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.tvChild);
        tv.setText("   " + groupItem.getName());

        tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return children.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String group = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.bloques_group, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.tvGroup);
        tv.setText(group);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        return true;
    }
}
