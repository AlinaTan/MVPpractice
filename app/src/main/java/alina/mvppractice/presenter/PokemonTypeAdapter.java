package alina.mvppractice.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import alina.mvppractice.R;
import alina.mvppractice.model.PokemonType;

/**
 * Created by Su Ping Alina Tan on 11/1/2018.
 */

public class PokemonTypeAdapter extends ArrayAdapter<PokemonType> {
    private Context context;
    private List<PokemonType> values;

    public PokemonTypeAdapter(Context context, List<PokemonType> values) {
        super(context, R.layout.list_item_pagination, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item_pagination, parent, false);
        }

        TextView textView = (TextView) row.findViewById(R.id.list_item_pagination_text);

        PokemonType item = values.get(position);
        String message = item.getPokemonName();
        textView.setText(message);

        return row;
    }
}
