package project.caixaeletronico.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import project.caixaeletronico.R;
import project.caixaeletronico.TO.ExtratoTO;

public class Extract extends AppCompatActivity {

    private String stringExtrato;
    private EditText edt_fromDate;
    private EditText edt_toDate;
    private ImageButton btn_fromDate;
    private ImageButton btn_toDate;
    private TextView extractView;
    private LinearLayout linearLayout;
    private Calendar startDate;
    private Calendar endDate;
    boolean flag = false;

    static final int DATE_DIALOG_ID = 0;

    private EditText activeDateDisplay;
    private Calendar activeDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extract);

        /*  capture our View elements for the start date function   */
        edt_fromDate = (EditText) findViewById(R.id.edt_fromDate);
        btn_fromDate = (ImageButton) findViewById(R.id.btn_fromData_calendar);

        /* get the current date */
        startDate = Calendar.getInstance();

        /* add a click listener to the button   */
        btn_fromDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDateDialog(edt_fromDate, startDate);
            }
        });

        /* capture our View elements for the end date function */
        edt_toDate = (EditText) findViewById(R.id.edt_toDate);
        btn_toDate = (ImageButton) findViewById(R.id.btn_toData_calendar);

        /* get the current date */
        endDate = Calendar.getInstance();

        /* add a click listener to the button   */
        btn_toDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDateDialog(edt_toDate, endDate);
            }
        });

        /* display the current date (this method is below)  */
        updateDisplay(edt_fromDate, startDate);
        updateDisplay(edt_toDate, endDate);
    }

    private void updateDisplay(EditText dateDisplay, Calendar date) {

        int day = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH);
        int year = date.get(Calendar.YEAR);

        String builderDate = (day < 10 ? ("0" + day) : (day)) + "/" + (month < 10 ? ("0" + month) : (month)) + "/" + year;

        dateDisplay.setText(builderDate);
    }

    public void showDateDialog(EditText dateDisplay, Calendar date) {
        activeDateDisplay = dateDisplay;
        activeDate = date;
        showDialog(DATE_DIALOG_ID);
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            activeDate.set(Calendar.YEAR, year);
            activeDate.set(Calendar.MONTH, monthOfYear);
            activeDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateDisplay(activeDateDisplay, activeDate);
            unregisterDateDisplay();
        }
    };

    private void unregisterDateDisplay() {
        activeDateDisplay = null;
        activeDate = null;
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, dateSetListener, activeDate.get(Calendar.YEAR), activeDate.get(Calendar.MONTH), activeDate.get(Calendar.DAY_OF_MONTH));
        }
        return null;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
        switch (id) {
            case DATE_DIALOG_ID:
                ((DatePickerDialog) dialog).updateDate(activeDate.get(Calendar.YEAR), activeDate.get(Calendar.MONTH), activeDate.get(Calendar.DAY_OF_MONTH));
                break;
        }
    }

    // Consult Extract into seven days
    public void extractSevenDays(View view) {

        ExtratoTO ext1 = new ExtratoTO();
        ext1.setTipoMovimentacao("Saque");
        ext1.setTipo(1);
        ext1.setValorMovimentacao(150.00);
        ext1.setSaldoAtual(500.00);
        ext1.setDataMovimentacao("01/09/2016");

        ExtratoTO ext2 = new ExtratoTO();
        ext2.setTipoMovimentacao("Deposito");
        ext2.setTipo(0);
        ext2.setValorMovimentacao(100.00);
        ext2.setSaldoAtual(600.00);
        ext2.setDataMovimentacao("02/09/2016");

        ExtratoTO ext3 = new ExtratoTO();
        ext3.setTipoMovimentacao("Saque");
        ext3.setTipo(1);
        ext3.setValorMovimentacao(50.00);
        ext3.setSaldoAtual(550.00);
        ext3.setDataMovimentacao("03/09/2016");

        ExtratoTO ext4 = new ExtratoTO();
        ext4.setTipoMovimentacao("Deposito");
        ext4.setTipo(0);
        ext4.setValorMovimentacao(1000.00);
        ext4.setSaldoAtual(1550.00);
        ext4.setDataMovimentacao("04/09/2016");

        ExtratoTO ext5 = new ExtratoTO();
        ext5.setTipoMovimentacao("Transferencia");
        ext5.setTipo(1);
        ext5.setValorMovimentacao(500.00);
        ext5.setSaldoAtual(1050.00);
        ext5.setDataMovimentacao("05/09/2016");

        ArrayList<ExtratoTO> extract = new ArrayList<>();

        extract.add(ext1);
        extract.add(ext2);
        extract.add(ext3);
        extract.add(ext4);
        extract.add(ext5);


        for (int i = 0; i < extract.size(); i++) {
            stringExtrato = stringExtrato + "Valor Da Movimentacao: " + extract.get(i).getValorMovimentacao() + "\nValor Saldo Atual: " +
                    extract.get(i).getSaldoAtual() + "\nTipo Movimentação: " + extract.get(i).getTipoMovimentacao() + "\nData Movimentacao: " + extract.get(i).getDataMovimentacao() +
                    "\n-------------------------------------------------\n";
        }

        extractView = (TextView) findViewById(R.id.extractText_view);
        extractView.setText(stringExtrato);

    }

    // Consult Extract into seven days
    public void extractFifteenDays(View view) {

        ExtratoTO ext1 = new ExtratoTO();
        ext1.setTipoMovimentacao("Saque");
        ext1.setTipo(1);
        ext1.setValorMovimentacao(150.00);
        ext1.setSaldoAtual(500.00);
        ext1.setDataMovimentacao("01/09/2016");

        ExtratoTO ext2 = new ExtratoTO();
        ext2.setTipoMovimentacao("Deposito");
        ext2.setTipo(0);
        ext2.setValorMovimentacao(100.00);
        ext2.setSaldoAtual(600.00);
        ext2.setDataMovimentacao("02/09/2016");

        ExtratoTO ext3 = new ExtratoTO();
        ext3.setTipoMovimentacao("Saque");
        ext3.setTipo(1);
        ext3.setValorMovimentacao(50.00);
        ext3.setSaldoAtual(550.00);
        ext3.setDataMovimentacao("03/09/2016");

        ExtratoTO ext4 = new ExtratoTO();
        ext4.setTipoMovimentacao("Deposito");
        ext4.setTipo(0);
        ext4.setValorMovimentacao(1000.00);
        ext4.setSaldoAtual(1550.00);
        ext4.setDataMovimentacao("04/09/2016");

        ExtratoTO ext5 = new ExtratoTO();
        ext5.setTipoMovimentacao("Transferencia");
        ext5.setTipo(1);
        ext5.setValorMovimentacao(500.00);
        ext5.setSaldoAtual(1050.00);
        ext5.setDataMovimentacao("05/09/2016");

        ArrayList<ExtratoTO> extract = new ArrayList<>();

        extract.add(ext1);
        extract.add(ext2);
        extract.add(ext3);
        extract.add(ext4);
        extract.add(ext5);


        for (int i = 0; i < extract.size(); i++) {
            stringExtrato = stringExtrato + "Valor Da Movimentacao: " + extract.get(i).getValorMovimentacao() + "\nValor Saldo Atual: " +
                    extract.get(i).getSaldoAtual() + "\nTipo Movimentação: " + extract.get(i).getTipoMovimentacao() + "\nData Movimentacao: " + extract.get(i).getDataMovimentacao() +
                    "\n-------------------------------------------------\n";
        }

        extractView = (TextView) findViewById(R.id.extractText_view);
        extractView.setText(stringExtrato);

    }

    // Consult Extract into seven days
    public void consultPeriodExtract(View view) {

        ExtratoTO ext1 = new ExtratoTO();
        ext1.setTipoMovimentacao("Saque");
        ext1.setTipo(1);
        ext1.setValorMovimentacao(150.00);
        ext1.setSaldoAtual(500.00);
        ext1.setDataMovimentacao("01/09/2016");

        ExtratoTO ext2 = new ExtratoTO();
        ext2.setTipoMovimentacao("Deposito");
        ext2.setTipo(0);
        ext2.setValorMovimentacao(100.00);
        ext2.setSaldoAtual(600.00);
        ext2.setDataMovimentacao("02/09/2016");

        ExtratoTO ext3 = new ExtratoTO();
        ext3.setTipoMovimentacao("Saque");
        ext3.setTipo(1);
        ext3.setValorMovimentacao(50.00);
        ext3.setSaldoAtual(550.00);
        ext3.setDataMovimentacao("03/09/2016");

        ExtratoTO ext4 = new ExtratoTO();
        ext4.setTipoMovimentacao("Deposito");
        ext4.setTipo(0);
        ext4.setValorMovimentacao(1000.00);
        ext4.setSaldoAtual(1550.00);
        ext4.setDataMovimentacao("04/09/2016");

        ExtratoTO ext5 = new ExtratoTO();
        ext5.setTipoMovimentacao("Transferencia");
        ext5.setTipo(1);
        ext5.setValorMovimentacao(500.00);
        ext5.setSaldoAtual(1050.00);
        ext5.setDataMovimentacao("05/09/2016");

        ArrayList<ExtratoTO> extract = new ArrayList<>();

        extract.add(ext1);
        extract.add(ext2);
        extract.add(ext3);
        extract.add(ext4);
        extract.add(ext5);


        for (int i = 0; i < extract.size(); i++) {
            stringExtrato = stringExtrato + "Valor Da Movimentacao: " + extract.get(i).getValorMovimentacao() + "\nValor Saldo Atual: " +
                    extract.get(i).getSaldoAtual() + "\nTipo Movimentação: " + extract.get(i).getTipoMovimentacao() + "\nData Movimentacao: " + extract.get(i).getDataMovimentacao() +
                    "\n-------------------------------------------------\n";
        }

        extractView = (TextView) findViewById(R.id.extractText_view);
        extractView.setText(stringExtrato);
    }

    public void showHideLinearDateFilter(View view) {

        linearLayout = (LinearLayout) findViewById(R.id.date_filter);

        if (flag) {

            linearLayout.setVisibility(View.GONE);
            flag = false;
        } else {

            //linearLayout.getLayoutParams().height = 160;
            //linearLayout.getLayoutParams().width = 700;

            linearLayout.setVisibility(View.VISIBLE);
            flag = true;
        }
    }

}

