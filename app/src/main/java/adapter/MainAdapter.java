package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.learn.myapplication.R;

import java.util.List;

import bean.MainData;

//后面有个泛型，不要忘了
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{
    private List<MainData> listData;
    private OnItemClickLitener mOnItemClickLitener;
    private Context context;


    //用于创建ViewHolder实例。这个方法将子项布局fruit_item 加载进来并传入ViewHolder的构造函数，最后返回ViewHolder对象
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_item, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    //此方法用于对子项的数据进行赋值，在每个子项滚动到屏幕内的时候执行
    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, final int position) {
        MainData data = listData.get(position);

        int resource = data.getImageId();
        Glide.with(context).load(resource).into(holder.listImage);

        holder.listText.setText(data.getName());

        //点击事件
        if(mOnItemClickLitener!=null){
            holder.itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickLitener.onItemClick(view,position);
                }
            });
        }
    }

    //用于返回RecyclerView的长度
    @Override
    public int getItemCount() {
        return listData.size();
    }


    //-----------------配置数据
    public MainAdapter(List<MainData> data){
        listData = data;
    }


    //点击事件
    public interface OnItemClickLitener{
        void onItemClick(View view,int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener){
        this.mOnItemClickLitener = mOnItemClickLitener;
    }



    static class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout itemLayout;
        ImageView listImage;
        TextView listText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listImage = (ImageView) itemView.findViewById(R.id.list_image);
            listText = (TextView) itemView.findViewById(R.id.list_name);
            itemLayout = (LinearLayout) itemView.findViewById(R.id.item_layout);
        }
    }


}
