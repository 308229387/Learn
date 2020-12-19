package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.myapplication.R;

import java.util.List;

import bean.MainData;

//后面有个泛型，不要忘了
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<MainData> listData;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView listImage;
        TextView listText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listImage = (ImageView) itemView.findViewById(R.id.list_image);
            listText = (TextView) itemView.findViewById(R.id.list_name);
        }
    }


    //用于创建ViewHolder实例。这个方法将子项布局fruit_item 加载进来并传入ViewHolder的构造函数，最后返回ViewHolder对象
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_item, parent, false);
        return new ViewHolder(view);
    }

    //此方法用于对子项的数据进行赋值，在每个子项滚动到屏幕内的时候执行
    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        MainData data = listData.get(position);
        holder.listImage.setImageResource(data.getImageId());
        holder.listText.setText(data.getName());
    }

    //用于返回RecyclerView的长度
    @Override
    public int getItemCount() {
        return listData.size();
    }

    //配置数据
    public MainAdapter(List<MainData> data){
        listData = data;
    }

}
