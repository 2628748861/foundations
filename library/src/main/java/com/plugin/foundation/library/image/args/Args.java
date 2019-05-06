package com.plugin.foundation.library.image.args;
import android.net.Uri;
import com.plugin.foundation.library.image.shape.CornerShape;

/**
 * 图片加载参数集合
 */
public class Args<Transform,Transaction,Listener> {

    /**
     * 加载目标(目前共支持4种):
     * 1.网络：Uri.parse("http://....")
     * 2.本地：Uri.fromFile(new File(...)) 或者:Uri.parse()
     * 3.drawable资源：
     * Resources r =mContext.getResources();
     * Uri uri =  Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
     *                 + r.getResourcePackageName(R.drawable.ic_placeholder) + "/"
     *                 + r.getResourceTypeName(R.drawable.ic_placeholder) + "/"
     *                 + r.getResourceEntryName(R.drawable.ic_placeholder));
     * 4.assets资源：Uri.parse("file:///android_asset/x.png")
     */
    private Uri uri;
    /**
     * 图片加载中的占位图
     */
    private int placeHolder;
    /**
     * 图片加载失败的占位图
     */
    private int error;

    /**
     * 缩略图比例
     */
    private float thumbnail;

    /**
     * 指定图片宽度
     */
    private int width;
    /**
     * 指定图片高度
     */
    private int height;

    /**
     * 图片形状(目前支持3种):
     * 1.默认形状(即传null)
     * 2.圆形(具体参考{@link CornerShape} 的实现类)
     * 3.圆角矩形(具体参考{@link CornerShape} 的实现类)
     */
    private CornerShape<Transform> shape;

    /**
     * 图像过渡形式
     */
    private Transaction transaction;

    /**
     * 监听器
     */
    private Listener listener;

    private Args(Builder<Transform,Transaction,Listener> builder)
    {
        this.uri=builder.uri;
        this.placeHolder=builder.placeHolder;
        this.error=builder.error;
        this.shape=builder.shape;
        this.listener=builder.listener;
        this.width=builder.width;
        this.height=builder.height;
        this.thumbnail=builder.thumbnail;
        this.transaction=builder.transaction;

    }

    public CornerShape<Transform> getShape() {
        return shape;
    }

    public int getError() {
        return error;
    }

    public int getPlaceHolder() {
        return placeHolder;
    }

    public Uri getUri() {
        return uri;
    }

    public Listener getListener() {
        return listener;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public float getThumbnail() {
        return thumbnail;
    }

    public static class Builder<Transform,Transaction,Listener>
    {
        private Uri uri;
        private int placeHolder;
        private int error;
        private float thumbnail;
        private int width;
        private int height;
        private CornerShape<Transform> shape;
        private Transaction transaction;
        private Listener listener;

        public Builder<Transform,Transaction,Listener> uri(Uri uri) {
            this.uri = uri;
            return this;
        }

        public Builder<Transform,Transaction,Listener> placeHolder(int placeHolder) {
            this.placeHolder = placeHolder;
            return this;
        }

        public Builder<Transform,Transaction,Listener> error(int error) {
            this.error = error;
            return this;
        }

        public Builder<Transform,Transaction,Listener> shape(CornerShape<Transform> shape) {
            this.shape = shape;
            return this;
        }

        public Builder<Transform,Transaction,Listener> listener(Listener listener) {
            this.listener = listener;
            return this;
        }

        public Builder<Transform,Transaction,Listener> override(int width,int height) {
            this.width = width;
            this.height = height;
            return this;
        }

        public Builder<Transform,Transaction,Listener> thumbnail(float thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public Builder<Transform,Transaction,Listener> transaction(Transaction transaction) {
            this.transaction = transaction;
            return this;
        }

        public Args<Transform,Transaction,Listener> build()
        {
            return new Args<Transform,Transaction,Listener>(this);
        }
    }
}
