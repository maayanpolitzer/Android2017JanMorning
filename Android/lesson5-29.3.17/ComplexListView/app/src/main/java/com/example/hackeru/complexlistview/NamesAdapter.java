package com.example.hackeru.complexlistview;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class NamesAdapter extends ArrayAdapter<Person> {

    private Context context;
    private Person[] people;

    public NamesAdapter(Context context, Person[] people){
        super(context, R.layout.list_item, people);
        this.context = context;
        this.people = people;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // inflate - transform a xml file to view object (java). LayoutInflater.
        System.out.println("getView() " + position + ", " + convertView);
        if (convertView == null) {
            System.out.println("******** INFLATE");
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }else{
            System.out.println("WOW");
        }
        TextView nameTextView = (TextView) convertView.findViewById(R.id.list_item_name_text_view);
        //ImageView imageView = (ImageView) convertView.findViewById(R.id.list_item_image_view);
        nameTextView.setText(people[position].getName());
        //imageView.setImageResource(people[position].getImage());
        return convertView;
    }
}
