package id.sch.smktelkom_mlg.tugas01.xirpl1021.formulirbasket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama;
    EditText etTahun;
    RadioGroup rgJk;
    Spinner spKota;
    CheckBox cb1, cb2, cb3, cb4;
    Button bOk;
    TextView tvHasil, tvPosisi;
    int nPosisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTahun = (EditText) findViewById(R.id.editTextTanggal);
        rgJk = (RadioGroup) findViewById(R.id.radioGroupJk);
        spKota = (Spinner) findViewById(R.id.spinnerKota);
        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
        bOk = (Button) findViewById(R.id.buttonOk);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvPosisi = (TextView) findViewById(R.id.textViewPosisi);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();
        String hasil = null;
        String asal = spKota.getSelectedItem().toString();
        String posisi = "\nPosisi Anda           : ";

        int startlen = posisi.length();
        if (cb1.isChecked()) posisi += cb1.getText() + ",";
        if (cb2.isChecked()) posisi += cb2.getText() + ",";
        if (cb3.isChecked()) posisi += cb3.getText() + ",";
        if (cb4.isChecked()) posisi += cb4.getText();

        if (posisi.length() == startlen) posisi += "Tidak ada pada pilihan";

        if (rgJk.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJk.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
        } else {
            etNama.setError(null);
        }

        if (tahun.isEmpty()) {
            etTahun.setError("Tahun Belum Diisi");
        } else if (tahun.length() > 2) {
            etTahun.setError("Format Umur Salah");
        } else {
            etNama.setError(null);
        }
        tvHasil.setText("**************** ( TSBC ) ****************" + "\nNama         : " + nama + " \nUmur         : " + tahun +
                "\nJenis Kelamin     : " + hasil + "\nAsal Kota       : " + asal + posisi);
        }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nPosisi += 1;
        else nPosisi -= 1;
        tvPosisi.setText("Hobi (" + nPosisi + " terpilih)");
    }
}