#!/usr/bin/env kotlin

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

@file:Repository("https://repo1.maven.org/maven2/")
@file:Repository("https://maven.google.com")
@file:DependsOn("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.21")
@file:DependsOn("com.android.tools:sdk-common:31.0.2")
@file:DependsOn("com.github.ajalt.clikt:clikt-jvm:3.5.2")
@file:DependsOn("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")

import com.android.ide.common.vectordrawable.Svg2Vector
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.check
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.defaultLazy
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.help
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import com.github.ajalt.clikt.parameters.types.int
import com.github.ajalt.clikt.parameters.types.path
import java.nio.file.Path
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.absolutePathString
import kotlin.io.path.deleteExisting
import kotlin.io.path.extension
import kotlin.io.path.isRegularFile
import kotlin.io.path.name
import kotlin.io.path.nameWithoutExtension
import kotlin.io.path.outputStream
import kotlin.io.path.readText
import kotlin.io.path.walk

/**
 * SVG2AVD will compress SVG files and convert them to AVD.
 * - https://github.com/svg/svgo
 * - https://central.sonatype.com/artifact/com.android.tools/sdk-common
 */
class SVG2AVD : CliktCommand(
    name = "svg2avd.main.kts",
    help = "⚙️ SVG2AVD: Convert SVG files to Android Vector Drawables (AVD).",
) {

    val input: Path by option("-i", "--input", help = "SVG assets input")
        .path(mustExist = true, canBeFile = false, mustBeReadable = true)
        .prompt()

    val output: Path by option("-o", "--output", help = "AVD assets output")
        .path(mustExist = true, canBeFile = false, mustBeWritable = true)
        .defaultLazy { input }

    val precision: Int by option("-p", "--precision", help = "svgo compression precision")
        .help("Set number of digits in the fractional part")
        .int().default(2)
        .check("must be a valid integer") { it in 0..10 }

    val prefix: String by option("-x", "--prefix", help = "XML file prefix")
        .default("")

    val copyright: Path? by option("-c", "--copyright", help = "Copyright header for AVD")
        .path(mustExist = false, canBeDir = false, mustBeReadable = true)

    val quiet by option("-q", "--quiet", help = "Print errors only")
        .flag(default = false)

    override fun run() {
        // 1. Optimize with svgo
        val svgo = ("svgo " +
            "--folder ${input.absolutePathString()} " +
            "--output ${output.absolutePathString()} " +
            "--precision $precision").exec()
        if (!quiet) echo(svgo)

        // 2. Convert SVG files to AVD
        val header = copyright?.takeIf { it.isRegularFile() }?.readText().orEmpty().toByteArray()
        output.files { it.extension == "svg" }
            .map { it to output.resolve("$prefix${it.nameWithoutExtension.toSnakeCase()}.xml") }
            .forEach { (svg, avd) ->
                if (!quiet) echo("Converting ${svg.name} to ${avd.name}")
                avd.outputStream().use {
                    it.write(header)
                    Svg2Vector.parseSvgToXml(svg, it)
                    svg.deleteExisting()
                }
            }

        // 3. Profit
        if (!quiet) echo("\n✅ " + output.absolutePathString())
    }
}

@OptIn(ExperimentalPathApi::class)
fun Path.files() = walk().filter { it: Path -> it.isRegularFile() }
fun Path.files(predicate: (Path) -> Boolean) = files().filter(predicate)
fun String.exec() = Runtime.getRuntime().exec(this).text()
fun Process.text() = apply { waitFor() }.inputStream.bufferedReader().use { it.readText().trim() }
fun String.toSnakeCase(): String = "(?<=.)[A-Z]".toRegex().replace(this, "_$0").lowercase()

SVG2AVD().main(args)
