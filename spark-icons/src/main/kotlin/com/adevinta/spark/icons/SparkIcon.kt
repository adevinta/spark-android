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
        public val Account: SparkIcon = SparkIcons.BankFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Activity", "com.adevinta.spark.icons"),
        )
        public val Activity: SparkIcon = SparkIcons.Activity

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.HolidayFill", "com.adevinta.spark.icons"),
        )
        public val Booking: SparkIcon = SparkIcons.HolidayFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.BurgerMenu", "com.adevinta.spark.icons"),
        )
        public val BurgerMenu: SparkIcon = SparkIcons.BurgerMenu

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Close", "com.adevinta.spark.icons"),
        )
        public val Close: SparkIcon = SparkIcons.DeleteFill

        @Deprecated("Use SparkIcons instead.")
        public object Cv {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.CvFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.CvFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.CvOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: SparkIcon = SparkIcons.CvOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.FileOffFill", "com.adevinta.spark.icons"),
            )
            public val Disabled: SparkIcon = SparkIcons.FileOffFill
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CountryFill", "com.adevinta.spark.icons"),
        )
        public val France: SparkIcon = SparkIcons.CountryFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.House", "com.adevinta.spark.icons"),
        )
        public val House: SparkIcon = SparkIcons.House

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.IdentityOutline", "com.adevinta.spark.icons"),
        )
        public val Identity: SparkIcon = SparkIcons.IdentityOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.KeyFill", "com.adevinta.spark.icons"),
        )
        public val Key: SparkIcon = SparkIcons.KeyFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Listing", "com.adevinta.spark.icons"),
        )
        public val Listing: SparkIcon = SparkIcons.Listing

        @Deprecated("Use SparkIcons instead.")
        public object Offers {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.OfferFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.OfferFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.OfferOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: SparkIcon = SparkIcons.OfferOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FileOffFill", "com.adevinta.spark.icons"),
        )
        public val SalesProspecting: SparkIcon = SparkIcons.FileOffFill

        @Deprecated("Use SparkIcons instead.")
        public object SecurePayment {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.SecurityFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.SecurityFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.SecurityOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: SparkIcon = SparkIcons.SecurityOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Shop {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ShopingCartFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.ShopingCartFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ShopingCartOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: SparkIcon = SparkIcons.ShopingCartOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Store", "com.adevinta.spark.icons"),
        )
        public val Store: SparkIcon = SparkIcons.Store

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FavoriteFill", "com.adevinta.spark.icons"),
        )
        public val ThumbUp: SparkIcon = SparkIcons.FavoriteFill

        @Deprecated("Use SparkIcons instead.")
        public object Work {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.FavoriteOutline", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.FavoriteOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.WorkOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: SparkIcon = SparkIcons.WorkOutline
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object Actions {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CalculateFill", "com.adevinta.spark.icons"),
        )
        public val Calculate: SparkIcon = SparkIcons.CalculateFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CopyFill", "com.adevinta.spark.icons"),
        )
        public val Copy: SparkIcon = SparkIcons.CopyFill

        @Deprecated("Use SparkIcons instead.")
        public object Eyes {
            @Deprecated("Use SparkIcons instead.")
            public object Filled {
                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("SparkIcons.EyeFill", "com.adevinta.spark.icons"),
                )
                public val Enabled: SparkIcon = SparkIcons.EyeFill

                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("SparkIcons.EyeOffFill", "com.adevinta.spark.icons"),
                )
                public val Disabled: SparkIcon = SparkIcons.EyeOffFill
            }

            @Deprecated("Use SparkIcons instead.")
            public object Outlined {
                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("SparkIcons.EyeOutline", "com.adevinta.spark.icons"),
                )
                public val Enabled: SparkIcon = SparkIcons.EyeOutline

                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("SparkIcons.EyeOffOutline", "com.adevinta.spark.icons"),
                )
                public val Disabled: SparkIcon = SparkIcons.EyeOffOutline
            }
        }

        @Deprecated("Use SparkIcons instead.")
        public object Favorite {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.LikeFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.LikeFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.LikeOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: SparkIcon = SparkIcons.LikeOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Filter", "com.adevinta.spark.icons"),
        )
        public val Filter: SparkIcon = SparkIcons.Filter

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlashlightFill", "com.adevinta.spark.icons"),
        )
        public val Flashlight: SparkIcon = SparkIcons.FlashlightFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.MoreMenuVertical", "com.adevinta.spark.icons"),
        )
        public val More: SparkIcon = SparkIcons.MoreMenuVertical

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.PauseOutline", "com.adevinta.spark.icons"),
        )
        public val Pause: SparkIcon = SparkIcons.PauseOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.PlayOutline", "com.adevinta.spark.icons"),
        )
        public val Play: SparkIcon = SparkIcons.PlayOutline

        @Deprecated("Use SparkIcons instead.")
        public object Pen {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.PenFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.PenFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.PenOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: SparkIcon = SparkIcons.PenOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.PrintFill", "com.adevinta.spark.icons"),
        )
        public val Print: SparkIcon = SparkIcons.PrintFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Refresh", "com.adevinta.spark.icons"),
        )
        public val Refresh: SparkIcon = SparkIcons.Refresh

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Scan", "com.adevinta.spark.icons"),
        )
        public val Scan: SparkIcon = SparkIcons.Scan

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Search", "com.adevinta.spark.icons"),
        )
        public val Search: SparkIcon = SparkIcons.Search

        @Deprecated("Use SparkIcons instead.")
        public object Trash {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.TrashFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.TrashFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.TrashOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: SparkIcon = SparkIcons.TrashOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.TrashCloseFill", "com.adevinta.spark.icons"),
            )
            public val Close: SparkIcon = SparkIcons.TrashCloseFill
        }

        @Deprecated("Use SparkIcons instead.")
        public object Wheel {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.WheelFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.WheelFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.WheelOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: SparkIcon = SparkIcons.WheelOutline
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
            public val Left: SparkIcon = SparkIcons.ArrowLeft

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ArrowRight", "com.adevinta.spark.icons"),
            )
            public val Right: SparkIcon = SparkIcons.ArrowRight
        }

        @Deprecated("Use SparkIcons instead.")
        public object Chevron {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ArrowVerticalLeft", "com.adevinta.spark.icons"),
            )
            public val Left: SparkIcon = SparkIcons.ArrowVerticalLeft

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ArrowVerticalRight", "com.adevinta.spark.icons"),
            )
            public val Right: SparkIcon = SparkIcons.ArrowVerticalRight

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ArrowHorizontalUp", "com.adevinta.spark.icons"),
            )
            public val Up: SparkIcon = SparkIcons.ArrowHorizontalUp

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ArrowHorizontalDown", "com.adevinta.spark.icons"),
            )
            public val Down: SparkIcon = SparkIcons.ArrowHorizontalDown
        }

        @Deprecated("Use SparkIcons instead.")
        public object DoubleChevron {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ArrowDoubleLeft", "com.adevinta.spark.icons"),
            )
            public val Left: SparkIcon = SparkIcons.ArrowDoubleLeft

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ArrowDoubleRight", "com.adevinta.spark.icons"),
            )
            public val Right: SparkIcon = SparkIcons.ArrowDoubleRight
        }

        @Deprecated("Use SparkIcons instead.")
        public object Close {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Close", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.Close

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.DeleteFill", "com.adevinta.spark.icons"),
            )
            public val Full: SparkIcon = SparkIcons.DeleteFill
        }

        @Deprecated("Use SparkIcons instead.")
        public object Chart {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.GraphArrowUp", "com.adevinta.spark.icons"),
            )
            public val Up: SparkIcon = SparkIcons.GraphArrowUp

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.GraphArrowDown", "com.adevinta.spark.icons"),
            )
            public val Down: SparkIcon = SparkIcons.GraphArrowDown
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object Calendar {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CalendarDotFill", "com.adevinta.spark.icons"),
        )
        public val Booking: SparkIcon = SparkIcons.CalendarDotFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CalendarFill", "com.adevinta.spark.icons"),
        )
        public val Default: SparkIcon = SparkIcons.CalendarFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CalendarValidFill", "com.adevinta.spark.icons"),
        )
        public val Valid: SparkIcon = SparkIcons.CalendarValidFill
    }

    @Deprecated("Use SparkIcons instead.")
    public object Categories {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Apartment", "com.adevinta.spark.icons"),
        )
        public val Apartment: SparkIcon = SparkIcons.Apartment

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CarOutline", "com.adevinta.spark.icons"),
        )
        public val Car: SparkIcon = SparkIcons.CarOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Couch", "com.adevinta.spark.icons"),
        )
        public val Couch: SparkIcon = SparkIcons.Couch

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Computer", "com.adevinta.spark.icons"),
        )
        public val Computer: SparkIcon = SparkIcons.Computer

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Clothes", "com.adevinta.spark.icons"),
        )
        public val Clothes: SparkIcon = SparkIcons.Clothes

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Equipment", "com.adevinta.spark.icons"),
        )
        public val Equipment: SparkIcon = SparkIcons.Equipment

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Family", "com.adevinta.spark.icons"),
        )
        public val Family: SparkIcon = SparkIcons.Family

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Ground", "com.adevinta.spark.icons"),
        )
        public val Ground: SparkIcon = SparkIcons.Ground

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Hobby", "com.adevinta.spark.icons"),
        )
        public val Hobbies: SparkIcon = SparkIcons.Hobby

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Holidays", "com.adevinta.spark.icons"),
        )
        public val Holidays: SparkIcon = SparkIcons.Holidays

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.House", "com.adevinta.spark.icons"),
        )
        public val House: SparkIcon = SparkIcons.House

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Land", "com.adevinta.spark.icons"),
        )
        public val Land: SparkIcon = SparkIcons.Land

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Multimedia", "com.adevinta.spark.icons"),
        )
        public val Multimedia: SparkIcon = SparkIcons.Multimedia

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Parking", "com.adevinta.spark.icons"),
        )
        public val Parking: SparkIcon = SparkIcons.Parking

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.MoreMenuHorizontal", "com.adevinta.spark.icons"),
        )
        public val Pending: SparkIcon = SparkIcons.MoreMenuHorizontal

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Pets", "com.adevinta.spark.icons"),
        )
        public val Pets: SparkIcon = SparkIcons.Pets

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Service", "com.adevinta.spark.icons"),
        )
        public val Services: SparkIcon = SparkIcons.Service

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Job", "com.adevinta.spark.icons"),
        )
        public val Suitcase: SparkIcon = SparkIcons.Job
    }

    @Deprecated("Use SparkIcons instead.")
    public object Contact {
        @Deprecated("Use SparkIcons instead.")
        public object Mail {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.MailFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.MailFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.MailOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: SparkIcon = SparkIcons.MailOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Micro {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.VoiceFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.VoiceFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.VoiceOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: SparkIcon = SparkIcons.VoiceOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.VoiceOffFill", "com.adevinta.spark.icons"),
            )
            public val Disabled: SparkIcon = SparkIcons.VoiceOffFill
        }

        @Deprecated("Use SparkIcons instead.")
        public object Message {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.MessageFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.MessageFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.MessageOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: SparkIcon = SparkIcons.MessageOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Phone {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.PhoneFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.PhoneFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.PhoneOutline", "com.adevinta.spark.icons"),
            )
            public val Outlined: SparkIcon = SparkIcons.PhoneOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.CallOutline", "com.adevinta.spark.icons"),
            )
            public val Message: SparkIcon = SparkIcons.CallOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.SendHorizontal", "com.adevinta.spark.icons"),
        )
        public val SendMessage: SparkIcon = SparkIcons.SendHorizontal
    }

    @Deprecated("Use SparkIcons instead.")
    public object Criterias {
        @Deprecated("Use SparkIcons instead.")
        public object Animaux {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Age", "com.adevinta.spark.icons"),
            )
            public val Age: SparkIcon = SparkIcons.Age

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Loof", "com.adevinta.spark.icons"),
            )
            public val Loof: SparkIcon = SparkIcons.Loof

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Offer", "com.adevinta.spark.icons"),
            )
            public val Offre: SparkIcon = SparkIcons.Offer

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Litter", "com.adevinta.spark.icons"),
            )
            public val Portee: SparkIcon = SparkIcons.Litter

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Tattoo", "com.adevinta.spark.icons"),
            )
            public val Tatouage: SparkIcon = SparkIcons.Tattoo

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Animals", "com.adevinta.spark.icons"),
            )
            public val TypeDeLOffre: SparkIcon = SparkIcons.Animals

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Vaccine", "com.adevinta.spark.icons"),
            )
            public val Vaccin: SparkIcon = SparkIcons.Vaccine
        }

        @Deprecated("Use SparkIcons instead.")
        public object Automobile {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Loof", "com.adevinta.spark.icons"),
            )
            public val Loof: SparkIcon = SparkIcons.Loof

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Boat", "com.adevinta.spark.icons"),
            )
            public val Bateau: SparkIcon = SparkIcons.Boat

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Fuel", "com.adevinta.spark.icons"),
            )
            public val Carburant: SparkIcon = SparkIcons.Fuel

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Color", "com.adevinta.spark.icons"),
            )
            public val Couleur: SparkIcon = SparkIcons.Color

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Cylindrical", "com.adevinta.spark.icons"),
            )
            public val Cylindree: SparkIcon = SparkIcons.Cylindrical

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Energy", "com.adevinta.spark.icons"),
            )
            public val Energie: SparkIcon = SparkIcons.Energy

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Power", "com.adevinta.spark.icons"),
            )
            public val Puissance: SparkIcon = SparkIcons.Power

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Mileage", "com.adevinta.spark.icons"),
            )
            public val Kilometrage: SparkIcon = SparkIcons.Mileage

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Moto", "com.adevinta.spark.icons"),
            )
            public val Moto: SparkIcon = SparkIcons.Moto

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.License", "com.adevinta.spark.icons"),
            )
            public val Permis: SparkIcon = SparkIcons.License

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Seats", "com.adevinta.spark.icons"),
            )
            public val Places: SparkIcon = SparkIcons.Seats

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Doors", "com.adevinta.spark.icons"),
            )
            public val Portes: SparkIcon = SparkIcons.Doors

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.CalendarCriterias", "com.adevinta.spark.icons"),
            )
            public val Regdate: SparkIcon = SparkIcons.CalendarCriterias

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Type", "com.adevinta.spark.icons"),
            )
            public val Type: SparkIcon = SparkIcons.Type

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Speed", "com.adevinta.spark.icons"),
            )
            public val Vitesse: SparkIcon = SparkIcons.Speed

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Trunk", "com.adevinta.spark.icons"),
            )
            public val Coffre: SparkIcon = SparkIcons.Trunk
        }

        @Deprecated("Use SparkIcons instead.")
        public object Emploi {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.EducationalLevel", "com.adevinta.spark.icons"),
            )
            public val EducationalLevel: SparkIcon = SparkIcons.EducationalLevel

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Experience", "com.adevinta.spark.icons"),
            )
            public val Experience: SparkIcon = SparkIcons.Experience

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Function", "com.adevinta.spark.icons"),
            )
            public val Fonction: SparkIcon = SparkIcons.Function

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Salary", "com.adevinta.spark.icons"),
            )
            public val Salaire: SparkIcon = SparkIcons.Salary

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Sector", "com.adevinta.spark.icons"),
            )
            public val Secteur: SparkIcon = SparkIcons.Sector

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Time", "com.adevinta.spark.icons"),
            )
            public val Temps: SparkIcon = SparkIcons.Time

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Type", "com.adevinta.spark.icons"),
            )
            public val Type: SparkIcon = SparkIcons.Type
        }

        @Deprecated("Use SparkIcons instead.")
        public object Generique {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.LikeOutline", "com.adevinta.spark.icons"),
            )
            public val Defaut1: SparkIcon = SparkIcons.LikeOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Listing", "com.adevinta.spark.icons"),
            )
            public val Defaut2: SparkIcon = SparkIcons.Listing

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Donate", "com.adevinta.spark.icons"),
            )
            public val Donate: SparkIcon = SparkIcons.Donate

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Smoking", "com.adevinta.spark.icons"),
            )
            public val Smoking: SparkIcon = SparkIcons.Smoking

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Localisation", "com.adevinta.spark.icons"),
            )
            public val Localisation: SparkIcon = SparkIcons.Localisation

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Delivery", "com.adevinta.spark.icons"),
            )
            public val Delivery: SparkIcon = SparkIcons.Delivery
        }

        @Deprecated("Use SparkIcons instead.")
        public object Immobilier {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Class", "com.adevinta.spark.icons"),
            )
            public val Classe: SparkIcon = SparkIcons.Class

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Class", "com.adevinta.spark.icons"),
            )
            public val Ges: SparkIcon = SparkIcons.Class

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Honoraria", "com.adevinta.spark.icons"),
            )
            public val Honoraires: SparkIcon = SparkIcons.Honoraria

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Furniture", "com.adevinta.spark.icons"),
            )
            public val Meuble: SparkIcon = SparkIcons.Furniture

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Pieces", "com.adevinta.spark.icons"),
            )
            public val Pieces: SparkIcon = SparkIcons.Pieces

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Reference", "com.adevinta.spark.icons"),
            )
            public val Reference: SparkIcon = SparkIcons.Reference

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Surface", "com.adevinta.spark.icons"),
            )
            public val Surface: SparkIcon = SparkIcons.Surface

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.HousingType", "com.adevinta.spark.icons"),
            )
            public val TypeDeBien: SparkIcon = SparkIcons.HousingType

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.SaleType", "com.adevinta.spark.icons"),
            )
            public val TypeDeVente: SparkIcon = SparkIcons.SaleType
        }

        @Deprecated("Use SparkIcons instead.")
        public object ImmobilierNeuf {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Balcony", "com.adevinta.spark.icons"),
            )
            public val Balcon: SparkIcon = SparkIcons.Balcony

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Cave", "com.adevinta.spark.icons"),
            )
            public val Cave: SparkIcon = SparkIcons.Cave

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Duplex", "com.adevinta.spark.icons"),
            )
            public val Duplex: SparkIcon = SparkIcons.Duplex

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Floor", "com.adevinta.spark.icons"),
            )
            public val Etage: SparkIcon = SparkIcons.Floor

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Garage", "com.adevinta.spark.icons"),
            )
            public val Garage: SparkIcon = SparkIcons.Garage

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Garden", "com.adevinta.spark.icons"),
            )
            public val Jardin: SparkIcon = SparkIcons.Garden

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Loggia", "com.adevinta.spark.icons"),
            )
            public val Loggia: SparkIcon = SparkIcons.Loggia

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.SunOrientation", "com.adevinta.spark.icons"),
            )
            public val Orientation: SparkIcon = SparkIcons.SunOrientation

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Parking", "com.adevinta.spark.icons"),
            )
            public val Parking: SparkIcon = SparkIcons.Parking

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Terrace", "com.adevinta.spark.icons"),
            )
            public val Terrasse: SparkIcon = SparkIcons.Terrace
        }

        @Deprecated("Use SparkIcons instead.")
        public object Location {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Cave", "com.adevinta.spark.icons"),
            )
            public val Cave: SparkIcon = SparkIcons.Cave

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Calm", "com.adevinta.spark.icons"),
            )
            public val Calme: SparkIcon = SparkIcons.Calm

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Cave", "com.adevinta.spark.icons"),
            )
            public val Cave2: SparkIcon = SparkIcons.Cave

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Fireplace", "com.adevinta.spark.icons"),
            )
            public val Chemine: SparkIcon = SparkIcons.Fireplace

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.LastFloor", "com.adevinta.spark.icons"),
            )
            public val DernierEtage: SparkIcon = SparkIcons.LastFloor

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Digicode", "com.adevinta.spark.icons"),
            )
            public val Digicode: SparkIcon = SparkIcons.Digicode

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.GlassWindows", "com.adevinta.spark.icons"),
            )
            public val BaiesVitrees: SparkIcon = SparkIcons.GlassWindows

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Janitor", "com.adevinta.spark.icons"),
            )
            public val Concierge: SparkIcon = SparkIcons.Janitor

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Attic", "com.adevinta.spark.icons"),
            )
            public val Combles: SparkIcon = SparkIcons.Attic

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.BeautifulBuilding", "com.adevinta.spark.icons"),
            )
            public val BeauBatiment: SparkIcon = SparkIcons.BeautifulBuilding

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Interphone", "com.adevinta.spark.icons"),
            )
            public val Interphone: SparkIcon = SparkIcons.Interphone

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Loft", "com.adevinta.spark.icons"),
            )
            public val Loft: SparkIcon = SparkIcons.Loft

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Light", "com.adevinta.spark.icons"),
            )
            public val Lumineux: SparkIcon = SparkIcons.Light

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Common", "com.adevinta.spark.icons"),
            )
            public val Mitoyen: SparkIcon = SparkIcons.Common

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Moulding", "com.adevinta.spark.icons"),
            )
            public val Mouture: SparkIcon = SparkIcons.Moulding

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Parquet", "com.adevinta.spark.icons"),
            )
            public val Parquet: SparkIcon = SparkIcons.Parquet

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Wardrobe", "com.adevinta.spark.icons"),
            )
            public val Penderie: SparkIcon = SparkIcons.Wardrobe

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Metro", "com.adevinta.spark.icons"),
            )
            public val Metro: SparkIcon = SparkIcons.Metro

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.StoreOutline", "com.adevinta.spark.icons"),
            )
            public val Magasin: SparkIcon = SparkIcons.StoreOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Shower", "com.adevinta.spark.icons"),
            )
            public val Douche: SparkIcon = SparkIcons.Shower

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Renovation", "com.adevinta.spark.icons"),
            )
            public val Renove: SparkIcon = SparkIcons.Renovation

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Bath", "com.adevinta.spark.icons"),
            )
            public val Baignoire: SparkIcon = SparkIcons.Bath

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.View", "com.adevinta.spark.icons"),
            )
            public val Vue: SparkIcon = SparkIcons.View

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.SeaView", "com.adevinta.spark.icons"),
            )
            public val VueMer: SparkIcon = SparkIcons.SeaView

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Wc", "com.adevinta.spark.icons"),
            )
            public val Wc: SparkIcon = SparkIcons.Wc

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Lift", "com.adevinta.spark.icons"),
            )
            public val Ascenseur: SparkIcon = SparkIcons.Lift

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ChargesIncluded", "com.adevinta.spark.icons"),
            )
            public val ChargesComprises: SparkIcon = SparkIcons.ChargesIncluded
        }

        @Deprecated("Use SparkIcons instead.")
        public object Loisirs {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Toy", "com.adevinta.spark.icons"),
            )
            public val Jouet: SparkIcon = SparkIcons.Toy

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.BicycleType", "com.adevinta.spark.icons"),
            )
            public val BicycleType: SparkIcon = SparkIcons.BicycleType

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ToysProduct", "com.adevinta.spark.icons"),
            )
            public val ToysProduct: SparkIcon = SparkIcons.ToysProduct
        }

        @Deprecated("Use SparkIcons instead.")
        public object Maison {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.DiyProduct", "com.adevinta.spark.icons"),
            )
            public val DiyProduct: SparkIcon = SparkIcons.DiyProduct

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.DiyType", "com.adevinta.spark.icons"),
            )
            public val DiyType: SparkIcon = SparkIcons.DiyType

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.HomeappliancesProduct", "com.adevinta.spark.icons"),
            )
            public val HomeAppliancesProduct: SparkIcon = SparkIcons.HomeappliancesProduct

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.HomeappliancesType", "com.adevinta.spark.icons"),
            )
            public val HomeAppliancesType: SparkIcon = SparkIcons.HomeappliancesType

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.GardeningProduct", "com.adevinta.spark.icons"),
            )
            public val GardeningProduct: SparkIcon = SparkIcons.GardeningProduct

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.GardeningType", "com.adevinta.spark.icons"),
            )
            public val GardeningType: SparkIcon = SparkIcons.GardeningType

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.LinensProduct", "com.adevinta.spark.icons"),
            )
            public val LinensProduct: SparkIcon = SparkIcons.LinensProduct

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.LinensType", "com.adevinta.spark.icons"),
            )
            public val LinensType: SparkIcon = SparkIcons.LinensType

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.TableArtMaterial", "com.adevinta.spark.icons"),
            )
            public val TableArtMaterial: SparkIcon = SparkIcons.TableArtMaterial

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.TableArtProduct", "com.adevinta.spark.icons"),
            )
            public val TableArtProduct: SparkIcon = SparkIcons.TableArtProduct

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.FurnitureType", "com.adevinta.spark.icons"),
            )
            public val FournitureType: SparkIcon = SparkIcons.FurnitureType
        }

        @Deprecated("Use SparkIcons instead.")
        public object Mode {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.EquipmentBaby", "com.adevinta.spark.icons"),
            )
            public val EquipementBebe: SparkIcon = SparkIcons.EquipmentBaby

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Color", "com.adevinta.spark.icons"),
            )
            public val Couleur: SparkIcon = SparkIcons.Color

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Condition", "com.adevinta.spark.icons"),
            )
            public val Etat: SparkIcon = SparkIcons.Condition

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.OfferOutline", "com.adevinta.spark.icons"),
            )
            public val Marque: SparkIcon = SparkIcons.OfferOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Material", "com.adevinta.spark.icons"),
            )
            public val Matiere: SparkIcon = SparkIcons.Material

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Luxe", "com.adevinta.spark.icons"),
            )
            public val Luxe: SparkIcon = SparkIcons.Luxe

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ShoeSize", "com.adevinta.spark.icons"),
            )
            public val Pointure: SparkIcon = SparkIcons.ShoeSize

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Size", "com.adevinta.spark.icons"),
            )
            public val Taille: SparkIcon = SparkIcons.Size

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Jewels", "com.adevinta.spark.icons"),
            )
            public val Bijoux: SparkIcon = SparkIcons.Jewels

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Shoes", "com.adevinta.spark.icons"),
            )
            public val Chaussure: SparkIcon = SparkIcons.Shoes

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Clothes", "com.adevinta.spark.icons"),
            )
            public val Vetements: SparkIcon = SparkIcons.Clothes

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Univers", "com.adevinta.spark.icons"),
            )
            public val Univers: SparkIcon = SparkIcons.Univers
        }

        @Deprecated("Use SparkIcons instead.")
        public object Multimedia {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Condition", "com.adevinta.spark.icons"),
            )
            public val Etat: SparkIcon = SparkIcons.Condition

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Memory", "com.adevinta.spark.icons"),
            )
            public val Memoire: SparkIcon = SparkIcons.Memory

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Model", "com.adevinta.spark.icons"),
            )
            public val Modele: SparkIcon = SparkIcons.Model

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Color", "com.adevinta.spark.icons"),
            )
            public val Couleur: SparkIcon = SparkIcons.Color

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Model", "com.adevinta.spark.icons"),
            )
            public val Marque: SparkIcon = SparkIcons.Model

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Type", "com.adevinta.spark.icons"),
            )
            public val Type: SparkIcon = SparkIcons.Type
        }

        @Deprecated("Use SparkIcons instead.")
        public object Vacances {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Animals", "com.adevinta.spark.icons"),
            )
            public val Animaux: SparkIcon = SparkIcons.Animals

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Capacity", "com.adevinta.spark.icons"),
            )
            public val Capacite: SparkIcon = SparkIcons.Capacity

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Rooms", "com.adevinta.spark.icons"),
            )
            public val Chambres: SparkIcon = SparkIcons.Rooms

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Arrival", "com.adevinta.spark.icons"),
            )
            public val Arrive: SparkIcon = SparkIcons.Arrival

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Start", "com.adevinta.spark.icons"),
            )
            public val Depart: SparkIcon = SparkIcons.Start

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Rating", "com.adevinta.spark.icons"),
            )
            public val NombreEtoiles: SparkIcon = SparkIcons.Rating

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.AirConditioning", "com.adevinta.spark.icons"),
            )
            public val Climatisation: SparkIcon = SparkIcons.AirConditioning

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Sport", "com.adevinta.spark.icons"),
            )
            public val SalleSport: SparkIcon = SparkIcons.Sport

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Breakfast", "com.adevinta.spark.icons"),
            )
            public val PetitDejeune: SparkIcon = SparkIcons.Breakfast

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Spa", "com.adevinta.spark.icons"),
            )
            public val Spa: SparkIcon = SparkIcons.Spa

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Tv", "com.adevinta.spark.icons"),
            )
            public val Tv: SparkIcon = SparkIcons.Tv

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Welcome", "com.adevinta.spark.icons"),
            )
            public val Acceuil: SparkIcon = SparkIcons.Welcome

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Wifi", "com.adevinta.spark.icons"),
            )
            public val Wifi: SparkIcon = SparkIcons.Wifi

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Clean", "com.adevinta.spark.icons"),
            )
            public val LabelSanitaire2: SparkIcon = SparkIcons.Clean

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.HousingType", "com.adevinta.spark.icons"),
            )
            public val TypeLogement: SparkIcon = SparkIcons.HousingType

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Garden", "com.adevinta.spark.icons"),
            )
            public val Jardin: SparkIcon = SparkIcons.Garden

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Parking", "com.adevinta.spark.icons"),
            )
            public val Parking: SparkIcon = SparkIcons.Parking

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Pool", "com.adevinta.spark.icons"),
            )
            public val Piscine: SparkIcon = SparkIcons.Pool

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.Accessories", "com.adevinta.spark.icons"),
            )
            public val Accessories: SparkIcon = SparkIcons.Accessories

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.CalendarCriterias", "com.adevinta.spark.icons"),
            )
            public val Date: SparkIcon = SparkIcons.CalendarCriterias
        }

        @Deprecated("Use SparkIcons instead.")
        public object MaterialTools {
            @Deprecated("Use SparkIcons instead.")
            public object Tools {
                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("SparkIcons.Tools", "com.adevinta.spark.icons"),
                )
                public val Agriculture: SparkIcon = SparkIcons.Tools
            }
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object Flags {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagAT", "com.adevinta.spark.icons"),
        )
        public val FlagAT: SparkIcon = SparkIcons.FlagAT

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagBE", "com.adevinta.spark.icons"),
        )
        public val FlagBE: SparkIcon = SparkIcons.FlagBE

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagBR", "com.adevinta.spark.icons"),
        )
        public val FlagBR: SparkIcon = SparkIcons.FlagBR

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagBY", "com.adevinta.spark.icons"),
        )
        public val FlagBY: SparkIcon = SparkIcons.FlagBY

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagCH", "com.adevinta.spark.icons"),
        )
        public val FlagCH: SparkIcon = SparkIcons.FlagCH

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagCL", "com.adevinta.spark.icons"),
        )
        public val FlagCL: SparkIcon = SparkIcons.FlagCL

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagCO", "com.adevinta.spark.icons"),
        )
        public val FlagCO: SparkIcon = SparkIcons.FlagCO

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagDO", "com.adevinta.spark.icons"),
        )
        public val FlagDO: SparkIcon = SparkIcons.FlagDO

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagES", "com.adevinta.spark.icons"),
        )
        public val FlagES: SparkIcon = SparkIcons.FlagES

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagFI", "com.adevinta.spark.icons"),
        )
        public val FlagFI: SparkIcon = SparkIcons.FlagFI

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagFR", "com.adevinta.spark.icons"),
        )
        public val FlagFR: SparkIcon = SparkIcons.FlagFR

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagHU", "com.adevinta.spark.icons"),
        )
        public val FlagHU: SparkIcon = SparkIcons.FlagHU

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagID", "com.adevinta.spark.icons"),
        )
        public val FlagID: SparkIcon = SparkIcons.FlagID

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagIE", "com.adevinta.spark.icons"),
        )
        public val FlagIE: SparkIcon = SparkIcons.FlagIE

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagIT", "com.adevinta.spark.icons"),
        )
        public val FlagIT: SparkIcon = SparkIcons.FlagIT

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagMA", "com.adevinta.spark.icons"),
        )
        public val FlagMA: SparkIcon = SparkIcons.FlagMA

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagMX", "com.adevinta.spark.icons"),
        )
        public val FlagMX: SparkIcon = SparkIcons.FlagMX

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagMY", "com.adevinta.spark.icons"),
        )
        public val FlagMY: SparkIcon = SparkIcons.FlagMY

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagPT", "com.adevinta.spark.icons"),
        )
        public val FlagPT: SparkIcon = SparkIcons.FlagPT

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagSE", "com.adevinta.spark.icons"),
        )
        public val FlagSE: SparkIcon = SparkIcons.FlagSE

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagTN", "com.adevinta.spark.icons"),
        )
        public val FlagTN: SparkIcon = SparkIcons.FlagTN

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagVN", "com.adevinta.spark.icons"),
        )
        public val FlagVN: SparkIcon = SparkIcons.FlagVN
    }

    @Deprecated("Use SparkIcons instead.")
    public object Images {
        @Deprecated("Use SparkIcons instead.")
        public object Camera {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.CameraFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.CameraFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.CameraOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.CameraOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.AddImageOutline", "com.adevinta.spark.icons"),
            )
            public val More: SparkIcon = SparkIcons.AddImageOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.GalleryFill", "com.adevinta.spark.icons"),
        )
        public val Library: SparkIcon = SparkIcons.GalleryFill

        @Deprecated("Use SparkIcons instead.")
        public object NewAd {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.AddSquareFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.AddSquareFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.AddSquareOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.AddSquareOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.NoPhoto", "com.adevinta.spark.icons"),
        )
        public val NoPhoto: SparkIcon = SparkIcons.NoPhoto

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.NoPhoto", "com.adevinta.spark.icons"),
        )
        public val ErrorPhoto: SparkIcon = SparkIcons.NoPhoto // FIXME

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.NoPhoto", "com.adevinta.spark.icons"),
        )
        public val NoPhoto2: SparkIcon = SparkIcons.NoPhoto

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.RotateImage", "com.adevinta.spark.icons"),
        )
        public val Rotate: SparkIcon = SparkIcons.RotateImage
    }

    @Deprecated("Use SparkIcons instead.")
    public object Infos {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CameraFill", "com.adevinta.spark.icons"),
        )
        public val Camera: SparkIcon = SparkIcons.CameraFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Block", "com.adevinta.spark.icons"),
        )
        public val Block: SparkIcon = SparkIcons.Block

        @Deprecated("Use SparkIcons instead.")
        public object Alert {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.AlertFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.AlertFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.AlertOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.AlertOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Ask {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.QuestionFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.QuestionFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.QuestionOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.QuestionOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Info {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.InfoFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.InfoFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.InfoOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.InfoOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object LightBulb {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.IdeaFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.IdeaFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.IdeaOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.IdeaOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Lock {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.LockFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.LockFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.LockOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.LockOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.UnlockOutline", "com.adevinta.spark.icons"),
            )
            public val Open: SparkIcon = SparkIcons.UnlockOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.WarningFill", "com.adevinta.spark.icons"),
        )
        public val Warning: SparkIcon = SparkIcons.WarningFill
    }

    @Deprecated("Use SparkIcons instead.")
    public object Delivery {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.DeliveryHandsOutline", "com.adevinta.spark.icons"),
        )
        public val DeliveryHand: SparkIcon = SparkIcons.DeliveryHandsOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.DeliveryOutline", "com.adevinta.spark.icons"),
        )
        public val DeliveryOutline: SparkIcon = SparkIcons.DeliveryOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.DeliveryTruckOutline", "com.adevinta.spark.icons"),
        )
        public val Truck: SparkIcon = SparkIcons.DeliveryTruckOutline

        @Deprecated("Use SparkIcons instead.")
        public object Mailbox {
            @Deprecated("Use SparkIcons instead.")
            public object Close {
                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("MailCloseFill", "com.adevinta.spark.icons"),
                )
                public val Down: SparkIcon = SparkIcons.MailCloseFill

                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("MailCloseFill", "com.adevinta.spark.icons"),
                )
                public val Up: SparkIcon = SparkIcons.MailCloseFill
            }

            @Deprecated("Use SparkIcons instead.")
            public object Open {
                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("SparkIcons.MailOpenFill", "com.adevinta.spark.icons"),
                )
                public val Down: SparkIcon = SparkIcons.MailOpenFill

                @Deprecated(
                    message = "Use SparkIcons instead.",
                    replaceWith = ReplaceWith("SparkIcons.MailOpenFill", "com.adevinta.spark.icons"),
                )
                public val Up: SparkIcon = SparkIcons.MailOpenFill
            }
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object Map {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.ThreeSixty", "com.adevinta.spark.icons"),
        )
        public val ThreeSixty: SparkIcon = SparkIcons.ThreeSixty

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Bike", "com.adevinta.spark.icons"),
        )
        public val Bike: SparkIcon = SparkIcons.Bike

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AllDirection", "com.adevinta.spark.icons"),
        )
        public val Drag: SparkIcon = SparkIcons.AllDirection

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.MapExpand", "com.adevinta.spark.icons"),
        )
        public val Expand: SparkIcon = SparkIcons.MapExpand

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.TargetOutline", "com.adevinta.spark.icons"),
        )
        public val Geoloc: SparkIcon = SparkIcons.TargetOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.HotelFill", "com.adevinta.spark.icons"),
        )
        public val Hotel: SparkIcon = SparkIcons.HotelFill

        @Deprecated("Use SparkIcons instead.")
        public object Marker {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.PinFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.PinFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.PinOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.PinOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Near {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.MapCursorFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.MapCursorFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.MapCursorOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.MapCursorOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.MapExpand", "com.adevinta.spark.icons"),
        )
        public val SimpleExpand: SparkIcon = SparkIcons.MapExpand

        @Deprecated("Use SparkIcons instead.")
        public object Train {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.TrainFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.TrainFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.TrainOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.TrainOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.WalkerFill", "com.adevinta.spark.icons"),
        )
        public val Walker: SparkIcon = SparkIcons.WalkerFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CarOutline", "com.adevinta.spark.icons"),
        )
        public val Car: SparkIcon = SparkIcons.CarOutline
    }

    @Deprecated("Use SparkIcons instead.")
    public object Navs {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AlarmOnFill", "com.adevinta.spark.icons"),
        )
        public val Arrow: SparkIcon = SparkIcons.AlarmOnFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.BurgerMenu", "com.adevinta.spark.icons"),
        )
        public val Drawer: SparkIcon = SparkIcons.BurgerMenu

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Close", "com.adevinta.spark.icons"),
        )
        public val Close: SparkIcon = SparkIcons.Close
    }

    @Deprecated("Use SparkIcons instead.")
    public object Notifications {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AlarmOnFill", "com.adevinta.spark.icons"),
        )
        public val Active: SparkIcon = SparkIcons.AlarmOnFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AlarmFill", "com.adevinta.spark.icons"),
        )
        public val Default: SparkIcon = SparkIcons.AlarmFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AlarmOffFill", "com.adevinta.spark.icons"),
        )
        public val Disable: SparkIcon = SparkIcons.AlarmOffFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AlarmOutline", "com.adevinta.spark.icons"),
        )
        public val Outline: SparkIcon = SparkIcons.AlarmOutline
    }

    @Deprecated("Use SparkIcons instead.")
    public object Options {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.BoosterFill", "com.adevinta.spark.icons"),
        )
        public val Booster: SparkIcon = SparkIcons.BoosterFill

        @Deprecated("Use SparkIcons instead.")
        public object Clock {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ClockArrowOutline", "com.adevinta.spark.icons"),
            )
            public val Arrow: SparkIcon = SparkIcons.ClockArrowOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ClockFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.ClockFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ClockOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.ClockOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.MoneyFill", "com.adevinta.spark.icons"),
        )
        public val Credit: SparkIcon = SparkIcons.MoneyFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlashlightFill", "com.adevinta.spark.icons"),
        )
        public val Flash: SparkIcon = SparkIcons.FlashlightFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.MoveUp", "com.adevinta.spark.icons"),
        )
        public val MoveUp: SparkIcon = SparkIcons.MoveUp

        @Deprecated("Use SparkIcons instead.")
        public object SpotLight {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.BookmarkFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.BookmarkFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.BookmarkOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.BookmarkOutline
        }

        @Deprecated("Use SparkIcons instead.")
        public object Star {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.StarFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.StarFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.StarOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.StarOutline
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
            public val Default: SparkIcon = SparkIcons.MegaphoneFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.MegaphoneOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.MegaphoneOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.SpeedmeterOutline", "com.adevinta.spark.icons"),
        )
        public val SpeedoMeter: SparkIcon = SparkIcons.SpeedmeterOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.DissatisfiedOutline", "com.adevinta.spark.icons"),
        )
        public val Dissatisfied: SparkIcon = SparkIcons.DissatisfiedOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Euro", "com.adevinta.spark.icons"),
        )
        public val Euro: SparkIcon = SparkIcons.Euro

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FlagOutline", "com.adevinta.spark.icons"),
        )
        public val FlagOutline: SparkIcon = SparkIcons.FlagOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.SatisfiedOutline", "com.adevinta.spark.icons"),
        )
        public val Satisfied: SparkIcon = SparkIcons.SatisfiedOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.BoxOutline", "com.adevinta.spark.icons"),
        )
        public val Package: SparkIcon = SparkIcons.BoxOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Refund", "com.adevinta.spark.icons"),
        )
        public val Refund: SparkIcon = SparkIcons.Refund
    }

    @Deprecated("Use SparkIcons instead.")
    public object Paiement {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.CarWarrantyOutline", "com.adevinta.spark.icons"),
        )
        public val GarantiePanne: SparkIcon = SparkIcons.CarWarrantyOutline
    }

    @Deprecated("Use SparkIcons instead.")
    public object Pro {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.ProCursorOutline", "com.adevinta.spark.icons"),
        )
        public val Actions: SparkIcon = SparkIcons.ProCursorOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AppearanceFill", "com.adevinta.spark.icons"),
        )
        public val Apparitions: SparkIcon = SparkIcons.AppearanceFill

        @Deprecated("Use SparkIcons instead.")
        public object Download {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.DownloadFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.DownloadFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.DownloadOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.DownloadOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.GraphOutline", "com.adevinta.spark.icons"),
        )
        public val MyPro: SparkIcon = SparkIcons.GraphOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.RocketOutline", "com.adevinta.spark.icons"),
        )
        public val SpaceShip: SparkIcon = SparkIcons.RocketOutline
    }

    @Deprecated("Use SparkIcons instead.")
    public object Share {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AttachFileOutline", "com.adevinta.spark.icons"),
        )
        public val AttachFile: SparkIcon = SparkIcons.AttachFileOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.FacebookFill", "com.adevinta.spark.icons"),
        )
        public val Facebook: SparkIcon = SparkIcons.FacebookFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Messenger", "com.adevinta.spark.icons"),
        )
        public val Messenger: SparkIcon = SparkIcons.Messenger

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Pinterest", "com.adevinta.spark.icons"),
        )
        public val Pinterest: SparkIcon = SparkIcons.Pinterest

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.InstagramOutline", "com.adevinta.spark.icons"),
        )
        public val Instagram: SparkIcon = SparkIcons.InstagramOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.ShareExpand", "com.adevinta.spark.icons"),
        )
        public val Goto: SparkIcon = SparkIcons.ShareExpand

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Link", "com.adevinta.spark.icons"),
        )
        public val Link: SparkIcon = SparkIcons.Link

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.ShareFill", "com.adevinta.spark.icons"),
        )
        public val ShareDefault: SparkIcon = SparkIcons.ShareFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.ForwardFill", "com.adevinta.spark.icons"),
        )
        public val ShareArrow: SparkIcon = SparkIcons.ForwardFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.TwitterFill", "com.adevinta.spark.icons"),
        )
        public val Twitter: SparkIcon = SparkIcons.TwitterFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Whatsapp", "com.adevinta.spark.icons"),
        )
        public val WhatsApp: SparkIcon = SparkIcons.Whatsapp

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Export", "com.adevinta.spark.icons"),
        )
        public val Upload: SparkIcon = SparkIcons.Export

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Import", "com.adevinta.spark.icons"),
        )
        public val Download: SparkIcon = SparkIcons.Import
    }

    @Deprecated("Use SparkIcons instead.")
    public object Toggles {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Plus", "com.adevinta.spark.icons"),
        )
        public val Add: SparkIcon = SparkIcons.Plus

        @Deprecated("Use SparkIcons instead.")
        public object Check {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ValidFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.ValidFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.ValidOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.ValidOutline

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.CheckFill", "com.adevinta.spark.icons"),
            )
            public val Simple: SparkIcon = SparkIcons.CheckFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.DoubleCheckFill", "com.adevinta.spark.icons"),
            )
            public val Double: SparkIcon = SparkIcons.DoubleCheckFill
        }
    }

    @Deprecated("Use SparkIcons instead.")
    public object User {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.ProOutline", "com.adevinta.spark.icons"),
        )
        public val Pro: SparkIcon = SparkIcons.ProOutline

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AccountFill", "com.adevinta.spark.icons"),
        )
        public val Default: SparkIcon = SparkIcons.AccountFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AccountOutline", "com.adevinta.spark.icons"),
        )
        public val Outline: SparkIcon = SparkIcons.AccountOutline

        @Deprecated("Use SparkIcons instead.")
        public object Group {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.GroupFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.GroupFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.GroupOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.GroupOutline
        }

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.VerifiedFill", "com.adevinta.spark.icons"),
        )
        public val Verified: SparkIcon = SparkIcons.VerifiedFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.AvatarFill", "com.adevinta.spark.icons"),
        )
        public val Avatar: SparkIcon = SparkIcons.AvatarFill

        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.Store", "com.adevinta.spark.icons"),
        )
        public val Store: SparkIcon = SparkIcons.Store
    }

    @Deprecated("Use SparkIcons instead.")
    public object Value {
        @Deprecated(
            message = "Use SparkIcons instead.",
            replaceWith = ReplaceWith("SparkIcons.RemoveOutline", "com.adevinta.spark.icons"),
        )
        public val Minus: SparkIcon = SparkIcons.RemoveOutline

        @Deprecated("Use SparkIcons instead.")
        public object More {
            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.AddFill", "com.adevinta.spark.icons"),
            )
            public val Default: SparkIcon = SparkIcons.AddFill

            @Deprecated(
                message = "Use SparkIcons instead.",
                replaceWith = ReplaceWith("SparkIcons.AddOutline", "com.adevinta.spark.icons"),
            )
            public val Outline: SparkIcon = SparkIcons.AddOutline
        }
    }
}
