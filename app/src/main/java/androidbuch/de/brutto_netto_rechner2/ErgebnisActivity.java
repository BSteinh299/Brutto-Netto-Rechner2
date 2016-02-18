package androidbuch.de.brutto_netto_rechner2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Bernd on 18.02.2016.
 */
public class ErgebnisActivity extends Activity
{
    @Override
    public void onCreate (Bundle icicle)
    {
        super.onCreate(icicle);
        setContentView(R.layout.ergebnis_anzeigen);

        final Bundle extras = getIntent().getExtras();

        if(extras != null)
        {
            final Ergebnis ergebnis = new Ergebnis();
            ergebnis.betrag = extras.getFloat(FormularActivity.BETRAG_KEY);
            ergebnis.isNetto = extras.getBoolean(FormularActivity.BETRAG_ART, true);
            ergebnis.ustProzent = extras.getInt(FormularActivity.UST_PROZENT);

            zeigeErgebnis(ergebnis);
        }
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.opt_beenden:
                finish();
                break;
            default:
        }
        return super.onCreateOptionsMenu((Menu) item);
    }

    private void zeigeErgebnis (Ergebnis ergebnis)
    {
        ergebnis.berechneErgebnis();

        final TextView txtNettobetrag = (TextView) findViewById(R.id.txt_nettobetrag);
        txtNettobetrag.setText(String.valueOf(ergebnis.betragNetto));

        final TextView txtUmsatzsteuer = (TextView) findViewById(R.id.txt_umsatzsteuer);
        txtUmsatzsteuer.setText(String.valueOf(ergebnis.betragUst));

        final TextView txtBruttobetrag = (TextView) findViewById(R.id.txt_bruttobetrag);
        txtBruttobetrag.setText(String.valueOf(ergebnis.betragBrutto));
    }
}
