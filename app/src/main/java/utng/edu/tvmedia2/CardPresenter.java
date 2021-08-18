package utng.edu.tvmedia2;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;

import com.squareup.picasso.Picasso;

public class CardPresenter extends Presenter {
    static class ViewHolder extends Presenter.ViewHolder {
        private ImageCardView mCardView;
        public ViewHolder(View view) {
            super(view);
            mCardView = (ImageCardView) view;
        }
        public ImageCardView getCardView() {
            return mCardView;
        }
        public void updateCardViewImage(String link ) {
            Picasso.get().load(link)
                    .resize(210, 210).centerCrop()
                    .into(mCardView.getMainImageView());
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        ImageCardView cardView = new ImageCardView( parent.getContext() );
        cardView.setFocusable( true );
        return new ViewHolder(cardView);
    }
    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder,
                                 Object item) {
        Video video = (Video) item;
        if ( !TextUtils.isEmpty(video.getPoster()) ) {
            ((ViewHolder) viewHolder).mCardView
                    .setTitleText(video.getTitle());
            ((ViewHolder) viewHolder).mCardView
                    .setMainImageDimensions( 350, 350 );
            ( (ViewHolder) viewHolder )

                    .updateCardViewImage( video.getPoster() );
        }
    }
    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
    }
    @Override
    public void onViewAttachedToWindow(Presenter.ViewHolder viewHolder) {
    }
}