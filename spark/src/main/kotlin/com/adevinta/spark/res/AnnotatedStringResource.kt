package com.adevinta.spark.res

import android.content.res.Resources
import android.graphics.Typeface
import android.text.Annotation
import android.text.Spanned
import android.text.SpannedString
import android.text.style.AbsoluteSizeSpan
import android.text.style.BulletSpan
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan
import android.text.style.SubscriptSpan
import android.text.style.SuperscriptSpan
import android.text.style.TypefaceSpan
import android.text.style.UnderlineSpan
import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.core.text.HtmlCompat
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.R
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.tokens.SparkColors
import com.adevinta.spark.tokens.SparkTypography


// FIXME: There is no official way to do this yet so we're waiting for
//   https://issuetracker.google.com/issues/139320238 to be fixed

/**
 * Load a annotated string resource with formatting.
 *
 * @param id the resource identifier
 * @param formatArgs the format arguments
 * @return the [AnnotatedString] data associated with the resource
 */
@Composable
public fun annotatedStringResource(@StringRes id: Int, vararg formatArgs: Any): AnnotatedString {
    val resources = resources()
    val density = LocalDensity.current
    val colors = SparkTheme.colors
    val typography = SparkTheme.typography
    return remember(id, formatArgs) {
        val text = resources.getText(id, *formatArgs)
        text.asAnnotatedString(density, colors, typography)
    }
}

/**
 * Load a annotated string resource.
 *
 * @param id the resource identifier
 * @return the [AnnotatedString] data associated with the resource
 */
@Composable
public fun annotatedStringResource(@StringRes id: Int): AnnotatedString {
    val resources = resources()
    val density = LocalDensity.current

    val colors = SparkTheme.colors
    val typography = SparkTheme.typography
    return remember(id) {
        val text = resources.getText(id)
        text.asAnnotatedString(density, colors, typography)
    }
}

@Composable
@ReadOnlyComposable
internal fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}

/**
 * Converts a [Spanned] to a [String] without the surrounding `<p dir="rtl | ltr" style="…">` tags as we don't support
 * [ParagraphStyle].
 */
internal fun Spanned.toHtmlWithoutParagraphs(): String {
    return HtmlCompat.toHtml(this, HtmlCompat.TO_HTML_PARAGRAPH_LINES_CONSECUTIVE)
        .substringAfter("<p dir=\"ltr\">").substringBeforeLast("</p>")
}

/**
 * The framework `getText()` method doesn't support formatting arguments, so we need to do it ourselves.
 */
internal fun Resources.getText(@StringRes id: Int, vararg args: Any): CharSequence {
    val escapedArgs = args.map {
        if (it is Spanned) it.toHtmlWithoutParagraphs() else it
    }.toTypedArray()
    val spannedString = SpannedString(getText(id))
    val htmlResource = spannedString.toHtmlWithoutParagraphs()
    val formattedHtml = String.format(htmlResource, *escapedArgs)
    return HtmlCompat.fromHtml(formattedHtml, HtmlCompat.FROM_HTML_MODE_LEGACY)
}

private fun CharSequence.asAnnotatedString(
    density: Density,
    colors: SparkColors,
    typography: SparkTypography,
): AnnotatedString {
    if (this !is Spanned) return AnnotatedString(this.toString())
    return buildAnnotatedString {
        append(this@asAnnotatedString.toString())
        getSpans(0, length, Any::class.java).forEach {
            val start = getSpanStart(it)
            val end = getSpanEnd(it)
            buildWithSpan(it, start, end, density, colors, typography)
        }
    }
}

private fun AnnotatedString.Builder.buildWithSpan(
    it: Any,
    start: Int,
    end: Int,
    density: Density,
    colors: SparkColors,
    typography: SparkTypography,
) {
    val span: SpanStyle = when (it) {
        is StyleSpan -> buildWithStyleSpan(it)
        is TypefaceSpan -> buildWithTypefaceSpan(it)
        is BulletSpan -> SpanStyle().also {
            Log.d("StringResources", "BulletSpan not supported yet")
        }

        is AbsoluteSizeSpan -> with(density) {
            SpanStyle(fontSize = if (it.dip) it.size.dp.toSp() else it.size.toSp())
        }

        is RelativeSizeSpan -> SpanStyle(fontSize = it.sizeChange.em)
        is StrikethroughSpan -> SpanStyle(textDecoration = TextDecoration.LineThrough)
        is UnderlineSpan -> SpanStyle(textDecoration = TextDecoration.Underline)
        is SuperscriptSpan -> SpanStyle(baselineShift = BaselineShift.Superscript)
        is SubscriptSpan -> SpanStyle(baselineShift = BaselineShift.Subscript)
        is ForegroundColorSpan -> SpanStyle(color = Color(it.foregroundColor))
        is Annotation -> SparkStringAnnotations.toSpanStyle(it.key, it.value, colors, typography)

        else -> SpanStyle()
    }
    addStyle(span, start, end)
}

private fun buildWithStyleSpan(it: StyleSpan): SpanStyle {
    return when (it.style) {
        Typeface.NORMAL -> FontWeight.Normal to FontStyle.Normal
        Typeface.BOLD -> FontWeight.Bold to FontStyle.Normal
        Typeface.ITALIC -> FontWeight.Normal to FontStyle.Italic
        Typeface.BOLD_ITALIC -> FontWeight.Bold to FontStyle.Italic
        else -> null
    }?.let { (fontWeight, fontStyle) ->
        SpanStyle(fontWeight = fontWeight, fontStyle = fontStyle)
    } ?: SpanStyle()
}

private fun buildWithTypefaceSpan(it: TypefaceSpan): SpanStyle = SpanStyle(
    fontFamily = when (it.family) {
        FontFamily.SansSerif.name -> FontFamily.SansSerif
        FontFamily.Serif.name -> FontFamily.Serif
        FontFamily.Monospace.name -> FontFamily.Monospace
        FontFamily.Cursive.name -> FontFamily.Cursive
        else -> FontFamily.Default
    },
)

@Preview
@Preview(
    locale = "fr-rFR",
)
@Composable
private fun AnnotatedStringResourcePreview() {
    PreviewTheme {
        val annotatedString = annotatedStringResource(R.string.spark_annotatedStringResource_test)
        Text(annotatedString)
    }
}
