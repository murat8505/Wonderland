package com.Wonderland.graphicObjects;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.Wonderland.main.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.File;
import java.util.List;

/**
 * Created by marco on 19/04/14.
 * <p/>
 * A Grid array used to show mp3, video or wallpapers previews
 */
public class ExtrasGridArrayAdapter extends MyArrayAdapter<File> {

    ImageLoader imageLoader = ImageLoader.getInstance();

    /**
     * Constants used to identify the type of the gallery
     */
    private static final int VIDEO = 0;
    private static final int AUDIO = 1;
    private static final int WALLPAPER = 2;

    /**
     * Default type
     */
    private int type = 2;

    public ExtrasGridArrayAdapter(Context context, int resource) {
        super(context, resource);
    }

    public ExtrasGridArrayAdapter(Context context, int resource, List<File> objects) {
        super(context, resource, objects);
    }

    /**
     * Tells to the gridArray to display video previews.
     * </br>
     * {@link com.Wonderland.graphicObjects.ExtrasGridArrayAdapter#type}
     * {@link com.Wonderland.graphicObjects.ExtrasGridArrayAdapter#VIDEO}
     */
    public void isVideo() {
        this.type = VIDEO;
    }

    /**
     * Tells to the gridArray to display audio previews.
     * </br>
     * {@link com.Wonderland.graphicObjects.ExtrasGridArrayAdapter#type}
     * {@link com.Wonderland.graphicObjects.ExtrasGridArrayAdapter#AUDIO}
     */
    public void isAudio() {
        this.type = AUDIO;
    }

    /**
     * Tells to the gridArray to display wallpaper previews.
     * </br>
     * {@link com.Wonderland.graphicObjects.ExtrasGridArrayAdapter#type}
     * {@link com.Wonderland.graphicObjects.ExtrasGridArrayAdapter#WALLPAPER}
     */
    public void isWallPaper() {
        this.type = WALLPAPER;
    }

    @Override
    protected Holder initializeHolder(View row) {
        MyHolder holder = new MyHolder();

        holder.title = (MyTextView) row.findViewById(R.id.title);
        holder.preview = (ImageView) row.findViewById(R.id.extraPreview);
        holder.playButton = (ImageView) row.findViewById(R.id.extraPreviewPlayButton);

        return holder;
    }

    @Override
    protected void updateHolder(File object, Holder holder) {
        MyHolder myHolder = (MyHolder) holder;
        myHolder.title.setFileName(object);
        myHolder.title.setSelected(true);

        switch (type) {

            case VIDEO:
                Bitmap thumbnail = ThumbnailUtils.createVideoThumbnail(object.getAbsolutePath(),
                        MediaStore.Images.Thumbnails.MINI_KIND);
                myHolder.preview.setImageBitmap(thumbnail);
                break;


            case AUDIO:
                myHolder.preview.setImageDrawable(context.getResources().getDrawable(R.drawable.audio_item));
                break;


            case WALLPAPER:
                myHolder.playButton.setVisibility(View.GONE);
                imageLoader.displayImage("file://" + object.getAbsolutePath(), myHolder.preview);
                break;
        }


    }

    static class MyHolder extends Holder {
        MyTextView title;
        ImageView preview;
        ImageView playButton;
    }
}

