package com.hryzx.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UniversityAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<University> universities = new ArrayList<>();

    public UniversityAdapter(Context context) {
        this.context = context;
    }

    public void setUniversities(ArrayList<University> universities) {
        this.universities = universities;
    }

    @Override
    public int getCount() {
        return universities.size();
    }

    @Override
    public Object getItem(int i) {
        return universities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = view;
        if (view1 == null) {
            view1 = LayoutInflater
                    .from(context)
                    .inflate(R.layout.item_university, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view1);
        University university = (University) getItem(i);
        viewHolder.bind(university);

        return view1;
    }
    private class ViewHolder {
        private TextView txName, txDescription;
        private CircleImageView imageView;

        ViewHolder(View view) {
            txName = view.findViewById(R.id.tx_name);
            txDescription = view.findViewById(R.id.tx_description);
            imageView = view.findViewById(R.id.img_image);
        }

        void bind(University university) {
            txName.setText(university.getName());
            txDescription.setText(university.getDescription());
            imageView.setImageResource(university.getImage());
        }
    }
}
