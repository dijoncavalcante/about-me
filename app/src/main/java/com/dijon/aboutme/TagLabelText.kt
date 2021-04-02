package com.dijon.aboutme

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.Typeface
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.StyleSpan
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
//import androidx.databinding.BindingAdapter
//import androidx.databinding.BindingAdapter;

class TagLabelText : AppCompatTextView {
    var tagText: String? = null
    private var text //text gốc trước khi thêm tag
            : String? = null
    var isTagFirst = false
    var isTagBold = false
    var tagRadius = 0f
    var tagSize = 0
    var tagPaddingStart = 0f
    var tagPaddingEnd = 0f
    var tagMarginStart = 0f
    var tagMarginEnd = 0f
    var tagTextColor = 0
    var tagBackgroundColor = 0

    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        text = super.getText().toString()
        setSpanText(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        text = super.getText().toString()
        setSpanText(context, attrs)
    }

    private fun setSpanText(ctx: Context, attrs: AttributeSet?) {
        val a = ctx.obtainStyledAttributes(attrs, R.styleable.TagLabelText)
        tagText = a.getString(R.styleable.TagLabelText_tagText)
        getAttr(a)
        if (tagText != null && tagText!!.length > 0) {
            setSpan()
        }
        a.recycle()
    }

    private fun getAttr(a: TypedArray) {
        isTagFirst = a.getBoolean(R.styleable.TagLabelText_tagFirst, true)
        isTagBold = a.getBoolean(R.styleable.TagLabelText_tagBold, false)
        tagRadius = a.getDimension(R.styleable.TagLabelText_tagRadius, 4f)
        tagSize = a.getDimension(R.styleable.TagLabelText_tagSize, 14f).toInt()
        tagPaddingStart = a.getDimension(R.styleable.TagLabelText_tagPaddingStart, 0f)
        tagPaddingEnd = a.getDimension(R.styleable.TagLabelText_tagPaddingEnd, 0f)
        tagMarginStart = a.getDimension(R.styleable.TagLabelText_tagMarginStart, 0f)
        tagMarginEnd = a.getDimension(R.styleable.TagLabelText_tagMarginEnd, 0f)
        tagTextColor =
            a.getColor(R.styleable.TagLabelText_tagTextColor, Color.parseColor("#FFFFFF"))
        tagBackgroundColor =
            a.getColor(R.styleable.TagLabelText_tagTextBackgroundColor, Color.parseColor("#289767"))
    }

    fun setSpan() {
        val tag = SpannableString(tagText)
        tag.setSpan(
            AbsoluteSizeSpan(tagSize, false),
            0,
            tag.length,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        tag.setSpan(
            RoundBackgroundColorSpan(
                tagBackgroundColor,
                tagTextColor,
                tagRadius,
                tagPaddingStart,
                tagPaddingEnd,
                tagMarginStart,
                tagMarginEnd
            ), 0, tag.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        if (isTagBold) {
            tag.setSpan(StyleSpan(Typeface.BOLD), 0, tag.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        } else {
            tag.setSpan(StyleSpan(Typeface.NORMAL), 0, tag.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        }
        val stringBuilder = SpannableStringBuilder()
        if (isTagFirst) {
            stringBuilder.append(tag).append(text)
        } else {
            stringBuilder.append(text).append(tag)
        }
        setText(stringBuilder)
    }

    fun mSetText(text: String?) {
        this.text = text
        super.setText(this.text)
    }

    fun mGetText(): String? {
        return text
    }

    companion object {


//        @BindingAdapter("text", "tagText", "tagBackgroundColor", "tagTextColor")
        @JvmStatic
        fun setTagText(
            view: TagLabelText,
            text: CharSequence?,
            tagText: CharSequence?,
            tagBackgroundColor: Int,
            tagTextColor: Int
        ) {
            if (text != null) {
                view.mSetText(text.toString())
            }
            if (tagText != null) {
                view.tagText = tagText.toString()
            }
            if (tagBackgroundColor != null) {
                view.tagBackgroundColor = tagBackgroundColor
            }
            if (tagTextColor != null) {
                view.tagTextColor = tagTextColor
            }
            view.setSpan()
        }


        @JvmStatic
        fun setTagText(
            view: TagLabelText,
            text: CharSequence?,
            tagText: CharSequence?
        ) {
            if (text != null) {
                view.mSetText(text.toString())
            }
            if (tagText != null) {
                view.tagText = tagText.toString()
            }
            view.setSpan()
        }

    }
}