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

package com.adevinta.spark.res

public sealed class SparkStringAnnotations {
    public sealed class Color : SparkStringAnnotations() {
        public object Primary : Color() {
            override fun toString(): String = "primary"
        }

        public object Secondary : Color() {
            override fun toString(): String = "secondary"
        }

        public object Success : Color() {
            override fun toString(): String = "success"
        }

        public object Alert : Color() {
            override fun toString(): String = "alert"
        }

        public object Error : Color() {
            override fun toString(): String = "error"
        }

        public object Info : Color() {
            override fun toString(): String = "info"
        }

        public object Neutral : Color() {
            override fun toString(): String = "neutral"
        }

        override fun toString(): String = "color"

        public companion object
    }

    public sealed class Typography : SparkStringAnnotations() {
        public object Title1 : Typography() {
            override fun toString(): String = "title1"
        }

        public object Title2 : Typography() {
            override fun toString(): String = "title2"
        }

        public object Title3 : Typography() {
            override fun toString(): String = "title3"
        }

        public object BodyImportant : Typography() {
            override fun toString(): String = "bodyImportant"
        }

        public object Body : Typography() {
            override fun toString(): String = "body"
        }

        public object SmallImportant : Typography() {
            override fun toString(): String = "smallImportant"
        }

        public object Small : Typography() {
            override fun toString(): String = "small"
        }

        public object ExtraSmallImportant : Typography() {
            override fun toString(): String = "extraSmallImportant"
        }

        public object ExtraSmall : Typography() {
            override fun toString(): String = "extraSmall"
        }

        public object Button : Typography() {
            override fun toString(): String = "button"
        }

        public companion object {
            public const val keyName: String = "typography"
        }
    }
}
