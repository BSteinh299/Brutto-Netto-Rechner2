package androidbuch.de.brutto_netto_rechner2;

/**
 * Created by Bernd on 18.02.2016.
 */
public class Ergebnis
{
    public float betrag;
    public boolean isNetto;
    public int ustProzent;

    public float betragNetto;
    public float betragBrutto;
    public float betragUst;

    public void berechneErgebnis()
    {
        //Berechne Bruttobetrag aus Nettobetrag
        if(isNetto)
        {
            betragNetto = betrag;
            betragUst = betrag * ustProzent / 100;
            betragBrutto = betrag + betragUst;
        }
        else
        //Berechne Nettobetrag aus Bruttobetrag
        {
            betragBrutto = betrag;
            betragUst = betrag * ustProzent / (100 + ustProzent);
            betragNetto = betrag - betragUst;
        }
    }
}
