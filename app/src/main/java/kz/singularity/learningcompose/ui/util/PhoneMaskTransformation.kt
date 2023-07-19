package kz.singularity.learningcompose.ui.util

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class PhoneMaskTransformation : VisualTransformation {
                    override fun filter(text: AnnotatedString): TransformedText {
                        return maskFilter(text)
                    }

                    private fun maskFilter(text: AnnotatedString): TransformedText {

                        // +7 012 345 67 89
                        // 0123456789012345
                        val trimmed = if (text.text.length >= 10) text.text.substring(0..9) else text.text
                        var out = "+7 "
                        for (i in trimmed.indices) {
                            out += trimmed[i]
                            if (i == 2) out += " "
                            if (i == 5) out += " "
                            if (i == 7) out += " "
                        }

                        val numberOffsetTranslator = object : OffsetMapping {

                            override fun originalToTransformed(offset: Int): Int {
                                if (offset <= 3) return offset + 3
                                if (offset <= 6) return offset + 4
                                if (offset <= 8) return offset + 5
                                if (offset <= 10) return offset + 6
                                return 16
                            }

                            override fun transformedToOriginal(offset: Int): Int {
                                if (offset in 3..7) return offset - 3
                                if (offset in 8..11) return offset - 4
                                if (offset in 12..16) return offset - 5
                                return 0
                            }
                        }

                        return TransformedText(AnnotatedString(out), numberOffsetTranslator)
                    }
                }