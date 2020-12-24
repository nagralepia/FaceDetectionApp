package owner.practice.appchangelanguage.helper;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class RectOverlay extends GraphicOverlay.Graphic {
    private int RECT_COLOR = Color.RED;
    private float STROKE_WIDTH =  4.0f;
    private Paint rectPaint ;

    private GraphicOverlay graphicOverlay;
    private Rect rect;

    public RectOverlay(GraphicOverlay overlay, Rect rect) {
        super(overlay);
        rectPaint = new Paint();
        rectPaint.setColor(RECT_COLOR);
        rectPaint.setStyle(Paint.Style.STROKE);
        rectPaint.setStrokeWidth(STROKE_WIDTH);

        this.graphicOverlay = overlay;
        this.rect = rect;

        postInvalidate();
    }


    @Override
    public void draw(Canvas canvas) {
            RectF rectF = new RectF(rect);
            rectF.left = translateX(rectF.left);
            rectF.right = translateX(rectF.right);
            rectF.top = translateY(rectF.top);
            rectF.bottom = translateY(rectF.bottom);

            canvas.drawRect(rectF,rectPaint);
    }
}
