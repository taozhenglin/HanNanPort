package com.cn.hainanproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.cn.hainanproject.R;
import com.donkingliang.imageselector.utils.UriUtils;
import com.donkingliang.imageselector.utils.VersionUtils;

import java.util.ArrayList;

/**
 * Created by tzl
 * on 2021/6/28
 */
public class MyImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> mImages=new ArrayList<>();
    private LayoutInflater mInflater;
    private boolean isAndroidQ = VersionUtils.isAndroidQ();
    OnMyClickListener mListener;
    ArrayList<String> addList=new ArrayList<>();



    public MyImageAdapter(Context context) {
        mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        addList.add("add");
        mImages.clear();
        mImages.addAll(addList);
    }

    public ArrayList<String> getImages() {
        return mImages;
    }

    @Override
    public int getCount() {
        return mImages == null ? 0 : mImages.size() ;

    }

    @Override
    public Object getItem(int position) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.gridview_item, null);
                holder.img = convertView.findViewById(R.id.img);
                holder.delet = convertView.findViewById(R.id.delet);

                if (mImages.get(position).equals("add")){
                    Glide.with(mContext).load(R.drawable.addblack).into(holder.img);
                    holder.delet.setVisibility(View.GONE);
                }else {
                    Glide.with(mContext).load(UriUtils.getImageContentUri(mContext, mImages.get(position))).into(holder.img);
                    holder.delet.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mImages.remove(position);
                            notifyDataSetChanged();
                        }
                    });
                }
                if (mImages.size()>10){
                    Glide.with(mContext).load(R.drawable.addgray).into(holder.img);
                    holder.img.setEnabled(false);

                }
                holder.img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mListener.click();
                    }
                });

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }

    public void refresh(ArrayList<String> images) {
        LogUtils.d("222222 refresh"+mImages);
        mImages = images;
        if (!mImages.contains("add")) {
            mImages.add("add");
        }
        LogUtils.d("222222 refresh"+mImages);
        notifyDataSetChanged();
    }

    public void addAll(ArrayList<String> images) {
        mImages.remove(mImages.size()-1);
        LogUtils.d("222222 addAll"+mImages);

        notifyDataSetChanged();


        if (mImages.size()<11){
           if (mImages.size()==10){
               ToastUtils.showShort("最多只能上传9张图片");
               return;
           }else {
             int  currentSize=  mImages.size();//当前有多少
               int sySize = 10 - currentSize;//剩余容量
               if (images.size()<=sySize){//当再次添加数量小于可添加数量时直接添加
                   for (int i = 0; i < images.size(); i++) {
                       mImages.add(images.get(i));
                   }
               }else {
                   for (int i = 0; i < sySize; i++) {//当再次添加数量大于可添加数量时只能添加可添加数量
                       mImages.add(images.get(i));
                   }
               }

               if (!mImages.contains("add")) {
                   mImages.add("add");

               }
               LogUtils.d("222222 addAll"+mImages);

               notifyDataSetChanged();

//               mImages.addAll(images);

           }
       }


    }

    public static class ViewHolder {
        ImageView img;
        ImageView delet;
        ImageView add;
    }

    public interface OnMyClickListener {
        public void click();
    }

    public void setOncliListener(OnMyClickListener listener) {
        this.mListener = listener;
    }
}
