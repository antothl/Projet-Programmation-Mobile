package com.example.projet.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projet.R;
import com.example.projet.model.Team;

import java.util.List;
/*adapter pour la liste des équipes avec ViewPager*/
public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>  {

    private Context context;
    private List<Team> teamList;

    public ViewPagerAdapter(Context context, List<Team> teamList) {
        this.context = context;
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View layoutView = inflater.inflate(R.layout.team_layout,parent,false);

        return new ViewPagerViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        holder.teamName.setText(teamList.get(position).getNom());
        holder.teamImage.setImageResource(teamList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    class ViewPagerViewHolder extends RecyclerView.ViewHolder{
        ImageView teamImage;
        TextView teamName;

        public ViewPagerViewHolder(@NonNull View itemView){
            super(itemView);
            teamImage=itemView.findViewById(R.id.team_image);
            teamName=itemView.findViewById(R.id.team_name);
        }
    }

}
