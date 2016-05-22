package com.hack.cooltivar.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hack.cooltivar.R;

import java.util.ArrayList;

/**
 * Created by gsanchez on 22/05/2016.
 */
public class ResumenItemAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    ResumenItemModel tempValues=null;
    int i=0;

    public ResumenItemAdapter(Activity a, ArrayList d) {

        /********** Take passed values **********/
        activity = a;
        data=d;

        /***********  Layout inflator to call external xml layout () ***********/
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        if(data.size()<=0)
            return 1;
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public static class ViewHolder{

        public TextView tvDescripcionCultivo;
        public TextView tvFecha;
        public TextView tvHora;
        public TextView tvTemperatura;
        public ImageView ivHora;
        public ImageView ivEstado;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if(convertView==null){

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.item_cooltivar, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.tvDescripcionCultivo = (TextView) vi.findViewById(R.id.tvDescripcionCultivo);
            holder.tvFecha=(TextView)vi.findViewById(R.id.tvFecha);
            holder.tvHora=(TextView)vi.findViewById(R.id.tvHora);
            holder.tvTemperatura = (TextView) vi.findViewById(R.id.tvTemperatura);
            holder.ivHora=(ImageView) vi.findViewById(R.id.ivHora);
            holder.ivEstado=(ImageView) vi.findViewById(R.id.ivEstadoTemperatura);
            /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else
            holder=(ViewHolder)vi.getTag();

        if(data.size()<=0)
        {

        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            tempValues=null;
            tempValues = ( ResumenItemModel ) data.get( position );

            /************  Set Model values in Holder elements ***********/

            holder.tvDescripcionCultivo.setText( tempValues.getDescripcionCultivo() );
            holder.tvFecha.setText( tempValues.getFecha() );
            holder.tvHora.setText( tempValues.getHora() );
            holder.tvTemperatura.setText( tempValues.getTemperatura() );

        }
        return vi;


    }




}


