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
package com.adevinta.spark.catalog.themes.themeprovider.milanuncios

import androidx.compose.ui.graphics.Color
import com.adevinta.spark.tokens.SparkColors
import com.adevinta.spark.tokens.darkSparkColors
import com.adevinta.spark.tokens.lightSparkColors

// Brand Palette
private val Hero50 = Color(0xFFF2FCF7)
private val Hero100 = Color(0xFFE5F9EE)
private val Hero200 = Color(0xFFC4F3D9)
private val Hero300 = Color(0xFF98E9BC)
private val Hero400 = Color(0xFF2DD276)
private val Hero500 = Color(0xFF11A753)
private val Hero600 = Color(0xFF0E9549)
private val Hero700 = Color(0xFF097137)
private val Hero800 = Color(0xFF075529)
private val Hero900 = Color(0xFF02441F)

private val Luon50 = Color(0xFFF5FAFF)
private val Luon100 = Color(0xFFE3F1FF)
private val Luon200 = Color(0xFFA3D1FF)
private val Luon300 = Color(0xFF70B8FF)
private val Luon400 = Color(0xFF3D9FFF)
private val Luon500 = Color(0xFF0A85FF)
private val Luon600 = Color(0xFF006CD6)
private val Luon700 = Color(0xFF0053A4)
private val Luon800 = Color(0xFF003B77)
private val Luon900 = Color(0xFF00264D)

private val Triforce50 = Color(0xFFFFFBEE)
private val Triforce100 = Color(0xFFFFF3CC)
private val Triforce200 = Color(0xFFFFEBAA)
private val Triforce300 = Color(0xFFFFE699)
private val Triforce400 = Color(0xFFFFD142)
private val Triforce500 = Color(0xFFF9BE01)
private val Triforce600 = Color(0xFFF9A501)
private val Triforce700 = Color(0xFFEF9801)
private val Triforce800 = Color(0xFFE57301)
private val Triforce900 = Color(0xFFD75A00)

private val Zelda50 = Color(0xFFFDF8FA)
private val Zelda100 = Color(0xFFFBF4F6)
private val Zelda200 = Color(0xFFFFE5EF)
private val Zelda300 = Color(0xFFEAC2D0)
private val Zelda400 = Color(0xFFDD7FA0)
private val Zelda500 = Color(0xFFBF406D)
private val Zelda600 = Color(0xFFA72A56)
private val Zelda700 = Color(0xFF7A2946)
private val Zelda800 = Color(0xFF541C30)
private val Zelda900 = Color(0xFF460F22)

private val Goron50 = Color(0xFFFFF6F6)
private val Goron100 = Color(0xFFFFEBEB)
private val Goron200 = Color(0xFFFFDEDE)
private val Goron300 = Color(0xFFFECDCD)
private val Goron400 = Color(0xFFFF6565)
private val Goron500 = Color(0xFFFC4141)
private val Goron600 = Color(0xFFE31010)
private val Goron700 = Color(0xFFC90303)
private val Goron800 = Color(0xFF970202)
private val Goron900 = Color(0xFF840000)

private val Zora50 = Color(0xFFF4F9FF)
private val Zora100 = Color(0xFFE5F2FF)
private val Zora200 = Color(0xFFD0E8FF)
private val Zora300 = Color(0xFF99CAFF)
private val Zora400 = Color(0xFF72B5FF)
private val Zora500 = Color(0xFF007AFF)
private val Zora600 = Color(0xFF0062CD)
private val Zora700 = Color(0xFF004999)
private val Zora800 = Color(0xFF003166)
private val Zora900 = Color(0xFF002955)

private val Poe50 = Color(0xFFF9F9FA)
private val Poe100 = Color(0xFFF4F5F6)
private val Poe200 = Color(0xFFE6E9EB)
private val Poe300 = Color(0xFFD3D7D9)
private val Poe400 = Color(0xFFB7BEC2)
private val Poe500 = Color(0xFF808D93)
private val Poe600 = Color(0xFF677379)
private val Poe700 = Color(0xFF50595E)
private val Poe800 = Color(0xFF3F474B)
private val Poe900 = Color(0xFF24292C)

private val Black = Color(0xFF191C1E)
private val White = Color(0xFFFFFFFF)

internal val MilanunciosLight: SparkColors = lightSparkColors(
    main = Hero500,
    onMain = White,
    mainContainer = Hero50,
    onMainContainer = Hero500,
    mainVariant = Hero700,
    onMainVariant = White,
    support = Luon800,
    onSupport = Luon50,
    supportContainer = Luon100,
    onSupportContainer = Luon800,
    supportVariant = Luon700,
    onSupportVariant = Luon50,
    accent = Triforce500,
    onAccent = Black,
    accentContainer = Triforce100,
    onAccentContainer = Black,
    accentVariant = Triforce300,
    onAccentVariant = Black,
    basic = Hero500,
    onBasic = White,
    basicContainer = Hero50,
    onBasicContainer = Hero500,
    success = Hero500,
    onSuccess = White,
    successContainer = Hero50,
    onSuccessContainer = Hero500,
    alert = Triforce500,
    onAlert = Black,
    alertContainer = Triforce100,
    onAlertContainer = Triforce800,
    error = Goron500,
    onError = White,
    errorContainer = Goron100,
    onErrorContainer = Goron500,
    info = Zora500,
    onInfo = White,
    infoContainer = Zora100,
    onInfoContainer = Zora500,
    neutral = Poe500,
    onNeutral = White,
    neutralContainer = Poe100,
    onNeutralContainer = Black,
    background = White,
    onBackground = Black,
    backgroundVariant = Poe100,
    onBackgroundVariant = Black,
    surface = White,
    onSurface = Black,
    surfaceInverse = Poe900,
    onSurfaceInverse = White,
    outline = Poe400,
    outlineHigh = Poe900,
)

// TODO Not yet ready
internal val MilanunciosDark: SparkColors = darkSparkColors(
    main = Hero500,
    onMain = White,
    mainContainer = Hero800,
    onMainContainer = Hero100,
    mainVariant = Hero400,
    onMainVariant = White,
    support = Poe100,
    onSupport = Black,
    supportContainer = Poe800,
    onSupportContainer = White,
    supportVariant = Luon700,
    onSupportVariant = Luon50,
    accent = Triforce500,
    onAccent = Black,
    accentContainer = Triforce800,
    onAccentContainer = Black,
    accentVariant = Triforce300,
    onAccentVariant = Black,
    basic = Hero500,
    onBasic = White,
    basicContainer = Hero800,
    onBasicContainer = Hero100,
    success = Hero500,
    onSuccess = White,
    successContainer = Hero800,
    onSuccessContainer = Hero100,
    alert = Triforce500,
    onAlert = Black,
    alertContainer = Triforce700,
    onAlertContainer = Triforce100,
    error = Goron500,
    onError = Black,
    errorContainer = Goron900,
    onErrorContainer = Goron100,
    info = Zora500,
    onInfo = Black,
    infoContainer = Zora900,
    onInfoContainer = Zora100,
    neutral = Poe400,
    onNeutral = Black,
    neutralContainer = Poe800,
    onNeutralContainer = Poe100,
    background = Black,
    onBackground = White,
    backgroundVariant = Poe900,
    onBackgroundVariant = White,
    surface = Black,
    onSurface = White,
    surfaceInverse = White,
    onSurfaceInverse = Black,
    outline = Poe600,
    outlineHigh = Poe400,
)
