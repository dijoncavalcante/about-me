package com.dijon.aboutme

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.FontMetricsInt
import android.graphics.RectF
import android.text.style.ReplacementSpan

class RoundBackgroundColorSpan(
    private val mBackgroundColor: Int,
    private val mTextColor: Int,
    private val mCornerRadius: Float,
    private val mPaddingStart: Float,
    private val mPaddingEnd: Float,
    private val mMarginStart: Float,
    private val mMarginEnd: Float
) :
    ReplacementSpan() {
    override fun getSize(
        paint: Paint,
        text: CharSequence,
        start: Int,
        end: Int,
        fm: FontMetricsInt?
    ): Int {
        //width of tag : padding + margin + content
        return (mPaddingStart + mMarginStart + paint.measureText(
            text.subSequence(start, end).toString()
        ) + mPaddingEnd + mMarginEnd).toInt()
    }

    override fun draw(
        canvas: Canvas,
        text: CharSequence,
        start: Int,
        end: Int,
        x: Float,
        top: Int,
        y: Int,
        bottom: Int,
        paint: Paint
    ) {
        val width = paint.measureText(text.subSequence(start, end).toString())
        val rect = RectF(
            x + mMarginStart,
            top.toFloat(), x + width + mPaddingStart + mPaddingEnd + mMarginStart, bottom.toFloat()
        )
        paint.color = mBackgroundColor
        canvas.drawRoundRect(rect, mCornerRadius, mCornerRadius, paint)
        paint.color = mTextColor
        val fm = paint.fontMetrics
        val height = fm.bottom - fm.top + fm.leading
        canvas.drawText(
            text,
            start,
            end,
            x + mPaddingStart + mMarginStart,
            ((top + bottom) / 2 + height / 3) as Float,
            paint
        )
    }
}