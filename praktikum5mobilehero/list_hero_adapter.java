package com.gading.praktikum5mobilehero;
        import android.content.Intent;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;

public class list_hero_adapter extends RecyclerView.Adapter<list_hero_adapter.ListViewHolder> {
    private ArrayList<hero> listhero;
    private OnItemCLickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemCLickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public list_hero_adapter(ArrayList<hero> List) {
        this.listhero = List;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.item_row_hero, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        hero hero = listhero.get(position);
        holder.imgPhoto.setImageResource(hero.getPhoto());
        holder.tvName.setText(hero.getName());
        holder.tvDescription.setText(hero.getDescription());
        holder.itemView.setOnClickListener(v -> {
            hero selectHero = listhero.get(holder.getAdapterPosition());
            Intent intent = new Intent(holder.itemView.getContext(), activityhero.class);
            intent.putExtra("HERO_PHOTO", hero.getPhoto());
            intent.putExtra("HERO_NAME", hero.getName());
            intent.putExtra("HERO_DESCRIPTION", hero.getDescription());
            holder.itemView.getContext().startActivity(intent);
//            Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listhero.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
        });
//        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listhero.get(holder.getAdapterPosition())));
    }
    public interface OnItemCLickCallback {
        void onItemClicked(hero data);
    }

    @Override
    public int getItemCount() {
        return listhero.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;

        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);

        }
    }
}
