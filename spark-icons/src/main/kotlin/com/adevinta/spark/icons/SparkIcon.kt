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
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.BankFill", "com.adevinta.spark.icons"),
        )
        public val Account: DrawableRes = SparkIcons.BankFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Activity", "com.adevinta.spark.icons"),
        )
        public val Activity: DrawableRes = SparkIcons.Activity

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.HolidayFill", "com.adevinta.spark.icons"),
        )
        public val Booking: DrawableRes = SparkIcons.HolidayFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.BurgerMenu", "com.adevinta.spark.icons"),
        )
        public val BurgerMenu: DrawableRes = SparkIcons.BurgerMenu

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Close", "com.adevinta.spark.icons"),
        )
        public val Close: DrawableRes = SparkIcons.DeleteFill

        @Deprecated("Use SparkIcons instead.")
        public object Cv {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.CvFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.CvFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.CvOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: DrawableRes = SparkIcons.CvOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.FileOffFill", "com.adevinta.spark.icons"),
            )
            public val Disabled: DrawableRes = SparkIcons.FileOffFill
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CountryFill", "com.adevinta.spark.icons"),
        )
        public val France: DrawableRes = SparkIcons.CountryFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.House", "com.adevinta.spark.icons"),
        )
        public val House: DrawableRes = SparkIcons.House

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.IdentityOutline", "com.adevinta.spark.icons"),
        )
        public val Identity: DrawableRes = SparkIcons.IdentityOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.KeyFill", "com.adevinta.spark.icons"),
        )
        public val Key: DrawableRes = SparkIcons.KeyFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Listing", "com.adevinta.spark.icons"),
        )
        public val Listing: DrawableRes = SparkIcons.Listing

        @Deprecated("Use SparkIcons instead.")
        public object Offers {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.OfferFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.OfferFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.OfferOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: DrawableRes = SparkIcons.OfferOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FileOffFill", "com.adevinta.spark.icons"),
        )
        public val SalesProspecting: DrawableRes = SparkIcons.FileOffFill

        @Deprecated("Use SparkIcons instead.")
        public object SecurePayment {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.SecurityFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.SecurityFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.SecurityOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: DrawableRes = SparkIcons.SecurityOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Shop {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ShopingCartFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.ShopingCartFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ShopingCartOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: DrawableRes = SparkIcons.ShopingCartOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Store", "com.adevinta.spark.icons"),
        )
        public val Store: DrawableRes = SparkIcons.Store

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FavoriteFill", "com.adevinta.spark.icons"),
        )
        public val ThumbUp: DrawableRes = SparkIcons.FavoriteFill

        @Deprecated("Use SparkIcons instead.")
        public object Work {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.FavoriteOutline", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.FavoriteOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.WorkOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: DrawableRes = SparkIcons.WorkOutline
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object Actions {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CalculateFill", "com.adevinta.spark.icons"),
        )
        public val Calculate: DrawableRes = SparkIcons.CalculateFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CopyFill", "com.adevinta.spark.icons"),
        )
        public val Copy: DrawableRes = SparkIcons.CopyFill

        @Deprecated("Use SparkIcons instead.")
        public object Eyes {
            @Deprecated("Use SparkIcons instead.")
            public object Filled {
                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("SparkIcons.EyeFill", "com.adevinta.spark.icons"),
                )
                public val Enabled: DrawableRes = SparkIcons.EyeFill

                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("SparkIcons.EyeOffFill", "com.adevinta.spark.icons"),
                )
                public val Disabled: DrawableRes = SparkIcons.EyeOffFill
            }

            @Deprecated("Use SparkIcons instead.")
            public object Outlined {
                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("SparkIcons.EyeOutline", "com.adevinta.spark.icons"),
                )
                public val Enabled: DrawableRes = SparkIcons.EyeOutline

                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("SparkIcons.EyeOffOutline", "com.adevinta.spark.icons"),
                )
                public val Disabled: DrawableRes = SparkIcons.EyeOffOutline
            }
        }

        @Deprecated("Use SparkIcons instead.")
        public object Favorite {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.LikeFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.LikeFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.LikeOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: DrawableRes = SparkIcons.LikeOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Filter", "com.adevinta.spark.icons"),
        )
        public val Filter: DrawableRes = SparkIcons.Filter

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlashlightFill", "com.adevinta.spark.icons"),
        )
        public val Flashlight: DrawableRes = SparkIcons.FlashlightFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.MoreMenuVertical", "com.adevinta.spark.icons"),
        )
        public val More: DrawableRes = SparkIcons.MoreMenuVertical

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.PauseOutline", "com.adevinta.spark.icons"),
        )
        public val Pause: DrawableRes = SparkIcons.PauseOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.PlayOutline", "com.adevinta.spark.icons"),
        )
        public val Play: DrawableRes = SparkIcons.PlayOutline

        @Deprecated("Use SparkIcons instead.")
        public object Pen {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.PenFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.PenFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.PenOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: DrawableRes = SparkIcons.PenOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.PrintFill", "com.adevinta.spark.icons"),
        )
        public val Print: DrawableRes = SparkIcons.PrintFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Refresh", "com.adevinta.spark.icons"),
        )
        public val Refresh: DrawableRes = SparkIcons.Refresh

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Scan", "com.adevinta.spark.icons"),
        )
        public val Scan: DrawableRes = SparkIcons.Scan

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Search", "com.adevinta.spark.icons"),
        )
        public val Search: DrawableRes = SparkIcons.Search

        @Deprecated("Use SparkIcons instead.")
        public object Trash {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.TrashFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.TrashFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.TrashOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: DrawableRes = SparkIcons.TrashOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.TrashCloseFill", "com.adevinta.spark.icons"),
            )
            public val Close: DrawableRes = SparkIcons.TrashCloseFill
        }

        @Deprecated("Use SparkIcons instead.")
        public object Wheel {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.WheelFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.WheelFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.WheelOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: DrawableRes = SparkIcons.WheelOutline
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object Arrows {
        @Deprecated("Use SparkIcons instead.")
        public object Arrow {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ArrowLeft", "com.adevinta.spark.icons"),
            )
            public val Left: DrawableRes = SparkIcons.ArrowLeft

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ArrowRight", "com.adevinta.spark.icons"),
            )
            public val Right: DrawableRes = SparkIcons.ArrowRight
        }

        @Deprecated("Use SparkIcons instead.")
        public object Chevron {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ArrowVerticalLeft", "com.adevinta.spark.icons"),
            )
            public val Left: DrawableRes = SparkIcons.ArrowVerticalLeft

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ArrowVerticalRight", "com.adevinta.spark.icons"),
            )
            public val Right: DrawableRes = SparkIcons.ArrowVerticalRight

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ArrowHorizontalUp", "com.adevinta.spark.icons"),
            )
            public val Up: DrawableRes = SparkIcons.ArrowHorizontalUp

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ArrowHorizontalDown", "com.adevinta.spark.icons"),
            )
            public val Down: DrawableRes = SparkIcons.ArrowHorizontalDown
        }

        @Deprecated("Use SparkIcons instead.")
        public object DoubleChevron {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ArrowDoubleLeft", "com.adevinta.spark.icons"),
            )
            public val Left: DrawableRes = SparkIcons.ArrowDoubleLeft

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ArrowDoubleRight", "com.adevinta.spark.icons"),
            )
            public val Right: DrawableRes = SparkIcons.ArrowDoubleRight
        }

        @Deprecated("Use SparkIcons instead.")
        public object Close {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Close", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.Close

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.DeleteFill", "com.adevinta.spark.icons"),
            )
            public val Full: DrawableRes = SparkIcons.DeleteFill
        }

        @Deprecated("Use SparkIcons instead.")
        public object Chart {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.GraphArrowUp", "com.adevinta.spark.icons"),
            )
            public val Up: DrawableRes = SparkIcons.GraphArrowUp

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.GraphArrowDown", "com.adevinta.spark.icons"),
            )
            public val Down: DrawableRes = SparkIcons.GraphArrowDown
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object Calendar {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CalendarDotFill", "com.adevinta.spark.icons"),
        )
        public val Booking: DrawableRes = SparkIcons.CalendarDotFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CalendarFill", "com.adevinta.spark.icons"),
        )
        public val Default: DrawableRes = SparkIcons.CalendarFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CalendarValidFill", "com.adevinta.spark.icons"),
        )
        public val Valid: DrawableRes = SparkIcons.CalendarValidFill
    }

    @Deprecated("Use SparkIcons instead.")
    public object Categories {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Apartment", "com.adevinta.spark.icons"),
        )
        public val Apartment: DrawableRes = SparkIcons.Apartment

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CarOutline", "com.adevinta.spark.icons"),
        )
        public val Car: DrawableRes = SparkIcons.CarOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Couch", "com.adevinta.spark.icons"),
        )
        public val Couch: DrawableRes = SparkIcons.Couch

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Computer", "com.adevinta.spark.icons"),
        )
        public val Computer: DrawableRes = SparkIcons.Computer

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CategoriesClothesOutline", "com.adevinta.spark.icons"),
        )
        public val Clothes: DrawableRes = SparkIcons.CategoriesClothesOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Equipment", "com.adevinta.spark.icons"),
        )
        public val Equipment: DrawableRes = SparkIcons.Equipment

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Family", "com.adevinta.spark.icons"),
        )
        public val Family: DrawableRes = SparkIcons.Family

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Ground", "com.adevinta.spark.icons"),
        )
        public val Ground: DrawableRes = SparkIcons.Ground

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Hobby", "com.adevinta.spark.icons"),
        )
        public val Hobbies: DrawableRes = SparkIcons.Hobby

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Holidays", "com.adevinta.spark.icons"),
        )
        public val Holidays: DrawableRes = SparkIcons.Holidays

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.House", "com.adevinta.spark.icons"),
        )
        public val House: DrawableRes = SparkIcons.House

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Land", "com.adevinta.spark.icons"),
        )
        public val Land: DrawableRes = SparkIcons.Land

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Multimedia", "com.adevinta.spark.icons"),
        )
        public val Multimedia: DrawableRes = SparkIcons.Multimedia

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Parking", "com.adevinta.spark.icons"),
        )
        public val Parking: DrawableRes = SparkIcons.Parking

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.MoreMenuHorizontal", "com.adevinta.spark.icons"),
        )
        public val Pending: DrawableRes = SparkIcons.MoreMenuHorizontal

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Pets", "com.adevinta.spark.icons"),
        )
        public val Pets: DrawableRes = SparkIcons.Pets

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Service", "com.adevinta.spark.icons"),
        )
        public val Services: DrawableRes = SparkIcons.Service

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Job", "com.adevinta.spark.icons"),
        )
        public val Suitcase: DrawableRes = SparkIcons.Job
    }

    @Deprecated("Use SparkIcons instead.")
    public object Contact {
        @Deprecated("Use SparkIcons instead.")
        public object Mail {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.MailFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.MailFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.MailOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: DrawableRes = SparkIcons.MailOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Micro {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.VoiceFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.VoiceFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.VoiceOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: DrawableRes = SparkIcons.VoiceOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.VoiceOffFill", "com.adevinta.spark.icons"),
            )
            public val Disabled: DrawableRes = SparkIcons.VoiceOffFill
        }

        @Deprecated("Use SparkIcons instead.")
        public object Message {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.MessageFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.MessageFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.MessageOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: DrawableRes = SparkIcons.MessageOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Phone {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.PhoneFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.PhoneFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.PhoneOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: DrawableRes = SparkIcons.PhoneOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.CallOutline", "com.adevinta.spark.icons"),
            )
            public val Message: DrawableRes = SparkIcons.CallOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.SendFill", "com.adevinta.spark.icons"),
        )
        public val SendMessage: DrawableRes = SparkIcons.SendFill
    }

    @Deprecated("Use SparkIcons instead.")
    public object Criterias {
        @Deprecated("Use SparkIcons instead.")
        public object Animaux {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Age", "com.adevinta.spark.icons"),
            )
            public val Age: DrawableRes = SparkIcons.Age

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Loof", "com.adevinta.spark.icons"),
            )
            public val Loof: DrawableRes = SparkIcons.Loof

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Offer", "com.adevinta.spark.icons"),
            )
            public val Offre: DrawableRes = SparkIcons.Offer

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Litter", "com.adevinta.spark.icons"),
            )
            public val Portee: DrawableRes = SparkIcons.Litter

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Tattoo", "com.adevinta.spark.icons"),
            )
            public val Tatouage: DrawableRes = SparkIcons.Tattoo

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Animals", "com.adevinta.spark.icons"),
            )
            public val TypeDeLOffre: DrawableRes = SparkIcons.Animals

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Vaccine", "com.adevinta.spark.icons"),
            )
            public val Vaccin: DrawableRes = SparkIcons.Vaccine
        }

        @Deprecated("Use SparkIcons instead.")
        public object Automobile {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Loof", "com.adevinta.spark.icons"),
            )
            public val Loof: DrawableRes = SparkIcons.Loof

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Boat", "com.adevinta.spark.icons"),
            )
            public val Bateau: DrawableRes = SparkIcons.Boat

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Fuel", "com.adevinta.spark.icons"),
            )
            public val Carburant: DrawableRes = SparkIcons.Fuel

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Color", "com.adevinta.spark.icons"),
            )
            public val Couleur: DrawableRes = SparkIcons.Color

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Cylindrical", "com.adevinta.spark.icons"),
            )
            public val Cylindree: DrawableRes = SparkIcons.Cylindrical

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Energy", "com.adevinta.spark.icons"),
            )
            public val Energie: DrawableRes = SparkIcons.Energy

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Power", "com.adevinta.spark.icons"),
            )
            public val Puissance: DrawableRes = SparkIcons.Power

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Mileage", "com.adevinta.spark.icons"),
            )
            public val Kilometrage: DrawableRes = SparkIcons.Mileage

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Moto", "com.adevinta.spark.icons"),
            )
            public val Moto: DrawableRes = SparkIcons.Moto

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.License", "com.adevinta.spark.icons"),
            )
            public val Permis: DrawableRes = SparkIcons.License

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Seats", "com.adevinta.spark.icons"),
            )
            public val Places: DrawableRes = SparkIcons.Seats

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Doors", "com.adevinta.spark.icons"),
            )
            public val Portes: DrawableRes = SparkIcons.Doors

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.CalendarCriterias", "com.adevinta.spark.icons"),
            )
            public val Regdate: DrawableRes = SparkIcons.CalendarCriterias

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Type", "com.adevinta.spark.icons"),
            )
            public val Type: DrawableRes = SparkIcons.Type

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Speed", "com.adevinta.spark.icons"),
            )
            public val Vitesse: DrawableRes = SparkIcons.Speed

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Trunk", "com.adevinta.spark.icons"),
            )
            public val Coffre: DrawableRes = SparkIcons.Trunk
        }

        @Deprecated("Use SparkIcons instead.")
        public object Emploi {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.EducationalLevel", "com.adevinta.spark.icons"),
            )
            public val EducationalLevel: DrawableRes = SparkIcons.EducationalLevel

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Experience", "com.adevinta.spark.icons"),
            )
            public val Experience: DrawableRes = SparkIcons.Experience

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Function", "com.adevinta.spark.icons"),
            )
            public val Fonction: DrawableRes = SparkIcons.Function

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Salary", "com.adevinta.spark.icons"),
            )
            public val Salaire: DrawableRes = SparkIcons.Salary

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Sector", "com.adevinta.spark.icons"),
            )
            public val Secteur: DrawableRes = SparkIcons.Sector

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Time", "com.adevinta.spark.icons"),
            )
            public val Temps: DrawableRes = SparkIcons.Time

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Type", "com.adevinta.spark.icons"),
            )
            public val Type: DrawableRes = SparkIcons.Type
        }

        @Deprecated("Use SparkIcons instead.")
        public object Generique {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.LikeOutline", "com.adevinta.spark.icons"),
            )
            public val Defaut1: DrawableRes = SparkIcons.LikeOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Listing", "com.adevinta.spark.icons"),
            )
            public val Defaut2: DrawableRes = SparkIcons.Listing

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Donate", "com.adevinta.spark.icons"),
            )
            public val Donate: DrawableRes = SparkIcons.Donate

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Smoking", "com.adevinta.spark.icons"),
            )
            public val Smoking: DrawableRes = SparkIcons.Smoking

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Localisation", "com.adevinta.spark.icons"),
            )
            public val Localisation: DrawableRes = SparkIcons.Localisation

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Delivery", "com.adevinta.spark.icons"),
            )
            public val Delivery: DrawableRes = SparkIcons.Delivery
        }

        @Deprecated("Use SparkIcons instead.")
        public object Immobilier {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Class", "com.adevinta.spark.icons"),
            )
            public val Classe: DrawableRes = SparkIcons.Class

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Class", "com.adevinta.spark.icons"),
            )
            public val Ges: DrawableRes = SparkIcons.Class

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Honoraria", "com.adevinta.spark.icons"),
            )
            public val Honoraires: DrawableRes = SparkIcons.Honoraria

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Furniture", "com.adevinta.spark.icons"),
            )
            public val Meuble: DrawableRes = SparkIcons.Furniture

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Pieces", "com.adevinta.spark.icons"),
            )
            public val Pieces: DrawableRes = SparkIcons.Pieces

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Reference", "com.adevinta.spark.icons"),
            )
            public val Reference: DrawableRes = SparkIcons.Reference

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Surface", "com.adevinta.spark.icons"),
            )
            public val Surface: DrawableRes = SparkIcons.Surface

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.HousingType", "com.adevinta.spark.icons"),
            )
            public val TypeDeBien: DrawableRes = SparkIcons.HousingType

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.SaleType", "com.adevinta.spark.icons"),
            )
            public val TypeDeVente: DrawableRes = SparkIcons.SaleType
        }

        @Deprecated("Use SparkIcons instead.")
        public object ImmobilierNeuf {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Balcony", "com.adevinta.spark.icons"),
            )
            public val Balcon: DrawableRes = SparkIcons.Balcony

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Cave", "com.adevinta.spark.icons"),
            )
            public val Cave: DrawableRes = SparkIcons.Cave

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Duplex", "com.adevinta.spark.icons"),
            )
            public val Duplex: DrawableRes = SparkIcons.Duplex

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Floor", "com.adevinta.spark.icons"),
            )
            public val Etage: DrawableRes = SparkIcons.Floor

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Garage", "com.adevinta.spark.icons"),
            )
            public val Garage: DrawableRes = SparkIcons.Garage

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Garden", "com.adevinta.spark.icons"),
            )
            public val Jardin: DrawableRes = SparkIcons.Garden

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Loggia", "com.adevinta.spark.icons"),
            )
            public val Loggia: DrawableRes = SparkIcons.Loggia

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.SunOrientation", "com.adevinta.spark.icons"),
            )
            public val Orientation: DrawableRes = SparkIcons.SunOrientation

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Parking", "com.adevinta.spark.icons"),
            )
            public val Parking: DrawableRes = SparkIcons.Parking

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Terrace", "com.adevinta.spark.icons"),
            )
            public val Terrasse: DrawableRes = SparkIcons.Terrace
        }

        @Deprecated("Use SparkIcons instead.")
        public object Location {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Cave", "com.adevinta.spark.icons"),
            )
            public val Cave: DrawableRes = SparkIcons.Cave

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Calm", "com.adevinta.spark.icons"),
            )
            public val Calme: DrawableRes = SparkIcons.Calm

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Cave", "com.adevinta.spark.icons"),
            )
            public val Cave2: DrawableRes = SparkIcons.Cave

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Fireplace", "com.adevinta.spark.icons"),
            )
            public val Chemine: DrawableRes = SparkIcons.Fireplace

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.LastFloor", "com.adevinta.spark.icons"),
            )
            public val DernierEtage: DrawableRes = SparkIcons.LastFloor

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Digicode", "com.adevinta.spark.icons"),
            )
            public val Digicode: DrawableRes = SparkIcons.Digicode

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.GlassWindows", "com.adevinta.spark.icons"),
            )
            public val BaiesVitrees: DrawableRes = SparkIcons.GlassWindows

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Janitor", "com.adevinta.spark.icons"),
            )
            public val Concierge: DrawableRes = SparkIcons.Janitor

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Attic", "com.adevinta.spark.icons"),
            )
            public val Combles: DrawableRes = SparkIcons.Attic

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.BeautifulBuilding", "com.adevinta.spark.icons"),
            )
            public val BeauBatiment: DrawableRes = SparkIcons.BeautifulBuilding

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Interphone", "com.adevinta.spark.icons"),
            )
            public val Interphone: DrawableRes = SparkIcons.Interphone

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Loft", "com.adevinta.spark.icons"),
            )
            public val Loft: DrawableRes = SparkIcons.Loft

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Light", "com.adevinta.spark.icons"),
            )
            public val Lumineux: DrawableRes = SparkIcons.Light

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Common", "com.adevinta.spark.icons"),
            )
            public val Mitoyen: DrawableRes = SparkIcons.Common

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Moulding", "com.adevinta.spark.icons"),
            )
            public val Mouture: DrawableRes = SparkIcons.Moulding

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Parquet", "com.adevinta.spark.icons"),
            )
            public val Parquet: DrawableRes = SparkIcons.Parquet

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Wardrobe", "com.adevinta.spark.icons"),
            )
            public val Penderie: DrawableRes = SparkIcons.Wardrobe

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Metro", "com.adevinta.spark.icons"),
            )
            public val Metro: DrawableRes = SparkIcons.Metro

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.StoreOutline", "com.adevinta.spark.icons"),
            )
            public val Magasin: DrawableRes = SparkIcons.StoreOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Shower", "com.adevinta.spark.icons"),
            )
            public val Douche: DrawableRes = SparkIcons.Shower

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Renovation", "com.adevinta.spark.icons"),
            )
            public val Renove: DrawableRes = SparkIcons.Renovation

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Bath", "com.adevinta.spark.icons"),
            )
            public val Baignoire: DrawableRes = SparkIcons.Bath

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.View", "com.adevinta.spark.icons"),
            )
            public val Vue: DrawableRes = SparkIcons.View

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.SeaView", "com.adevinta.spark.icons"),
            )
            public val VueMer: DrawableRes = SparkIcons.SeaView

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Wc", "com.adevinta.spark.icons"),
            )
            public val Wc: DrawableRes = SparkIcons.Wc

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Lift", "com.adevinta.spark.icons"),
            )
            public val Ascenseur: DrawableRes = SparkIcons.Lift

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ChargesIncluded", "com.adevinta.spark.icons"),
            )
            public val ChargesComprises: DrawableRes = SparkIcons.ChargesIncluded
        }

        @Deprecated("Use SparkIcons instead.")
        public object Loisirs {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Toy", "com.adevinta.spark.icons"),
            )
            public val Jouet: DrawableRes = SparkIcons.Toy

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.BicycleType", "com.adevinta.spark.icons"),
            )
            public val BicycleType: DrawableRes = SparkIcons.BicycleType

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ToysProduct", "com.adevinta.spark.icons"),
            )
            public val ToysProduct: DrawableRes = SparkIcons.ToysProduct
        }

        @Deprecated("Use SparkIcons instead.")
        public object Maison {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.DiyProduct", "com.adevinta.spark.icons"),
            )
            public val DiyProduct: DrawableRes = SparkIcons.DiyProduct

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.DiyType", "com.adevinta.spark.icons"),
            )
            public val DiyType: DrawableRes = SparkIcons.DiyType

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.HomeappliancesProduct", "com.adevinta.spark.icons"),
            )
            public val HomeAppliancesProduct: DrawableRes = SparkIcons.HomeappliancesProduct

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.HomeappliancesType", "com.adevinta.spark.icons"),
            )
            public val HomeAppliancesType: DrawableRes = SparkIcons.HomeappliancesType

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.GardeningProduct", "com.adevinta.spark.icons"),
            )
            public val GardeningProduct: DrawableRes = SparkIcons.GardeningProduct

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.GardeningType", "com.adevinta.spark.icons"),
            )
            public val GardeningType: DrawableRes = SparkIcons.GardeningType

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.LinensProduct", "com.adevinta.spark.icons"),
            )
            public val LinensProduct: DrawableRes = SparkIcons.LinensProduct

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.LinensType", "com.adevinta.spark.icons"),
            )
            public val LinensType: DrawableRes = SparkIcons.LinensType

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.TableArtMaterial", "com.adevinta.spark.icons"),
            )
            public val TableArtMaterial: DrawableRes = SparkIcons.TableArtMaterial

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.TableArtProduct", "com.adevinta.spark.icons"),
            )
            public val TableArtProduct: DrawableRes = SparkIcons.TableArtProduct

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.FurnitureType", "com.adevinta.spark.icons"),
            )
            public val FournitureType: DrawableRes = SparkIcons.FurnitureType
        }

        @Deprecated("Use SparkIcons instead.")
        public object Mode {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.EquipmentBaby", "com.adevinta.spark.icons"),
            )
            public val EquipementBebe: DrawableRes = SparkIcons.EquipmentBaby

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Color", "com.adevinta.spark.icons"),
            )
            public val Couleur: DrawableRes = SparkIcons.Color

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Condition", "com.adevinta.spark.icons"),
            )
            public val Etat: DrawableRes = SparkIcons.Condition

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.OfferOutline", "com.adevinta.spark.icons"),
            )
            public val Marque: DrawableRes = SparkIcons.OfferOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Material", "com.adevinta.spark.icons"),
            )
            public val Matiere: DrawableRes = SparkIcons.Material

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Luxe", "com.adevinta.spark.icons"),
            )
            public val Luxe: DrawableRes = SparkIcons.Luxe

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ShoeSize", "com.adevinta.spark.icons"),
            )
            public val Pointure: DrawableRes = SparkIcons.ShoeSize

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Size", "com.adevinta.spark.icons"),
            )
            public val Taille: DrawableRes = SparkIcons.Size

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Jewels", "com.adevinta.spark.icons"),
            )
            public val Bijoux: DrawableRes = SparkIcons.Jewels

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Shoes", "com.adevinta.spark.icons"),
            )
            public val Chaussure: DrawableRes = SparkIcons.Shoes

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Clothes", "com.adevinta.spark.icons"),
            )
            public val Vetements: DrawableRes = SparkIcons.Clothes

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Univers", "com.adevinta.spark.icons"),
            )
            public val Univers: DrawableRes = SparkIcons.Univers
        }

        @Deprecated("Use SparkIcons instead.")
        public object Multimedia {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Condition", "com.adevinta.spark.icons"),
            )
            public val Etat: DrawableRes = SparkIcons.Condition

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Memory", "com.adevinta.spark.icons"),
            )
            public val Memoire: DrawableRes = SparkIcons.Memory

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Model", "com.adevinta.spark.icons"),
            )
            public val Modele: DrawableRes = SparkIcons.Model

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Color", "com.adevinta.spark.icons"),
            )
            public val Couleur: DrawableRes = SparkIcons.Color

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Model", "com.adevinta.spark.icons"),
            )
            public val Marque: DrawableRes = SparkIcons.Model

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Type", "com.adevinta.spark.icons"),
            )
            public val Type: DrawableRes = SparkIcons.Type
        }

        @Deprecated("Use SparkIcons instead.")
        public object Vacances {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Animals", "com.adevinta.spark.icons"),
            )
            public val Animaux: DrawableRes = SparkIcons.Animals

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Capacity", "com.adevinta.spark.icons"),
            )
            public val Capacite: DrawableRes = SparkIcons.Capacity

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Rooms", "com.adevinta.spark.icons"),
            )
            public val Chambres: DrawableRes = SparkIcons.Rooms

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Arrival", "com.adevinta.spark.icons"),
            )
            public val Arrive: DrawableRes = SparkIcons.Arrival

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Start", "com.adevinta.spark.icons"),
            )
            public val Depart: DrawableRes = SparkIcons.Start

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Rating", "com.adevinta.spark.icons"),
            )
            public val NombreEtoiles: DrawableRes = SparkIcons.Rating

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.AirConditioning", "com.adevinta.spark.icons"),
            )
            public val Climatisation: DrawableRes = SparkIcons.AirConditioning

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Sport", "com.adevinta.spark.icons"),
            )
            public val SalleSport: DrawableRes = SparkIcons.Sport

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Breakfast", "com.adevinta.spark.icons"),
            )
            public val PetitDejeune: DrawableRes = SparkIcons.Breakfast

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Spa", "com.adevinta.spark.icons"),
            )
            public val Spa: DrawableRes = SparkIcons.Spa

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Tv", "com.adevinta.spark.icons"),
            )
            public val Tv: DrawableRes = SparkIcons.Tv

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Welcome", "com.adevinta.spark.icons"),
            )
            public val Acceuil: DrawableRes = SparkIcons.Welcome

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Wifi", "com.adevinta.spark.icons"),
            )
            public val Wifi: DrawableRes = SparkIcons.Wifi

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Clean", "com.adevinta.spark.icons"),
            )
            public val LabelSanitaire2: DrawableRes = SparkIcons.Clean

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.HousingType", "com.adevinta.spark.icons"),
            )
            public val TypeLogement: DrawableRes = SparkIcons.HousingType

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Garden", "com.adevinta.spark.icons"),
            )
            public val Jardin: DrawableRes = SparkIcons.Garden

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Parking", "com.adevinta.spark.icons"),
            )
            public val Parking: DrawableRes = SparkIcons.Parking

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Pool", "com.adevinta.spark.icons"),
            )
            public val Piscine: DrawableRes = SparkIcons.Pool

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Accessories", "com.adevinta.spark.icons"),
            )
            public val Accessories: DrawableRes = SparkIcons.Accessories

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.CalendarCriterias", "com.adevinta.spark.icons"),
            )
            public val Date: DrawableRes = SparkIcons.CalendarCriterias
        }

        @Deprecated("Use SparkIcons instead.")
        public object MaterialTools {
            @Deprecated("Use SparkIcons instead.")
            public object Tools {
                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("SparkIcons.Tools", "com.adevinta.spark.icons"),
                )
                public val Agriculture: DrawableRes = SparkIcons.Tools
            }
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object Flags {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagAT", "com.adevinta.spark.icons"),
        )
        public val FlagAT: DrawableRes = SparkIcons.FlagAT

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagBE", "com.adevinta.spark.icons"),
        )
        public val FlagBE: DrawableRes = SparkIcons.FlagBE

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagBR", "com.adevinta.spark.icons"),
        )
        public val FlagBR: DrawableRes = SparkIcons.FlagBR

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagBY", "com.adevinta.spark.icons"),
        )
        public val FlagBY: DrawableRes = SparkIcons.FlagBY

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagCH", "com.adevinta.spark.icons"),
        )
        public val FlagCH: DrawableRes = SparkIcons.FlagCH

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagCL", "com.adevinta.spark.icons"),
        )
        public val FlagCL: DrawableRes = SparkIcons.FlagCL

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagCO", "com.adevinta.spark.icons"),
        )
        public val FlagCO: DrawableRes = SparkIcons.FlagCO

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagDO", "com.adevinta.spark.icons"),
        )
        public val FlagDO: DrawableRes = SparkIcons.FlagDO

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagES", "com.adevinta.spark.icons"),
        )
        public val FlagES: DrawableRes = SparkIcons.FlagES

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagFI", "com.adevinta.spark.icons"),
        )
        public val FlagFI: DrawableRes = SparkIcons.FlagFI

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagFR", "com.adevinta.spark.icons"),
        )
        public val FlagFR: DrawableRes = SparkIcons.FlagFR

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagHU", "com.adevinta.spark.icons"),
        )
        public val FlagHU: DrawableRes = SparkIcons.FlagHU

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagID", "com.adevinta.spark.icons"),
        )
        public val FlagID: DrawableRes = SparkIcons.FlagID

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagIE", "com.adevinta.spark.icons"),
        )
        public val FlagIE: DrawableRes = SparkIcons.FlagIE

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagIT", "com.adevinta.spark.icons"),
        )
        public val FlagIT: DrawableRes = SparkIcons.FlagIT

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagMA", "com.adevinta.spark.icons"),
        )
        public val FlagMA: DrawableRes = SparkIcons.FlagMA

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagMX", "com.adevinta.spark.icons"),
        )
        public val FlagMX: DrawableRes = SparkIcons.FlagMX

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagMY", "com.adevinta.spark.icons"),
        )
        public val FlagMY: DrawableRes = SparkIcons.FlagMY

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagPT", "com.adevinta.spark.icons"),
        )
        public val FlagPT: DrawableRes = SparkIcons.FlagPT

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagSE", "com.adevinta.spark.icons"),
        )
        public val FlagSE: DrawableRes = SparkIcons.FlagSE

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagTN", "com.adevinta.spark.icons"),
        )
        public val FlagTN: DrawableRes = SparkIcons.FlagTN

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagVN", "com.adevinta.spark.icons"),
        )
        public val FlagVN: DrawableRes = SparkIcons.FlagVN
    }

    @Deprecated("Use SparkIcons instead.")
    public object Images {
        @Deprecated("Use SparkIcons instead.")
        public object Camera {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.CameraFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.CameraFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.CameraOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.CameraOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.AddImageOutline", "com.adevinta.spark.icons"),
            )
            public val More: DrawableRes = SparkIcons.AddImageOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.GalleryFill", "com.adevinta.spark.icons"),
        )
        public val Library: DrawableRes = SparkIcons.GalleryFill

        @Deprecated("Use SparkIcons instead.")
        public object NewAd {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.AddSquareFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.AddSquareFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.AddSquareOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.AddSquareOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.NoPhoto", "com.adevinta.spark.icons"),
        )
        public val NoPhoto: DrawableRes = SparkIcons.NoPhoto

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.ErrorPhotoOutline", "com.adevinta.spark.icons"),
        )
        public val ErrorPhoto: DrawableRes = SparkIcons.ErrorPhoto

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.NoPhoto", "com.adevinta.spark.icons"),
        )
        public val NoPhoto2: DrawableRes = SparkIcons.NoPhoto

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.RotateImage", "com.adevinta.spark.icons"),
        )
        public val Rotate: DrawableRes = SparkIcons.RotateImage
    }

    @Deprecated("Use SparkIcons instead.")
    public object Infos {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CameraFill", "com.adevinta.spark.icons"),
        )
        public val Camera: DrawableRes = SparkIcons.CameraFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Block", "com.adevinta.spark.icons"),
        )
        public val Block: DrawableRes = SparkIcons.Block

        @Deprecated("Use SparkIcons instead.")
        public object Alert {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.AlertFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.AlertFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.AlertOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.AlertOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Ask {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.QuestionFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.QuestionFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.QuestionOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.QuestionOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Info {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.InfoFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.InfoFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.InfoOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.InfoOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object LightBulb {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.IdeaFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.IdeaFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.IdeaOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.IdeaOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Lock {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.LockFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.LockFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.LockOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.LockOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.UnlockOutline", "com.adevinta.spark.icons"),
            )
            public val Open: DrawableRes = SparkIcons.UnlockOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.WarningFill", "com.adevinta.spark.icons"),
        )
        public val Warning: DrawableRes = SparkIcons.WarningFill
    }

    @Deprecated("Use SparkIcons instead.")
    public object Delivery {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.DeliveryHandsOutline", "com.adevinta.spark.icons"),
        )
        public val DeliveryHand: DrawableRes = SparkIcons.DeliveryHandsOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.DeliveryOutline", "com.adevinta.spark.icons"),
        )
        public val DeliveryOutline: DrawableRes = SparkIcons.DeliveryOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.DeliveryTruckOutline", "com.adevinta.spark.icons"),
        )
        public val Truck: DrawableRes = SparkIcons.DeliveryTruckOutline

        @Deprecated("Use SparkIcons instead.")
        public object Mailbox {
            @Deprecated("Use SparkIcons instead.")
            public object Close {
                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("MailCloseFill", "com.adevinta.spark.icons"),
                )
                public val Down: DrawableRes = SparkIcons.MailCloseFill

                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("MailCloseFill", "com.adevinta.spark.icons"),
                )
                public val Up: DrawableRes = SparkIcons.MailCloseFill
            }

            @Deprecated("Use SparkIcons instead.")
            public object Open {
                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("SparkIcons.MailOpenFill", "com.adevinta.spark.icons"),
                )
                public val Down: DrawableRes = SparkIcons.MailOpenFill

                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("SparkIcons.MailOpenFill", "com.adevinta.spark.icons"),
                )
                public val Up: DrawableRes = SparkIcons.MailOpenFill
            }
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object Map {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.ThreeSixty", "com.adevinta.spark.icons"),
        )
        public val ThreeSixty: DrawableRes = SparkIcons.ThreeSixty

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Bike", "com.adevinta.spark.icons"),
        )
        public val Bike: DrawableRes = SparkIcons.Bike

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AllDirection", "com.adevinta.spark.icons"),
        )
        public val Drag: DrawableRes = SparkIcons.AllDirection

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.MapExpand", "com.adevinta.spark.icons"),
        )
        public val Expand: DrawableRes = SparkIcons.MapExpand

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.TargetOutline", "com.adevinta.spark.icons"),
        )
        public val Geoloc: DrawableRes = SparkIcons.TargetOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.HotelFill", "com.adevinta.spark.icons"),
        )
        public val Hotel: DrawableRes = SparkIcons.HotelFill

        @Deprecated("Use SparkIcons instead.")
        public object Marker {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.PinFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.PinFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.PinOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.PinOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Near {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.MapCursorFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.MapCursorFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.MapCursorOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.MapCursorOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.MapExpand", "com.adevinta.spark.icons"),
        )
        public val SimpleExpand: DrawableRes = SparkIcons.MapExpand

        @Deprecated("Use SparkIcons instead.")
        public object Train {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.TrainFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.TrainFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.TrainOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.TrainOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.WalkerFill", "com.adevinta.spark.icons"),
        )
        public val Walker: DrawableRes = SparkIcons.WalkerFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CarOutline", "com.adevinta.spark.icons"),
        )
        public val Car: DrawableRes = SparkIcons.CarOutline
    }

    @Deprecated("Use SparkIcons instead.")
    public object Navs {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AlarmOnFill", "com.adevinta.spark.icons"),
        )
        public val Arrow: DrawableRes = SparkIcons.AlarmOnFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.BurgerMenu", "com.adevinta.spark.icons"),
        )
        public val Drawer: DrawableRes = SparkIcons.BurgerMenu

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Close", "com.adevinta.spark.icons"),
        )
        public val Close: DrawableRes = SparkIcons.Close
    }

    @Deprecated("Use SparkIcons instead.")
    public object Notifications {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AlarmOnFill", "com.adevinta.spark.icons"),
        )
        public val Active: DrawableRes = SparkIcons.AlarmOnFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AlarmFill", "com.adevinta.spark.icons"),
        )
        public val Default: DrawableRes = SparkIcons.AlarmFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AlarmOffFill", "com.adevinta.spark.icons"),
        )
        public val Disable: DrawableRes = SparkIcons.AlarmOffFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AlarmOutline", "com.adevinta.spark.icons"),
        )
        public val Outline: DrawableRes = SparkIcons.AlarmOutline
    }

    @Deprecated("Use SparkIcons instead.")
    public object Options {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.BoosterFill", "com.adevinta.spark.icons"),
        )
        public val Booster: DrawableRes = SparkIcons.BoosterFill

        @Deprecated("Use SparkIcons instead.")
        public object Clock {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ClockArrow", "com.adevinta.spark.icons"),
            )
            public val Arrow: DrawableRes = SparkIcons.ClockArrow

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ClockFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.ClockFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ClockOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.ClockOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.MoneyFill", "com.adevinta.spark.icons"),
        )
        public val Credit: DrawableRes = SparkIcons.MoneyFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlashlightFill", "com.adevinta.spark.icons"),
        )
        public val Flash: DrawableRes = SparkIcons.FlashlightFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.MoveUp", "com.adevinta.spark.icons"),
        )
        public val MoveUp: DrawableRes = SparkIcons.MoveUp

        @Deprecated("Use SparkIcons instead.")
        public object SpotLight {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.BookmarkFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.BookmarkFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.BookmarkOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.BookmarkOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Star {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.StarFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.StarFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.StarOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.StarOutline
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object Others {
        @Deprecated("Use SparkIcons instead.")
        public object Megaphone {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.MegaphoneFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.MegaphoneFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.MegaphoneOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.MegaphoneOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.SpeedmeterOutline", "com.adevinta.spark.icons"),
        )
        public val SpeedoMeter: DrawableRes = SparkIcons.SpeedmeterOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.DissatisfiedOutline", "com.adevinta.spark.icons"),
        )
        public val Dissatisfied: DrawableRes = SparkIcons.DissatisfiedOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Euro", "com.adevinta.spark.icons"),
        )
        public val Euro: DrawableRes = SparkIcons.Euro

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagOutline", "com.adevinta.spark.icons"),
        )
        public val FlagOutline: DrawableRes = SparkIcons.FlagOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.SatisfiedOutline", "com.adevinta.spark.icons"),
        )
        public val Satisfied: DrawableRes = SparkIcons.SatisfiedOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.BoxOutline", "com.adevinta.spark.icons"),
        )
        public val Package: DrawableRes = SparkIcons.BoxOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Refund", "com.adevinta.spark.icons"),
        )
        public val Refund: DrawableRes = SparkIcons.Refund
    }

    @Deprecated("Use SparkIcons instead.")
    public object Paiement {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CarWarrantyOutline", "com.adevinta.spark.icons"),
        )
        public val GarantiePanne: DrawableRes = SparkIcons.CarWarrantyOutline
    }

    @Deprecated("Use SparkIcons instead.")
    public object Pro {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.ProCursorOutline", "com.adevinta.spark.icons"),
        )
        public val Actions: DrawableRes = SparkIcons.ProCursorOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AppearanceFill", "com.adevinta.spark.icons"),
        )
        public val Apparitions: DrawableRes = SparkIcons.AppearanceFill

        @Deprecated("Use SparkIcons instead.")
        public object Download {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.DownloadFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.DownloadFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.DownloadOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.DownloadOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.GraphOutline", "com.adevinta.spark.icons"),
        )
        public val MyPro: DrawableRes = SparkIcons.GraphOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.RocketOutline", "com.adevinta.spark.icons"),
        )
        public val SpaceShip: DrawableRes = SparkIcons.RocketOutline
    }

    @Deprecated("Use SparkIcons instead.")
    public object Share {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AttachFileOutline", "com.adevinta.spark.icons"),
        )
        public val AttachFile: DrawableRes = SparkIcons.AttachFileOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FacebookFill", "com.adevinta.spark.icons"),
        )
        public val Facebook: DrawableRes = SparkIcons.FacebookFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Messenger", "com.adevinta.spark.icons"),
        )
        public val Messenger: DrawableRes = SparkIcons.Messenger

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Pinterest", "com.adevinta.spark.icons"),
        )
        public val Pinterest: DrawableRes = SparkIcons.Pinterest

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.InstagramOutline", "com.adevinta.spark.icons"),
        )
        public val Instagram: DrawableRes = SparkIcons.InstagramOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.ShareExpand", "com.adevinta.spark.icons"),
        )
        public val Goto: DrawableRes = SparkIcons.ShareExpand

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Link", "com.adevinta.spark.icons"),
        )
        public val Link: DrawableRes = SparkIcons.Link

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.ShareFill", "com.adevinta.spark.icons"),
        )
        public val ShareDefault: DrawableRes = SparkIcons.ShareFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.ForwardFill", "com.adevinta.spark.icons"),
        )
        public val ShareArrow: DrawableRes = SparkIcons.ForwardFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.TwitterFill", "com.adevinta.spark.icons"),
        )
        public val Twitter: DrawableRes = SparkIcons.TwitterFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Whatsapp", "com.adevinta.spark.icons"),
        )
        public val WhatsApp: DrawableRes = SparkIcons.Whatsapp

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Export", "com.adevinta.spark.icons"),
        )
        public val Upload: DrawableRes = SparkIcons.Export

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Import", "com.adevinta.spark.icons"),
        )
        public val Download: DrawableRes = SparkIcons.Import
    }

    @Deprecated("Use SparkIcons instead.")
    public object Toggles {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Plus", "com.adevinta.spark.icons"),
        )
        public val Add: DrawableRes = SparkIcons.Plus

        @Deprecated("Use SparkIcons instead.")
        public object Check {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ValidFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.ValidFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ValidOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.ValidOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.CheckFill", "com.adevinta.spark.icons"),
            )
            public val Simple: DrawableRes = SparkIcons.CheckFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.DoubleCheckFill", "com.adevinta.spark.icons"),
            )
            public val Double: DrawableRes = SparkIcons.DoubleCheckFill
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object User {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.ProOutline", "com.adevinta.spark.icons"),
        )
        public val Pro: DrawableRes = SparkIcons.ProOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AccountFill", "com.adevinta.spark.icons"),
        )
        public val Default: DrawableRes = SparkIcons.AccountFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AccountOutline", "com.adevinta.spark.icons"),
        )
        public val Outline: DrawableRes = SparkIcons.AccountOutline

        @Deprecated("Use SparkIcons instead.")
        public object Group {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.GroupFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.GroupFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.GroupOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.GroupOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.VerifiedFill", "com.adevinta.spark.icons"),
        )
        public val Verified: DrawableRes = SparkIcons.VerifiedFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AvatarFill", "com.adevinta.spark.icons"),
        )
        public val Avatar: DrawableRes = SparkIcons.AvatarFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Store", "com.adevinta.spark.icons"),
        )
        public val Store: DrawableRes = SparkIcons.Store
    }

    @Deprecated("Use SparkIcons instead.")
    public object Value {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.RemoveOutline", "com.adevinta.spark.icons"),
        )
        public val Minus: DrawableRes = SparkIcons.RemoveOutline

        @Deprecated("Use SparkIcons instead.")
        public object More {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.AddFill", "com.adevinta.spark.icons"),
            )
            public val Default: DrawableRes = SparkIcons.AddFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.AddOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: DrawableRes = SparkIcons.AddOutline
        }
    }
}

@Deprecated(
    message = "Use SparkIcons.ClockArrow instead.",
    replaceWith = ReplaceWith("SparkIcons.ClockArrow", "com.adevinta.spark.icons"),
)
public val SparkIcons.ClockArrowFill: SparkIcon.DrawableRes get() = SparkIcons.ClockArrow

@Deprecated(
    message = "Use SparkIcons.ClockArrow instead.",
    replaceWith = ReplaceWith("SparkIcons.ClockArrow", "com.adevinta.spark.icons"),
)
public val SparkIcons.ClockArrowOutline: SparkIcon.DrawableRes get() = SparkIcons.ClockArrow

@Deprecated(
    message = "Use SparkIcons.ErrorPhoto instead.",
    replaceWith = ReplaceWith("SparkIcons.ErrorPhoto", "com.adevinta.spark.icons"),
)
public val SparkIcons.ErrorPhotoOutline: SparkIcon.DrawableRes get() = SparkIcons.ErrorPhoto
