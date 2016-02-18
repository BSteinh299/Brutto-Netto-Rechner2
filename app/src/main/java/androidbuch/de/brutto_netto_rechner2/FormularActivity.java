package androidbuch.de.brutto_netto_rechner2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class FormularActivity extends ActionBarActivity
{

    public static final String BETRAG_KEY = "betrag";
    public static final String BETRAG_ART = "art";
    public static final String UST_PROZENT = "ust";

    public void onClickBerechnen(View button)
    {
        //Betrag
        final EditText txtBetrag = (EditText) findViewById(R.id.edt_betrag);
        final String tmpBetrag=txtBetrag.getText().toString();
        float betrag=0.0f;
        if(tmpBetrag.length() > 0)
        {
            betrag = Float.parseFloat(tmpBetrag);
        }

        //Art des Betrages (Brutto, Netto)
        boolean isNetto = true;
        final RadioGroup rg = (RadioGroup) findViewById(R.id.rg_art);
        switch (rg.getCheckedRadioButtonId())
        {
            case R.id.rb_art_netto:
                isNetto = true;
                break;
            case R.id.rb_art_brutto:
                isNetto = false;
                break;
            default:
        }

        //Prozentwert Umsatzsteuer
        final Spinner spinner = (Spinner) findViewById(R.id.sp_umsatzsteuer);
        final int pos = spinner.getSelectedItemPosition();
        final int[] prozentwerte = getResources().getIntArray(R.array.ust_werte);
        final int prozentwert = prozentwerte[pos];
        final Intent intent = new Intent(this, ErgebnisActivity.class);

        intent.putExtra(BETRAG_KEY, betrag);
        intent.putExtra(BETRAG_ART, isNetto);
        intent.putExtra(UST_PROZENT, prozentwert);

        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formular);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formular, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
