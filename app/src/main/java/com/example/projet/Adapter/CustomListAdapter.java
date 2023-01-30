package com.example.projet.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projet.R;
import com.example.projet.model.listejoueurs;

import java.util.List;
/*adapter pour la liste de joueurs*/
public class CustomListAdapter  extends BaseAdapter {

    private List<listejoueurs> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext, List<listejoueurs> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listjoueurview, null);
            holder = new ViewHolder();
            holder.photoJoueur = (ImageView) convertView.findViewById(R.id.imageView_photo);
            holder.nomJoueur = (TextView) convertView.findViewById(R.id.textView_nomJoueur);
            holder.numeroJoueur = (TextView) convertView.findViewById(R.id.textView_numeroJoueur);
            holder.prenomJoueur=(TextView) convertView.findViewById(R.id.textView_prenomJoueur);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        listejoueurs listej = this.listData.get(position);
        holder.nomJoueur.setText(listej.getNomJoueur());
        holder.numeroJoueur.setText("Numero: " + listej.getNumeroJoueur());
        holder.prenomJoueur.setText(listej.getPrenomJoueur());

        int imageId = this.getMipmapResIdByName(listej.getPhotoJoueur());

        holder.photoJoueur.setImageResource(imageId);

        return convertView;
    }
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "drawable", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        ImageView photoJoueur;
        TextView nomJoueur;
        TextView numeroJoueur;
        TextView prenomJoueur;
    }
}