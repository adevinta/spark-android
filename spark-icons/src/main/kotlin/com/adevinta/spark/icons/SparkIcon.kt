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
package com.adevinta.spark.icons

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector

@Stable
public sealed class SparkIcon {
    public data class DrawableRes(@androidx.annotation.DrawableRes val drawableId: Int) : SparkIcon()
    public data class Vector(val imageVector: ImageVector) : SparkIcon()

    @Deprecated("Use SparkIcons instead.")
    public object Account {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.BankFill", "com.adevinta.spark.icons"))
        public val Account : SparkIcon = SparkIcons.BankFill // R.drawable.spark_icons_account
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Activity", "com.adevinta.spark.icons"))
        public val Activity : SparkIcon = SparkIcons.Activity // R.drawable.spark_icons_activity
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.HolidayFill", "com.adevinta.spark.icons"))
        public val Booking : SparkIcon = SparkIcons.HolidayFill // R.drawable.spark_icons_booking

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.BurgerMenu", "com.adevinta.spark.icons"))
        public val BurgerMenu : SparkIcon = SparkIcons.BurgerMenu // R.drawable.spark_icons_menu

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Close", "com.adevinta.spark.icons"))
        public val Close : SparkIcon = SparkIcons.Close // R.drawable.spark_icons_close_full
        @Deprecated("Use SparkIcons instead.")
        public object Cv {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CvFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.CvFill// R.drawable.spark_icons_cv
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CvOutline", "com.adevinta.spark.icons"))
            public val Outlined: SparkIcon = SparkIcons.CvOutline // R.drawable.spark_icons_cv_outline
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FileOffFill", "com.adevinta.spark.icons"))
            public val Disabled: SparkIcon = SparkIcons.FileOffFill // R.drawable.spark_icons_sales_prospecting
        }

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CountryFill", "com.adevinta.spark.icons"))
        public val France : SparkIcon = SparkIcons.CountryFill // R.drawable.spark_icons_france
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.House", "com.adevinta.spark.icons"))
        public val House : SparkIcon = SparkIcons.House // R.drawable.spark_icons_house
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.IdentityOutline", "com.adevinta.spark.icons"))
        public val Identity : SparkIcon = SparkIcons.IdentityOutline // R.drawable.spark_icons_identity
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.KeyFill", "com.adevinta.spark.icons"))
        public val Key : SparkIcon = SparkIcons.KeyFill // R.drawable.spark_icons_key
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Listing", "com.adevinta.spark.icons"))
        public val Listing : SparkIcon = SparkIcons.Listing // R.drawable.spark_icons_listing
        @Deprecated("Use SparkIcons instead.")
        public object Offers {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.OfferFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.OfferFill // R.drawable.spark_icons_offers
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.OfferOutline", "com.adevinta.spark.icons"))
            public val Outlined: SparkIcon = SparkIcons.OfferOutline // R.drawable.spark_icons_offers_outline
        }

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FileOffFill", "com.adevinta.spark.icons"))
        public val SalesProspecting : SparkIcon = SparkIcons.FileOffFill // R.drawable.spark_icons_sales_prospecting
        @Deprecated("Use SparkIcons instead.")
        public object SecurePayment {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.SecurityFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.SecurityFill // R.drawable.spark_icons_secure_payment
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.SecurityOutline", "com.adevinta.spark.icons"))
            public val Outlined: SparkIcon = SparkIcons.SecurityOutline // R.drawable.spark_icons_secure_payment_outline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Shop {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ShopingCartFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.ShopingCartFill // R.drawable.spark_icons_shop
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ShopingCartOutline", "com.adevinta.spark.icons"))
            public val Outlined: SparkIcon = SparkIcons.ShopingCartOutline // R.drawable.spark_icons_shop_outline
        }

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Store", "com.adevinta.spark.icons"))
        public val Store : SparkIcon = SparkIcons.Store // R.drawable.spark_icons_store
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FavoriteFill", "com.adevinta.spark.icons"))
        public val ThumbUp : SparkIcon = SparkIcons.FavoriteFill // R.drawable.spark_icons_thumbs_up
        @Deprecated("Use SparkIcons instead.")
        public object Work {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FavoriteOutline", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.FavoriteOutline // R.drawable.spark_icons_suitcase_filled
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.WorkOutline", "com.adevinta.spark.icons"))
            public val Outlined: SparkIcon = SparkIcons.WorkOutline // R.drawable.spark_icons_suitcase
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object Actions {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CalculateFill", "com.adevinta.spark.icons"))
        public val Calculate: SparkIcon = SparkIcons.CalculateFill // R.drawable.spark_icons_calculate
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CopyFill", "com.adevinta.spark.icons"))
        public val Copy: SparkIcon = SparkIcons.CopyFill // R.drawable.spark_icons_copy
        @Deprecated("Use SparkIcons instead.")
        public object Eyes {
            @Deprecated("Use SparkIcons instead.")
            public object Filled {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.EyeFill", "com.adevinta.spark.icons"))
                public val Enabled: SparkIcon = SparkIcons.EyeFill // R.drawable.spark_icons_eyes
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.EyeOffFill", "com.adevinta.spark.icons"))
                public val Disabled: SparkIcon = SparkIcons.EyeOffFill // R.drawable.spark_icons_eyes_disabled
            }

            @Deprecated("Use SparkIcons instead.")
            public object Outlined {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.EyeOutline", "com.adevinta.spark.icons"))
                public val Enabled: SparkIcon = SparkIcons.EyeOutline // R.drawable.spark_icons_eyes_outline
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.EyeOffOutline", "com.adevinta.spark.icons"))
                public val Disabled: SparkIcon = SparkIcons.EyeOffOutline // R.drawable.spark_icons_eyes_disabled_outline
            }
        }

        @Deprecated("Use SparkIcons instead.")
        public object Favorite {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.LikeFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.LikeFill // R.drawable.spark_icons_heart
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.LikeOutline", "com.adevinta.spark.icons"))
            public val Outlined: SparkIcon = SparkIcons.LikeOutline // R.drawable.spark_icons_heart_outline
        }

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Filter", "com.adevinta.spark.icons"))
        public val Filter: SparkIcon = SparkIcons.Filter // R.drawable.spark_icons_filter
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlashlightFill", "com.adevinta.spark.icons"))
        public val Flashlight: SparkIcon = SparkIcons.FlashlightFill // R.drawable.spark_icons_flashlight
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.MoreMenuVertical", "com.adevinta.spark.icons"))
        public val More: SparkIcon = SparkIcons.MoreMenuVertical // R.drawable.spark_icons_more_menu

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.PauseOutline", "com.adevinta.spark.icons"))
        public val Pause: SparkIcon = SparkIcons.PauseOutline // R.drawable.spark_icons_pause
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.PlayOutline", "com.adevinta.spark.icons"))
        public val Play: SparkIcon = SparkIcons.PlayOutline // R.drawable.spark_icons_play
        @Deprecated("Use SparkIcons instead.")
        public object Pen {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.PenFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.PenFill // R.drawable.spark_icons_pen
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.PenOutline", "com.adevinta.spark.icons"))
            public val Outlined: SparkIcon = SparkIcons.PenOutline // R.drawable.spark_icons_pen_outline
        }

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.PrintFill", "com.adevinta.spark.icons"))
        public val Print: SparkIcon = SparkIcons.PrintFill // R.drawable.spark_icons_print
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Refresh", "com.adevinta.spark.icons"))
        public val Refresh: SparkIcon = SparkIcons.Refresh // R.drawable.spark_icons_refresh
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Scan", "com.adevinta.spark.icons"))
        public val Scan: SparkIcon = SparkIcons.Scan // R.drawable.spark_icons_scan
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Search", "com.adevinta.spark.icons"))
        public val Search: SparkIcon = SparkIcons.Search // R.drawable.spark_icons_search
        @Deprecated("Use SparkIcons instead.")
        public object Trash {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.TrashFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.TrashFill // R.drawable.spark_icons_trash
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.TrashOutline", "com.adevinta.spark.icons"))
            public val Outlined: SparkIcon = SparkIcons.TrashOutline // R.drawable.spark_icons_trash_outline
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Close", "com.adevinta.spark.icons"))
            public val Close: SparkIcon = SparkIcons.Close // R.drawable.spark_icons_trash_close
        }

        @Deprecated("Use SparkIcons instead.")
        public object Wheel {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.WheelFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.WheelFill // R.drawable.spark_icons_wheel
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.WheelOutline", "com.adevinta.spark.icons"))
            public val Outlined: SparkIcon = SparkIcons.WheelOutline // R.drawable.spark_icons_wheel_outline
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object Arrows {
        @Deprecated("Use SparkIcons instead.")
        public object Arrow {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ArrowLeft", "com.adevinta.spark.icons"))
            public val Left: SparkIcon = SparkIcons.ArrowLeft // R.drawable.spark_icons_arrow_left
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ArrowRight", "com.adevinta.spark.icons"))
            public val Right: SparkIcon = SparkIcons.ArrowRight // R.drawable.spark_icons_arrow_right
        }

        @Deprecated("Use SparkIcons instead.")
        public object Chevron {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ArrowVerticalLeft", "com.adevinta.spark.icons"))
            public val Left: SparkIcon = SparkIcons.ArrowVerticalLeft // R.drawable.spark_icons_chevron_left
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ArrowVerticalRight", "com.adevinta.spark.icons"))
            public val Right: SparkIcon = SparkIcons.ArrowVerticalRight // R.drawable.spark_icons_chevron_right
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ArrowHorizontalUp", "com.adevinta.spark.icons"))
            public val Up: SparkIcon = SparkIcons.ArrowHorizontalUp // R.drawable.spark_icons_chevron_up
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ArrowHorizontalDown", "com.adevinta.spark.icons"))
            public val Down: SparkIcon = SparkIcons.ArrowHorizontalDown // R.drawable.spark_icons_chevron_down
        }

        @Deprecated("Use SparkIcons instead.")
        public object DoubleChevron {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ArrowDoubleLeft", "com.adevinta.spark.icons"))
            public val Left: SparkIcon = SparkIcons.ArrowDoubleLeft // R.drawable.spark_icons_chevron_double_left
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ArrowDoubleRight", "com.adevinta.spark.icons"))
            public val Right: SparkIcon = SparkIcons.ArrowDoubleRight // R.drawable.spark_icons_chevron_double_right
        }

        @Deprecated("Use SparkIcons instead.")
        public object Close {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Close", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.Close // R.drawable.spark_icons_close
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.DeleteFill", "com.adevinta.spark.icons"))
            public val Full: SparkIcon = SparkIcons.DeleteFill // R.drawable.spark_icons_close_full
        }

        @Deprecated("Use SparkIcons instead.")
        public object Chart {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.GraphArrowUp", "com.adevinta.spark.icons"))
            public val Up: SparkIcon = SparkIcons.GraphArrowUp // R.drawable.spark_icons_chart_up
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.GraphArrowDown", "com.adevinta.spark.icons"))
            public val Down: SparkIcon = SparkIcons.GraphArrowDown // R.drawable.spark_icons_chart_down
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object Calendar {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CalendarDotFill", "com.adevinta.spark.icons"))
        public val Booking: SparkIcon = SparkIcons.CalendarDotFill // R.drawable.spark_icons_calendar_booking
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CalendarFill", "com.adevinta.spark.icons"))
        public val Default: SparkIcon = SparkIcons.CalendarFill // R.drawable.spark_icons_calendar_simple
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CalendarValidFill", "com.adevinta.spark.icons"))
        public val Valid: SparkIcon = SparkIcons.CalendarValidFill // R.drawable.spark_icons_calendar_valid
    }

    @Deprecated("Use SparkIcons instead.")
    public object Categories {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Apartment", "com.adevinta.spark.icons"))
        public val Apartment: SparkIcon = SparkIcons.Apartment // R.drawable.spark_icons_apartment
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CarOutline", "com.adevinta.spark.icons"))
        public val Car: SparkIcon = SparkIcons.CarOutline // R.drawable.spark_icons_car
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Couch", "com.adevinta.spark.icons"))
        public val Couch: SparkIcon = SparkIcons.Couch // R.drawable.spark_icons_couch
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Computer", "com.adevinta.spark.icons"))
        public val Computer: SparkIcon = SparkIcons.Computer // R.drawable.spark_icons_computer
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Clothes", "com.adevinta.spark.icons"))
        public val Clothes: SparkIcon = SparkIcons.Clothes // R.drawable.spark_icons_mode
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Equipment", "com.adevinta.spark.icons"))
        public val Equipment: SparkIcon = SparkIcons.Equipment // R.drawable.spark_icons_equipment
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Family", "com.adevinta.spark.icons"))
        public val Family: SparkIcon = SparkIcons.Family // R.drawable.spark_icons_family
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Ground", "com.adevinta.spark.icons"))
        public val Ground: SparkIcon = SparkIcons.Ground // R.drawable.spark_icons_ground
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Hobby", "com.adevinta.spark.icons"))
        public val Hobbies: SparkIcon = SparkIcons.Hobby // R.drawable.spark_icons_hobbies
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Holidays", "com.adevinta.spark.icons"))
        public val Holidays: SparkIcon = SparkIcons.Holidays // R.drawable.spark_icons_holidays
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.House", "com.adevinta.spark.icons"))
        public val House: SparkIcon = SparkIcons.House // R.drawable.spark_icons_house
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Land", "com.adevinta.spark.icons"))
        public val Land: SparkIcon = SparkIcons.Land // R.drawable.spark_icons_land
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Multimedia", "com.adevinta.spark.icons"))
        public val Multimedia: SparkIcon = SparkIcons.Multimedia // R.drawable.spark_icons_multimedia
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Parking", "com.adevinta.spark.icons"))
        public val Parking: SparkIcon = SparkIcons.Parking // R.drawable.spark_icons_parking
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.MoreMenuHorizontal", "com.adevinta.spark.icons"))
        public val Pending: SparkIcon = SparkIcons.MoreMenuHorizontal // R.drawable.spark_icons_pending
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Pets", "com.adevinta.spark.icons"))
        public val Pets: SparkIcon = SparkIcons.Pets // R.drawable.spark_icons_pets
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Services", "com.adevinta.spark.icons"))
        public val Services: SparkIcon = SparkIcons.Service // R.drawable.spark_icons_services
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Job", "com.adevinta.spark.icons"))
        public val Suitcase: SparkIcon = SparkIcons.Job // R.drawable.spark_icons_suitcase
    }

    @Deprecated("Use SparkIcons instead.")
    public object Contact {
        @Deprecated("Use SparkIcons instead.")
        public object Mail {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.MailFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.MailFill // R.drawable.spark_icons_mail
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.MailOutline", "com.adevinta.spark.icons"))
            public val Outlined: SparkIcon = SparkIcons.MailOutline // R.drawable.spark_icons_mail_outline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Micro {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.VoiceFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.VoiceFill // R.drawable.spark_icons_micro
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.VoiceOutline", "com.adevinta.spark.icons"))
            public val Outlined: SparkIcon = SparkIcons.VoiceOutline // R.drawable.spark_icons_micro_outline
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.VoiceOffFill", "com.adevinta.spark.icons"))
            public val Disabled: SparkIcon = SparkIcons.VoiceOffFill // R.drawable.spark_icons_micro_off
        }

        @Deprecated("Use SparkIcons instead.")
        public object Message {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.MessageFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.MessageFill // R.drawable.spark_icons_message
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.MegaphoneOutline", "com.adevinta.spark.icons"))
            public val Outlined: SparkIcon = SparkIcons.MegaphoneOutline // R.drawable.spark_icons_message_outline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Phone {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.PhoneFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.PhoneFill // R.drawable.spark_icons_phone
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.PhoneOutline", "com.adevinta.spark.icons"))
            public val Outlined: SparkIcon = SparkIcons.PhoneOutline // R.drawable.spark_icons_phone_outine
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CallOutline", "com.adevinta.spark.icons"))
            public val Message: SparkIcon = SparkIcons.CallOutline // R.drawable.spark_icons_phone_message
        }

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.SendHorizontal", "com.adevinta.spark.icons"))
        public val SendMessage: SparkIcon = SparkIcons.SendHorizontal // R.drawable.spark_icons_send_message
    }

    @Deprecated("Use SparkIcons instead.")
    public object Criterias {
        @Deprecated("Use SparkIcons instead.")
        public object Animaux {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Age", "com.adevinta.spark.icons"))
            public val Age: SparkIcon = SparkIcons.Age // R.drawable.spark_icons_animal_age
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Loof", "com.adevinta.spark.icons"))
            public val Loof: SparkIcon = SparkIcons.Loof // R.drawable.spark_icons_animal_race
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Offer", "com.adevinta.spark.icons"))
            public val Offre: SparkIcon = SparkIcons.Offer // R.drawable.spark_icons_animal_offer_nature
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Litter", "com.adevinta.spark.icons"))
            public val Portee: SparkIcon = SparkIcons.Litter // R.drawable.spark_icons_animal_litter
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Tattoo", "com.adevinta.spark.icons"))
            public val Tatouage: SparkIcon = SparkIcons.Tattoo // R.drawable.spark_icons_animal_identification
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Animals", "com.adevinta.spark.icons"))
            public val TypeDeLOffre: SparkIcon = SparkIcons.Animals // R.drawable.spark_icons_animal_type
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Vaccine", "com.adevinta.spark.icons"))
            public val Vaccin: SparkIcon = SparkIcons.Vaccine // R.drawable.spark_icons_animal_vaccinated
        }

        @Deprecated("Use SparkIcons instead.")
        public object Automobile {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Loof", "com.adevinta.spark.icons"))
            public val Loof: SparkIcon = SparkIcons.Loof // R.drawable.spark_icons_animal_race
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Bateau", "com.adevinta.spark.icons"))
            public val Bateau: SparkIcon = SparkIcons.Boat // R.drawable.spark_icons_boat
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Fuel", "com.adevinta.spark.icons"))
            public val Carburant: SparkIcon = SparkIcons.Fuel // R.drawable.spark_icons_fuel
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Color", "com.adevinta.spark.icons"))
            public val Couleur: SparkIcon = SparkIcons.Color // R.drawable.spark_icons_color

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Cylindrical", "com.adevinta.spark.icons"))
            public val Cylindree: SparkIcon = SparkIcons.Cylindrical // R.drawable.spark_icons_engine
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Energy", "com.adevinta.spark.icons"))
            public val Energie: SparkIcon = SparkIcons.Energy // R.drawable.spark_icons_energy
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Power", "com.adevinta.spark.icons"))
            public val Puissance: SparkIcon = SparkIcons.Power // R.drawable.spark_icons_horse_power

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Mileage", "com.adevinta.spark.icons"))
            public val Kilometrage: SparkIcon = SparkIcons.Mileage // R.drawable.spark_icons_mileage
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Marque", "com.adevinta.spark.icons"))
            public val Marque: SparkIcon = SparkIcons.Marque // R.drawable.spark_icons_model
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Moto", "com.adevinta.spark.icons"))
            public val Moto: SparkIcon = SparkIcons.Moto // R.drawable.spark_icons_motobike

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.License", "com.adevinta.spark.icons"))
            public val Permis: SparkIcon = SparkIcons.License // R.drawable.spark_icons_car_licence
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Seats", "com.adevinta.spark.icons"))
            public val Places: SparkIcon = SparkIcons.Seats // R.drawable.spark_icons_seats
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Doors", "com.adevinta.spark.icons"))
            public val Portes: SparkIcon = SparkIcons.Doors // R.drawable.spark_icons_doors
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CalendarCriterias", "com.adevinta.spark.icons"))
            public val Regdate: SparkIcon = SparkIcons.CalendarCriterias // R.drawable.spark_icons_date
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Type", "com.adevinta.spark.icons"))
            public val Type: SparkIcon = SparkIcons.Type // R.drawable.spark_icons_car_type
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Speed", "com.adevinta.spark.icons"))
            public val Vitesse: SparkIcon = SparkIcons.Speed // R.drawable.spark_icons_gearbox
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Trunk", "com.adevinta.spark.icons"))
            public val Coffre: SparkIcon = SparkIcons.Trunk // R.drawable.spark_icons_trunk
        }

        @Deprecated("Use SparkIcons instead.")
        public object Emploi {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.EducationalLevel", "com.adevinta.spark.icons"))
            public val EducationalLevel: SparkIcon = SparkIcons.EducationalLevel // R.drawable.spark_icons_job_study
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Experience", "com.adevinta.spark.icons"))
            public val Experience: SparkIcon = SparkIcons.Experience // R.drawable.spark_icons_job_experience
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Function", "com.adevinta.spark.icons"))
            public val Fonction: SparkIcon = SparkIcons.Function // R.drawable.spark_icons_job_duty
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Salary", "com.adevinta.spark.icons"))
            public val Salaire: SparkIcon = SparkIcons.Salary // R.drawable.spark_icons_job_salary
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Sector", "com.adevinta.spark.icons"))
            public val Secteur: SparkIcon = SparkIcons.Sector // R.drawable.spark_icons_job_field
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Time", "com.adevinta.spark.icons"))
            public val Temps: SparkIcon = SparkIcons.Time // R.drawable.spark_icons_job_time
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Type", "com.adevinta.spark.icons"))
            public val Type: SparkIcon = SparkIcons.Type // R.drawable.spark_icons_job_contract
        }

        @Deprecated("Use SparkIcons instead.")
        public object Generique {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Defaut1", "com.adevinta.spark.icons"))
            public val Defaut1: SparkIcon = SparkIcons.LikeOutline // R.drawable.spark_icons_like
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Listing", "com.adevinta.spark.icons"))
            public val Defaut2: SparkIcon = SparkIcons.Listing // R.drawable.spark_icons_criteria
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Donate", "com.adevinta.spark.icons"))
            public val Donate: SparkIcon = SparkIcons.Donate // R.drawable.spark_icons_donate
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Smoking", "com.adevinta.spark.icons"))
            public val Smoking: SparkIcon = SparkIcons.Smoking // R.drawable.spark_icons_smoking
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Localisation", "com.adevinta.spark.icons"))
            public val Localisation: SparkIcon = SparkIcons.Localisation // R.drawable.spark_icons_localisation
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Delivery", "com.adevinta.spark.icons"))
            public val Delivery: SparkIcon = SparkIcons.Delivery // R.drawable.spark_icons_delivery
        }

        @Deprecated("Use SparkIcons instead.")
        public object Immobilier {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Class", "com.adevinta.spark.icons"))
            public val Classe: SparkIcon = SparkIcons.Class // R.drawable.spark_icons_energy_rate
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Class", "com.adevinta.spark.icons"))
            public val Ges: SparkIcon = SparkIcons.Class // R.drawable.spark_icons_ges
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Honoraria", "com.adevinta.spark.icons"))
            public val Honoraires: SparkIcon = SparkIcons.Honoraria // R.drawable.spark_icons_fai
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Furniture", "com.adevinta.spark.icons"))
            public val Meuble: SparkIcon = SparkIcons.Furniture // R.drawable.spark_icons_furnished
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Pieces", "com.adevinta.spark.icons"))
            public val Pieces: SparkIcon = SparkIcons.Pieces // R.drawable.spark_icons_rooms
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Reference", "com.adevinta.spark.icons"))
            public val Reference: SparkIcon = SparkIcons.Reference // R.drawable.spark_icons_reference
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Surface", "com.adevinta.spark.icons"))
            public val Surface: SparkIcon = SparkIcons.Surface // R.drawable.spark_icons_square
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.HousingType", "com.adevinta.spark.icons"))
            public val TypeDeBien: SparkIcon = SparkIcons.HousingType // R.drawable.spark_icons_real_estate_type
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.SaleType", "com.adevinta.spark.icons"))
            public val TypeDeVente: SparkIcon = SparkIcons.SaleType // R.drawable.spark_icons_real_estate_sale_type
        }

        @Deprecated("Use SparkIcons instead.")
        public object ImmobilierNeuf {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Balcony", "com.adevinta.spark.icons"))
            public val Balcon: SparkIcon = SparkIcons.Balcony // R.drawable.spark_icons_balcony
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Cave", "com.adevinta.spark.icons"))
            public val Cave: SparkIcon = SparkIcons.Cave // R.drawable.spark_icons_cellar
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Duplex", "com.adevinta.spark.icons"))
            public val Duplex: SparkIcon = SparkIcons.Duplex // R.drawable.spark_icons_duplex
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Etage", "com.adevinta.spark.icons"))
            public val Etage: SparkIcon = SparkIcons.Floor // R.drawable.spark_icons_floor
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Garage", "com.adevinta.spark.icons"))
            public val Garage: SparkIcon = SparkIcons.Garage // R.drawable.spark_icons_garage
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Garden", "com.adevinta.spark.icons"))
            public val Jardin: SparkIcon = SparkIcons.Garden // R.drawable.spark_icons_garden
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Loggia", "com.adevinta.spark.icons"))
            public val Loggia: SparkIcon = SparkIcons.Loggia // R.drawable.spark_icons_loggia
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.SunOrientation", "com.adevinta.spark.icons"))
            public val Orientation: SparkIcon = SparkIcons.SunOrientation // R.drawable.spark_icons_direction
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Parking", "com.adevinta.spark.icons"))
            public val Parking: SparkIcon = SparkIcons.Parking // R.drawable.spark_icons_park_sign
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Terrace", "com.adevinta.spark.icons"))
            public val Terrasse: SparkIcon = SparkIcons.Terrace // R.drawable.spark_icons_terrace
        }

        @Deprecated("Use SparkIcons instead.")
        public object Location {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Cave", "com.adevinta.spark.icons"))
            public val Cave: SparkIcon = SparkIcons.Cave // R.drawable.spark_icons_location_cave
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Calm", "com.adevinta.spark.icons"))
            public val Calme: SparkIcon = SparkIcons.Calm // R.drawable.spark_icons_location_calme
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Cave", "com.adevinta.spark.icons"))
            public val Cave2: SparkIcon = SparkIcons.Cave // R.drawable.spark_icons_location_cave_2
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Fireplace", "com.adevinta.spark.icons"))
            public val Chemine: SparkIcon = SparkIcons.Fireplace // R.drawable.spark_icons_location_chemine
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.LastFloor", "com.adevinta.spark.icons"))
            public val DernierEtage: SparkIcon = SparkIcons.LastFloor // R.drawable.spark_icons_location_dernieretage
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Digicode", "com.adevinta.spark.icons"))
            public val Digicode: SparkIcon = SparkIcons.Digicode // R.drawable.spark_icons_location_digicode
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.GlassWindows", "com.adevinta.spark.icons"))
            public val BaiesVitrees: SparkIcon = SparkIcons.GlassWindows // R.drawable.spark_icons_location_baiesvitrees
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Janitor", "com.adevinta.spark.icons"))
            public val Concierge: SparkIcon = SparkIcons.Janitor // R.drawable.spark_icons_location_concierge
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Attic", "com.adevinta.spark.icons"))
            public val Combles: SparkIcon = SparkIcons.Attic // R.drawable.spark_icons_location_combles
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.BeautifulBuilding", "com.adevinta.spark.icons"))
            public val BeauBatiment: SparkIcon = SparkIcons.BeautifulBuilding // R.drawable.spark_icons_location_beaubatiment
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Interphone", "com.adevinta.spark.icons"))
            public val Interphone: SparkIcon = SparkIcons.Interphone // R.drawable.spark_icons_location_interphone
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Loft", "com.adevinta.spark.icons"))
            public val Loft: SparkIcon = SparkIcons.Loft // R.drawable.spark_icons_location_loft
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Light", "com.adevinta.spark.icons"))
            public val Lumineux: SparkIcon = SparkIcons.Light // R.drawable.spark_icons_location_lumineux
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Common", "com.adevinta.spark.icons"))
            public val Mitoyen: SparkIcon = SparkIcons.Common // R.drawable.spark_icons_location_mitoyen
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Moulding", "com.adevinta.spark.icons"))
            public val Mouture: SparkIcon = SparkIcons.Moulding // R.drawable.spark_icons_location_moulure
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Parquet", "com.adevinta.spark.icons"))
            public val Parquet: SparkIcon = SparkIcons.Parquet // R.drawable.spark_icons_location_parquet
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Wardrobe", "com.adevinta.spark.icons"))
            public val Penderie: SparkIcon = SparkIcons.Wardrobe // R.drawable.spark_icons_location_penderie
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Metro", "com.adevinta.spark.icons"))
            public val Metro: SparkIcon = SparkIcons.Metro // R.drawable.spark_icons_location_metro
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.StoreOutline", "com.adevinta.spark.icons"))
            public val Magasin: SparkIcon = SparkIcons.StoreOutline // R.drawable.spark_icons_location_magasin
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Shower", "com.adevinta.spark.icons"))
            public val Douche: SparkIcon = SparkIcons.Shower // R.drawable.spark_icons_location_douche
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Renovation", "com.adevinta.spark.icons"))
            public val Renove: SparkIcon = SparkIcons.Renovation // R.drawable.spark_icons_location_renovee
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Bath", "com.adevinta.spark.icons"))
            public val Baignoire: SparkIcon = SparkIcons.Bath // R.drawable.spark_icons_location_baignoire
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.View", "com.adevinta.spark.icons"))
            public val Vue: SparkIcon = SparkIcons.View // R.drawable.spark_icons_location_vue
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.SeaView", "com.adevinta.spark.icons"))
            public val VueMer: SparkIcon = SparkIcons.SeaView // R.drawable.spark_icons_location_vue_mer
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Wc", "com.adevinta.spark.icons"))
            public val Wc: SparkIcon = SparkIcons.Wc // R.drawable.spark_icons_location_wc
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Lift", "com.adevinta.spark.icons"))
            public val Ascenseur: SparkIcon = SparkIcons.Lift // R.drawable.spark_icons_elevator
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ChargesIncluded", "com.adevinta.spark.icons"))
            public val ChargesComprises: SparkIcon = SparkIcons.ChargesIncluded // R.drawable.spark_icons_location_charges_comprises
        }

        @Deprecated("Use SparkIcons instead.")
        public object Loisirs {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Toy", "com.adevinta.spark.icons"))
            public val Jouet: SparkIcon = SparkIcons.Toy // R.drawable.spark_icons_jouet
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.BicycleType", "com.adevinta.spark.icons"))
            public val BicycleType: SparkIcon = SparkIcons.BicycleType // R.drawable.spark_icons_bicycle
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ToysProduct", "com.adevinta.spark.icons"))
            public val ToysProduct: SparkIcon = SparkIcons.ToysProduct // R.drawable.spark_icons_toy_product
        }

        @Deprecated("Use SparkIcons instead.")
        public object Maison {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.DiyProduct", "com.adevinta.spark.icons"))
            public val DiyProduct: SparkIcon = SparkIcons.DiyProduct // R.drawable.spark_icons_maison_diy_product
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.DiyType", "com.adevinta.spark.icons"))
            public val DiyType: SparkIcon = SparkIcons.DiyType // R.drawable.spark_icons_maison_diy_type
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.HomeappliancesProduct", "com.adevinta.spark.icons"))
            public val HomeAppliancesProduct: SparkIcon = SparkIcons.HomeappliancesProduct // R.drawable.spark_icons_maison_homeappliance_product
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.HomeappliancesType", "com.adevinta.spark.icons"))
            public val HomeAppliancesType: SparkIcon = SparkIcons.HomeappliancesType // R.drawable.spark_icons_maison_homeappliance_type
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.GardeningProduct", "com.adevinta.spark.icons"))
            public val GardeningProduct: SparkIcon = SparkIcons.GardeningProduct // R.drawable.spark_icons_maison_gardening_product
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.GardeningType", "com.adevinta.spark.icons"))
            public val GardeningType: SparkIcon = SparkIcons.GardeningType // R.drawable.spark_icons_maison_gardening_type
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.LinensProduct", "com.adevinta.spark.icons"))
            public val LinensProduct: SparkIcon = SparkIcons.LinensProduct // R.drawable.spark_icons_linens_product
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.LinensType", "com.adevinta.spark.icons"))
            public val LinensType: SparkIcon = SparkIcons.LinensType // R.drawable.spark_icons_linens_type
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.TableArtMaterial", "com.adevinta.spark.icons"))
            public val TableArtMaterial: SparkIcon = SparkIcons.TableArtMaterial // R.drawable.spark_icons_maison_tableart_material
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.TableArtProduct", "com.adevinta.spark.icons"))
            public val TableArtProduct: SparkIcon = SparkIcons.TableArtProduct // R.drawable.spark_icons_maison_tableart_product
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FurnitureType", "com.adevinta.spark.icons"))
            public val FournitureType: SparkIcon = SparkIcons.FurnitureType // R.drawable.spark_icons_furniture_type
        }

        @Deprecated("Use SparkIcons instead.")
        public object Mode {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.EquipmentBaby", "com.adevinta.spark.icons"))
            public val EquipementBebe: SparkIcon = SparkIcons.EquipmentBaby // R.drawable.spark_icons_baby_equipment_type
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Color", "com.adevinta.spark.icons"))
            public val Couleur: SparkIcon = SparkIcons.Color // R.drawable.spark_icons_color
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Etat", "com.adevinta.spark.icons"))
            public val Etat: SparkIcon = SparkIcons.Condition // R.drawable.Condition
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.OfferOutline", "com.adevinta.spark.icons"))
            public val Marque: SparkIcon = SparkIcons.OfferOutline // R.drawable.spark_icons_brand
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Material", "com.adevinta.spark.icons"))
            public val Matiere: SparkIcon = SparkIcons.Material // R.drawable.spark_icons_clothing_material
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Luxe", "com.adevinta.spark.icons"))
            public val Luxe: SparkIcon = SparkIcons.Luxe // R.drawable.spark_icons_accessories_material
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ShoeSize", "com.adevinta.spark.icons"))
            public val Pointure: SparkIcon = SparkIcons.ShoeSize // R.drawable.spark_icons_shoe_size
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Size", "com.adevinta.spark.icons"))
            public val Taille: SparkIcon = SparkIcons.Size // R.drawable.spark_icons_clothing_size
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Jewels", "com.adevinta.spark.icons"))
            public val Bijoux: SparkIcon = SparkIcons.Jewels // R.drawable.spark_icons_accessories_type_2
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Shoes", "com.adevinta.spark.icons"))
            public val Chaussure: SparkIcon = SparkIcons.Shoes // R.drawable.spark_icons_shoe_type
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Clothes", "com.adevinta.spark.icons"))
            public val Vetements: SparkIcon = SparkIcons.Clothes // R.drawable.spark_icons_clothing_type
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Univers", "com.adevinta.spark.icons"))
            public val Univers: SparkIcon = SparkIcons.Univers // R.drawable.spark_icons_people
        }

        @Deprecated("Use SparkIcons instead.")
        public object Multimedia {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Condition", "com.adevinta.spark.icons"))
            public val Etat: SparkIcon = SparkIcons.Condition // R.drawable.spark_icons_item_condition
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Memory", "com.adevinta.spark.icons"))
            public val Memoire: SparkIcon = SparkIcons.Memory // R.drawable.spark_icons_phone_memory
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Model", "com.adevinta.spark.icons"))
            public val Modele: SparkIcon = SparkIcons.Model // R.drawable.spark_icons_phone_type
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Color", "com.adevinta.spark.icons"))
            public val Couleur: SparkIcon = SparkIcons.Color // R.drawable.spark_icons_color
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Model", "com.adevinta.spark.icons"))
            public val Marque: SparkIcon = SparkIcons.Model // R.drawable.spark_icons_phone_type
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Type", "com.adevinta.spark.icons"))
            public val Type: SparkIcon = SparkIcons.Type // R.drawable.spark_icons_video_game_type
        }

        @Deprecated("Use SparkIcons instead.")
        public object Vacances {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Animals", "com.adevinta.spark.icons"))
            public val Animaux: SparkIcon = SparkIcons.Animals // R.drawable.spark_icons_pet_accepted
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Capacity", "com.adevinta.spark.icons"))
            public val Capacite: SparkIcon = SparkIcons.Capacity // R.drawable.spark_icons_people
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Rooms", "com.adevinta.spark.icons"))
            public val Chambres: SparkIcon = SparkIcons.Rooms // R.drawable.spark_icons_bedrooms
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Arrival", "com.adevinta.spark.icons"))
            public val Arrive: SparkIcon = SparkIcons.Arrival // R.drawable.spark_icons_check_in_out
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Depart", "com.adevinta.spark.icons"))
            public val Depart: SparkIcon = SparkIcons.Start // R.drawable.spark_icons_check_in_out
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Rating", "com.adevinta.spark.icons"))
            public val NombreEtoiles: SparkIcon = SparkIcons.Rating // R.drawable.spark_icons_housing_ranking
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AirConditioning", "com.adevinta.spark.icons"))
            public val Climatisation: SparkIcon = SparkIcons.AirConditioning // R.drawable.spark_icons_aircooler
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Sport", "com.adevinta.spark.icons"))
            public val SalleSport: SparkIcon = SparkIcons.Sport // R.drawable.spark_icons_gym
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Breakfast", "com.adevinta.spark.icons"))
            public val PetitDejeune: SparkIcon = SparkIcons.Breakfast // R.drawable.spark_icons_breakfast
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Spa", "com.adevinta.spark.icons"))
            public val Spa: SparkIcon = SparkIcons.Spa // R.drawable.spark_icons_spa
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Tv", "com.adevinta.spark.icons"))
            public val Tv: SparkIcon = SparkIcons.Tv // R.drawable.spark_icons_television
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Welcome", "com.adevinta.spark.icons"))
            public val Acceuil: SparkIcon = SparkIcons.Welcome // R.drawable.spark_icons_welcome
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Wifi", "com.adevinta.spark.icons"))
            public val Wifi: SparkIcon = SparkIcons.Wifi // R.drawable.spark_icons_wifi
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Clean", "com.adevinta.spark.icons"))
            public val LabelSanitaire2: SparkIcon = SparkIcons.Clean // R.drawable.spark_icons_covid
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.HousingType", "com.adevinta.spark.icons"))
            public val TypeLogement: SparkIcon = SparkIcons.HousingType // R.drawable.spark_icons_real_estate_type
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Garden", "com.adevinta.spark.icons"))
            public val Jardin: SparkIcon = SparkIcons.Garden // R.drawable.spark_icons_garden
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Parking", "com.adevinta.spark.icons"))
            public val Parking: SparkIcon = SparkIcons.Parking // R.drawable.spark_icons_park
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Pool", "com.adevinta.spark.icons"))
            public val Piscine: SparkIcon = SparkIcons.Pool // R.drawable.spark_icons_swimming_pool
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Accessories", "com.adevinta.spark.icons"))
            public val Accessories: SparkIcon = SparkIcons.Accessories // R.drawable.spark_icons_accessories_type
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CalendarCriterias", "com.adevinta.spark.icons"))
            public val Date: SparkIcon = SparkIcons.CalendarCriterias // R.drawable.spark_icons_date
        }

        @Deprecated("Use SparkIcons instead.")
        public object MaterialTools {
            @Deprecated("Use SparkIcons instead.")
            public object Tools {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Tools", "com.adevinta.spark.icons"))
                public val Agriculture: SparkIcon = SparkIcons.Tools // R.drawable.spark_icons_agriculture
            }
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object Flags {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagAT", "com.adevinta.spark.icons"))
        public val FlagAT: SparkIcon = SparkIcons.FlagAT // R.drawable.spark_icons_flag_at
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagBE", "com.adevinta.spark.icons"))
        public val FlagBE: SparkIcon = SparkIcons.FlagBE // R.drawable.spark_icons_flag_be
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagBR", "com.adevinta.spark.icons"))
        public val FlagBR: SparkIcon = SparkIcons.FlagBR // R.drawable.spark_icons_flag_br
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagBY", "com.adevinta.spark.icons"))
        public val FlagBY: SparkIcon = SparkIcons.FlagBY // R.drawable.spark_icons_flag_by
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagCH", "com.adevinta.spark.icons"))
        public val FlagCH: SparkIcon = SparkIcons.FlagCH // R.drawable.spark_icons_flag_ch
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagCL", "com.adevinta.spark.icons"))
        public val FlagCL: SparkIcon = SparkIcons.FlagCL // R.drawable.spark_icons_flag_cl
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagCO", "com.adevinta.spark.icons"))
        public val FlagCO: SparkIcon = SparkIcons.FlagCO // R.drawable.spark_icons_flag_co
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagDO", "com.adevinta.spark.icons"))
        public val FlagDO: SparkIcon = SparkIcons.FlagDO // R.drawable.spark_icons_flag_do
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagES", "com.adevinta.spark.icons"))
        public val FlagES: SparkIcon = SparkIcons.FlagES // R.drawable.spark_icons_flag_es
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagFI", "com.adevinta.spark.icons"))
        public val FlagFI: SparkIcon = SparkIcons.FlagFI // R.drawable.spark_icons_flag_fi
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagFR", "com.adevinta.spark.icons"))
        public val FlagFR: SparkIcon = SparkIcons.FlagFR // R.drawable.spark_icons_flag_fr
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagHU", "com.adevinta.spark.icons"))
        public val FlagHU: SparkIcon = SparkIcons.FlagHU // R.drawable.spark_icons_flag_hu
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagID", "com.adevinta.spark.icons"))
        public val FlagID: SparkIcon = SparkIcons.FlagID // R.drawable.spark_icons_flag_id
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagIE", "com.adevinta.spark.icons"))
        public val FlagIE: SparkIcon = SparkIcons.FlagIE // R.drawable.spark_icons_flag_ie
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagIT", "com.adevinta.spark.icons"))
        public val FlagIT: SparkIcon = SparkIcons.FlagIT // R.drawable.spark_icons_flag_it
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagMA", "com.adevinta.spark.icons"))
        public val FlagMA: SparkIcon = SparkIcons.FlagMA // R.drawable.spark_icons_flag_ma
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagMX", "com.adevinta.spark.icons"))
        public val FlagMX: SparkIcon = SparkIcons.FlagMX // R.drawable.spark_icons_flag_mx
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagMY", "com.adevinta.spark.icons"))
        public val FlagMY: SparkIcon = SparkIcons.FlagMY // R.drawable.spark_icons_flag_my
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagPT", "com.adevinta.spark.icons"))
        public val FlagPT: SparkIcon = SparkIcons.FlagPT // R.drawable.spark_icons_flag_pt
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagSE", "com.adevinta.spark.icons"))
        public val FlagSE: SparkIcon = SparkIcons.FlagSE // R.drawable.spark_icons_flag_se
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagTN", "com.adevinta.spark.icons"))
        public val FlagTN: SparkIcon = SparkIcons.FlagTN // R.drawable.spark_icons_flag_tn
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagVN", "com.adevinta.spark.icons"))
        public val FlagVN: SparkIcon = SparkIcons.FlagVN // R.drawable.spark_icons_flag_vn
    }

    @Deprecated("Use SparkIcons instead.")
    public object Images {
        @Deprecated("Use SparkIcons instead.")
        public object Camera {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CameraFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.CameraFill // R.drawable.spark_icons_camera
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CameraOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.CameraOutline // R.drawable.spark_icons_camera_outline
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AddImageOutline", "com.adevinta.spark.icons"))
            public val More: SparkIcon = SparkIcons.AddImageOutline // R.drawable.spark_icons_camera_more
        }

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.GalleryFill", "com.adevinta.spark.icons"))
        public val Library: SparkIcon = SparkIcons.GalleryFill // R.drawable.spark_icons_library
        @Deprecated("Use SparkIcons instead.")
        public object NewAd {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AddSquareFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.AddSquareFill // R.drawable.spark_icons_new_ad
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AddSquareOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.AddSquareOutline // R.drawable.spark_icons_new_ad_outline
        }

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.NoPhoto", "com.adevinta.spark.icons"))
        public val NoPhoto: SparkIcon = SparkIcons.NoPhoto // R.drawable.spark_icons_no_photo1
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ErrorPhoto", "com.adevinta.spark.icons"))
        public val ErrorPhoto: SparkIcon = SparkIcons.ErrorPhoto // R.drawable.spark_icons_error_photo

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.NoPhoto", "com.adevinta.spark.icons"))
        public val NoPhoto2: SparkIcon = SparkIcons.NoPhoto // R.drawable.spark_icons_no_photo2
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.RotateImage", "com.adevinta.spark.icons"))
        public val Rotate: SparkIcon = SparkIcons.RotateImage // R.drawable.spark_icons_photo_rotate
    }

    @Deprecated("Use SparkIcons instead.")
    public object Infos {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CameraFill", "com.adevinta.spark.icons"))
        public val Camera: SparkIcon = SparkIcons.CameraFill // R.drawable.spark_icons_camera

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Block", "com.adevinta.spark.icons"))
        public val Block: SparkIcon = SparkIcons.Block // R.drawable.spark_icons_block

        @Deprecated("Use SparkIcons instead.")
        public object Alert {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AlertFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.AlertFill // R.drawable.spark_icons_alerte
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AlertOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.AlertOutline // R.drawable.spark_icons_alert_outline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Ask {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.QuestionFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.QuestionFill // R.drawable.spark_icons_ask
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.QuestionOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.QuestionOutline // R.drawable.spark_icons_ask_outline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Info {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.InfoFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.InfoFill // R.drawable.spark_icons_info
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.InfoOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.InfoOutline // R.drawable.spark_icons_info_outline
        }

        @Deprecated("Use SparkIcons instead.")
        public object LightBulb {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.IdeaFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.IdeaFill // R.drawable.spark_icons_lightbulb
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.IdeaOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.IdeaOutline // R.drawable.spark_icons_lightbulb_outline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Lock {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.LockFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.LockFill // R.drawable.spark_icons_lock
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.LockOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.LockOutline // R.drawable.spark_icons_lock_outline
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.UnlockOutline", "com.adevinta.spark.icons"))
            public val Open: SparkIcon = SparkIcons.UnlockOutline // R.drawable.spark_icons_open
        }

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.WarningFill", "com.adevinta.spark.icons"))
        public val Warning: SparkIcon = SparkIcons.WarningFill // R.drawable.spark_icons_warning
    }

    @Deprecated("Use SparkIcons instead.")
    public object Delivery {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.DeliveryHandsOutline", "com.adevinta.spark.icons"))
        public val DeliveryHand: SparkIcon = SparkIcons.DeliveryHandsOutline // R.drawable.spark_icons_delivery_hands
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.DeliveryOutline", "com.adevinta.spark.icons"))
        public val DeliveryOutline: SparkIcon = SparkIcons.DeliveryOutline // R.drawable.spark_icons_box_outline
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.DeliveryTruckOutline", "com.adevinta.spark.icons"))
        public val Truck: SparkIcon = SparkIcons.DeliveryTruckOutline // R.drawable.spark_icons_delivery_truck
        @Deprecated("Use SparkIcons instead.")
        public object Mailbox {
            @Deprecated("Use SparkIcons instead.")
            public object Close {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("MailCloseFill", "com.adevinta.spark.icons"))
                public val Down: SparkIcon = SparkIcons.MailCloseFill // R.drawable.spark_icons_delivery_mailbox_closed_down
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("MailCloseFill", "com.adevinta.spark.icons"))
                public val Up: SparkIcon = SparkIcons.MailCloseFill // R.drawable.spark_icons_delivery_mailbox_closed_up
            }

            @Deprecated("Use SparkIcons instead.")
            public object Open {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.MailOpenFill", "com.adevinta.spark.icons"))
                public val Down: SparkIcon = SparkIcons.MailOpenFill // R.drawable.spark_icons_delivery_mailbox_open_down
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.MailOpenFill", "com.adevinta.spark.icons"))
                public val Up: SparkIcon = SparkIcons.MailOpenFill // R.drawable.spark_icons_delivery_mailbox_open_up
            }
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object Map {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ThreeSixty", "com.adevinta.spark.icons"))
        public val ThreeSixty: SparkIcon = SparkIcons.ThreeSixty // R.drawable.spark_icons_three_sixty
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Bike", "com.adevinta.spark.icons"))
        public val Bike: SparkIcon = SparkIcons.Bike // R.drawable.spark_icons_bike
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AllDirection", "com.adevinta.spark.icons"))
        public val Drag: SparkIcon = SparkIcons.AllDirection // R.drawable.spark_icons_drag
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.MapExpand", "com.adevinta.spark.icons"))
        public val Expand: SparkIcon = SparkIcons.MapExpand // R.drawable.spark_icons_expand
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.TargetOutline", "com.adevinta.spark.icons"))
        public val Geoloc: SparkIcon = SparkIcons.TargetOutline // R.drawable.spark_icons_geoloc
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.HotelFill", "com.adevinta.spark.icons"))
        public val Hotel: SparkIcon = SparkIcons.HotelFill // R.drawable.spark_icons_hotel

        @Deprecated("Use SparkIcons instead.")
        public object Marker {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.PinFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.PinFill // R.drawable.spark_icons_marker
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.PinOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.PinOutline // R.drawable.spark_icons_marker_outline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Near {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.MapCursorFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.MapCursorFill // R.drawable.spark_icons_near
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.MapCursorOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.MapCursorOutline // R.drawable.spark_icons_near_outline
        }

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.MapExpand", "com.adevinta.spark.icons"))
        public val SimpleExpand: SparkIcon = SparkIcons.MapExpand // R.drawable.spark_icons_expand_simple

        @Deprecated("Use SparkIcons instead.")
        public object Train {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.TrainFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.TrainFill // R.drawable.spark_icons_train
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.TrainOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.TrainOutline // R.drawable.spark_icons_train_outline
        }

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.WalkerFill", "com.adevinta.spark.icons"))
        public val Walker: SparkIcon = SparkIcons.WalkerFill // R.drawable.spark_icons_walker
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CarOutline", "com.adevinta.spark.icons"))
        public val Car: SparkIcon = SparkIcons.CarOutline // R.drawable.spark_icons_car
    }

    @Deprecated("Use SparkIcons instead.")
    public object Navs {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AlarmOnFill", "com.adevinta.spark.icons"))
        public val Arrow: SparkIcon = SparkIcons.AlarmOnFill // R.drawable.spark_icons_notif_actif
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.BurgerMenu", "com.adevinta.spark.icons"))
        public val Drawer: SparkIcon = SparkIcons.BurgerMenu // R.drawable.spark_icons_menu
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Close", "com.adevinta.spark.icons"))
        public val Close: SparkIcon = SparkIcons.Close // R.drawable.spark_icons_close
    }

    @Deprecated("Use SparkIcons instead.")
    public object Notifications {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AlarmOnFill", "com.adevinta.spark.icons"))
        public val Active: SparkIcon = SparkIcons.AlarmOnFill // R.drawable.spark_icons_notif_actif
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AlarmFill", "com.adevinta.spark.icons"))
        public val Default: SparkIcon = SparkIcons.AlarmFill // R.drawable.spark_icons_notif
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AlarmOffFill", "com.adevinta.spark.icons"))
        public val Disable: SparkIcon = SparkIcons.AlarmOffFill // R.drawable.spark_icons_no_notif
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AlarmOutline", "com.adevinta.spark.icons"))
        public val Outline: SparkIcon = SparkIcons.AlarmOutline // R.drawable.spark_icons_notif_outline
    }

    @Deprecated("Use SparkIcons instead.")
    public object Options {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Booster", "com.adevinta.spark.icons"))
        public val Booster: SparkIcon = SparkIcons.Booster // R.drawable.spark_icons_booster
        @Deprecated("Use SparkIcons instead.")
        public object Clock {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ClockArrowOutline", "com.adevinta.spark.icons"))
            public val Arrow: SparkIcon = SparkIcons.ClockArrowOutline // R.drawable.spark_icons_clockarrow
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ClockFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.ClockFill // R.drawable.spark_icons_clock_filled
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ClockOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.ClockOutline // R.drawable.spark_icons_clock
        }

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.MoneyFill", "com.adevinta.spark.icons"))
        public val Credit: SparkIcon = SparkIcons.MoneyFill // R.drawable.spark_icons_credit
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlashlightFill", "com.adevinta.spark.icons"))
        public val Flash: SparkIcon = SparkIcons.FlashlightFill // R.drawable.spark_icons_flashlight
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.MoveUp", "com.adevinta.spark.icons"))
        public val MoveUp: SparkIcon = SparkIcons.MoveUp // R.drawable.spark_icons_moveup
        @Deprecated("Use SparkIcons instead.")
        public object SpotLight {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.BookmarkFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.BookmarkFill // R.drawable.spark_icons_spotlight
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.BookmarkOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.BookmarkOutline // R.drawable.spark_icons_spotlight_outline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Star {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.StarFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.StarFill // R.drawable.spark_icons_star
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.StarOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.StarOutline // R.drawable.spark_icons_star_outline
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object Others {
        @Deprecated("Use SparkIcons instead.")
        public object Megaphone {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.MegaphoneFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.MegaphoneFill // R.drawable.spark_icons_demand_filled
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.MegaphoneOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.MegaphoneOutline // R.drawable.spark_icons_demand
        }

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.SpeedmeterOutline", "com.adevinta.spark.icons"))
        public val SpeedoMeter: SparkIcon = SparkIcons.SpeedmeterOutline // R.drawable.spark_icons_speedometer
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.DissatisfiedOutline", "com.adevinta.spark.icons"))
        public val Dissatisfied: SparkIcon = SparkIcons.DissatisfiedOutline // R.drawable.spark_icons_dissatisfied
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Euro", "com.adevinta.spark.icons"))
        public val Euro: SparkIcon = SparkIcons.Euro // R.drawable.spark_icons_euro
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FlagOutline", "com.adevinta.spark.icons"))
        public val FlagOutline: SparkIcon = SparkIcons.FlagOutline // R.drawable.spark_icons_flag_outline
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.SatisfiedOutline", "com.adevinta.spark.icons"))
        public val Satisfied: SparkIcon = SparkIcons.SatisfiedOutline // R.drawable.spark_icons_satisfied
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.BoxOutline", "com.adevinta.spark.icons"))
        public val Package: SparkIcon = SparkIcons.BoxOutline // R.drawable.spark_icons_package
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Refund", "com.adevinta.spark.icons"))
        public val Refund: SparkIcon = SparkIcons.Refund // R.drawable.spark_icons_refund
    }

    @Deprecated("Use SparkIcons instead.")
    public object Paiement {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CarWarrantyOutline", "com.adevinta.spark.icons"))
        public val GarantiePanne: SparkIcon = SparkIcons.CarWarrantyOutline // R.drawable.spark_icons_garantie_panne
    }

    @Deprecated("Use SparkIcons instead.")
    public object Pro {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ProCursorOutline", "com.adevinta.spark.icons"))
        public val Actions: SparkIcon = SparkIcons.ProCursorOutline // R.drawable.spark_icons_actions
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Apparitions", "com.adevinta.spark.icons"))
        public val Apparitions: SparkIcon = SparkIcons.Apparitions // R.drawable.spark_icons_apparitions

        @Deprecated("Use SparkIcons instead.")
        public object Download {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.DownloadFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.DownloadFill // R.drawable.spark_icons_download
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.DownloadOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.DownloadOutline // R.drawable.spark_icons_download_outline
        }

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.GraphOutline", "com.adevinta.spark.icons"))
        public val MyPro: SparkIcon = SparkIcons.GraphOutline // R.drawable.spark_icons_my_pro
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.RocketOutline", "com.adevinta.spark.icons"))
        public val SpaceShip: SparkIcon = SparkIcons.RocketOutline // R.drawable.spark_icons_spaceship
    }

    @Deprecated("Use SparkIcons instead.")
    public object Share {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AttachFileOutline", "com.adevinta.spark.icons"))
        public val AttachFile: SparkIcon = SparkIcons.AttachFileOutline // R.drawable.spark_icons_attachment
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.FacebookFill", "com.adevinta.spark.icons"))
        public val Facebook: SparkIcon = SparkIcons.FacebookFill // R.drawable.spark_icons_facebook
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Messenger", "com.adevinta.spark.icons"))
        public val Messenger: SparkIcon = SparkIcons.Messenger // R.drawable.spark_icons_messenger
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Pinterest", "com.adevinta.spark.icons"))
        public val Pinterest: SparkIcon = SparkIcons.Pinterest // R.drawable.spark_icons_pinterest
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.InstagramOutline", "com.adevinta.spark.icons"))
        public val Instagram: SparkIcon = SparkIcons.InstagramOutline // R.drawable.spark_icons_instagram
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ShareExpand", "com.adevinta.spark.icons"))
        public val Goto: SparkIcon = SparkIcons.ShareExpand // R.drawable.spark_icons_goto
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Link", "com.adevinta.spark.icons"))
        public val Link: SparkIcon = SparkIcons.Link // R.drawable.spark_icons_link
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ShareFill", "com.adevinta.spark.icons"))
        public val ShareDefault: SparkIcon = SparkIcons.ShareFill // R.drawable.spark_icons_share
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ForwardFill", "com.adevinta.spark.icons"))
        public val ShareArrow: SparkIcon = SparkIcons.ForwardFill // R.drawable.spark_icons_share_arrow
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.TwitterFill", "com.adevinta.spark.icons"))
        public val Twitter: SparkIcon = SparkIcons.TwitterFill // R.drawable.spark_icons_twitter
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Whatsapp", "com.adevinta.spark.icons"))
        public val WhatsApp: SparkIcon = SparkIcons.Whatsapp // R.drawable.spark_icons_whatsapp
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Export", "com.adevinta.spark.icons"))
        public val Upload: SparkIcon = SparkIcons.Export // R.drawable.spark_icons_upload
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Import", "com.adevinta.spark.icons"))
        public val Download: SparkIcon = SparkIcons.Import // R.drawable.spark_icons_share_download
    }

    @Deprecated("Use SparkIcons instead.")
    public object Toggles {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Plus", "com.adevinta.spark.icons"))
        public val Add: SparkIcon = SparkIcons.Plus // R.drawable.spark_icons_add

        @Deprecated("Use SparkIcons instead.")
        public object Check {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ValidFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.ValidFill // R.drawable.spark_icons_check
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ValidOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.ValidOutline // R.drawable.spark_icons_check_outline
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.CheckFill", "com.adevinta.spark.icons"))
            public val Simple: SparkIcon = SparkIcons.CheckFill // R.drawable.spark_icons_check_simple
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.DoubleCheckFill", "com.adevinta.spark.icons"))
            public val Double: SparkIcon = SparkIcons.DoubleCheckFill // R.drawable.spark_icons_check_double
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object User {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ProOutline", "com.adevinta.spark.icons"))
        public val Pro: SparkIcon = SparkIcons.ProOutline // R.drawable.spark_icons_profile_pro2
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AccountFill", "com.adevinta.spark.icons"))
        public val Default: SparkIcon = SparkIcons.AccountFill // R.drawable.spark_icons_user
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AccountOutline", "com.adevinta.spark.icons"))
        public val Outline: SparkIcon = SparkIcons.AccountOutline // R.drawable.spark_icons_user_outline
        @Deprecated("Use SparkIcons instead.")
        public object Group {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.GroupFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.GroupFill // R.drawable.spark_icons_user_group
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.GroupOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.GroupOutline // R.drawable.spark_icons_user_group_outline
        }

        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.VerifiedFill", "com.adevinta.spark.icons"))
        public val Verified: SparkIcon = SparkIcons.VerifiedFill // R.drawable.spark_icons_verified
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.ProfileFill", "com.adevinta.spark.icons"))
        public val Avatar: SparkIcon = SparkIcons.ProfileFill // R.drawable.spark_icons_avatar_part
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Store", "com.adevinta.spark.icons"))
        public val Store: SparkIcon = SparkIcons.Store // R.drawable.spark_icons_profile_pro1_grey
    }

    @Deprecated("Use SparkIcons instead.")
    public object Value {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.Minus", "com.adevinta.spark.icons"))
        public val Minus: SparkIcon = SparkIcons.Minus // R.drawable.spark_icons_minus_outline

        @Deprecated("Use SparkIcons instead.")
        public object More {
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AddFill", "com.adevinta.spark.icons"))
            public val Default: SparkIcon = SparkIcons.AddFill // R.drawable.spark_icons_more
        @Deprecated(message = "Use SparkIcons instead.", replaceWith = ReplaceWith("SparkIcons.AddOutline", "com.adevinta.spark.icons"))
            public val Outline: SparkIcon = SparkIcons.AddOutline // R.drawable.spark_icons_more_outline
        }
    }
}
