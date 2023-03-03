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
@Composable
@ReadOnlyComposable
public fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}

public fun Spanned.toHtmlWithoutParagraphs(): String {
    return HtmlCompat.toHtml(this, HtmlCompat.TO_HTML_PARAGRAPH_LINES_CONSECUTIVE)
        .substringAfter("<p dir=\"ltr\">").substringBeforeLast("</p>")
}

public fun Resources.getText(@StringRes id: Int, vararg args: Any): CharSequence {
    val escapedArgs = args.map {
        if (it is Spanned) it.toHtmlWithoutParagraphs() else it
    }.toTypedArray()
    val resource = SpannedString(getText(id))
    val htmlResource = resource.toHtmlWithoutParagraphs()
    val formattedHtml = String.format(htmlResource, *escapedArgs)
    return HtmlCompat.fromHtml(formattedHtml, HtmlCompat.FROM_HTML_MODE_LEGACY)
}

@Composable
public fun annotatedStringResource(@StringRes id: Int, vararg formatArgs: Any): AnnotatedString {
    val resources = resources()
    val density = LocalDensity.current

    val colors = SparkTheme.colors
    val typography = SparkTheme.typography
    return remember(id, formatArgs) {
        val text = resources.getText(id, *formatArgs)
        spannableStringToAnnotatedString(text, density, colors, typography)
    }
}

@Composable
public fun annotatedStringResource(@StringRes id: Int): AnnotatedString {
    val resources = resources()
    val density = LocalDensity.current

    val colors = SparkTheme.colors
    val typography = SparkTheme.typography
    return remember(id) {
        val text = resources.getText(id)
        spannableStringToAnnotatedString(text, density, colors, typography)
    }
}

private fun spannableStringToAnnotatedString(
    text: CharSequence,
    density: Density,
    colors: SparkColors,
    typography: SparkTypography,
): AnnotatedString {
    return if (text is Spanned) {
        with(density) {
            buildAnnotatedString {
                append(text.toString())
                text.getSpans(0, text.length, Any::class.java).forEach {
                    val start = text.getSpanStart(it)
                    val end = text.getSpanEnd(it)
                    when (it) {
                        is StyleSpan -> when (it.style) {
                            Typeface.NORMAL -> addStyle(
                                SpanStyle(
                                    fontWeight = FontWeight.Normal,
                                    fontStyle = FontStyle.Normal,
                                ),
                                start,
                                end,
                            )

                            Typeface.BOLD -> addStyle(
                                SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontStyle = FontStyle.Normal,
                                ),
                                start,
                                end,
                            )

                            Typeface.ITALIC -> addStyle(
                                SpanStyle(
                                    fontWeight = FontWeight.Normal,
                                    fontStyle = FontStyle.Italic,
                                ),
                                start,
                                end,
                            )

                            Typeface.BOLD_ITALIC -> addStyle(
                                SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontStyle = FontStyle.Italic,
                                ),
                                start,
                                end,
                            )
                        }

                        is TypefaceSpan -> addStyle(
                            SpanStyle(
                                fontFamily = when (it.family) {
                                    FontFamily.SansSerif.name -> FontFamily.SansSerif
                                    FontFamily.Serif.name -> FontFamily.Serif
                                    FontFamily.Monospace.name -> FontFamily.Monospace
                                    FontFamily.Cursive.name -> FontFamily.Cursive
                                    else -> FontFamily.Default
                                },
                            ),
                            start,
                            end,
                        )

                        is BulletSpan -> {
                            Log.d("StringResources", "BulletSpan not supported yet")
                            addStyle(SpanStyle(), start, end)
                        }

                        is AbsoluteSizeSpan -> addStyle(
                            SpanStyle(fontSize = if (it.dip) it.size.dp.toSp() else it.size.toSp()),
                            start,
                            end,
                        )

                        is RelativeSizeSpan -> addStyle(
                            SpanStyle(fontSize = it.sizeChange.em),
                            start,
                            end,
                        )

                        is StrikethroughSpan -> addStyle(
                            SpanStyle(textDecoration = TextDecoration.LineThrough),
                            start,
                            end,
                        )

                        is UnderlineSpan -> addStyle(
                            SpanStyle(textDecoration = TextDecoration.Underline),
                            start,
                            end,
                        )

                        is SuperscriptSpan -> addStyle(
                            SpanStyle(baselineShift = BaselineShift.Superscript),
                            start,
                            end,
                        )

                        is SubscriptSpan -> addStyle(
                            SpanStyle(baselineShift = BaselineShift.Subscript),
                            start,
                            end,
                        )

                        is ForegroundColorSpan -> addStyle(
                            SpanStyle(color = Color(it.foregroundColor)),
                            start,
                            end,
                        )

                        is Annotation -> {
                            val span = SparkStringAnnotations.toSpanStyle(it.key, it.value, colors, typography)
                            addStyle(span, start, end)
                        }

                        else -> addStyle(SpanStyle(), start, end)
                    }
                }
            }
        }
    } else {
        AnnotatedString(text.toString())
    }
}

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
