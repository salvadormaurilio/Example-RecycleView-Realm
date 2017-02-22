package hack.inventive.com.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * 20/02/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

  private List<Animal> mAnimalList;
  private Context mContext;
  private LayoutInflater mLayoutInflater;
  private MyItemListener mMyItemListener;

  public MyAdapter(List<Animal> animalList, Context context) {
    mAnimalList = animalList;
    mContext = context;
    mLayoutInflater = LayoutInflater.from(mContext);
  }

  public void setMyItemListener(MyItemListener myItemListener) {
    mMyItemListener = myItemListener;
  }

  @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View viewItem = mLayoutInflater.inflate(R.layout.item_list, parent, false);
    MyViewHolder myViewHolder = new MyViewHolder(viewItem, mContext);

    return myViewHolder;
  }

  @Override public void onBindViewHolder(MyViewHolder holder, int position) {
    Animal animal = mAnimalList.get(position);
    holder.render(animal);
  }

  @Override public int getItemCount() {
    return mAnimalList.size();
  }

  public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView imagen;
    private TextView title;
    private TextView description;

    private Context mContext;

    public MyViewHolder(View itemView, Context context) {
      super(itemView);
      mContext = context;
      findViews(itemView);

      itemView.setOnClickListener(this);
    }

    private void findViews(View itemView) {
      imagen = (ImageView) itemView.findViewById(R.id.image_item);
      title = (TextView) itemView.findViewById(R.id.title);
      description = (TextView) itemView.findViewById(R.id.description);
    }

    public void render(Animal animal) {
      title.setText(animal.getNombre());
      description.setText(animal.getDescription());
      Picasso.with(mContext).load(animal.getUrlImage()).into(imagen);

    }

    @Override public void onClick(View view) {
      int position = getAdapterPosition();
      mMyItemListener.onItemClick(position, mAnimalList.get(position).getNombre());
    }
  }

  public interface MyItemListener{
    public void onItemClick(int position, String name);
  }

}
