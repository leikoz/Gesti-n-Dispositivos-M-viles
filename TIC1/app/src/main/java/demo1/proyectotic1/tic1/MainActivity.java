package demo1.proyectotic1.tic1;

import android.app.Application;
import android.content.Intent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    private Context ctx;
    private View v1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSalir = (Button) findViewById(R.id.btnSalir);
        ctx = this;
        btnSalir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                v1 = v;
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ctx);
                dialogo1.setTitle("Cerrar Sesión");
                dialogo1.setMessage("¿Desea cerrar la sesión?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent intent = new Intent (v1.getContext(), LoginActivity.class);
                        startActivityForResult(intent, 0);
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        finish();
                    }
                });
                dialogo1.show();
            }
        });
    }
    }
