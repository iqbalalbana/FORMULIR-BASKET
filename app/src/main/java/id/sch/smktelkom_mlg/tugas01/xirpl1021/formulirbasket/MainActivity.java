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

    EditText etNama, etTahun;
    RadioGroup rgJk;
    Spinner spKota;
    CheckBox cb1, cb2, cb3, cb4;
    Button bOk;
    TextView tvHasil1, tvHasil2, tvHasil3, tvHasil4, tvHasil5, tvPosisi;
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
        tvHasil1 = (TextView) findViewById(R.id.textViewHasil1);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);
        tvHasil5 = (TextView) findViewById(R.id.textViewHasil5);
        tvPosisi = (TextView) findViewById(R.id.textViewPosisi);

        findViewById(R.id.buttonOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });

    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String umur = etTahun.getText().toString();
        String Jenis = null;
        String Posisi = "Posisi                      : ";
        int startlen = Posisi.length();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
        } else if (nama.length() <= 4) {
            etNama.setError("Nama minimal 4 karakter");
        } else {
            etNama.setError(null);
        }
        tvHasil1.setText("Nama                      : " + nama);

        if (umur.isEmpty()) {
            etTahun.setError("Umur belum diisi");
        } else if (umur.length() != 2) {
            etTahun.setError("Format Umur Anda Salah");
        } else {
            etTahun.setError(null);
        }
        tvHasil2.setText("Umur                       : " + umur);

        tvHasil3.setText("Asal                         : " + "Kota " + spKota.getSelectedItem().toString());
        if (rgJk.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJk.getCheckedRadioButtonId());
            Jenis = rb.getText().toString();
        }
        if (Jenis == null) {
            tvHasil4.setText("Jenis Kelamin        : -");
        } else {
            tvHasil4.setText("Jenis Kelamin        : " + Jenis);
        }

        if (cb1.isChecked()) Posisi += cb1.getText() + ", ";
        if (cb2.isChecked()) Posisi += cb2.getText() + ", ";
        if (cb3.isChecked()) Posisi += cb3.getText() + ". ";

        if (Posisi.length() == startlen) Posisi += "Tidak ada pada Pilihan";
        tvHasil5.setText(Posisi);


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nPosisi += 1;
        else nPosisi -= 1;

        tvHasil5.setText("Posisi            : ");

    }
}