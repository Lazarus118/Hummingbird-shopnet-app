package co.aulatech.e_portal_auth;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

class AndroidImageAdapter extends PagerAdapter {
    private Context mContext;

    AndroidImageAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return sliderImagesId.length;
    }

    private int[] sliderImagesId = new int[]{
            R.drawable.image1, R.drawable.image2, R.drawable.owl,
            R.drawable.image1, R.drawable.image2, R.drawable.owl,
    };

    @Override
    public boolean isViewFromObject(View v, Object obj) {
        return v == obj;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int i) {
        ImageView mImageView = new ImageView(mContext);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mImageView.setImageResource(sliderImagesId[i]);
        container.addView(mImageView, 0);


//        TextView info = new TextView(mContext);
//        info.setText("new items");

        return mImageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int i, Object obj) {
        container.removeView((ImageView) obj);
    }
}