package com.example.searchlogger;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QAActivity extends ActionBarActivity {

    private ListView preference_list_view;
    private VerticalPreference[] preferences;
    private ArrayAdapter<VerticalPreference> list_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa);
        // Get the list view.
        preference_list_view = (ListView) findViewById(R.id.vertical_preference_list_view);
        preference_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                VerticalPreference preference = list_adapter.getItem(position);
                preference.toggleChecked();
                VerticalPreferenceViewHolder holder = (VerticalPreferenceViewHolder) view.getTag();
                holder.getIsChecked().setChecked(preference.isChecked());
            }
        });
        // Build the verticals here.
        if (preferences == null)
        {
            preferences = new VerticalPreference[] {
                    new VerticalPreference("Images"),
                    new VerticalPreference("Videos"),
                    new VerticalPreference("Wiki"),
                    new VerticalPreference("Q&A"),
                    new VerticalPreference("General Web"),
                    new VerticalPreference("News"),
            };

        }
        ArrayList <VerticalPreference> vertical_list = new ArrayList<VerticalPreference>();
        vertical_list.addAll(Arrays.asList(preferences));
        list_adapter = new VerticalPreferenceListAdaptor(this, vertical_list);
        preference_list_view.setAdapter(list_adapter);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.qa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private static class VerticalPreferenceViewHolder {

        private CheckBox is_checked;
        private TextView vertical_name;

        public VerticalPreferenceViewHolder(TextView vname) {
            vertical_name = vname;
        }

        public VerticalPreferenceViewHolder(TextView vname, CheckBox check_box) {
            vertical_name = vname;
            is_checked = check_box;
        }
        public CheckBox getIsChecked() {
            return is_checked;
        }

        public void setVerticalName(TextView vertical) {
            vertical_name = vertical;
        }


        public TextView getTextView() {
            return vertical_name;
        }
    }

    private static class VerticalPreference {
        private String vertical_name;
        // Whether user selected this vertical for a task.
        private boolean is_checked;
        public VerticalPreference(String name) {
            vertical_name = name;
            is_checked = false;
        }
        public VerticalPreference(String name, boolean selected) {
            vertical_name = name;
            is_checked = selected;
        }

        public String toString() {
            return vertical_name ;
        }
        public void toggleChecked() {
            is_checked = !is_checked ;
        }
        public boolean isChecked() {
            return is_checked;
        }

        public void setChecked(boolean checked) {
            is_checked = checked;
        }

            }

    private class VerticalPreferenceListAdaptor extends ArrayAdapter<VerticalPreference> {


        private LayoutInflater inflater;

        public VerticalPreferenceListAdaptor( Context context, List<VerticalPreference> preference_list ) {
            super( context, R.layout.vertical_preference, R.id.rowVerticalNameView, preference_list );
            // Cache the LayoutInflate to avoid asking for a new one each time.
            inflater = LayoutInflater.from(context) ;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Vertical to display.
            VerticalPreference preference = (VerticalPreference) this.getItem( position );

            // The child views in each row.
            CheckBox checkBox ;
            TextView textView ;

            // Create a new row view
            if ( convertView == null ) {
                convertView = inflater.inflate(R.layout.vertical_preference, null);

                // Find the child views.
                textView = (TextView) convertView.findViewById( R.id.rowVerticalNameView );
                checkBox = (CheckBox) convertView.findViewById( R.id.rowVerticalCheckBox );

                // Optimization: Tag the row with it's child views, so we don't have to
                // call findViewById() later when we reuse the row.
                convertView.setTag( new VerticalPreferenceViewHolder(textView,checkBox) );

                // If CheckBox is toggled, update the vertical it is tagged with.
                checkBox.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v ;
                        VerticalPreference preference = (VerticalPreference) cb.getTag();
                        preference.setChecked(cb.isChecked());
                    }
                });
            }
            // Reuse existing row view
            else {
                // Because we use a ViewHolder, we avoid having to call findViewById().
                VerticalPreferenceViewHolder viewHolder = (VerticalPreferenceViewHolder) convertView.getTag();
                checkBox = viewHolder.getIsChecked() ;
                textView = viewHolder.getTextView() ;
            }

            // Tag the CheckBox with the Preference it is displaying, so that we can
            // access the preference in onClick() when the CheckBox is toggled.
            checkBox.setTag( preference );

            // Display planet data
            checkBox.setChecked(preference.isChecked());
            textView.setText( preference.toString());

            return convertView;
        }

    }
}

