package demo1.proyectotic1.tic1;

import android.app.Application;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyAdapter mAdapter=null;
    public class Node{
        public String Title;
        public String Descripcion;
        public Integer ImagenResourse;

    }
    private static ArrayList<Node> mArray=new ArrayList<Node>();
    private ListView list;
    private  String[] Aplicaciones;
    private String[] sistemas = {"Plato Tradicional", "Comidas Rapitas", "Arroz CHino", "Bebidas", "Postres",
            "Comida de Mar", "Entradas", "De la casa","Servicios especiales ","Arros Chileno"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setData();
        mAdapter =new MyAdapter(this);
        setListAdapter(MyAdapter);

        TextView txtview =(TextView)findViewById(R.id.textView2);
        List<PackageInfo> packagelist=getPackageManager().getInstalledPackages(0);
        Aplicaciones = new  String[packagelist.size()];
        for (int i=0;i<packagelist.size();i++){
            PackageInfo packageInfo=packagelist.get(i);
            if((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM)==0){
                String appName=packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
                Aplicaciones[i]=appName;
                Log.e("App name :"+Integer.toHexString(i),Aplicaciones[i]);
                txtview.append(Aplicaciones[i]);//impirmimos el nombre de la app en el textviw
                txtview.append(",");
            }
        }
    }

    private  void setData(){
         mArray.clear();
         Node mynode=new Node();

         mynode.Title=this.getResources().getString(R.string.App_Correo);
         mynode.Descripcion=this.getResources().getString(R.string.App_Correod);
         mynode.ImagenResourse=R.drawable.Correo;
         mArray.add(mynode);

    }
    public  static  class MyAdapter extends BaseAdapter{

        public Context mContext;
        public  MyAdapter(Context c){
            mContext=c;
        }

        @Override
        public int getCount() {
            return mArray.size();
        }

        @Override
        public Object getItem(int position) {
            return mArray.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }

//metodo para obetener todos los nombres de las apps intaladas  el el dispositivo
  /*
    public String[] ObtenerListaApps(){

        List<PackageInfo> packagelist=getPackageManager().getInstalledPackages(0);
        Aplicaciones = new  String[packagelist.size()];
        for (int i=0;i<packagelist.size();i++){
            PackageInfo packageInfo=packagelist.get(i);
            if((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM)==0){
                String appName=packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
                Aplicaciones[i]=appName;
                Log.e("App name :"+Integer.toHexString(i),Aplicaciones[i]);

            }

        }
        return  Aplicaciones;
    }
*/

}
