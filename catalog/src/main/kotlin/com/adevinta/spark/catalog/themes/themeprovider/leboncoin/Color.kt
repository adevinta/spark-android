/*
 * Copyright (c) 2023 Adevinta
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.adevinta.spark.catalog.themes.themeprovider.leboncoin

import androidx.compose.ui.graphics.Color
import com.adevinta.spark.tokens.SparkColors
import com.adevinta.spark.tokens.darkSparkColors
import com.adevinta.spark.tokens.lightSparkColors

// region Clementin colors
private val Clementin900 = Color(0xFF2F1305)
private val Clementin800 = Color(0xFF5C250A)
private val Clementin700 = Color(0xFF89380F)
private val Clementin600 = Color(0xFFB84A14)
private val Clementin500 = Color(0xFFEC5A13)
private val Clementin400 = Color(0xFFF07B42)
private val Clementin300 = Color(0xFFF49D71)
private val Clementin200 = Color(0xFFF7BEA1)
private val Clementin100 = Color(0xFFFFE9DE)
private val Clementin50 = Color(0xFFFFF2EB)
// endregion

// region Plum colors
private val Plum900 = Color(0xFF1B052E)
private val Plum800 = Color(0xFF360F57)
private val Plum700 = Color(0xFF501782)
private val Plum600 = Color(0xFF6B1FAD)
private val Plum500 = Color(0xFF8526D9)
private val Plum400 = Color(0xFF9F47EB)
private val Plum300 = Color(0xFFB775F0)
private val Plum200 = Color(0xFFCFA3F5)
private val Plum100 = Color(0xFFE9D6FA)
private val Plum50 = Color(0xFFF5EDFD)
// endregion

// region Blueberry colors
private val Blueberry1000 = Color(0xFF010509)
private val Blueberry900 = Color(0xFF152233)
private val Blueberry800 = Color(0xFF094171)
private val Blueberry700 = Color(0xFF0C5291)
private val Blueberry600 = Color(0xFF0F69B9)
private val Blueberry500 = Color(0xFF1388EC)
private val Blueberry400 = Color(0xFF69B2F3)
private val Blueberry300 = Color(0xFF9FCEF7)
private val Blueberry200 = Color(0xFFC2E0FA)
private val Blueberry100 = Color(0xFFE6F2FD)
private val Blueberry50 = Color(0xFFF4F9FE)
// endregion

// region Avocado colors
private val Avocado900 = Color(0xFF101E10)
private val Avocado800 = Color(0xFF1F3D20)
private val Avocado700 = Color(0xFF2F5B30)
private val Avocado600 = Color(0xFF3E7A40)
private val Avocado500 = Color(0xFF4E9850)
private val Avocado400 = Color(0xFF71AD73)
private val Avocado300 = Color(0xFF95C196)
private val Avocado200 = Color(0xFFB8D6B9)
private val Avocado100 = Color(0xFFDCEADC)
private val Avocado50 = Color(0xFFEDF5EE)
// endregion

// region Cherry colors
private val Cherry900 = Color(0xFF2B0B08)
private val Cherry800 = Color(0xFF57150F)
private val Cherry700 = Color(0xFF822017)
private val Cherry600 = Color(0xFFAD291F)
private val Cherry500 = Color(0xFFD93426)
private val Cherry400 = Color(0xFFE05D52)
private val Cherry300 = Color(0xFFE8867D)
private val Cherry200 = Color(0xFFF0AEA8)
private val Cherry100 = Color(0xFFF7D7D4)
private val Cherry50 = Color(0xFFFBECEB)
// endregion

// region Banana colors
private val Banana900 = Color(0xFF332200)
private val Banana800 = Color(0xFF664400)
private val Banana700 = Color(0xFF996600)
private val Banana600 = Color(0xFFCC8800)
private val Banana500 = Color(0xFFFFAA00)
private val Banana400 = Color(0xFFFFBB33)
private val Banana300 = Color(0xFFFFCC66)
private val Banana200 = Color(0xFFFFDD99)
private val Banana100 = Color(0xFFFFEECC)
private val Banana50 = Color(0xFFFFF6E5)
// endregion

// region NightShade colors
private val NightShade1000 = Color(0xFF13171D)
private val NightShade900 = Color(0xFF202730)
private val NightShade800 = Color(0xFF2B3441)
private val NightShade700 = Color(0xFF3A4757)
private val NightShade600 = Color(0xFF4F6076)
private val NightShade500 = Color(0xFF6C819D)
private val NightShade400 = Color(0xFFACB8C7)
private val NightShade300 = Color(0xFFD0D7DF)
private val NightShade200 = Color(0xFFE4E8ED)
private val NightShade100 = Color(0xFFF0F2F5)
private val NightShade50 = Color(0xFFF6F8F9)
// endregion

internal val LeboncoinColorPartLight: SparkColors = lightSparkColors(
    accent = Plum500,
    onAccent = Color.White,
    accentContainer = Plum100,
    onAccentContainer = Plum800,
    accentVariant = Plum700,
    onAccentVariant = Color.White,
    basic = Blueberry800,
    onBasic = Color.White,
    basicContainer = Blueberry100,
    onBasicContainer = Blueberry900,
    main = Clementin500,
    onMain = Color.White,
    mainContainer = Clementin100,
    onMainContainer = Clementin700,
    mainVariant = Clementin600,
    onMainVariant = Color.White,
    support = Blueberry800,
    onSupport = Color.White,
    supportContainer = Blueberry100,
    onSupportContainer = Blueberry900,
    supportVariant = Blueberry700,
    onSupportVariant = Color.White,
    success = Avocado600,
    onSuccess = Color.White,
    successContainer = Avocado100,
    onSuccessContainer = Avocado700,
    alert = Banana500,
    onAlert = NightShade900,
    alertContainer = Banana100,
    onAlertContainer = Banana700,
    error = Cherry500,
    onError = Color.White,
    errorContainer = Cherry100,
    onErrorContainer = Cherry700,
    info = Blueberry500,
    onInfo = Color.White,
    infoContainer = Blueberry200,
    onInfoContainer = Blueberry700,
    neutral = NightShade600,
    onNeutral = Color.White,
    neutralContainer = NightShade100,
    onNeutralContainer = NightShade700,
    background = Color.White,
    onBackground = Blueberry900,
    backgroundVariant = Blueberry50,
    onBackgroundVariant = Blueberry900,
    surface = Color.White,
    onSurface = Blueberry900,
    surfaceInverse = NightShade800,
    onSurfaceInverse = Color.White,
    outline = NightShade400,
    outlineHigh = NightShade900,
)

internal val LeboncoinColorProLight: SparkColors = lightSparkColors(
    accent = Plum500,
    onAccent = Color.White,
    accentContainer = Plum100,
    onAccentContainer = Plum800,
    accentVariant = Plum700,
    onAccentVariant = Color.White,
    basic = Blueberry800,
    onBasic = Color.White,
    basicContainer = Blueberry100,
    onBasicContainer = Blueberry900,
    main = Blueberry600,
    onMain = Color.White,
    mainContainer = Blueberry100,
    onMainContainer = Blueberry700,
    mainVariant = Blueberry700,
    onMainVariant = Color.White,
    support = Blueberry800,
    onSupport = Color.White,
    supportContainer = Blueberry100,
    onSupportContainer = Blueberry900,
    supportVariant = Blueberry700,
    onSupportVariant = Color.White,
    success = Avocado600,
    onSuccess = Color.White,
    successContainer = Avocado100,
    onSuccessContainer = Avocado700,
    alert = Banana500,
    onAlert = NightShade900,
    alertContainer = Banana100,
    onAlertContainer = Banana700,
    error = Cherry500,
    onError = Color.White,
    errorContainer = Cherry100,
    onErrorContainer = Cherry700,
    info = Blueberry500,
    onInfo = Color.White,
    infoContainer = Blueberry200,
    onInfoContainer = Blueberry700,
    neutral = NightShade600,
    onNeutral = Color.White,
    neutralContainer = NightShade100,
    onNeutralContainer = NightShade700,
    background = Color.White,
    onBackground = Blueberry900,
    backgroundVariant = Blueberry50,
    onBackgroundVariant = Blueberry900,
    surface = Color.White,
    onSurface = Blueberry900,
    surfaceInverse = NightShade800,
    onSurfaceInverse = Color.White,
    outline = NightShade400,
    outlineHigh = NightShade900,
)

internal val LeboncoinColorPartDark: SparkColors = darkSparkColors(
    accent = Plum200,
    onAccent = Plum900,
    accentContainer = Plum700,
    onAccentContainer = Plum50,
    accentVariant = Plum300,
    onAccentVariant = Plum900,
    basic = Blueberry200,
    onBasic = Blueberry900,
    basicContainer = Blueberry800,
    onBasicContainer = Blueberry50,
    main = Clementin400,
    onMain = Clementin900,
    mainContainer = Clementin700,
    onMainContainer = Clementin50,
    mainVariant = Clementin300,
    onMainVariant = Clementin900,
    support = Blueberry200,
    onSupport = Blueberry900,
    supportContainer = Blueberry800,
    onSupportContainer = Blueberry50,
    supportVariant = Blueberry100,
    onSupportVariant = Blueberry900,
    success = Avocado300,
    onSuccess = Avocado900,
    successContainer = Avocado700,
    onSuccessContainer = Avocado50,
    alert = Banana300,
    onAlert = Banana900,
    alertContainer = Banana800,
    onAlertContainer = Banana50,
    error = Cherry300,
    onError = Cherry900,
    errorContainer = Cherry700,
    onErrorContainer = Cherry50,
    info = Blueberry300,
    onInfo = Blueberry900,
    infoContainer = Blueberry700,
    onInfoContainer = Blueberry50,
    neutral = NightShade400,
    onNeutral = NightShade900,
    neutralContainer = NightShade700,
    onNeutralContainer = NightShade50,
    background = NightShade900,
    onBackground = NightShade50,
    backgroundVariant = NightShade1000,
    onBackgroundVariant = NightShade50,
    surface = NightShade900,
    onSurface = NightShade50,
    surfaceInverse = NightShade50,
    onSurfaceInverse = NightShade800,
    surfaceTint = Color.White,
    outline = NightShade600,
    outlineHigh = NightShade100,
    dimContent1 = .72f,
    dimContent2 = .56f,
    dimContent3 = .40f,
    dimContent4 = .16f,
    dimContent5 = .08f,
)

internal val LeboncoinColorProDark: SparkColors = darkSparkColors(
    accent = Plum200,
    onAccent = Plum900,
    accentContainer = Plum700,
    onAccentContainer = Plum50,
    accentVariant = Plum300,
    onAccentVariant = Plum900,
    basic = Blueberry200,
    onBasic = Blueberry900,
    basicContainer = Blueberry800,
    onBasicContainer = Blueberry50,
    main = Blueberry400,
    onMain = Blueberry900,
    mainContainer = Blueberry800,
    onMainContainer = Blueberry50,
    mainVariant = Blueberry300,
    onMainVariant = Blueberry900,
    support = Blueberry200,
    onSupport = Blueberry900,
    supportContainer = Blueberry800,
    onSupportContainer = Blueberry50,
    supportVariant = Blueberry100,
    onSupportVariant = Blueberry900,
    success = Avocado300,
    onSuccess = Avocado900,
    successContainer = Avocado700,
    onSuccessContainer = Avocado50,
    alert = Banana300,
    onAlert = Banana900,
    alertContainer = Banana800,
    onAlertContainer = Banana50,
    error = Cherry300,
    onError = Cherry900,
    errorContainer = Cherry700,
    onErrorContainer = Cherry50,
    info = Blueberry300,
    onInfo = Blueberry900,
    infoContainer = Blueberry700,
    onInfoContainer = Blueberry50,
    neutral = NightShade400,
    onNeutral = NightShade900,
    neutralContainer = NightShade700,
    onNeutralContainer = NightShade50,
    background = NightShade900,
    onBackground = NightShade50,
    backgroundVariant = NightShade1000,
    onBackgroundVariant = NightShade50,
    surface = NightShade900,
    onSurface = NightShade50,
    surfaceInverse = NightShade50,
    onSurfaceInverse = NightShade800,
    surfaceTint = Color.White,
    outline = NightShade600,
    outlineHigh = NightShade100,
    dimContent1 = .72f,
    dimContent2 = .56f,
    dimContent3 = .40f,
    dimContent4 = .16f,
    dimContent5 = .08f,
)
