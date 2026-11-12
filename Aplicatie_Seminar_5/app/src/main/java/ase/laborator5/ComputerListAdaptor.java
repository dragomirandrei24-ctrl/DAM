package ase.laborator5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class ComputerListAdaptor extends BaseAdapter {
    private final Context context;
    private final List<Computer> list;

    public ComputerListAdaptor(Context context, List<Computer> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ComputerHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_view, parent, false);
            holder = new ComputerHolder();
            holder.ramTextView_Item = convertView.findViewById(R.id.ramTextView_Holder);
            holder.storageTextView_Item = convertView.findViewById(R.id.storageTextView_Holder);
            holder.manufactureTextView_Item = convertView.findViewById(R.id.manufactureTextView_Holder);
            holder.purchaseDateTextView_Item = convertView.findViewById(R.id.purchaseDateTextView_Holder);
            holder.touchscreenCheckBox_Item = convertView.findViewById(R.id.touchscreenCheckBox_Holder);
            holder.extraOptionsTextView_Item = convertView.findViewById(R.id.extraOptionsTextView_Holder);
            convertView.setTag(holder);
        } else {
            holder = (ComputerHolder) convertView.getTag();
        }

        Computer computer = list.get(position);
        if (computer != null) {
            holder.ramTextView_Item.setText("RAM: " + computer.getRam() + " GB");
            holder.storageTextView_Item.setText("Storage: " + computer.getStorage() + " GB");
            holder.manufactureTextView_Item.setText("Manufacturer: " + computer.getManufacter());
            holder.purchaseDateTextView_Item.setText("Purchase Date: " + computer.getPurchaceDate().toString());
            holder.touchscreenCheckBox_Item.setChecked(Boolean.TRUE.equals(computer.getTouchScreen()));
            holder.extraOptionsTextView_Item.setText("Extra Options: " + computer.getOptiuniExtra().toString());
        }

        return convertView;
    }
}
