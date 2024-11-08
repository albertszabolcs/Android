import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.mylistview.R;

import java.util.List;

public class CurrencyAdapter extends ArrayAdapter<Currency> {


    public CurrencyAdapter(Context context, List<Currency> currencies) {
        super(context,0,currencies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_currency, parent, false);
        }

        Currency currency = getItem(position);

        TextView currencyName = convertView.findViewById(R.id.currency_name);
        TextView currencyPrice = convertView.findViewById(R.id.currency_price);

        currencyName.setText(currency.getName());
        currencyPrice.setText(String.format("%.2f", currency.getPrice()));

        return convertView;
    }
}
